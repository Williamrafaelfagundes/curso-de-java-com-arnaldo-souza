 class SuperClasse{
	public void imprime(){
		System.out.println("Imprimindo da SuperClasse;");
	}
}
 class MinhaClasse{
	@Override
	public void imprime(){
		System.out.println("Imprimindo da Minha classe sobreescrevendo a super classe!;");
	}

}

public class ExercicioOverride{
	public static void main(String[] args){
		MinhaClasse minhaClasse = new MinhaClasse();

		minhaClasse.imprime();
	}
}