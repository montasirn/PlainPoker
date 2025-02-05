import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File f = new File("src/input");

        // Variables to accumulate totals for Part 1
        int fiveOfAKind = 0;
        int fourOfAKind = 0;
        int fullHouse = 0;
        int threeOfAKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        // List to store hands and their bids for Part 2
        List<Hand> hands = new ArrayList<>();
        List<Hand> handJ = new ArrayList<>();

        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                String[] parts = currentLine.split("\\|");
                String[] cards = parts[0].split(",");
                int bid = Integer.parseInt(parts[1]);

                //Create hand object for part 1 and 2
                Hand hand = new Hand(cards, bid);
                hand.numCards();
                String handType = hand.evaluateHand();

                //Create hand object for part 3
                Hand hand1 = new Hand(cards, bid);
                hand1.numCards();
                String handTypeWild = hand1.evalHandWithJack();


                // Increment the appropriate counter for Part 1
                switch (handType) {
                    case "Five of a kind" -> fiveOfAKind++;
                    case "Four of a kind" -> fourOfAKind++;
                    case "Full house" -> fullHouse++;
                    case "Three of a kind" -> threeOfAKind++;
                    case "Two pair" -> twoPair++;
                    case "One pair" -> onePair++;
                    case "High card" -> highCard++;
                }

                // Add the hand to the list for Part 2
                hands.add(hand);
                handJ.add(hand1);
            }

            // sorting for part 2 and part 3 respectively

            Hand.sortArray(hands, false);
            Hand.sortArray(handJ, true);

            // Calculate total bid value for part 2 and part 3 separately

            Hand.calculateBid(hands);
            Hand.calculateBid(handJ);

            // Print Part 1 results
            System.out.println("Number of five of a kind hands: " + fiveOfAKind);
            System.out.println("Number of full house hands: " + fullHouse);
            System.out.println("Number of four of a kind hands: " + fourOfAKind);
            System.out.println("Number of three of a kind hands: " + threeOfAKind);
            System.out.println("Number of two pair hands: " + twoPair);
            System.out.println("Number of one pair hands: " + onePair);
            System.out.println("Number of high card hands: " + highCard);

            // Print Part 2 result
            Hand.calculateBid(hands);
            System.out.println("Total Bid Value: " + Hand.getTotalBid());

            // Print Part 3 result
            Hand.calculateBid(handJ);
            System.out.println("Total Bid Value With Jacks Wild: " + Hand.getTotalBid());

            //If input file is missing return error 1
        } catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }

    }

}
