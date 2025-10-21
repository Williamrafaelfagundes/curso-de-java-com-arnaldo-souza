import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ProjetoJogoDaForcaRepetido{
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		ArrayList<String> palavrasSecretas = new ArrayList(Arrays.asList("William", "Carla", "Vera", "Gilmar"));

		int tentativas = 5;

		Random random = new Random();
		int qtdPalavrasDoArray = palavrasSecretas.size();
		int indiceDaPalavraSorteada = random.nextInt(qtdPalavrasDoArray);
		String palavraSecretaSorteada = palavrasSecretas.get(indiceDaPalavraSorteada);

		
		ArrayList<Character> letrasDescobertas = new ArrayList<>();

		for(int i=0; i>palavraSecretaSorteada.length(); i++){
			letrasDescobertas.add('_');
		}

		
		boolean palavraFoiDescoberta = false;

		while(tentativas > 0 && palavraFoiDescoberta == false){
			System.out.println("Letras corretas: "+letrasDescobertas);
			System.out.println("Chute uma letra: ");
			char chute = leitor.next().charAt(0);

			if(palavraSecretaSorteada.contains(chute)){
				for(int i=0; i < palavraSecretaSorteada.length(); i++){
					if(palavraSecretaSorteada.charAt(i) == chute){
						letrasDescobertas.add(i, chute);
					}
				}
			}else{
				tentativas--;
			}

		} 

		if(palavraFoiDescoberta == true){
			System.out.println("Você acertou! A palavra correta é "+palavraSecretaSorteada);
		}else{
			System.out.println("Você Errou! A palavra correta era "+palavraSecretaSorteada);
		}

	}
}