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
        String urlAPI = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
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
            System.out.printf("\nNome: " + lista.get("title") +
                    "\nAno: " + lista.get("year") +
                    "\nEquipe: " + lista.get("crew") +
                    "\nNota: \u001b[34m" + lista.get("imDbRating") +
                    "\n\u001b[mCapa: " + lista.get("image") + "\n");

            /*Afazeres:
            - Cor para nota a depender do valor (verde para vermelho)
            - Títulos em negrito
            - Emojis
            - Meta: Trocar JsonParse por uma biblioteca de Json (i.e. jackson, gson)
            */
        }
    }
}

//https://docs.oracle.com/en/java/javase/11/docs/api/java.net.http/java/net/http/HttpRequest.html
//https://gist.github.com/alexandreaquiles/cf337d3bcb59dd790ed2b08a0a4db7a3
//https://regex101.com/