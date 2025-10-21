public class diasNoMes{
	public static void main(String[] args) {
		String mes = "Abril";

		switch (mes){
			case "Janeiro","Março", "Maio", "Julho", "Agosto", "Outubro", "Dezembro" -> System.out.println("Numero de dias = 31");
			case "Abril", "Junho", "Setembro", "Novembro" -> System.out.println("Número de dias = 30");
			case "Fevereiro" -> System.out.println("O número de dias = 28");
			default -> System.out.println("Mes desconhecido.");
		};
	}
}