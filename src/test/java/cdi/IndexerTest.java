package cdi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class IndexerTest {
	
	private Indexer indexer;
	
	@Before
	public void setup() {
		indexer = new Indexer();
	}
	
	public void testIndexer() {
		Article a = new Article();
		a.title = "Hello world";
		indexer.updateIndex(new ArticleEvent(ArticleEvent.Type.NEW, a));
		Map<String, Article> map = indexer.getIndex();
		assertEquals(2, map.size());
	}
	@Test
	public void testIsStopWord() {
		assertTrue(Indexer.isStopWord("in"));
		assertFalse(Indexer.isStopWord("ian"));
		assertTrue(Indexer.isStopWord("to"));
	}

}
