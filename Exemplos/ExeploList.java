import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ExemploList {
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();

		lista.add("Java");
		lista.add("Python");
		lista.add("C++");

		System.out.println(" Contem java? "+lista.contains("Java"));

		List<String> outraLista = Arrays.ArrayList("JavaScript", "Ruby");

		lista.addAll(outraLista);

		System.out.println(" Lista completa: "+lista);

		lista.remove("Python");

		System.out.println(" Lista completa: "+lista);

		String elemento = lista.get(2);

		System.out.println(" Elemento do indice 2: "+elemento);


		lista.clear();
		System.out.println("Lista limpa: "+lista);
	}
}