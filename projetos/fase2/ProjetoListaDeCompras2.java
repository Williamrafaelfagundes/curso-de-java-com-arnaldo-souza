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


public class ProjetoListaDeCompras2 extends Application{

	private ArrayList<String> arrayListListaDeCompras = new ArrayList<>();
	private ListView<String> listViewListaDeCompras = new ListView<>();

	@Override
	public void start(Stage palco){

	Label tituloDescricaoDoItem = new Label("Digite o nome do item: ");
	TextField textFieldDescricaoDoItem = new TextField();
	Button botaoAdicionar  = new Button("Adicionar Produto");	
	Label tituloLista = new Label("Lista de Compras");
	Button botaoRegistrar = new Button("Registrar");

	ObservableList<String> observableList = FXCollections.observableList(arrayListListaDeCompras);

	VBox layout = new VBox();
	layout.getChildren().addAll(tituloDescricaoDoItem, textFieldDescricaoDoItem, botaoAdicionar, tituloLista, listViewListaDeCompras, botaoRegistrar);
	layout.setPadding(new Insets(10));
	layout.setSpacing(10);

	Scene cena = new Scene(layout, 350, 300);
	palco.setScene(cena);
	palco.show();

	botaoAdicionar.setOnAction(e -> {
		String item = textFieldDescricaoDoItem.getText();
		if(!item.isEmpty()){
			arrayListListaDeCompras.add(item);
			listViewListaDeCompras.getItems().add(item);
			textFieldDescricaoDoItem.clear();			
		}
	});

	botaoRegistrar.setOnAction(e ->{
		try{
			File arquivoCriado = new File("listaDeCompras3.txt");
			PrintWriter escritor = new PrintWriter(arquivoCriado);
			for(String item : arrayListListaDeCompras){
				escritor.println(arquivoCriado);
			}
			escritor.close();
		}catch(Exception ex){
			System.out.println("Erro: "+ex.getMessage());
		}
	});


	}

	public static void main(String[] args){
	launch(args);
	}
	

}
