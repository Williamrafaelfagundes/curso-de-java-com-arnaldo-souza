package empresa.dados;
	public class Funcionarios{
		private String nome;
		private double salario;

		public Funcionarios(String nomeInit, double salarioInit){
			nome = nomeInit;
			salario = salarioInit;
		}

		public String obterInfo(){
			return "Nome: "+ nome+", Salario: "+ salario;
		}
	}	
