import java.util.Arrays;


public class hand {


    private int fiveOfAKind;
    private int fourOfAKind;
    private int fullHouse;
    private int threeOfAKind;
    private int twoPair;
    private int onePair;
    private int highCard;
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


    private String[] hands;


    public hand(String[] cards){
        hands = cards;
    }


    public int getFiveOfAKind(){
        if (num2 == 5 | num3 == 5 | num4 == 5 | num5 == 5 | num6 == 5 | num7 == 5 | num8 == 5 | num9 == 5 | num10 == 5 | numKing == 5 | numQueen == 5 | numJack == 5 | numAce == 5){
            fiveOfAKind ++;
        }
        return fiveOfAKind;
    }


    public int getFourOfAKind(){
        if (num2 == 4 | num3 == 4 | num4 == 4 | num5 == 4 | num6 == 4 | num7 == 4 | num8 == 4 | num9 == 4 | num10 == 4 | numKing == 4 | numQueen == 4 | numJack == 4 | numAce == 4){
            fourOfAKind ++;
        }
        return fourOfAKind;
    }


    public int getFullHouse(){
        if (num2 == 3 | num3 == 3 | num4 == 3 | num5 == 3 | num6 == 3 | num7 == 3 | num8 == 3 | num9 == 3 | num10 == 3 | numKing == 3 | numQueen == 3 | numJack == 3 | numAce == 3){
            if (num2 == 2 | num3 == 2 | num4 == 2 | num5 == 2 | num6 == 2 | num7 == 2 | num8 == 2 | num9 == 2 | num10 == 2 | numKing == 2 | numQueen == 2 | numJack == 2 | numAce == 2) {
                fullHouse ++;
            }
        }
        return fullHouse;
    }


    public int getThreeOfAKind(){
        if (num2 == 3 | num3 == 3 | num4 == 3 | num5 == 3 | num6 == 3 | num7 == 3 | num8 == 3 | num9 == 3 | num10 == 3 | numKing == 3 | numQueen == 3 | numJack == 3 | numAce == 3){
            if (num2 != 2 && num3 != 2 && num4 != 2 && num5 != 2 && num6 != 2 && num7 != 2 && num8 != 2 && num9 != 2 && num10 != 2 && numKing != 2 && numQueen != 2 && numJack != 2 && numAce != 2) {
                threeOfAKind ++;
            }
        }
        return threeOfAKind;
    }


    public int getTwoPair(){
        int a = 0;
        int[] pairs = {num2, num3, num4, num5, num6, num7, num8, num9, num10, numKing, numQueen, numJack, numAce};
        for (int item : pairs){
            if (item == 2){
                a ++;
            }
        }
        if (a == 2){
            twoPair ++;
        }
        return twoPair;
    }


    public void numCards(){
        for (String hand : hands) {
            switch (hand) {
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


    public int getNum5() {
        return num5;
    }


    @Override
    public String toString() {
        return Arrays.toString(hands);
    }
}
