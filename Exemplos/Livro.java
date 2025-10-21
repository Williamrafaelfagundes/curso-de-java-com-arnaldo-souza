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
	}

	public Livro(String titulo, String autor){
		this.titulo = titulo;
		this.autor = autor;
		this.anoFabricacao = 0;
		this.preco = 0.0;
	}

	public Livro(String titulo, String autor, int anoFabricacao, double preco){
		this.titulo = titulo;
		this.autor = autor;
		this.anoFabricacao = anoFabricacao;
		this.preco = preco;
	}

}

public class Aplicacao{
	public static void main(String[] args) {
		Livro livro = new Livro();

		System.out.println("Livro: "+livro.titulo);

	}
}