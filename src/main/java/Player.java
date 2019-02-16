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

}
