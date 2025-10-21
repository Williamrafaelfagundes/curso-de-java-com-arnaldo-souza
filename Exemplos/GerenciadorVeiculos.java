abstract class Veiculo{
	private String placa;
	private int ano;

	void Veiculo(String placa, int ano){
	this.placa = placa;
	this.ano = ano;
	}

	public void exibirInformacoes(){
		System.out.println("Placa: "+placa);
		System.out.println("Ano: "+ano);
	}

}

class Onibus extends Veiculo{
	int assentos;

	public Onibus(String placa, int ano, int assentos){
		super(placa,ano);
		this.assentos = assentos;
	}

	public void exibirInformacoes(){
		super.exibirInformacoes();
		System.out.println("Assentos: "+assentos);
	}

}

class Caminhao extends Veiculo{
	int eixos;

	public Caminhao(String placa, int ano, int eixos){
		super(placa, ano);
		this.eixos = eixos;

	}

	public void exibirInformacoes(){
		super.exibirInformacoes();
		System.out.println("Eixos: "+eixos);
	}
}

public class GerenciadorVeiculos{
	public static void main(String[] args) {
		Caminhao caminhao = new Caminhao();

		Onibus onibus = new Onibus();

	}
}