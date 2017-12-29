package cdi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("articleList")
@SessionScoped
public class ArticleList implements Serializable {
	private static final long serialVersionUID = 4733810540541910798L;
	
	List<Article> all = new ArrayList<>();

	public void addArticle(Article a) {
		System.out.println("ArticleList.addArticle(): Adding " + a);
		all.add(a);
	}

	public List<Article> all() {
		return all;
	}
}
