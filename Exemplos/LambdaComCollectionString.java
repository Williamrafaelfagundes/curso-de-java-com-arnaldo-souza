import java.util.Arrays;
import java.util.*;

public class LambdaComCollectionString{
	public static void main(String[] args) {
			List<Integer> listaDeNumeros = Arrays.asList(218, 1586, 15, 35, 3);
			List<Integer> numerosPares = new ArrayList<>();

			listaDeNumeros.forEach((numeros) ->{
					if (numeros % 2 == 0){
						numerosPares.add(numeros);
					}
			} );

			System.out.println("Números Pares: "+ numerosPares);

	}
}