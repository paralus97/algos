package challengequestions;

// You are given an integer that represents an amount of change you are to make. Assuming a US dollar denomination
// write a method that returns the smallest number of bills necessary to make change for the given amount. For
// example, if you need to make change for 7 USD, the correct answer is two (one $5 bill, one $2 bill). Write a method
// with the following signature:
public class SmallestNumberOfBills {

    static final int[] NOTES = {500, 100, 50, 20, 10, 5};

    /*
     * Complete the 'MakeChange' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER amount as parameter.
     */

    public static int MakeChange(int amount)
    {
        int res = 0;
        // For a given ammount, find the lowest common deonominator for a given ammount?
        // 5 euro notes for 15? 3
        // 10 euro notes for 15? 1

        // Start with highest note that leaves no remainder undivisable by other notes
        // 15 case, 100 leaves remainder 15, 50 leaves remainder 15, 10 leaves remainder 5, BOOM 5 leaves remainder 0
        // subtract 5 from sum, repeat till sum is 0 or indivisible without change
        boolean indivisibleByNotes = false;
        int currentAmmount = amount;
        while (currentAmmount > 0 && !indivisibleByNotes) {
            int note = getHighestNoteDivisor(currentAmmount);
            if (note != 0) {
                res++;
                currentAmmount -= note;
            } else {
                indivisibleByNotes = true;
            }
        }
        return res;
    }

    public static int getHighestNoteDivisor(int amount) {
        for (int note : NOTES) {
            if (amount % note == 0) {
                return note;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(MakeChange(25));
    }
}
