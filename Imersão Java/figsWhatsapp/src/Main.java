import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

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
            InputStream inputStream = new URL(lista.get("image")).openStream();

            var gerador = new CreateFig();
            gerador.criarFig(inputStream, "fig" + (lista.get("title") + ".png"), lista.get("imDbRating"));

            System.out.printf("\n\u001b[1mNome: \u001b[m" + lista.get("title"));
        }
    }
}

