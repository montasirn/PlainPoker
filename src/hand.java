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
