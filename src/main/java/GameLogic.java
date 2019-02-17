import java.util.ArrayList;

public class GameLogic {

	private Deck deck;
	private Dealer dealer;
	private ArrayList<Player> players;

	public GameLogic(Deck deck, Dealer dealer, ArrayList<Player> players) {
		this.deck = deck;
		this.dealer = dealer;
		this.players = players;
	}

	public void playGame() {
		Card card = dealer.deal(deck);
		dealer.addCardsToDealersHand(card);
		Card card2 = dealer.deal(deck);
		dealer.addCardsToDealersHand(card2);
		for (Player player : players) {
			Card card3 = dealer.deal(deck);
			player.addCardsToPlayersHand(card3);
			Card card4 = dealer.deal(deck);
			player.addCardsToPlayersHand(card4);
		}
	}

	public Player gameWinnerPlayer() {
		for (Player player : this.players) {
			if (player.valueOfPlayersHand() > dealer.checkDealerScore()) {
				return player;
			} else {
				gameWinnerDealer();
			}
		}
		return null;
	}

	public Dealer gameWinnerDealer() {
		return dealer;
	}

}
