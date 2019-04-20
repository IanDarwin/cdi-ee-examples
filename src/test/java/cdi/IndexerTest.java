package cdi;

import static org.junit.Assert.*;

import org.junit.Test;

public class IndexerTest {

	@Test
	public void testIsStopWord() {
		assertTrue(Indexer.isStopWord("in"));
		assertFalse(Indexer.isStopWord("ian"));
	}

}
