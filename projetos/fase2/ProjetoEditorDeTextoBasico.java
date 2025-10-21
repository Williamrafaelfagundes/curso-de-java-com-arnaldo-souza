import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane; 
import javafx.stage.Stage;
import java.io.File;
import java.io.PrintWriter;
import javafx.scene.control.ToolBar;
import javafx.stage.FileChooser;


public class ProjetoEditorDeTextoBasico extends Application{
	
	@Override
	public void start(Stage palco){
	//Criação da TextArea para o editor de texto
	TextArea areaEditavel = new TextArea();

	//Botao para salvar o texto
	Button botaoSalvar = new Button("Salvar Texto");
	botaoSalvar.setOnAction(e -> salvarTexto(areaEditavel));

	//Barra de ferraenta com o botão salvar
	ToolBar barraDeFerramentas = new ToolBar(botaoSalvar);

	//Configuração do Layout principal
	BorderPane borderPane = new BorderPane();
	borderPane.setTop(barraDeFerramentas);
	borderPane.setCenter(areaEditavel);

	//Configuração da cena  do palco
	Scene cena = new Scene(borderPane, 800, 600);
	
	palco.setTitle("Editor de texto básico");
	palco.setScene(cena);
	palco.show();
	}

	private void salvarTexto(TextArea areaTexto){
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Salvar arquivo de texto");
		File file  = fileChooser.showSaveDialog(null);

		if(file != null){
		try(PrintWriter writer = new PrintWriter(file)){

			writer.println(areaTexto.getText());

		} catch(Exception e){
			System.out.println(e.getMessage());
			}
		}
	}


	public static void main(String[] args){
		launch(args);
	}

}