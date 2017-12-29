package cdi;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named("articleHome")
@RequestScoped
public class ArticleHome {

	@Inject ArticleList articleList;
	
	@Inject Event<ArticleEvent> articleSavedEvent;
	
	String title, body;
	
	public String saveArticle() {
		System.out.println("ArticleHome.saveArticle");
		Article a = new Article();
		a.title = title;
		a.body = body;
		// Simulate saving the article using JPA
		articleList.addArticle(a);
		
		// After it saves without exception, we want to
		// broadcast an event that we created the Article
		articleSavedEvent.fire(new ArticleEvent(ArticleEvent.Type.NEW, a));
		System.out.println("Fired event " + articleSavedEvent);
		return "index";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
