import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

	public class DealerTest {

		Dealer dealer;
		Deck deck;
		Card card;

		@Before
		public void before(){
			dealer = new Dealer("Jock");
			deck = new Deck();
			card = new Card(SuitType.HEARTS, RankType.FIVE);
		}

		@Test
		public void GameDealerCanDeal(){
			deck.populateDeckWithCards();
			deck.shuffleCards();
			Card card = dealer.deal(deck);
			assertNotNull(card);
			assertEquals(51, deck.getDeckCardCount());
		}

		@Test
		public void DealerHasName(){
			assertEquals("Jock", dealer.getDealerName());
		}

		@Test
		public void checkNoCardsInDealersHand(){
			assertEquals(0, dealer.countDealersCards());
		}

		@Test
		public void canAddCardsToDealersHand(){
			dealer.addCardsToDealersHand(card);
			assertEquals(1, dealer.countDealersCards());
		}


	}





