import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

/**
 * Classe principal da aplicação que gerencia a janela e o painel de abas.
 */
public class TesteRedeCanais extends Application {

    private static final String URL_INICIAL = "https://redecanais.sh/browse-filmes-dublado-videos-8-rating.html";
    private TabPane tabPane;
    private Stage palcoPrincipal;

    // Substitua o seu método start por este:

@Override
public void start(Stage palco) {
    this.palcoPrincipal = palco;
    this.tabPane = new TabPane();

    // --- ORDEM DE INICIALIZAÇÃO CORRIGIDA ---

    // 1. PRIMEIRO: Crie a aba especial "+" que servirá como botão.
    Tab abaDeAdicionar = new Tab("+");
    abaDeAdicionar.setClosable(false);

    // 2. SEGUNDO: Adicione a aba "+" ao painel. Agora o painel não está mais vazio.
    tabPane.getTabs().add(abaDeAdicionar);

    // 3. TERCEIRO: Configure o listener para detectar quando a aba "+" for clicada.
    tabPane.getSelectionModel().selectedItemProperty().addListener((obs, oldTab, newTab) -> {
        if (newTab == abaDeAdicionar) {
            criarNovaAba(URL_INICIAL);
        }
    });

    // 4. QUARTO: Agora, com o painel já contendo a aba "+", crie a primeira aba de conteúdo.
    // Esta chamada agora funcionará sem erros.
    criarNovaAba(URL_INICIAL);

    // Configuração da janela principal
    Scene cena = new Scene(tabPane, 1280, 720);
    palco.setTitle("Navegador RedeCanais");
    palco.setScene(cena);
    palco.show();
}

    /**
     * Cria e adiciona uma nova aba de navegador ao TabPane.
     * @param url A URL inicial para carregar na nova aba.
     */
    private void criarNovaAba(String url) {
        // Cria uma instância da nossa classe de aba customizada
        NavegadorTab novaAba = new NavegadorTab(url, this);

        // Adiciona a nova aba antes do botão "+"
        int indiceBotaoAdicionar = tabPane.getTabs().size() - 1;
        tabPane.getTabs().add(indiceBotaoAdicionar, novaAba);

        // Seleciona a aba que acabamos de criar
        tabPane.getSelectionModel().select(novaAba);
    }

    /**
     * Abre uma URL externa em uma janela completamente nova e separada.
     * Este método é chamado de dentro da classe NavegadorTab.
     * @param url A URL externa a ser carregada.
     */
    public void abrirLinkExterno(String url) {
        Stage popupStage = new Stage();
        popupStage.setTitle("Navegação Externa");
        popupStage.initOwner(palcoPrincipal);

        WebView popupWebView = new WebView();
        if (url != null && !url.isEmpty()) {
            popupWebView.getEngine().load(url);
        }

        // Listener para atualizar o título da janela externa
        popupWebView.getEngine().getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                popupStage.setTitle(popupWebView.getEngine().getTitle());
            }
        });

        VBox popupRoot = new VBox(popupWebView);
        Scene popupScene = new Scene(popupRoot, 1024, 768);
        popupStage.setScene(popupScene);
        popupStage.show();
    }
    
    /**
     * Retorna a referência do TabPane principal.
     */
    public TabPane getTabPane() {
        return tabPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}


/**
 * Classe que representa uma única aba do navegador.
 * Contém todos os componentes e lógica para uma sessão de navegação independente.
 */
class NavegadorTab extends Tab {
    
    private final WebEngine motor;
    private boolean cancelandoNavegacao = false;
    private final TesteRedeCanais aplicacaoPrincipal;

    public NavegadorTab(String urlInicial, TesteRedeCanais appPrincipal) {
        this.aplicacaoPrincipal = appPrincipal;

        // --- Componentes da UI para esta aba ---
        Button botaoVoltar = new Button("<");
        Button botaoAvancar = new Button(">");
        TextField campoUrl = new TextField();
        WebView navegador = new WebView();
        this.motor = navegador.getEngine();

        // Layout dos componentes
        HBox painelDeControle = new HBox(5, botaoVoltar, botaoAvancar, campoUrl);
        painelDeControle.setPadding(new Insets(5));
        HBox.setHgrow(campoUrl, Priority.ALWAYS);

        VBox layoutDaAba = new VBox(painelDeControle, navegador);
        VBox.setVgrow(navegador, Priority.ALWAYS);
        
        // Define o conteúdo desta aba como o layout que criamos
        this.setContent(layoutDaAba);

        // --- Lógica de Navegação (específica para esta aba) ---

        // Bind (vincula) o título da aba ao título da página da web
        this.textProperty().bind(
            Bindings.when(motor.titleProperty().isNotEmpty())
                  .then(motor.titleProperty())
                  .otherwise("Nova Aba")
        );
        
        // Listener para mudanças de URL (lógica de restrição de domínio)
        motor.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (cancelandoNavegacao) {
                if (newState == Worker.State.SUCCEEDED || newState == Worker.State.FAILED || newState == Worker.State.CANCELLED) {
                    cancelandoNavegacao = false;
                }
                return;
            }

            if (newState == Worker.State.SUCCEEDED) {
                String novaUrl = motor.getLocation();
                campoUrl.setText(novaUrl); // Atualiza a barra de endereço

                // Se a URL for externa, cancela na aba atual e abre em janela separada
                if (novaUrl != null && !novaUrl.contains("redecanais")) {
                    final String urlExterna = novaUrl;
                    final WebHistory historicoDoMotor = motor.getHistory();

                    if (historicoDoMotor.getCurrentIndex() > 0) {
                        Platform.runLater(() -> {
                            cancelandoNavegacao = true;
                            historicoDoMotor.go(-1); // Volta para a página anterior
                            aplicacaoPrincipal.abrirLinkExterno(urlExterna); // Chama o método da classe principal
                        });
                    }
                    return;
                }
                
                // Atualiza o estado dos botões de voltar/avançar
                atualizarBotoes(botaoVoltar, botaoAvancar);
            }
        });

        // Ações dos botões
        campoUrl.setOnAction(evento -> motor.load(formatUrl(campoUrl.getText())));
        
        botaoVoltar.setOnAction(e -> {
            if (motor.getHistory().getCurrentIndex() > 0) {
                motor.getHistory().go(-1);
            }
        });

        botaoAvancar.setOnAction(e -> {
            if (motor.getHistory().getCurrentIndex() < motor.getHistory().getEntries().size() - 1) {
                motor.getHistory().go(1);
            }
        });

        // Lógica para fechar a aplicação se for a última aba
        this.setOnCloseRequest(e -> {
            // Se o número de abas for 2 (nossa aba + a aba "+"), fechar esta significa que é a última.
            if (aplicacaoPrincipal.getTabPane().getTabs().size() <= 2) {
                Platform.exit(); // Fecha a aplicação inteira
            }
        });

        // Carrega a URL inicial
        motor.load(urlInicial);
        atualizarBotoes(botaoVoltar, botaoAvancar);
    }
    
    // Atualiza o estado (ativado/desativado) dos botões de navegação
    private void atualizarBotoes(Button voltar, Button avancar) {
        WebHistory history = motor.getHistory();
        boolean podeVoltar = history.getCurrentIndex() > 0;
        boolean podeAvancar = history.getCurrentIndex() < history.getEntries().size() - 1;
        voltar.setDisable(!podeVoltar);
        avancar.setDisable(!podeAvancar);
    }
    
    // Formata a URL (adiciona https:// se necessário)
    private String formatUrl(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            return "https://" + url;
        }
        return url;
    }
}