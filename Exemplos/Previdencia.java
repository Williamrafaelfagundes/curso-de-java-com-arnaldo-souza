class InformaRegras{
	@Deprecated
	public void MostrarRegrasParaAposentadoria(){
		System.out.println("Mostrar Regras para aposentadoria!");
	}

	public void MostrarNovasRegrasParaAposentadoria(){
		System.out.println("Mostrar NOVAS regras para aposentadoria!");
	}

}

public class Previdencia {
	public static void main(String[] args){
	InformaRegras informaRegras = new InformaRegras();

	//Uso da classe absoleta
	informaRegras.MostrarRegrasParaAposentadoria();

	//Uso da nova regra
	informaRegras.MostrarNovasRegrasParaAposentadoria();

	}
}