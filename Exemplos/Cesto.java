public class Cesto<C>{
	private C coisaNoCesto;

	public void guardar(C coisaNoCesto){
		this.coisaNoCesto = coisaNoCesto;
	}

	public C pegar(){
		return coisaNoCesto;
	}

	public static void main(String[] args) {
		
		Cesto<Peixe> cestoDePeixe = new Cesto<>();
		Cesto<Polvo> cestoDePolvo = new Cesto<>();

		cestoDePeixe.guardar(new Peixe("Teste Nome do Peixei", 10));
		cestoDePolvo.guardar(new Polvo("Teste Nome do Polvo", 8));

		Peixe peixe =  cestoDePeixe.pegar();
		Polvo polvo =  cestoDePolvo.pegar();

		System.out.println("Peixe: "+peixe.getNome());


	}
	
}
