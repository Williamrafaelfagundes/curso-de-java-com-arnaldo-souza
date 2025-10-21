import java.util.Set;
import java.util.HashSet;
//import.java.util.*; //importa todas as classes do java Util

public class ExemploSet{
	public static void main(String[] args){
		Set<String> conjunto = new HashSet<>();

		//Adicionamos Elementos
		conjunto.add("Java");
		conjunto.add("Python");
		conjunto.add("C++");

		//Verificando se um conjunto contem um elemento
		System.out.println("Contem 'Java'? " +conjunto.contains("Java"));

		//Adiciona mais elementos
		conjunto.add("JavaScript");
		conjunto.add("Ruby");

		//Imprime [ Java, Python, C++, JavaScript, Ruby]
		System.out.println("Imprime conjunto completo: " +conjunto);

		//Removendo um elemento
		conjunto.remove("Python");

		//Imprime [Java, C++, JavaScript, Ruby]	
		System.out.println("Imprime conjunto após remocao: " +conjunto);

		//Tentando adicionar repetido
		boolean foiAdicionado = conjunto.add("Java");
		System.out.println("Java Foi adicionado? " +foiAdicionado);

		conjunto.clear();
		System.out.println("Conjunto após limpar "+conjunto);



	}
}