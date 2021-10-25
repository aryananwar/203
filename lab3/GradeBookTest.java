package lab3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook g1;
	GradeBook g2;
	
	//task 3
	@BeforeEach
	public void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(93.0);
		g1.addScore(86.0);
		g2.addScore(53.0);
		g2.addScore(16.0);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testGetScoreSize() {
		assertEquals(2, g1.getScoreSize());
		assertEquals(2, g2.getScoreSize());
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("93.0 86.0 "));
		assertEquals(2, g1.getScoreSize());
		assertTrue(g2.toString().equals("53.0 16.0 "));
		assertEquals(2, g2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(179.0, g1.sum());
		assertEquals(69.0, g2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(86.0, g1.minimum());
		assertEquals(16.0, g2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(93.0, g1.finalScore());
		assertEquals(53.0, g2.finalScore());
	}

	@Test
	void testToString() {
		assertTrue(g1.toString().equals("93.0 86.0 "));
		assertTrue(g2.toString().equals("53.0 16.0 "));
	}

}
