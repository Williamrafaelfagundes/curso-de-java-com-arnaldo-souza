public class TestArrayException{
	public static void main(String[] args) {
		try{
			int [] numeros = {1 , 2 , 3};
			System.out.println("Posicao 5: "+numeros[5]);

		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Erro: "+e.getMessage());
		}finally{
			System.out.println("Programa Finalizado com ou sem Problemas! ");
		}
	}
	
}