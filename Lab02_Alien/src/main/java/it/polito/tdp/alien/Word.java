package it.polito.tdp.alien;

import java.util.*;

public class Word {

	private String alienWord;
	private List<String> translation;

	public Word(String alienWord, String translation) {
		super();
		this.alienWord = alienWord;
		this.translation = new ArrayList<String>();
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public List<String> getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation.add(translation);
	}

	public boolean equals(Object obj) {

		if (this.alienWord.equals(obj))
			return true;

		return false;
	}

	public String toString() {
		String r = "";

		for (String s : this.translation)
			r += "\n" + s;

		return r;
	}

}
