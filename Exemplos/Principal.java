class MinhaClasse{
	@Deprecated
	public void calcularSoma(){
		System.out.println("Função Calcular SOMA!");
	}
	public void calcularProduto (){
		System.out.println("Função Calcular PRODUTO!");
	}

}

public class Principal{
	@SuppressWarnings("deprecated")
	public static void main(String[] args) {
		MinhaClasse classe = new MinhaClasse();


		classe.calcularSoma();
		classe.calcularProduto();

	}
}