import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;

public class ExemploGridPane extends Application{

	@Override
	public void start(Stage palco){
		//Criançao dos elemenos, rotulo, campos de texto..
		Label rotuloNome = new Label("Nome: ");
		Label rotuloEmail = new Label("Email: ");

		TextField campoNome = new TextField();
		TextField campoEmail = new TextField();


		Button botaoEnviar = new Button("Enviar");

		GridPane gridPane = new GridPane();
		gridPane.setHgap(8);
		gridPane.setVgap(8);
		gridPane.setPadding(new Insets(5));


		//adição dos elementos ao gridPane
		gridPane.addRow(0, rotuloNome, campoNome);
		gridPane.addRow(1, rotuloEmail, campoEmail);
		gridPane.addRow(2, botaoEnviar);

		Scene scene = new Scene(gridPane, 400, 200);
		palco.setScene(scene);
		palco.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}