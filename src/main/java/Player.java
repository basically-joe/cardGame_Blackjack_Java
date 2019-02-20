import java.util.ArrayList;

public class Player {

	private String playerName;
	private ArrayList<Card> playersHand;

	public Player(String playerName){
		this.playerName = playerName;
		this.playersHand = new ArrayList<>();
	}

	public String getPlayerName(){
		return this.playerName;
	}

	public int countPlayersCards(){
		return this.playersHand.size();
	}

	public void addCardsToPlayersHand(Card card){
		this.playersHand.add(card);
	}

	public void removeAllCardsFromPlayersHand(){
		this.playersHand.clear();
	}

	public int valueOfPlayersHand(){
		int total = 0;
		for (Card card : this.playersHand){
			total += card.getValueFromEnum();
		}
		return total;
	}

	public int checkForAcesInHandAndAdd10() {
		if (this.valueOfPlayersHand() <= 11) {
			int total = 0;
			for (Card card : this.playersHand) {
				if (card.getRank() == RankType.ACE) {
					total += 1;
				}
			}
			return total * 10 + this.valueOfPlayersHand();
		}
		return this.valueOfPlayersHand();
	}
}
