package com.github.anonisnap.dynamicviewchanges;

import java.util.ArrayList;
import java.util.List;

public class ItemDisplay {
	private String name;
	private String description;
	private List<String> quotes;
	private char gender;
	private int image;

	public ItemDisplay(String name, String description, char gender, String quote, int image) {
		this.name = name;
		this.description = description;
		this.gender = gender;
		quotes = new ArrayList<>();
		quotes.add(quote);
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public ItemDisplay setName(String name) {
		this.name = name;
		return this;

	}

	public String getDescription() {
		return description;
	}

	public ItemDisplay setDescription(String description) {
		this.description = description;
		return this;

	}

	public String getQuote() {
		return quotes.get((int) (Math.random() * quotes.size()));
	}

	public ItemDisplay addQuote(String quote) {
		quotes.add(quote);
		return this;
	}

	public int getImage() {
		return image;
	}

	public ItemDisplay setImage(int image) {
		this.image = image;
		return this;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getGender() {
		return gender;
	}
}
