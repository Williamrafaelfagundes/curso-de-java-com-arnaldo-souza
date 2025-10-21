interface Veiculo{
	void acelerar();
}

class Carro implements Veiculo{
	public void acelerar(){
		System.out.println("O carro está acelerando!");
	}
}

class Moto implements Veiculo {
	public void acelerar(){
		System.out.println("A Moto está acelerando!");
	}
}

public class PoliInterface{
	public static void main(String [] args){
		Veiculo meuCarro  = new Carro();

		Veiculo minhaMoto = new Moto();

		meuCarro.acelerar();
		minhaMoto.acelerar();

	}
}