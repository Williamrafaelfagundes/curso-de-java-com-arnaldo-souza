final class Veiculo{
	void ligarMotor(){
		System.out.println("Motor Ligado");
	}
}
class Carro extends Veiculo{
	void ligarMotor(){
		System.out.println("Motor ligado pelo segundo método.");
	}
}