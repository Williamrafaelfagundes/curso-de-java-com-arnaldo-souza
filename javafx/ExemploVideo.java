import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class ExemploVideo extends Application{

	@Override
	public void start(Stage palcoPrincipal){

		String urlDoVideo = "file:/C:/Users/willi/Pictures/Camera%20Roll/WIN_20250929_16_43_05_Pro.mp4";
		Media media = new Media(urlDoVideo);
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		MediaView mediaView = new MediaView(mediaPlayer);

		HBox hbox = new HBox();
		hbox.getChildren().add(mediaView);

		Scene scene = new Scene(hbox, 800, 600);
		palcoPrincipal.setTitle("Exemplo de vídeo");
		palcoPrincipal.setScene(scene);
		palcoPrincipal.show();

		mediaPlayer.play();

	}

	public static void main(String[] args) {
		launch();
	}
}

