import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ExemploImagens extends Application{

	public static void main(String[] args) {
		launch(args);

	}

		@Override
		public void start(Stage palco){
			//Caminho absoluto para a imagem no Windows
			String caminhoImagem = "file:///D:/Curso/imagens/cachorro_correndo.gif";
			Image imagem = new Image(caminhoImagem);
			ImageView imageView = new ImageView(imagem); 

			//Configuraca para ajustar o tamanho da imagem
			imageView.setFitWidth(613); //Largura desejada em Pixels
			imageView.setFitHeight(640); //Altura desejada em Pixels
			imageView.setPreserveRatio(true); // Mantem a proporção original da imagem

			VBox layout = new VBox(imageView);
			Scene cena = new Scene(layout, 700, 700);

			palco.setScene(cena);
			palco.show();




		}
	}

