package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {

	private List<Word> words = new ArrayList<>();

	/**
	 * Aggiungere la parola e la relativa traduzione al dizionario
	 * 
	 * @param aWord
	 * @param tW
	 */
	public void addWord(String aWord, String tWord) {

		if (this.translateWord(aWord) == null) {
			Word w = new Word(aWord, tWord);
			this.words.add(w);
		} else
			this.translateWord(aWord).setTranslation(tWord);
	}

	/**
	 * restituisce la parola tradotta
	 * 
	 * @param alienWord parola da tradurre
	 * @return null se non esiste, se no rida la traduzione
	 */
	public Word translateWord(String alienWord) {

		for (Word w : this.words) {
			if (w.getAlienWord().equals(alienWord))
				return w;
		}
		return null;

	}

	public void reset() {
		// TODO Auto-generated method stub
		this.words.clear();
	}

	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

}
