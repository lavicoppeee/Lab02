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

		String word = txtWord.getText().toLowerCase();


		// controllo che si inseriscano le parole
		if (word.length() == 0) {
			txtResult.appendText("Non posso tradurre se non scrivi niente!");
			return;
		}

		txtResult.clear();

		String array[] = word.split(" ");
		String alienWord = array[0];
		Word translated = null;

		if (array.length == 1) {
			translated = this.dictionary.translateWord(alienWord);
			if (translated == null) 
				txtResult.appendText("Non esiste la traduzione di " + alienWord);
			 else 
				txtResult.appendText("La traduzione di " + alienWord + " è " + translated.toString());
			
		}

		txtResult.clear();

		for (int i = 0; i < array.length; i++) {
			this.dictionary.addWord(alienWord, array[i]);
		}
		
		translated=this.dictionary.translateWord(alienWord);
		txtResult.appendText("E' stata inserita la nuova parola" + alienWord + "con traduzione " + translated.toString());
		
		
		


	}

    @FXML
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
