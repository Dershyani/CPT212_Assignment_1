
// Importing Random class from java.util package
import java.util.Random;

// Main class
class CPT212_KaratsubaAlgorithm {

    // Global counter for primitive operations
    static long operationCount = 0;

    // Main driver method
    public static long mult(long x, long y) {
        operationCount++; // function call

        // Checking only if input is within range
        if (x < 10 && y < 10) {
            operationCount++; // multiplication
            return x * y;
        }

        // Declaring variables in order to
        // Find length of both integer
        // numbers x and y
        int noOneLength = numLength(x);
        int noTwoLength = numLength(y);
        operationCount += 2; // assignment

        // Finding maximum length from both numbers
        // using math library max function
        int maxNumLength = Math.max(noOneLength, noTwoLength);
        operationCount++; // max comparison and assignment

        // Rounding up the divided Max length
        Integer halfMaxNumLength = (maxNumLength / 2) + (maxNumLength % 2);
        operationCount += 2; // division and addition

        // Multiplier
        long maxNumLengthTen = (long) Math.pow(10, halfMaxNumLength);
        operationCount++; // pow operation

        // Compute the expressions
        long a = x / maxNumLengthTen;
        long b = x % maxNumLengthTen;
        long c = y / maxNumLengthTen;
        long d = y % maxNumLengthTen;
        operationCount += 4; // division and modulo

        // Compute all multiplying variables
        // needed to get the multiplication
        long z0 = mult(a, c);
        long z1 = mult(a + b, c + d);
        long z2 = mult(b, d);
        operationCount += 3; // recursive function calls

        long ans = (z0 * (long) Math.pow(10, halfMaxNumLength * 2) +
                ((z1 - z0 - z2) * (long) Math.pow(10, halfMaxNumLength) + z2));
        operationCount += 3; // multiplication and addition

        return ans;

    }

    // Method to calculate length of the number
    public static int numLength(long n) {
        int noLen = 0;
        while (n > 0) {
            noLen++;
            n /= 10;
            operationCount += 2; // loop iteration and division
        }

        // Returning length of number n
        return noLen;
    }

    // Main driver function
    public static void main(String[] args) {
        int maxDigits = 10; // maximum digit length
        Random random = new Random();

        for (int n = 1; n <= maxDigits; n++) {
            long x = (long) (Math.pow(10, n - 1) + random.nextInt((int) Math.pow(10, n - 1)));
            long y = (long) (Math.pow(10, n - 1) + random.nextInt((int) Math.pow(10, n - 1)));
            operationCount = 0; // reset counter

            long product = mult(x, y); // run multiplication
            System.out.println("Multiplying " + x + " and " + y + " resulted in " + product);
            System.out.println("Primitive operations count: " + operationCount);
            System.out.println("-----------------------------------");
        }
    }
}