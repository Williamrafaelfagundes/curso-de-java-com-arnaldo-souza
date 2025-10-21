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

	@Override
	public void start(Stage palco){

		ArrayList<String> arrayListaDeItens = new ArrayList();
		ListView<String> listViewListaDeItens = new ListView();

		Label descricaoItem = new Label("Informe o nome do item: ");
		TextField textFieldDescricaoItem = new TextField();
		Button btnAdicionar = new Button("Adicionar");
		Label tituloLista = new Label("Lista de produtos: ");
		Button btnRegistrar = new Button("Registrar");

		ObservableList observableList = FXCollections.observableArrayList(arrayListaDeItens);

		VBox layout = new VBox();
		layout.getChildren().addAll(descricaoItem, textFieldDescricaoItem, btnAdicionar);
		layout.getChildren().addAll(tituloLista, listViewListaDeItens, btnRegistrar);
		layout.setSpacing(10);
		layout.setPadding(new Insets(10));

		Scene cena = new Scene(layout, 350, 300);
		palco.setScene(cena);
		palco.show();

		btnAdicionar.setOnAction(e ->{
			String item = textFieldDescricaoItem.getText();
			if(!item.isEmpty()){
				arrayListaDeItens.add(item);
				listViewListaDeItens.getItems().addAll(item);
				textFieldDescricaoItem.clear();
			}
		});

		btnRegistrar.setOnAction(e ->{
			try{
				File arquivo = new File("ProjetoListaDeCompras2.txt");
				PrintWriter writer = new PrintWriter(arquivo);

				for(String item : arrayListaDeItens){
					writer.println(item);
				}
				writer.close();
			}catch(Exception ex){
				System.out.println("Erro: "+ex.getMessage());
			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}

}