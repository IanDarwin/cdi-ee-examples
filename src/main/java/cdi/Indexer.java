package cdi;

import java.util.Map;
import java.util.TreeMap;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

/** When an Article is created (or deleted) it has to be updated in the index.
 * @author Ian Darwin
 */
@Named
@ApplicationScoped
public class Indexer {
	
	Map<String,Article> map = new TreeMap<>();
	
	public void updateIndex(@Observes ArticleEvent newArticleEvt) {
		final Article article = newArticleEvt.article;
		System.out.println("Indexer.updateIndex(): INDEXING " + article);
		
		// Here would be the code to do the indexing
		for (String s : article.title.split("\\s")) {
			map.put(s, article);
		}
	}
	
	public Map<String,Article> getIndex() {
		return map;
	}
}
