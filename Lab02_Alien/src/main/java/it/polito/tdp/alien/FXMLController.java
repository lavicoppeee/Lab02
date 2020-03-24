package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {

	@FXML
    private AlienDictionary dictionary;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtWord;

    @FXML
    private Button btnTranslate;

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	txtWord.clear();
    	this.dictionary.reset();
    	
    }

    @FXML
	void doTranslate(ActionEvent event) {

		boolean trad = false;
		String word = txtWord.getText().toLowerCase();

		// controllo che si inseriscano le parole
		if (word.length() == 0) {
			txtResult.appendText("Non posso tradurre se non scrivi niente!");
			return;
		}
		txtResult.clear();

		// Controllo formato
		
		String pattern = "[A-Za-z]*";
		if (!word.matches(pattern)) {
			txtResult.appendText("Parametro non valido, puoi inserire solo caratteri [A-Za-z]\n");
			return;
		}
		txtResult.clear();

		String array[] = word.split(" ");
		System.out.println("Lunghezza array: "+array.length);
		
		if (array.length > 2) {
			txtResult.appendText("Puoi inserire solo due paramentri\n");
			return;
		}

		String alienWord = array[0];
		String translation = null;

		if (array.length == 1) {
			trad = false;
		} else {
			trad = true;
			translation = array[1];

		}

		if (trad) {
			Word result = this.dictionary.translateWord(alienWord);
			if (result != null) {
				txtResult.appendText("La traduzione di " + alienWord + " è " + result.getTranslation() + "\n");
			} else {
				txtResult.appendText("La traduzione di " + alienWord + " non esiste nel dizonario\n");
			}
		} else {
			this.dictionary.addWord(alienWord, translation);
			txtResult.appendText("Nuova traduzione aggiunta al dizionario");
		}

	}


	@FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
