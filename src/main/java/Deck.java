import java.util.ArrayList;

public class Deck {

	private ArrayList<Card> cards;

	public Deck(){
		this.cards = new ArrayList<>();
	}

	public int getDeckCardCount(){
		return this.cards.size();
	}

	public ArrayList populateDeckWithCards() {
		SuitType[] suits = SuitType.values();
		RankType[] ranks = RankType.values();

		for (SuitType suit : suits) {
			for (RankType rank : ranks) {
				Card card = new Card(suit, rank);
				this.cards.add(card);
			}
		}
		return this.cards;
	}


}
