class Peixe{
	String nome;
	int tamanho;
	public Peixe(String nome, int tamanho){
		this.nome = nome;
		this.tamanho = tamanho;
	}

	public String getNome(){
		return nome;
	}
	public int getTamanho(){
		return tamanho;
	}

}

class Polvo{
	String nome;
	int tentaculos;
	public Polvo(String nome, int tentaculos){
		this.nome = nome;
		this.tentaculos = tentaculos;
	}
	public String getNome(){
		return nome;
	}
	public int getTentaculos(){
		return tentaculos;
	}

}

public class MainGenerics{
	public static void main(String[] args){
		Peixe peixe = new Peixe("Sardinha", 30);
		Polvo polvo = new Polvo("Rodrigo", 5);

		System.out.println("Peixe: "+peixe.getNome()+" Tamanho: "+peixe.getTamanho());
		System.out.println("Polvo: "+polvo.getNome()+" Tentaculos: "+polvo.getTentaculos());
	
	}
			
}