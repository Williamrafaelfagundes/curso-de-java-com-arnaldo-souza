interface Animal{
	 void FazerSom();
}

class Cachorro implements Animal{
	public void FazerSom(){
		System.out.println("O cachorro faz Au Au");
	}
}

class Gato implements Animal{
	public void FazerSom(){
		System.out.println("O Gato faz Miau Miau");
	}
}
public class TestInterface{
	public static void main(String[] args) {
		Cachorro cachorro = new Cachorro();
		Gato gato = new Gato();

		cachorro.FazerSom();
		gato.FazerSom();
		
	}
}
