import java.util.List;

class Hand {
    private int num2;
    private int num3;
    private int num4;
    private int num5;
    private int num6;
    private int num7;
    private int num8;
    private int num9;
    private int num10;
    private int numKing;
    private int numQueen;
    private int numJack;
    private int numAce;

    private static int totalBid;

    private String[] cards;
    private int bid;
    private String type;

    public Hand(String[] cards, int bid) {
        this.cards = cards;
        this.bid = bid;
    }

    public void numCards() {
        for (String card : cards) {
            switch (card) {
                case "2" -> num2++;
                case "3" -> num3++;
                case "4" -> num4++;
                case "5" -> num5++;
                case "6" -> num6++;
                case "7" -> num7++;
                case "8" -> num8++;
                case "9" -> num9++;
                case "10" -> num10++;
                case "King" -> numKing++;
                case "Queen" -> numQueen++;
                case "Jack" -> numJack++;
                case "Ace" -> numAce++;
            }
        }
    }

    public String evaluateHand() {
        int[] counts = {num2, num3, num4, num5, num6, num7, num8, num9, num10, numKing, numQueen, numJack, numAce};

        int pairs = 0;
        boolean threeOfAKind = false;
        boolean fourOfAKind = false;
        boolean fiveOfAKind = false;

        for (int count : counts) {
            if (count == 2) pairs++;
            if (count == 3) threeOfAKind = true;
            if (count == 4) fourOfAKind = true;
            if (count == 5) fiveOfAKind = true;
        }

        if (fiveOfAKind) {
            type = "Five of a kind";
        } else if (fourOfAKind) {
            type = "Four of a kind";
        } else if (threeOfAKind && pairs == 1) {
            type = "Full house";
        } else if (threeOfAKind) {
            type = "Three of a kind";
        } else if (pairs == 2) {
            type = "Two pair";
        } else if (pairs == 1) {
            type = "One pair";
        } else {
            type = "High card";
        }

        return type;
    }

    public String evalHandWithJack(){
        int[] counts = {num2, num3, num4, num5, num6, num7, num8, num9, num10, numKing, numQueen, numAce, numJack};

        int pairs = 0;
        boolean threeOfAKind = false;
        boolean fourOfAKind = false;
        boolean fiveOfAKind = false;
        boolean fullHouse = false;
        boolean twoPair = false;
        boolean onePair = false;
        boolean highCard = false;
        int num = 0;

        for (int i = 0; i < counts.length - 1; i++) {
            if (counts[i] > num) {
                num = counts[i];
            }
        }

        for (int count : counts) {
            if (count == 2) pairs++;
        }

        if (num + numJack == 5) {
            fiveOfAKind = true;
        } else if (num + numJack == 4) {
            fourOfAKind = true;
        } else if (num + numJack == 3 && pairs == 0) {
            threeOfAKind = true;
        } else if (num + numJack == 3 && pairs == 1) {
            fullHouse = true;
        } else if (num == 2 && pairs == 2) {
            twoPair = true;
        } else if (num == 2 && pairs == 1) {
            onePair = true;
        } else {
            highCard = true;
        }

        if (fiveOfAKind) {
            type = "Five of a kind";
        } else if (fourOfAKind) {
            type = "Four of a kind";
        } else if (fullHouse) {
            type = "Full house";
        } else if (threeOfAKind) {
            type = "Three of a kind";
        } else if (twoPair) {
            type = "Two pair";
        } else if (onePair) {
            type = "One pair";
        } else if (highCard) {
            type = "High card";
        }
        return type;
    }

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

    public static void sortArray(List<Hand> hands, boolean ifWild){
        hands.sort((h1, h2) -> {
            int num = getHandTypeStrength(h2.getType());
            int num1 = getHandTypeStrength(h1.getType());
            if (num == 11 && ifWild) num = 1;
            if (num1 == 11 && ifWild) num1 = 1;
            int typeComparison = Integer.compare(num, num1);
            if (typeComparison != 0) {
                return typeComparison;
            }
            // If types are equal, compare card by card
            for (int i = 0; i < 5; i++) {
                int numIfJack = getCardStrength(h2.getCards()[i]);
                int numIfJack1 = getCardStrength(h1.getCards()[i]);
                if (numIfJack == 11 && ifWild) numIfJack = 1;
                if (numIfJack1 == 11 && ifWild) numIfJack1 = 1;
                int cardComparison = Integer.compare(numIfJack, numIfJack1);
                if (cardComparison != 0) {
                    return cardComparison;
                }
            }
            return 0;
        });
    }


    public static void calculateBid(List<Hand> hand){
        totalBid = 0;
        int rank = hand.size();
        for (Hand line : hand){
            totalBid += line.getBid() * rank;
            rank --;
        }
    }

    public static int getTotalBid(){
        return totalBid;
    }


    public String[] getCards() {
        return cards;
    }

    public int getBid() {
        return bid;
    }

    public String getType() {
        return type;
    }
}
