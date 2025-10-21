import java.io.*;

public class ExemploIO{
	public static void main(String[] args){

		ManipulacaoArquivos ma = new ManipulacaoArquivos();
		ma.escreverNoArquivo("D:\\Curso\\pastinha\\meuarquivo.txt", "Olá mundo!");

		ma.lerNoArquivo("D:\\Curso\\pastinha\\meuarquivo.txt");


	}
	
}

class ManipulacaoArquivos{
    public void escreverNoArquivo(String caminhoDoArquivo, String textoEscrever){
    	try {
		FileWriter writer = new FileWriter(caminhoDoArquivo);

		writer.write(textoEscrever); 
		writer.close();

		} catch(IOException e){

		 	System.out.println("Problema de IO: "+e.getMessage());
		
		}

	}

    public void lerNoArquivo(String caminhoDoArquivo){
    	try {
		FileReader reader = new FileReader("D:\\Curso\\pastinha\\meuarquivo.txt");

		int data = reader.read();

		while(data != -1 ){
			System.out.print((char) data);
			data = reader.read();
			}
		reader.close();

		} catch(IOException e){

		 	System.out.println("Problema de IO: "+e.getMessage());
		
		}

    }
}