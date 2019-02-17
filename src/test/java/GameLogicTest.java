import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GameLogicTest {

	GameLogic game;
	Dealer dealer;
	Player player1;
	Player player2;
	Deck deck;

	@Before
	public void before() {
		deck = new Deck();
		dealer = new Dealer("Sam");
		player1 = new Player("Joe");
		player2 = new Player("Stevie");
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		game = new GameLogic(deck, dealer, players);
	}

	@Test
	public void testDealerGets2cards(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		assertEquals(50, deck.getDeckCardCount());
		assertEquals(2, dealer.countDealersCards());
	}

}
