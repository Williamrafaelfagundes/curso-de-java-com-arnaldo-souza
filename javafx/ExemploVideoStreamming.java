import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.web.WebView;

public class ExemploVideoStreamming extends Application{
	
	@Override
	public void start(Stage palco){
		WebView webView  = new WebView();

		String urlVideo;
		urlVideo = "https://www.youtube.com/watch?v=iQ-TVzCQoYc";
		
		webView.getEngine().load(urlVideo);
		Scene scene = new Scene(webView, 800, 600);

		palco.setTitle("Exemplo de vídeo de Streaming");
		palco.setScene(scene);
		palco.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}