public class CaixaGenerica<T>{
	private T coisaNaCaixa;

	public void guardar(T coisa){
		this.coisaNaCaixa = coisa;
	}
	public T pegar(){
		return coisaNaCaixa;
	}
	public static void main (String [] args){
		CaixaGenerica<Carrinho> caixaDeCarrinho = new CaixaGenerica<>();
		CaixaGenerica<Boneca> caixaDeBoneca = new CaixaGenerica<>();
		
		caixaDeCarrinho.guardar(new Carrinho("Ferrari"));

		caixaDeBoneca.guardar(new Boneca("Barbie"));

		Carrinho carrinho = caixaDeCarrinho.pegar();
		Boneca boneca =  caixaDeBoneca.pegar();

		System.out.println("Carrinho: "+ carrinho.getModelo());
		System.out.println("Boneca: "+ boneca.getNome());

	}
}
