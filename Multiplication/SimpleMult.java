import java.util.Random;

public class SimpleMult {
    static int processCount = 1;
    static int primitiveCounter = 0;

    public static void main(String[] args) {
        for (int n = 1; n <= 10; n++) {
            int[] multiplicand = generateRandomNumber(n);
            int[] multiplier = generateRandomNumber(n);
            multiplyAndPrint(multiplicand, multiplier);
        }
    }

    public static int multiplyAndPrint(int[] multiplicand, int[] multiplier) {
        int m = multiplicand.length;
        int n = multiplier.length;
        int[] products = new int[m + n];
        primitiveCounter = 0; // Resetting operation count
        primitiveCounter += 5; // 1 method call, 4 assignemnts

        System.out.println("\n-----------------------------------------");
        System.out.println("Simple Multiplication Process " + processCount++);
        System.out.println("-----------------------------------------");
        System.out.println("Multiplicand: " + arrayToString(multiplicand));
        System.out.println("Multiplier  : " + arrayToString(multiplier) + "\n");

        // Step 1: Multiply each digit in the multiplicand by each digit of the multiplier
        for (int i = n - 1; i >= 0; i--) {
            int[] partialProduct = new int[m + 1];
            int[] carrier = new int[m + 1];
            primitiveCounter+=5; // 3 assignments, 1 comparison, 1 arithmetic
            
            for (int j = m - 1; j >= 0; j--) {
                int product = multiplicand[j] * multiplier[i];
                partialProduct[j + 1] = product % 10;
                carrier[j + 1] += product / 10; 
                primitiveCounter += 10; // 4 assignments, 1 comparison, 5 arithmetic  
            }

            // Handle the carry-over of carriers from one digit position to the next
            for (int k = m; k > 0; k--) {
                carrier[k - 1] += carrier[k] / 10;
                carrier[k] %= 10;
                primitiveCounter += 8; // 3 assignments, 1 comparison, 4 arithmetic
            }

            printPartialProduct(multiplicand, multiplier[i], partialProduct);
            printCarrier(multiplicand, multiplier[i], carrier);

            // Add the partial products and carriers
            for (int k = m + i, l = m; k >= i; k--, l--) {
                products[k] += partialProduct[l];
                primitiveCounter += 7; // 3 assignemnts, 1 comparison, 3 arithmetic
                if (k - 1 >= 0) {
                    products[k - 1] += carrier[l];
                    primitiveCounter += 3; // 1 comparison, 1 assignment, 1 arithmetic
                }
            }
        }

        // Handle the carry-over of partial products from one digit position to the next
        for (int i = m + n - 1; i > 0; i--) {
            primitiveCounter += 3; // 1 assignment, 1 comparison, 1 arithmetic
            if (products[i] >= 10) {
                products[i - 1] += products[i] / 10;
                products[i] %= 10;
                primitiveCounter += 6; // 1 comparison, 2 assignments, 3 arithmetic
            }
        }

        System.out.print("Result of multiplication: ");
        System.out.println(printResult(products));

        System.out.println("Total Primitive Operations: " + primitiveCounter);

        primitiveCounter+=1; // 1 return from a method
        return 0;
    }

    private static void printPartialProduct(int[] multiplicand, int multiplierDigit, int[] partialProduct) {
        primitiveCounter += 1; // 1 method call
        System.out.print("Partial product for (" + arrayToString(multiplicand) + " x " + multiplierDigit + "): ");
        for (int i = 1; i < partialProduct.length; i++) {
            primitiveCounter += 3; // 1 assignment, 1 comparison, 1 arithmetic
            System.out.print(partialProduct[i]);
        }
        System.out.println();
    }

private static void printCarrier(int[] multiplicand, int multiplierDigit, int[] carrier) {
        primitiveCounter += 1; // 1 method call
        System.out.print("Carrier for (" + arrayToString(multiplicand) + " x " + multiplierDigit + "): ");
        for (int i = 1; i < carrier.length; i++) {
            primitiveCounter += 3; // 1 assignment, 1 comparison, 1 arithmetic
            if (i == 1) {
                System.out.print(carrier[i]);
                primitiveCounter += 1; // 1 comparison
            } else {
                System.out.print(carrier[i]);
            }
        }
        System.out.println();
        System.out.println();
    }

    // Printing the result of multiplication and also removing unwanted zero digits
    private static String printResult(int[] result) {
        boolean allZeros = true;
        primitiveCounter+=2; // 1 method call & 1 assignment
        
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            primitiveCounter+=1; // 1 comparison
            
            if (digit != 0) {
                 
                allZeros = false;
                primitiveCounter+=2; // 1 comparison, 1 assignment
                
                break;
            }
        }

        if (allZeros) {
            primitiveCounter+=1; // 1 comparison
            
            sb.append("0\n");
            
        } 
        
        else {
            int startIndex = 0;
             primitiveCounter+=1;// 1 assignment
            
            while (startIndex < result.length && result[startIndex] == 0) {
                startIndex++;
                primitiveCounter+= 2; // 1 comparison, 1 arithmetic
            }
             sb.append(printArray(result, startIndex));
             
            sb.append("\n");
        }
        primitiveCounter+=1; // 1 return from a method
        return sb.toString();
    }
    
    
    private static String printArray(int[] array, int startIndex) {
        primitiveCounter+=1; // 1 method call
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < array.length; i++) {
            primitiveCounter+=3; // 1 assignment, 1 comparison, 1 arithmetic
            sb.append(array[i]);
        }
        primitiveCounter+=1; // 1 return from a method
        return sb.toString();
    }

    // Converts integer array to string for easy visualization of multiplication
    public static String arrayToString(int[] array) {
        primitiveCounter+=1; // 1 method call
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            primitiveCounter+=1; // 1 comparison
            sb.append(num);
        }
        primitiveCounter+=1; // 1 return from a method
        return sb.toString();
    }

    public static int[] generateRandomNumber(int n) {
        primitiveCounter+=1; // 1 method call
        Random random = new Random();
        int[] number = new int[n];
        primitiveCounter+=2; // 2 assignments
        for (int i = 0; i < n; i++) {
            number[i] = random.nextInt(10);
            primitiveCounter += 4; // 2 assignments, 1 comparison, 1 arithmetic
        }
        primitiveCounter+=1; // 1 return from a method
        return number;
    }
}
