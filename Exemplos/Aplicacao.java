class Livro{
	public String titulo;
	private String autor;
	protected int anoFabricacao;
	double preco;

	public Livro(){
		this.titulo = "Desconhecido";
		this.autor = "Desconhecido";
		this.anoFabricacao = 0;
		this.preco = 0.0;
		System.out.println("Livro: "+this.titulo);
		System.out.println("Autor: "+this.autor);
		System.out.println("Ano de Fabricação: "+this.anoFabricacao);
		System.out.println("Preço: "+this.preco);
	}

	public Livro(String titulo, String autor){
		this.titulo = titulo;
		this.autor = autor;
		this.anoFabricacao = 0;
		this.preco = 0.0;

		System.out.println("Livro: "+this.titulo);
		System.out.println("Autor: "+this.autor);
		System.out.println("Ano de Fabricação: "+this.anoFabricacao);
		System.out.println("Preço: "+this.preco);
	}

	public Livro(String titulo, String autor, int anoFabricacao, double preco){
		this.titulo = titulo;
		this.autor = autor;
		this.anoFabricacao = anoFabricacao;
		this.preco = preco;

		System.out.println("Livro: "+this.titulo);
		System.out.println("Autor: "+this.autor);
		System.out.println("Ano de Fabricação: "+this.anoFabricacao);
		System.out.println("Preço: "+this.preco);
	}

}

public class Aplicacao{
	public static void main(String[] args) {
		Livro livro = new Livro();

		

		Livro livro2 = new Livro("O homem mais rico da babilonia", "William");
		

		Livro livro3 = new Livro("O homem mais rico da babilonia", "William", 2025, 100.5);
		


	}
}