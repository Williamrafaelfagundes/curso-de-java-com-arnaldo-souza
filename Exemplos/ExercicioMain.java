interface Veiculo{
	void iniciar();

	void parar();

	public default void buzinar(){
		System.out.println("Buzinando!");
	}
}

class Carro implements Veiculo{
	public void iniciar(){
		System.out.println("Carro iniciar!");
	}

	public void parar(){
		System.out.println("Carro parar!");
	}
}

class Caminhao implements Veiculo{
	public void iniciar(){
		System.out.println("Caminha iniciar!");
	}
	public void parar(){
		System.out.println("Caminhao parar!");
	}
}

class ExercicioMain{
	public static void main(String[] args) {
		Carro carro  = new Carro();
		Caminhao caminhao = new Caminhao();

		carro.iniciar();
		carro.parar();

		caminhao.iniciar();
		caminhao.parar();

		carro.buzinar();
		caminhao.buzinar();


	}

}