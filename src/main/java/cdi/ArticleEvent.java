package cdi;

public class ArticleEvent {
	Article article;
	enum Type {NEW, UPDATE, DELETE};
	Type type;
	
	public ArticleEvent(Type type, Article article) {
		this.type = type;
		this.article = article;
	}
}
