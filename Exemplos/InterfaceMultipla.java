interface Interface1{
	void metodo1();
}

interface Interface2{
	void metodo2();
}


class ClasseExemplo implements Interface1, Interface2{
	public void metodo1(){
		System.out.println("Metodo 1!");
	}
	public void metodo2(){
		System.out.println("Metodo 2!");
	}
	
}

class InterfaceMultipla{
	public static void main(String[] args){
		ClasseExemplo exemplo = new ClasseExemplo();

		exemplo.metodo1();
		exemplo.metodo2();
		
	}
}