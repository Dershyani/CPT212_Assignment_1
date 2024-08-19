# Multiplication Algorithms in Java

This project for CPT212 involves implementing and analyzing multiplication algorithms.

- Simple Multiplication: Basic digit-by-digit multiplication.
- Karatsuba Algorithm: Optimized multiplication with operation counters and complexity analysis.

<img src="pdf_converter/Preview.gif" alt="Preview Leafy Website GIF" width="1200px" />

Prerequisites

Java Development Kit (JDK) installed. Download from Oracle.

## How To Use

1. **Pull the Docker images**
   
   ```bash
   docker pull httpd
   docker pull php:apache
   ```

2. **Download the repository**
   
   ```bash
   git clone https://github.com/Lithia22/CAT201_Assignment_1.git
   ```
   
3. **Enter the project folder**
   
   ```bash 
   cd pdf_converter
   ```
   
4. **Launch the Docker container**
   
   ```bash
   docker run -d -p 8000:80 --name PDF_converter -v "$(pwd)":/var/www/html php:apache
   ```
   
5. **Verify the container is running**
   
   ```bash
   docker ps
   ```
   
6. Access the application at localhost:8000 to start converting PDFs and TXT files.

## Sample Output
