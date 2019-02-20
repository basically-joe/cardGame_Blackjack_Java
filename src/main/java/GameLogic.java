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
		for (Player player : players){
			Card card3 = dealer.deal(deck);
			player.addCardsToPlayersHand(card3);
			Card card4 = dealer.deal(deck);
			player.addCardsToPlayersHand(card4);
		}
	}

	public String gameWinner(){
		String winner = "";
		playerTwist();
		dealerTwist();
		dealerSticks();
		playerSticks();
		playerBust();
		dealerBust();
		for (Player player : this.players) {
			if (player.valueOfPlayersHand() > dealer.checkDealerScore()) {
				String winner1 = "Player: " + player.getPlayerName() + " wins!";
				return winner1;
			}else{
				String winner2 = "Dealer wins";
				return winner2;
			}

		}
		return winner;
	}

	public boolean dealerBust(){
		if (dealer.checkDealerScore() <= 21){
			return true;
		}else{
			return false;
		}
	}

	public boolean playerBust(){
		for (Player player : this.players) {
			if (player.valueOfPlayersHand() <= 21) {
				return true;
			}else{
				return false;
			}

		}
		return false;
	}

	public void dealerTwist(){
		if (dealer.checkDealerScore() < 16){
			Card card = dealer.deal(deck);
			dealer.addCardsToDealersHand(card);
		}
	}

	public void playerTwist(){
			for (Player player : players){
				if(player.valueOfPlayersHand() < 16) {
					Card card3 = dealer.deal(deck);
					player.addCardsToPlayersHand(card3);
				}
			}

	}

	public boolean dealerSticks(){
		if (dealer.checkDealerScore() >= 16) {
			return true;
		}else{
			return false;
		}
	}

	public boolean playerSticks(){
		for (Player player : this.players) {
			if (player.valueOfPlayersHand() >= 16) {
				return true;
			}else{
				return false;
			}

		}
		return false;
	}


}
