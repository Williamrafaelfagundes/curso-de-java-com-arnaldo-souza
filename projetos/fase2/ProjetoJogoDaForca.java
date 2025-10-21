import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProjetoJogoDaForca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> palavrasSecretas = new ArrayList<>(); //Esse arraylist irá conter 3 palavras secretas
        palavrasSecretas.add("cobra");
        palavrasSecretas.add("elefante");
        palavrasSecretas.add("girafa");

        Random random = new Random();
        int tamanhoDoArrayList = palavrasSecretas.size();
        int indiceDaPalavraSecretaGerada = random.nextInt(tamanhoDoArrayList);
        String palavraGerada = palavrasSecretas.get(indiceDaPalavraSecretaGerada);

        ArrayList<Character> letrasDescobertas = new ArrayList<>();

        // CORREÇÃO 1: Usar a String 'palavraGerada' e o método '.length()'
        for (int i = 0; i < palavraGerada.length(); i++) {
            // CORREÇÃO 2: Usar aspas simples para Character
            letrasDescobertas.add('_');
        }

        int tentativas = 6;
        boolean palavraFoiDescoberta = false;

        while (!palavraFoiDescoberta && tentativas > 0) {
            System.out.println("Palavra: " + letrasDescobertas);
            System.out.print("Digite uma letra: "); // Sugestão: usar "letra" em vez de "palavra"
            char chute = scanner.next().charAt(0);

            boolean acertou = false;
            // CORREÇÃO 3: O loop deve verificar a 'palavraGerada'
            for (int i = 0; i < palavraGerada.length(); i++) {
                // CORREÇÃO 4: O método charAt() deve ser usado na 'palavraGerada'
                if (palavraGerada.charAt(i) == chute) {
                    letrasDescobertas.set(i, chute);
                    acertou = true;
                }
            }

            if (!acertou) {
                tentativas--;
                // CORREÇÃO 5: Corrigir o erro de digitação para 'println'
                System.out.println("Você tem mais " + tentativas + " tentativas.");
            }
            
            palavraFoiDescoberta = !letrasDescobertas.contains('_');
        }

        if (palavraFoiDescoberta) {
            // BÔNUS: Mostrar a palavra correta ('palavraGerada') e não a lista toda
            System.out.println("Parabéns, você acertou! A palavra era " + palavraGerada);
        } else {
            // BÔNUS: Mostrar a palavra correta ('palavraGerada')
            System.out.println("Você errou! A palavra era " + palavraGerada);
        }
        
        scanner.close(); // Fechar o scanner é uma boa prática
    }
}