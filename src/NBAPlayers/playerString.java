package NBAPlayers;
import java.util.*;

public class playerString {
	String playerList;
	List<String> remainingPlayers;
	int stringLength=0;
	public boolean addTerm()
	{
		String searchTerm = playerList.substring(playerList.lastIndexOf('$') + 1) + "$";
		//System.out.println(searchTerm);
        List<String> matchingTerms = new ArrayList<>();
        for (String term : remainingPlayers) {
            if (term.contains(searchTerm)) {
                matchingTerms.add(term);
            }
        }

        if (matchingTerms.isEmpty()) {
            //System.out.println("No matches found");
            return false;
        }

        int randomIndex = (int)(Math.random() * matchingTerms.size());
        String selectedTerm = matchingTerms.get(randomIndex);

        remainingPlayers.remove(selectedTerm);
        playerList = playerList+"$"+selectedTerm.split("\\$")[1];
        stringLength++;
        //System.out.println(stringLength);
        //System.out.println(playerList);
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
}
