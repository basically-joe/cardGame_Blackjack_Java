import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	public ArrayList<Card> cards;

	public Deck(){
		this.cards = new ArrayList<>();
	}

	public int getDeckCardCount(){
		return this.cards.size();
	}

	public ArrayList getDeck(){
		return this.cards;
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

	public void shuffleCards(){
		Collections.shuffle(this.cards);
	}

	public Card dealCard(){
		return this.cards.remove(0);
	}


}
