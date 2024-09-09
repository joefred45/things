package NBAPlayers;

import java.util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NBAPlayers {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\zrobe\\Desktop\\player_names.txt";
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String finalString = "";
        int maxLength = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many times would you like to simulate? (For reference, 500 simulations takes about 30 seconds)");
        int simulationTimes = scanner.nextInt();
        System.out.println("Simulating " + simulationTimes + " times....");
        scanner.close();
        for (int i = 0; i<simulationTimes; i++) {
        	for (int j = 0; j < lines.size(); j++) 
        	{
		        playerString test1 = new playerString();
		        test1.playerList=lines.get(j);;
		        test1.remainingPlayers=lines;
		        while (test1.addTerm());
		        if (test1.getStringLength()>maxLength) {
		        	maxLength = test1.getStringLength();
		        	finalString = test1.getPlayerList();
		        }
        	}
        	printLoadingBar(i, simulationTimes);
        }
        System.out.println ("\nBiggest String Found: " + maxLength);
        System.out.println(finalString);
    }
    public static void printLoadingBar(int current, int total) {
        int percent = (int) ((current * 100) / total);

        int barLength = 50;
        int filledLength = (int) ((percent / 100.0) * barLength);
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < filledLength; i++) {
            bar.append("=");
        }
        for (int i = filledLength; i < barLength; i++) {
            bar.append(" ");
        }
        bar.append("] ").append(percent).append("%");

        System.out.print("\r" + bar.toString());
    }
}

   
