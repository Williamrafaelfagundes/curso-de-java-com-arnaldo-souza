import empresa.dados.Funcionarios;

class FolhaDePagamento {
	public static void main(String[] args){

		Funcionarios funcionarios  = new Funcionarios("Arnaldo", 500.00);
		System.out.println(funcionarios.obterInfo());

	}
}