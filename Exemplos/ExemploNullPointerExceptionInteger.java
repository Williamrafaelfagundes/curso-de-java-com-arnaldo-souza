class ExemploNullPointerExceptionInteger {
	
	

	public static void main(String[] args) {
		Integer numero = null;
		ExemploNullPointerExceptionInteger e = new ExemploNullPointerExceptionInteger();

		try{
			System.out.println("Numero: "+numero);
			String texto = numero.toString();
			System.out.println("Texto: "+texto);
		}catch (NullPointerException e2){
			System.out.println("Erro: "+e2);

		}

	}


}