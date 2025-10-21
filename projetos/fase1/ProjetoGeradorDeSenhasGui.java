import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;



public class ProjetoGeradorDeSenhasGui extends Application{
	
	@Override
	public void start(Stage palco){
		palco.setTitle("Gerador de senhas");

		Label labelTamanhoSenha = new Label("Tamanho senha: ");
		TextField campoTamanhoSenha = new TextField();
		campoTamanhoSenha.setText("8"); //Sugestão de tamanho de senha

		Label labelSenhaGerada = new Label("Senha gerada: ");
		TextField campoSenhaGerada = new TextField();
		campoSenhaGerada.setEditable(false);
		campoSenhaGerada.setStyle("-fx-text-fill: cyan; -fx-background-color:black;");


		Button botaoGerarSenha = new Button("Gerar senha!");
		botaoGerarSenha.setOnAction( e ->{
			int tamanhoSenha = Integer.parseInt(campoTamanhoSenha.getText());
			String senha = ProjetoGeradorDeSenhas.gerarSenha(tamanhoSenha);
			campoSenhaGerada.setText(senha); //mostra a senha

		});

		VBox vbox = new VBox(labelTamanhoSenha, campoTamanhoSenha, botaoGerarSenha, labelSenhaGerada, campoSenhaGerada);
		vbox.setSpacing(10);
		vbox.setPadding(new Insets(10));

		Scene cena = new Scene(vbox, 300, 200);
		palco.setScene(cena);
		palco.show();
	}
	public static void main(String[] args){
		launch(args);
	}

}


/*

Não esquecer dos imports

*/