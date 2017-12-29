package cdi;

import java.io.Serializable;
import java.time.LocalDate;

public class Article implements Serializable {
	private static final long serialVersionUID = 1357911L;
	
	String title;
	String body;
	LocalDate date;

	public String getTitle() {
		return title;
	}



	public String getBody() {
		return body;
	}



	public LocalDate getDate() {
		return date;
	}



	@Override
	public String toString() {
		return "Article(" + title + ")";
	}
}
