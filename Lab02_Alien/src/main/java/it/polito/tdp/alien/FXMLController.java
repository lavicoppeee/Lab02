package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLController {

	@FXML
	private AlienDictionary alienDictionary = new AlienDictionary();
	
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
    	alienDictionary.resetDictionary();
    	
    }

	@FXML
	void doTranslate(ActionEvent event) {

		String word = txtWord.getText().toLowerCase();

		// controllo che si inseriscano le parole
		if (word.length() == 0 || word == null) {
			txtResult.appendText("Non posso tradurre se non scrivi niente!");
			return;
		}
		txtResult.clear();

		StringTokenizer array = new StringTokenizer(word, " ");

		// String array[] = word.split(" ");

		if (!array.hasMoreElements()) {
			txtResult.appendText("Puoi inserire solo due paramentri\n");
			return;
		}

		String alienWord = array.nextToken();

		if (array.hasMoreTokens()) {

			String translation = array.nextToken();

			if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			// Aggiungo la parola aliena e traduzione nel dizionario
			alienDictionary.addWord(alienWord, translation);

			txtResult.setText("La parola: \"" + alienWord + "\", con traduzione: \"" + translation
					+ "\", ed  è stata inserita nel dizionario.");

		} else {

			// Controllo che non ci siano caratteri non ammessi
			if (!alienWord.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.");
				return;
			}

			String translation = alienDictionary.translateWord(alienWord);

			if (translation != null) {
				txtResult.setText("La traduzione di " + alienWord + " è " + translation + "\n");
			} else {
				txtResult.setText("La traduzione di " + alienWord + " non esiste nel dizonario\n");
			}
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
