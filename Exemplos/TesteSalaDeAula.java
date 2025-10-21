class SalaDeAula{
	static int numTotAlunos = 0;

	public static void adicionarAluno(){
		numTotAlunos++;
	}

	public static void exibirTotalDeAlunos(){
		System.out.println("O total de alunos é "+SalaDeAula.numTotAlunos);
	}

}

public class TesteSalaDeAula{
	public static void main(String[] args) {
		SalaDeAula.adicionarAluno();
		SalaDeAula.adicionarAluno();

		SalaDeAula.exibirTotalDeAlunos();

	}

}