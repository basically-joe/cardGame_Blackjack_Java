import java.util.ArrayList;

public class Dealer {


	private String name;
	private ArrayList<Card> dealerHand;

	public Dealer(String name) {
		this.name = name;
		this.dealerHand = new ArrayList<>();
	}

	public String getDealerName() {
		return this.name;
	}

	public Card deal(Deck deck) {
		return deck.dealCard();
	}

	public int countDealersCards(){
		return this.dealerHand.size();
	}

	public void addCardsToDealersHand(Card card){
		this.dealerHand.add(card);
	}

	public void removeAllCardsFromDealer(){
		this.dealerHand.clear();
	}

	public int checkDealerScore(){
		int total = 0;
		for (Card card : this.dealerHand){
			total += card.getValueFromEnum();
		}
		return total;
	}




}
