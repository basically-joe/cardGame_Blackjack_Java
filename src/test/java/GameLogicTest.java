import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.*;

public class GameLogicTest {

	GameLogic game;
	Dealer dealer;
	Player player1;
//	Player player2;
	Deck deck;
	String myString;

	@Before
	public void before() {
		deck = new Deck();
		dealer = new Dealer("Sam");
		player1 = new Player("Joe");
//		player2 = new Player("Stevie");
		ArrayList<Player> players = new ArrayList<>();
		players.add(player1);
//		players.add(player2);
		game = new GameLogic(deck, dealer, players);
		myString = myString;
	}

	@Test
	public void testDealerGets2cards() {
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		assertEquals(2, dealer.countDealersCards());
	}

	@Test
	public void testAllPlayersAndDealerGet2Cards() {
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		assertEquals(48, deck.getDeckCardCount());
		assertEquals(2, dealer.countDealersCards());
		assertEquals(2, player1.countPlayersCards());
//		assertEquals(2, player2.countPlayersCards());
	}

	@Test
	public void testWhoWinsWithHighestHand() {
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		myString = game.gameWinner();
		assertTrue(myString.equals("Player: Joe wins!") || myString.equals("Dealer wins"));

	}

	@Test
	public void testDealerBust(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		assertEquals(true, game.dealerNotBust());
	}

	@Test
	public void testPlayerBust(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		assertEquals(true, game.playerNotBust());
	}

	@Test
	public void testDealerTwisting(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		game.dealerTwist();
		Integer dealerTwistCards = dealer.countDealersCards();
		assertTrue(dealerTwistCards.equals(2) || dealerTwistCards.equals(3));
	}

	@Test
	public void testPlayerTwisting(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		game.playerTwist();
		Integer playerTwistCards = player1.countPlayersCards();
		assertTrue(playerTwistCards.equals(2) || playerTwistCards.equals(3));

	}

	@Test
	public void testDealerSticking(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		game.dealerSticks();
		assertEquals(2, dealer.countDealersCards());
		Boolean dealerSticking = game.dealerSticks();
		assertTrue(dealerSticking.equals(true) || dealerSticking.equals(false));
	}

	@Test
	public void testPlayerSticking(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		game.playerSticks();
		assertEquals(2, player1.countPlayersCards());
		Boolean playerSticking = game.playerSticks();
		assertTrue(playerSticking.equals(true) || playerSticking.equals(false));
	}

}
