# RSA-Algorithm-Code
RSA Encryption: Implemented RSA algorithm for secure communication
# RSA Encryption and Decryption Project

## Overview
This Java program implements the RSA algorithm, which is a widely used public-key encryption system. RSA uses a pair of keys for encryption and decryption:
- **Public Key** (e, n): Used to encrypt data.
- **Private Key** (d, n): Used to decrypt data.

The program generates two large prime numbers, `p` and `q`, computes their product `n`, and uses this information to calculate the public and private keys. Then, it encrypts and decrypts a message using these keys.

## Features
- **Prime Generation**: The program finds two prime numbers `p` and `q` within a user-defined range.
- **Key Generation**: It computes the RSA keys (`e`, `d`, and `n`).
- **Encryption**: The message is encrypted using the public key.
- **Decryption**: The encrypted message is decrypted using the private key.
- **Modular Arithmetic**: The encryption and decryption processes involve modular exponentiation.

## Requirements
- Java Development Kit (JDK) 8 or later.
- Command line interface for running the Java program.

## Installation
1. **Clone or Download the Code**:
   - Clone the repository or download the `RSA_project.java` file.

2. **Compile the Java Program**:
   - Open a terminal or command prompt in the directory containing the `RSA_project.java` file.
   - Compile the program using the following command:
     ```bash
     javac RSA_project.java
     ```

3. **Run the Program**:
   - After compilation, run the program with the following command:
     ```bash
     java RSA_project
     ```

## Usage

### Step 1: Input the Upper Limits for Prime Generation
The program will prompt you to enter the upper limits for the two primes `p` and `q`. These limits determine the range from which the program will generate two prime numbers.

```text
Enter Two distinct upper limits for the two primes p, q:
upper limit for p: 100
upper limit for q: 100
```

### Step 2: Enter a Message to Encrypt
Once the primes are generated, you will be asked to enter the message you want to encrypt.

```text
Enter Original Message: Hello
```

### Step 3: View the Results
The program will then display the following:
- The generated prime numbers `p` and `q`.
- The computed public key `(e, n)` and private key `(d, n)`.
- The encrypted message.
- The decrypted message.

Example output:

```text
p = 97
q = 89
n = 8633
m = 8448
e = 3
d = 5632
Cipher Message : Iwwjl
Decrypted Message : Hello
```

### Encryption and Decryption Process
1. **Encryption**: The message is encrypted using the public key `e` and `n` with the formula:
   ```text
   Cipher = (Plaintext^e) % n
   ```

2. **Decryption**: The cipher text is decrypted using the private key `d` and `n` with the formula:
   ```text
   Plaintext = (Cipher^d) % n
   ```

## Functions

### `checkForPrime(BigInteger i)`
Checks whether the number `i` is a prime number using trial division from 2 to √i.

### `sumN(BigInteger p, BigInteger q)`
Calculates the modulus `n = p * q` for the RSA algorithm.

### `sumM(BigInteger p, BigInteger q)`
Calculates `m = (p-1) * (q-1)` which is used for key generation.

### `sumE()`
Generates the public exponent `e`, which is coprime with `m`.

### `sumD()`
Calculates the private exponent `d` such that `(e * d) ≡ 1 (mod m)`.

### `main()`
This is the entry point of the program. It handles user input, generates primes `p` and `q`, computes the keys, encrypts the message, and decrypts the message.

## Example

### Input:
```text
Enter Two distinct upper limits for the two primes p,q:
upper limit for p: 100
upper limit for q: 100
Enter Original Message: Hello
```

### Output:
```text
p = 97
q = 89
n = 8633
m = 8448
e = 3
d = 5632
Cipher Message : Iwwjl
Decrypted Message : Hello
```

## Conclusion
This project demonstrates the RSA encryption and decryption process using Java. It showcases the key generation, encryption, and decryption steps in the RSA algorithm. You can experiment with different prime ranges and messages to explore the RSA cryptosystem further.

Author
Marina Abdallah– https://github.com/Marina-Abdallah
