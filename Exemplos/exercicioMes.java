public class exercicioMes{
	public static void main(String[] args) {
		int numMes = 4;

		String mes = switch(numMes){
			case 1 -> "Janeiro";
			case 2 -> "Fevereiro";
			case 3 -> "Marco";
			case 4 -> "Abril";
			default -> "Mes invalido";
		};

		System.out.println("Mes: "+mes);

	}
}