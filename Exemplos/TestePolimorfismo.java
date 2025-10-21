abstract class Animal{ //SuperClasse
	public abstract void FazerSom();
}

class Cachorro extends Animal{ //Subclasse Cachorro
	public void FazerSom(){
	 System.out.println("O cachorro faz au au! ");
	}
}

class Gato extends Animal{
	public void FazerSom(){
	 System.out.println("O gato faz miau miau! ");
	}
}

public class TestePolimorfismo{
	public static void main(String[] args) {
		Object meuCachorro = new Cachorro();

		Object meuGato = new Gato();

		Cachorro objConvertido = (Cachorro) meuCachorro;
		objConvertido.FazerSom();

		((Cachorro) meuCachorro).FazerSom();

	}
	
}