@FunctionalInterface
interface Calculadora{
	double Calcular(double a, double b);
}

public class CalculadoraComInterfaceFuncional{
	public static void main(String[] args){
		Calculadora soma = (a, b) -> a + b;
		System.out.println("Soma: "+soma.Calcular(10, 2));

		Calculadora subtracao = (a, b) -> a - b;
		System.out.println("Subtracao: "+subtracao.Calcular(10, 5));

		Calculadora multiplicacao = (a, b) -> a * b;
		System.out.println("Muliplicacao: "+ multiplicacao.Calcular(10, 5));

		Calculadora divisao = (a, b) -> a / b;
		System.out.println("Divisão: "+ divisao.Calcular(10, 5));



	}
}