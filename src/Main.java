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

        try {
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String currentLine = s.nextLine();
                String[] parts = currentLine.split("\\|");
                String[] cards = parts[0].split(",");
                int bid = Integer.parseInt(parts[1]);

                Hand hand = new Hand(cards, bid);
                hand.numCards();
                String handType = hand.evaluateHand();

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
            }

            // Sort the hands based on strength
            hands.sort((h1, h2) -> {
                int typeComparison = Integer.compare(getHandTypeStrength(h2.getType()), getHandTypeStrength(h1.getType()));
                if (typeComparison != 0) {
                    return typeComparison;
                }
                // If types are equal, compare card by card
                for (int i = 0; i < 5; i++) {
                    int cardComparison = Integer.compare(getCardStrength(h2.getCards()[i]), getCardStrength(h1.getCards()[i]));
                    if (cardComparison != 0) {
                        return cardComparison;
                    }
                }
                return 0;
            });

            // Calculate total bid value
            int totalValue = 0;
            for (int i = 0; i < hands.size(); i++) {
                int rank = i + 1; // Rank starts at 1 for the weakest hand
                totalValue += hands.get(i).getBid() * rank;
            }

            // Print Part 1 results
            System.out.println("Number of five of a kind hands: " + fiveOfAKind);
            System.out.println("Number of full house hands: " + fullHouse);
            System.out.println("Number of four of a kind hands: " + fourOfAKind);
            System.out.println("Number of three of a kind hands: " + threeOfAKind);
            System.out.println("Number of two pair hands: " + twoPair);
            System.out.println("Number of one pair hands: " + onePair);
            System.out.println("Number of high card hands: " + highCard);

            // Print Part 2 result
            System.out.println("Total Bid Value: " + totalValue);

        } catch (FileNotFoundException fe) {
            System.out.println("File was not found");
            System.exit(1);
        }
    }

    // Helper method to get the strength of a hand type
    private static int getHandTypeStrength(String type) {
        return switch (type) {
            case "Five of a kind" -> 7;
            case "Four of a kind" -> 6;
            case "Full house" -> 5;
            case "Three of a kind" -> 4;
            case "Two pair" -> 3;
            case "One pair" -> 2;
            case "High card" -> 1;
            default -> 0;
        };
    }

    // Helper method to get the strength of a card
    private static int getCardStrength(String card) {
        return switch (card) {
            case "Ace" -> 14;
            case "King" -> 13;
            case "Queen" -> 12;
            case "Jack" -> 11;
            case "10" -> 10;
            case "9" -> 9;
            case "8" -> 8;
            case "7" -> 7;
            case "6" -> 6;
            case "5" -> 5;
            case "4" -> 4;
            case "3" -> 3;
            case "2" -> 2;
            default -> 0;
        };
    }
}