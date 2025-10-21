import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ProjetoListaDeCompras extends Application{
	private ArrayList<String> listaDeCompras = new ArrayList<>();
	private ListView<String> listaVisualizavel = new ListView();

	@Override
	public void start(Stage palco){
		palco.setTitle("Aplicativo de lista de compras");
		TextField textFieldDescricaoItem = new TextField(); //TextField para adiconar o nome/descrição do item
		Button botaoAdicionar = new Button("Adicionar");
		Button botaoExportar = new Button("Exportar Lista");

		Label labelAdicionar = new Label("Digite o item que deseja adicionar: ");
		Label labelListaDeCompras = new Label("Lista de Compras: ");

		//Criação do observableList a partir da listagem de compras
		ObservableList<String> observableListaDeCompras = FXCollections.observableArrayList(listaDeCompras); //
		listaVisualizavel.setItems(observableListaDeCompras);

		VBox vbox = new VBox();
		vbox.getChildren().addAll(labelAdicionar, textFieldDescricaoItem, botaoAdicionar);
		vbox.getChildren().addAll(labelListaDeCompras, listaVisualizavel, botaoExportar);
		vbox.setSpacing(10); //Espaçamento vertical entre os componentes
		vbox.setPadding(new Insets(10)); //Margens internas espaçamento para o vbox.

		botaoAdicionar.setOnAction(e ->{
		String item = textFieldDescricaoItem.getText(); //Obtem o texto digitado e armazena na variavel item
		if(!item.isEmpty()){ //Entra no if se o texto não estiver vazio
			listaDeCompras.add(item); //o texto adicionado é adicionado a lista de compras
			listaVisualizavel.getItems().add(item); //Adicionamos o texto a listaVisualizavel
			textFieldDescricaoItem.clear(); //o campo de texto é limpo removendo o texto ditado
			}
		});
		botaoExportar.setOnAction(e -> {
    	try {
        	File arquivo = new File("listaDeCompras.txt");
        	PrintWriter writer = new PrintWriter(arquivo); // O PrintWriter é usado para gravar os itens da lista no arquivo.
        	for (String item : listaDeCompras) { // Percorre todos os itens da compra.
            writer.println(item); // Escrevemos cada item da lista no arquivo, adiciona uma nova linha para cada item.
        	}
        	writer.close();
    	} catch (Exception ex) {
       	 System.out.println("Erro Ocorrido: " + ex.getMessage());
    		}
		});

		Scene cena = new Scene(vbox, 350, 300);
		palco.setScene(cena);
		palco.show();
	}
	public static void main(String[] args){
		launch();
	}
}