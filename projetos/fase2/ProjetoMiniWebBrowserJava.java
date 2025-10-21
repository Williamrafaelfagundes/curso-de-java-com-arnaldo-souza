import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class ProjetoMiniWebBrowserJava extends Application{
	
	@Override
	public void start(Stage palco){
		TextField campoUrl = new TextField();
		WebView navegador = new WebView();
		WebEngine motor = navegador.getEngine();


		//Carrega uma página da web quando um usuário pressionar enter
		campoUrl.setOnAction(evento -> motor.load(formatUrl(campoUrl.getText())));

		VBox vbox = new VBox();
		vbox.getChildren().addAll(campoUrl, navegador);

		Scene cena = new Scene(vbox);

		palco.setTitle("Meu browser Java");
		palco.setScene(cena);
		palco.show();


	}
	public static void main(String[] args){
		launch(args);
	}

	public String formatUrl(String url){
		if(!url.startsWith("http://") && !url.startsWith("https://")){
		url = "http://"+url;
		}
		return url;
	}

}

/*
Melhorias;
Colocar o HTTP caso o usuário nao colocar;
	public String formatUrl( String url){
		if(!url.starsWih("http://") && !url.startsWith("https://"){
		url = "http://"+url;
		}
		return url;
	}

campoUrl.setOnAction(evento -> motor.load(formatUrl(campoUrl.getText() ));

*/