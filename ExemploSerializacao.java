import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

//testeteste

public class ExemploSerializacao{
	//Metodo para Serializar contatos
	private static void serializarContatos(List<Contato> listaContatos) throws IOException{
		try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("agenda.ser"))){
		outputStream.writeObject(listaContatos);
		System.out.println("Contatos serializados e salvos com sucesso!");
		}
	}

	//Metodo para deserializar e exibir os contatos
	@SuppressWarnings("unchecked")
	private static void deserializarContatos() throws IOException, ClassNotFoundException {
		try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("agenda.ser"))){
		List<Contato> contatosLidos = (List<Contato>) inputStream.readObject();
			for (Contato contato: contatosLidos){
				System.out.println("Nome: "+contato.nome+", Telefone: "+contato.telefone);

			} 
		}

	}

public static void main(String[] args){
	Contato contato1 = new Contato("Arnaldo", "(11) 1234-5678");
	Contato contato2 = new Contato("Maria", "(55) 99126-9821");
	Contato contato3 = new Contato("Carol", "(55) 991959586");

	List<Contato> listaContatos = new ArrayList<>();
	listaContatos.add(contato1);
	listaContatos.add(contato2);
	listaContatos.add(contato3);
	try{
		serializarContatos(listaContatos);
		deserializarContatos();

	}catch (IOException | ClassNotFoundException e){
		System.out.println("Erro ao manipular contatos "+ e.getMessage());
	}
}


}
