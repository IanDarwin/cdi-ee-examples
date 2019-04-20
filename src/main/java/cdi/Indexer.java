package cdi;

import java.util.Map;
import java.util.TreeMap;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

/** When an Article is created (or deleted) it has to be updated in the index.
 * We get notified of article changes by @Observes for ArticleEvents, fired
 * somewhere else in the code.
 * @author Ian Darwin
 */
@Named
@ApplicationScoped
public class Indexer {
	
	Map<String,Article> map = new TreeMap<>();
	
	public void updateIndex(@Observes ArticleEvent newArticleEvt) {
		final Article article = newArticleEvt.article;
		System.out.println("Indexer.updateIndex(): INDEXING " + article);
		
		// Do the indexing (a real app would make this persistent, but oh well).
		for (String s : article.title.toLowerCase().split("\\s")) {
			if (!isStopWord(s)) {
				map.put(s.toLowerCase(), article);
			}
		}

		// XXX Later: add indexing of body
	}

	/** Check for stop words (words not to index).
	 * ASSERT: Input is in lower case already
	 * @return True if input is a stopword, false otherwise.
	 */
	static boolean isStopWord(String s) {
		if (s.length() == 1) {
			return false;
		}
		return s.equals("an") || s.equals("in") || s.equals("on") || s.equals("to");
	}
	
	public Map<String,Article> getIndex() {
		return map;
	}
}
