interface Produto{
	String getNome();
	int getQuantidade();
	int adicionarQuantidade(int quantidade);
	int removerQuantidade(int quantidade);
}
class ProdutoImp implements Produto{
	private String nome;
	private int quantidade;

	public ProdutoImp(String nome, int quantidade){
		this.nome = nome;
		this.quantidade = quantidade;
	}

	@Override
	public String getNome(){
		return nome;
	}
	@Override
	public int getQuantidade(){
		return quantidade;
	}
	@Override
	public int adicionarQuantidade(int quantidade){
		return this.quantidade += quantidade;
	}
	@Override
	public int removerQuantidade(int quantidade){
		return this.quantidade -= quantidade;
	}


}

public class ExercicioInterface{
	public static void main(String[] args) {
		Produto p = new ProdutoImp("Caneta", 5);

		System.out.println("Produto: "+p.getNome()+ " Qtd: "+p.getQuantidade());
		
	}
}