abstract class Loja{
	String CNPJ;
	String razaoSocial;
	String aberta;

	abstract void abrir();

	abstract void fechar();

}

class LojaComercial extends Loja{
	public LojaComercial(String CNPJ, String razaoSocial){
		super.CNPJ = CNPJ;
		super.razaoSocial = razaoSocial;
		System.out.println("CNPJ: "+super.CNPJ);
		System.out.println("Razao Social: "+super.razaoSocial);
	}
	public void abrir(){
		super.aberta = "Loja Aberta";
		System.out.println(super.aberta);

	}
	public void fechar(){
		super.aberta = "Loja Fechada";
		System.out.println(super.aberta);
	}

}

class mainExercicioExtendsLoja{
	public static void main(String[] args) {
		LojaComercial loja = new LojaComercial("038-956-160-60", "Loja Teste");
		loja.abrir();
		loja.fechar();

	}
}

