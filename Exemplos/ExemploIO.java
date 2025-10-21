import java.io.*;

public class ExemploIO{
	public static void main(String[] args){

		try {
		//Escrevendo em um arquivo
		FileWriter writer = new FileWriter("meuarquivo.txt");

		writer.write("Ola, mundo! "); //Grava os dados

		writer.close();

		//Lendo de um arquivo
		FileReader reader = new FileReader("meuarquivo.txt");

		int data = reader.read();

		while(data != -1 ){
			System.out.println((char) data);
			data = reader.read();
			}
		reader.close();

		} catch(IOException e){

		 	System.out.println("Problema de IO: "+e.getMessage());
		
		}

	}
	
}