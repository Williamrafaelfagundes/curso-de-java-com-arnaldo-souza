import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.stage.FileChooser;
import java.io.File;

import javafx.stage.Stage;


public class ExemploFileChooser extends Application{

	@Override
	public void start(Stage palco){
		FileChooser seletorDeArquivo = new FilseChooser();
		seletorDeArquivo.setTitle("Escolha um arquivo");

		Button botaoAbrir  = new Button("Abrir arquivo");
		botaoAbrir.setOnAction(e -> {
			File arquivoSelecionado = seletorDeArquivo.showOpenDialog(palco);
			if (arquivoSelecionado !=  null){
				exibirImagem(arquivoSelecionado, palco);
			}
		});

		VBox layout = new VBox(botaoAbrir);
		Scene cena = new Scene(layout, 800, 600);
		palco.setTitle("Testando o FileChooser");
		palco.setScene(cena);
		palco.show();

	}
	private void exibirImagem(File arquivo, Stage palcoDoArquivoSelecionado){

		Image imagem = new Imagem(arquivo.toURI().toString());
		ImageView imageView = new ImageView(imagem);

		VBox layout;

		//A linha abaixo obtem o laytou atual 
		laytou = (VBox) palcoDoArquivoSelecionado.getScene().getRoot();

		//A linha a baixo adiciona a imagem ao layout
		laytou.getChildren().add(imageView);

		//Ajustar tamanho da imagem
		imageView.setFitWidth(500);
		imageView.setFitHeight(500);

		palcoDoArquivoSelecionado.setTitle("Seletor de arquivos");


	}
	public static void main(String[] args) {
		launch(args);
	}
}