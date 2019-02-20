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

	@Test
	public void checkNoCardsInPlayersHand(){
		assertEquals(0, player.countPlayersCards());
	}

	@Test
	public void addCardsToPlayerHand(){
		player.addCardsToPlayersHand(card);
		player.addCardsToPlayersHand(card2);
		assertEquals(2, player.countPlayersCards());
	}

	@Test
	public void checkRemovingAllCardsFromPLayersHand(){
		player.addCardsToPlayersHand(card);
		player.addCardsToPlayersHand(card2);
		assertEquals(2, player.countPlayersCards());
		player.removeAllCardsFromPlayersHand();
		assertEquals(0, player.countPlayersCards());
	}

	@Test
	public void checkTotalForPlayersHand(){
		player.addCardsToPlayersHand(card);
		assertEquals(5, player.valueOfPlayersHand());
	}

	@Test
	public void testAdding10ToPlayersHandValueWhenAcesFound(){
		player.addCardsToPlayersHand(card);
		player.addCardsToPlayersHand(card2);
		assertEquals(2, player.countPlayersCards());
		assertEquals(16, player.checkForAcesInHandAndAdd10());
	}

}
