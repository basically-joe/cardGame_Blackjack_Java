import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PlayerTest {

	Player player;
	Deck deck;
	Card card;
	Card card2;

	@Before
	public void before(){
		player = new Player("Joe");
		deck = new Deck();
		card = new Card(SuitType.HEARTS, RankType.FIVE);
		card2 = new Card(SuitType.CLUBS, RankType.ACE);
	}

	@Test
	public void checkPlayerHasName(){
		assertEquals("Joe", player.getPlayerName());
	}

}
