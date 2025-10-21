abstract class FiguraGeometrica{
	abstract void calculaArea();

	abstract void calculaPerimetro();
}

class Retangulo extends FiguraGeometrica{
	@Override
	void calculaArea(){
		System.out.println("Metodo Calcula Area! ");
	}
	@Override
	void calculaPerimetro(){
		System.out.println("Metodo Calcula Perimetro! ");
	}
}

class ExercicioClasseAbstrata{
	public static void main(String[] args) {
		Retangulo r = new Retangulo();

		r.calculaArea();
		r.calculaPerimetro();
	}

}