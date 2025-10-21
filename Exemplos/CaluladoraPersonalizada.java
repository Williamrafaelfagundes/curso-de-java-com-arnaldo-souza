@FunctionalInterface
interface OperacaoMatematica{
	double executar(double a, double b);
}
public class CaluladoraPersonalizada{
	public static void main(String[] args) {
		OperacaoMatematica potencia = (a, b) -> Math.pow(a,b);
		System.out.println("Potencia: "+ potencia.executar(10, 5));

		OperacaoMatematica raiz = (a, b) -> Math.sqrt(a + b);
		System.out.println("Raiz: "+ raiz.executar(10, 5));



	}
}