import org.json.JSONObject;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProjetoSistemaDeInformacoesClimaticasEmTempoReal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome da cidade: ");
        String cidade = scanner.nextLine(); // Lê a cidade do teclado

        try {
            String dadosClimaticos = getDadosClimaticos(cidade); //retorna um JSON

            // Código 1006 significa localização não é encontrada.
            if (dadosClimaticos.contains("\"code\":1006")) { // \"code\":1006 representa "code":1006
                System.out.println("Localização não encontrada. Por favor, tente novamente.");
            } else {
                imprimirDadosClimaticos(dadosClimaticos);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getDadosClimaticos(String cidade) throws Exception {
        String apiKey = Files.readString( Paths.get("api-key.txt")).trim();

        String formataNomeCidade = URLEncoder.encode(cidade, StandardCharsets.UTF_8);
        String apiUrl = "http://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + formataNomeCidade;
        HttpRequest request = HttpRequest.newBuilder() // Começa a construção de uma nova solicitação HTTP
                .uri(URI.create(apiUrl)) // Este método define o URI da solicitação HTTP.
                .build(); // Finaliza a construção da solicitação HTTP.

        // Criar objeto enviar solicitações HTTP e receber respostas HTTP, para acessar o site da WeatherAPI
        HttpClient client = HttpClient.newHttpClient();

        // Agora vamos enviar requisições HTTP e receber respostas HTTP, comunicar com o site da API Meteorologica.
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body(); // retorna os dados meteorológicos obtidos no site da API (WeatherAPI)
    }
    
    public static void imprimirDadosClimaticos(String dados){
    System.out.println("Dados originais (json) obtidos no site metereológico: "+ dados);

    JSONObject dadosJson = new JSONObject(dados);
    JSONObject informacoesMetereologicas = dadosJson.getJSONObject("current"); //pega só as informações atuais, os dados atuais e nao o histórico.

    //Extrai os dados de localizacao
    String cidade = dadosJson.getJSONObject("location").getString("name");
    String pais = dadosJson.getJSONObject("location").getString("country");

    //Extrai os dados adicionais
    String condicaoTempo = informacoesMetereologicas.getJSONObject("condition").getString("text");
    int umidade = informacoesMetereologicas.getInt("humidity");
    float velocidadeVento = informacoesMetereologicas.getFloat("wind_kph");
    float pressaoAtmosferia = informacoesMetereologicas.getFloat("pressure_mb");
    float sensacaoTermica = informacoesMetereologicas.getFloat("feelslike_c");
    float temperaturaAtual = informacoesMetereologicas.getFloat("temp_c");

    //Extrai a data e a hora da String retornada pela API
    String dataHoraString = informacoesMetereologicas.getString("last_updated");

    //Imprime as informacoes atuais
    System.out.println("Informaçoes Metereologicas para " + cidade + ", " + pais);
    System.out.println("Data e hora: "+ dataHoraString);
    System.out.println("Temperatura atual: "+ temperaturaAtual + " °C");
    System.out.println("Sensação términca: "+ sensacaoTermica + " °C");
    System.out.println("Condicao Tempo: "+ condicaoTempo);
    System.out.println("Umidade: "+ umidade + " %");
    System.out.println("Velocidade do Vento: "+ velocidadeVento + " km/h");
    System.out.println("Pressao Atmosférica: "+ pressaoAtmosferia + " mb");

    }
}