import java.util.ArrayList;

public class GameLogic {

	private Deck deck;
	private Dealer dealer;
	private ArrayList<Player> players;
	private boolean bustOrNot;

	public GameLogic(Deck deck, Dealer dealer, ArrayList<Player> players){
		this.deck = deck;
		this.dealer = dealer;
		this.players = players;
		this.bustOrNot = true;
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
		playerNotBust();
		dealerNotBust();
		for (Player player : this.players) {
			if (player.checkForAcesInHandAndAdd10() > dealer.checkDealerScore()) {
				String winner1 = "Player: " + player.getPlayerName() + " wins!";
				return winner1;
			}else{
				String winner2 = "Dealer wins";
				return winner2;
			}

		}
		return winner;
	}

	public boolean dealerNotBust(){
		if (dealer.checkDealerScore() <= 21){
			this.bustOrNot = true;
		}else{
			this.bustOrNot = false;
		}
		return this.bustOrNot;
	}

	public boolean playerNotBust(){
		for (Player player : this.players) {
			if (player.checkForAcesInHandAndAdd10() <= 21) {
				this.bustOrNot = true;
			}else{
				this.bustOrNot = false;
			}
		}
		return this.bustOrNot;
	}

	public void dealerTwist(){
		if (dealer.checkDealerScore() < 16){
			Card card = dealer.deal(deck);
			dealer.addCardsToDealersHand(card);
		}
	}

	public void playerTwist(){
			for (Player player : players){
				if(player.checkForAcesInHandAndAdd10() < 16) {
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
			if (player.checkForAcesInHandAndAdd10() >= 16) {
				return true;
			}else{
				return false;
			}

		}
		return false;
	}


}
