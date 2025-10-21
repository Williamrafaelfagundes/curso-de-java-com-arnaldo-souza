import java.util.Map;
import java.util.HashMap;

public class EstoqueHashMap{
	public static void main(String[] args) {
	Map<String, Integer> estoque = new HashMap<>();

	estoque.put("Nike", 10);
	estoque.put("Adidas", 5);
	estoque.put("Olympico", 23);
			
	System.out.println("Estoque: "+estoque);
	

	}
	
}