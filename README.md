# Java Password Cracker 🔐

This Java-based password cracker was developed as part of Project 1 for the **Security & Privacy in Computer Systems** course at NJIT. The goal was to simulate brute-force and dictionary-style attacks on hashed passwords to understand basic password cracking strategies.

## 🔧 Files

- `SimpleCracker.java` – A lightweight version that demonstrates brute-force/dictionary cracking for educational purposes.
- `Cracker.java` – More advanced or complete version of the cracker (if provided).
- `Output of Problem 1.pdf` – Contains screenshots or logs from the execution of the cracker.

## 💡 How It Works

The cracker:
- Takes a hashed password as input (SHA-1 or similar).
- Attempts to match it using combinations of characters from a predefined dictionary or character set.
- Prints the matched password when found.

## 🚀 How to Run

```bash
javac SimpleCracker.java
java SimpleCracker <hash_to_crack>
