import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GameLogicTest {

	GameLogic game;
	Dealer dealer;
	Player player1;
//	Player player2;
	Deck deck;

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
		assertEquals("Player: Joe wins!", game.gameWinner());
		assertEquals("Dealer wins", game.gameWinner());
	}

	@Test
	public void testDealerBust(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		assertEquals(true, game.dealerBust());
	}

	@Test
	public void testPlayerBust(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		assertEquals(true, game.playerBust());
	}

	@Test
	public void testDealerTwisting(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		game.dealerTwist();
		assertEquals(3, dealer.countDealersCards());
	}

	@Test
	public void testPlayerTwisting(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		game.playerTwist();
		assertEquals(3, player1.countPlayersCards());
	}

	@Test
	public void testDealerSticking(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		game.dealerSticks();
		assertEquals(2, dealer.countDealersCards());
		assertEquals(true, game.dealerSticks());
	}

	@Test
	public void testPlayerSticking(){
		deck.populateDeckWithCards();
		deck.shuffleCards();
		game.playGame();
		game.playerSticks();
		assertEquals(2, player1.countPlayersCards());
		assertEquals(true, game.playerSticks());
	}

}
