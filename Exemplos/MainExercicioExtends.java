abstract class Operacao{

	abstract double Calcular(double a, double b);

}
class Soma extends Operacao{
	@Override
	double Calcular(double a, double b){
		return a + b;
	}
}

class Multiplicacao extends Operacao{
	@Override
	double Calcular(double a, double b){
		return a * b;
	}
}
class Divisao extends Operacao{
	@Override
	double Calcular(double a, double b){
		return a / b;
	}
}

public class MainExercicioExtends{
	public static void main(String[] args) {
		Soma soma = new Soma();

		double respostaSoma = soma.Calcular(10.5,10.3);
		System.out.println("Resposta Soma: "+respostaSoma);

		Multiplicacao multiplicacao = new Multiplicacao();

		double respostaMult = multiplicacao.Calcular(10.0,10.0);
		System.out.println("Resposta Multiplicacao: "+respostaMult);

		Divisao divisao = new Divisao();

		double respostaDiv = divisao.Calcular(10.0,10.0);
		System.out.println("Resposta Divisao: "+respostaDiv);

	}
}


