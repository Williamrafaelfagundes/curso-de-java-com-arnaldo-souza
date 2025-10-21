class CaixaDeBrinquedos{
	private Object coisaNaCaixa;


	public void guardar(Object coisa){
		this.coisaNaCaixa = coisa;
	}

	public Object pegar(){
		return coisaNaCaixa;
	}

	public static void main(String[] args) {
		
		CaixaDeBrinquedos caixaDeCarrinos = new CaixaDeBrinquedos();
		caixaDeCarrinos.guardar(new Carrinho("Hot Whels"));

		CaixaDeBrinquedos caixaDeBonecas = new CaixaDeBrinquedos();
		caixaDeBonecas.guardar(new Boneca("Barbie"));

		if (caixaDeCarrinos.pegar() instanceof Carrinho){
			Carrinho carrinho = (Carrinho) caixaDeCarrinos.pegar();
			System.out.println(carrinho.getModelo());

		}
		if (caixaDeBonecas.pegar() instanceof Boneca){
			Boneca boneca = (Boneca) caixaDeBonecas.pegar();
			System.out.println(boneca.getNome());
		}


	}
}