package NBAPlayers;
import java.util.*;

public class playerString {
	String playerList;
	List<String> remainingPlayers;
	int stringLength=1;
	public boolean addTerm()
	{
		String searchTerm = playerList.substring(playerList.lastIndexOf('$') + 1) + "$";
        List<String> matchingTerms = new ArrayList<>();
        for (String term : remainingPlayers) {
            if (term.contains(searchTerm)) {
                matchingTerms.add(term);
            }
        }

        if (matchingTerms.isEmpty()) {
            return false;
        }

        int randomIndex = (int)(Math.random() * matchingTerms.size());
        String selectedTerm = matchingTerms.get(randomIndex);

        remainingPlayers.remove(selectedTerm);
        playerList = playerList+"$"+selectedTerm.split("\\$")[1];
        stringLength++;
        return true;
	}
	public int getStringLength()
	{
		return stringLength;
	}
	public String getPlayerList()
	{
		return playerList;
	}
	public List<String> getRemainingPlayers ()
	{
		return remainingPlayers;
	}
}
