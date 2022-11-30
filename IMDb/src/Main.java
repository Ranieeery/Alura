import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Requisição para API p/ top 250
        String urlAPI = "https://imdb-api.com/en/API/MostPopularMovies/k_vuv0zd9w";
        var endereco = URI.create(urlAPI);
        var httpClient = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        String body = response.body();

        // Selecionar dados (ex: título, poster, nota)
        var jsonParse = new JsonParse();
        List<Map<String, String>> listaFilmes = jsonParse.parse(body);

        // Exibir os dados selecionados
        for (Map<String, String> lista : listaFilmes) {
            int cor;
            StringBuilder star = new StringBuilder();
            try {
                if (Double.parseDouble(lista.get("imDbRating")) <= 4.5) {
                    cor = 31;
                } else if (Double.parseDouble(lista.get("imDbRating")) <= 7.5) {
                    cor = 33;
                } else cor = 32;
            } catch (NumberFormatException e){
                cor = 31;
            }

            try {
                star.append("⭐".repeat((int) (Math.max(0, Double.parseDouble(lista.get("imDbRating")))/1.82)));
            } catch (NumberFormatException e){
                star.append("\uDB40\uDC20");
            }

            System.out.printf("\n\u001b[1mNome: \u001b[m" + lista.get("title") +
                    "\n\u001b[1mAno: \u001b[m" + lista.get("year") +
                    "\n\u001b[1mEquipe: \u001b[m" + lista.get("crew") +
                    "\n\u001b[1mNota: \u001b[0;%dm" + lista.get("imDbRating") + "\u001b[0m - %s" +
                    "\n\u001b[1mCapa: \u001b[m" + lista.get("image") + "\n", cor , star);
        }
    }
}

//https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.html
//https://gist.github.com/alexandreaquiles/cf337d3bcb59dd790ed2b08a0a4db7a3
//https://regex101.com/
