import java.util.Arrays;
import java.util.*;

public class ExercicioLambda{
	public static void main(String[] args) {
		
		Set<Integer> listaDeNumeros = new HashSet<>();

		listaDeNumeros.add(1);
		listaDeNumeros.add(2);
		listaDeNumeros.add(3);
		listaDeNumeros.add(4);
		listaDeNumeros.add(5);
		listaDeNumeros.add(6);
		
		listaDeNumeros.removeIf(numeros -> numeros % 2 != 0);

		System.out.println(listaDeNumeros);




	}
	
}