# Multiplication Algorithms in Java

This project for CPT212 involves implementing and analyzing multiplication algorithms.

- **Simple Multiplication:** Basic digit-by-digit multiplication.

<p>
  <img width="368" alt="Screenshot 2024-08-19 at 4 57 29 PM" src="https://github.com/user-attachments/assets/20eea200-852d-43c2-8295-4719371b63e7" style="display:inline-block; margin-right:10px;" />
</p>

- **Karatsuba Algorithm:** Optimized multiplication with operation counters and complexity analysis.

<p>
  <img width="511" alt="Screenshot 2024-08-19 at 4 57 52 PM" src="https://github.com/user-attachments/assets/4c0b1d11-4ea3-4ab1-9391-c5946080993f" style="display:inline-block;" />
</p>

## Prerequisites

Java Development Kit (JDK) installed. Download from Oracle.

## How To Use

1. **Clone the repository**
   
   ```bash
   git clone https://github.com/Lithia22/CPT212_Assignment_1.git
   ```

2. **Navigate to the project directory**
   
   ```bash
   cd Multiplication
   ```
   
3. **Compile the program**
   
   ```bash 
   javac SimpleMultiplication.java Karatsuba.java
   ```
   
4. **Run the Simple Multiplication**
   
   ```bash
   java SimpleMultiplication
   ```
   
5. **Run the Karatsuba Algorithm**
   
   ```bash
   java Karatsuba
   ```

## Sample Output

### Case 1: Pattern Found

**Scenario 1: Non-Repetitive Pattern**

- **Text:** BAD CHARACTER TABLE
- **Pattern:** TABLE

  Output:
  - `All characters match, so the pattern "TABLE" is found at index 14 in the text.`
  - `Total occurences of the pattern in the text: 1`

**Scenario 2: Repetitive Pattern**

- **Text:** AABAACAADAABAABA
- **Pattern:** AABA

  Output:
  - `All characters match, so the pattern "AABA" is found at index 0 in the text.`
  - `All characters match, so the pattern "AABA" is found at index 9 in the text.`
  - `All characters match, so the pattern "AABA" is found at index 12 in the text.`
  - `Total occurences of the pattern in the text: 3`

### Case 2: No Pattern Found

- **Text:** Boyer Moore
- **Pattern:** Algo

  Output: `No such pattern is found in the text`
