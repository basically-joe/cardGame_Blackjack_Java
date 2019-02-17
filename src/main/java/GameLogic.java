import java.util.ArrayList;

public class GameLogic {

	private Deck deck;
	private Dealer dealer;
	private ArrayList<Player> players;

	public GameLogic(Deck deck, Dealer dealer, ArrayList<Player> players){
		this.deck = deck;
		this.dealer = dealer;
		this.players = players;
	}

	public void playGame(){
		Card card = dealer.deal(deck);
		dealer.addCardsToDealersHand(card);
		Card card2 = dealer.deal(deck);
		dealer.addCardsToDealersHand(card2);
	}

}
