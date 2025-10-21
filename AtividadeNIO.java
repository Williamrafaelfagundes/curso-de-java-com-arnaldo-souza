import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class AtividadeNIO {
    public static void main(String[] args) {
        ManipulacaoArquivos ma = new ManipulacaoArquivos();
        String caminho = "D:\\Curso\\pastinha\\meuarquivo.txt";

        ma.escreverNoArquivo(caminho, "Olá mundo atividade NIO!");

        ma.lerNoArquivo(caminho);
    }
}

class ManipulacaoArquivos {
    public void escreverNoArquivo(String caminhoDoArquivo, String textoEscrever) {
        Path path = Paths.get(caminhoDoArquivo);
        try {
            Files.write(path, textoEscrever.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // CORREÇÃO 1: O método agora recebe o caminho do arquivo como parâmetro.
    public void lerNoArquivo(String caminhoDoArquivo) {
        // CORREÇÃO 1: A variável 'path' é criada aqui dentro.
        Path path = Paths.get(caminhoDoArquivo);
        try {
            // CORREÇÃO 2: Trocado 'bytes[]' por 'byte[]'.
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}