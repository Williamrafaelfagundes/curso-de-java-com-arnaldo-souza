import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXTesteWilliam extends Application{
	@Override
	public void start(Stage palco){
		Button btn = new Button("Exemplo de botão");
		Button btn2 = new Button("Exemplo de botao 2");

		HBox hBox = new HBox(btn, btn2);
		hBox.setAlignment(Pos.CENTER);

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(hBox);

		Scene cena = new Scene(borderPane, 400, 400);
		palco.seetScene(cena);
		palco.show();


	}

	public static void main(String[] args) {
		launch(args);
	}

}