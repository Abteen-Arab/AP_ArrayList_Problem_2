import java.util.ArrayList;
public class Questions {
    /** Programmer: Abteen Arab
     *  Program: ArrayList Assignment 2
     * Date: Dec. 2, 2020
     */
    public static void main (String [] args) {
        //Primes List
        ArrayList <Integer> nums= new ArrayList();
        nums = Eratosthenes (20);
        
        System.out.println("The Primes: ");
        for (int i = 0; i<nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
        
        //Primes Of Evens
        int[] sum = new int [2];
        sum = goldbachConjecture(800);
        int num =  sum[0] + sum[1];
        
        System.out.println("\nThe Prime Sums Of " + num + ": ");
        for (int i = 0; i<sum.length; i++) {
            System.out.print(sum[i] + " ");
        }
        
        //Big Ints
        ArrayList <Integer> sumOfBigInts= new ArrayList();
        sumOfBigInts = addBigInts(9,5);
        
        System.out.println("\nThe Sum of Two Big Ints: ");
        for (int i = 0; i<sumOfBigInts.size(); i++) {
            System.out.print(sumOfBigInts.get(i) + " ");
        }
    }
    
    /** Loop 1: Creates an array list of natural numbers from 2 to max 
     *  Loop 2: The loop goes through all the numbers in the list 'nums' 
     *  Loop 3: For every number passed in Loop2, Loop3 goes through all the numbers in the list 'nums' to check whether they are multiples of previous values in 'nums'.
     */
    public static ArrayList <Integer> Eratosthenes(int max) {
        ArrayList <Integer> nums= new ArrayList();
        for (int i = 2; i<=max; i++) {
            nums.add(i);
        }
        
        for (int j = 0; j<nums.size();j++){
            for (int i = nums.size()-1; i>j; i--) {
                if (nums.get(i) % nums.get(j) == 0) {
                    nums.remove(i);
                }
            }
        } 
        return nums;
    }
    
    /** Primes List: This is the set of all prime numbers [2, even), where even = the number whose prime sum is seeked.
     *  Loop 1: Traverses through the list of primes. 
     *  Loop 2: Traverses through the list of primes and check to see if the sum of the primes in the first and second loop equal the prime
     */
    public static int[] goldbachConjecture(int even) {
        ArrayList <Integer> primes= new ArrayList();
        primes = Eratosthenes (even);
        int[] prime = new int [2];

        for (int i = 0; i<primes.size();i++){
            for (int j = 0; j<primes.size(); j++){
                if (primes.get(i) + primes.get(j) == even) {
                    prime [0] = primes.get(i);
                    prime [1] = primes.get(j);
                }
            }
        } 
        return prime;
    }
    
    /** Loop 1 and 2: Creates an array list of random natural numbers with max digits. 
     *  Loop 3: Creates a temporary sums array with the value of 0 
     *  Loop 4: Takes the sum of the int1 and int2, rounding where appropraite.
     *  Loop 5: Fills in the empty spots in the sum int
     *  Loop 6: Reverses the order of sums
     */
    public static ArrayList<Integer> addBigInts(int max1, int max2){
        ArrayList<Integer> int1 = new ArrayList<>();
        ArrayList<Integer> int2 = new ArrayList<>();
        ArrayList<Integer> sums = new ArrayList<>();
        ArrayList<Integer> temps = new ArrayList<>();
        
        int max = 0;
        int min = 0;
        
        
        for (int i = 0; i< max1; i++){
            int1.add((int)(Math.random() * 10));
        }
        for (int i = 0; i< max2; i++){
            int2.add((int)(Math.random() * 10));
        }
    
       
        if (int1.size() - int2.size() < 0) {
            min = int1.size();
            max = int2.size();
        } else {
            max = int1.size();
            min = int2.size();
        }
        
        for (int i = 0; i < max; i++){
            sums.add(0);
        }
        
        for (int i = 0; i < min; i++) {
           int sum = int1.get(i) + int2.get(i);
           if (sum > 9) {
               sums.set(i+1,sums.get(i+1)+1);
               sum %= 10;
           }
           sums.set(i, sum);
        }
        
        for (int i = min; i < max; i++) {
           if (int1.size() == max) {
               sums.set(i, int1.get(i));
           } else {
               sums.set(i, int2.get(i));
           }
        }
        return sums;
        
        /* Flips the answer in case we are adding the other way around
        for (int i = sums.size()-1; i >= 0; i--) {
           temps.add(sums.get(i));
        }
        
        return temps;
        */
    }
}
