package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.AlienTraslator.Traduttore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Traduttore traduttore = new Traduttore ();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btClear;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextField txtInput;

    @FXML
    private TextArea txtOutput;
    
    public void inserisci(String s) {
    	String[] riga = s.split(" ");
    	
    	riga[0] = riga[0].toLowerCase();
    	
    	int lunghezza = riga.length;
    	if (lunghezza == 2) {
    		this.traduttore.aggiungi(riga[0], riga[1]);
    		txtOutput.setText("Aggiunta parola: " + riga[0] +" al dizionario");
    	}
    	else if (riga.length == 1) {
    		String traduzione = traduttore.traduci(riga[0]);
    		txtOutput.setText(traduzione);
    	}
    	
    	
    }
    

    @FXML
    void doClear(ActionEvent event) {
    	txtInput.setText("");
    	txtOutput.setText("");
    }

    @FXML
    void doTraslate(ActionEvent event) {
    	String parola = txtInput.getText();
    	if (parola.matches("[a-zA-Z\\s]+")) {
    		inserisci(parola);
    	}
    	else {txtOutput.setText("Inserire lettere alfabetiche");}
    	
    }
    
    public void setTraduttore(Traduttore t) {
    	this.traduttore = t;
    }

    @FXML
    void initialize() {
        assert btClear != null : "fx:id=\"btClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
