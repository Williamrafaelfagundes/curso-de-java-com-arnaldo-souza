import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class ProjetoCalculaoraIMC extends Application{
	@Override
	public void start(Stage palco){
		//Etiquetas para os campos de entrada
		Label etiquetaPeso = new Label("Peso");
		Label etiquetaAltura = new Label("Altura");

		//Campo de texto para entrada de dados
		TextField campoPeso = new  TextField();
		campoPeso.setPromptText("Peso e kg");

		TextField campoAltura = new TextField();
		campoAltura.setPromptText("Altura em Metros");

		Label etiquetaResultado = new Label();

		//Botao para calcular o IMC
		Button botaoCalcular = new Button("Calcular ICM");
		botaoCalcular.setOnAction(e ->{
			try{

			double peso = Double.parseDouble(campoPeso.getText().replace(',', '.'));
			double altura = Double.parseDouble(campoAltura.getText().replace(',', '.'));
			double imc = peso /(altura * altura);
			etiquetaResultado.setText(String.format("Seu IMC é %.2f", imc));
		}catch(NumberFormatException ex){
			etiquetaResultado.setText("Por favor, insira números válidos para peso e altura");
		}
		});

		//Layout vertical
		VBox layout = new VBox(10, etiquetaPeso, campoPeso, etiquetaAltura, campoAltura, botaoCalcular, etiquetaResultado);
		layout.setPadding(new Insets(10));
		layout.setAlignment(Pos.CENTER);

		//Cena e palco
		Scene cena = new Scene(layout, 300, 250);
		palco.setTitle("Calculadora de IMC");
		palco.setScene(cena);
		palco.show();

	}

		public static void main(String[] args) {
			launch(args);
		}
}