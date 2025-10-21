import java.util.Set;
import java.util.HashSet;

public class ExercicioHashSet{
	public static void main(String[] args) {
		Set<String> conjunto = new HashSet<>();

		conjunto.add("Carla");
		conjunto.add("Carol");
		conjunto.add("Carmed");
		conjunto.add("Citroen");



		System.out.println("Contem Citroen? "+conjunto.contains("Citroen"));



		
	}
}
