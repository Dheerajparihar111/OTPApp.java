🔐 Java OTP Generator (CLI Application)

A secure, object-oriented One-Time Password (OTP) generation and verification system built in Java.
The application generates a 6-digit OTP using a cryptographically secure algorithm and includes a real-time countdown timer with automatic expiry handling.

📌 Features

Secure 6-digit OTP generation

Cryptographically strong random number generation (SecureRandom)

60-second OTP expiry

Live countdown timer (60 → 0)

OTP verification

Clean OOP architecture

Multithreading for countdown timer

Console-based user interaction

🏗 Project Structure
otp-app
│
├── OTPApp.java        (Main application entry point)
├── OTPService.java    (OTP generation & verification logic)
└── OTP.java           (OTP model class)

🧠 Architecture Overview
OTP.java

Model class that stores:

OTP code

Expiry timestamp

OTPService.java

Business logic layer:

Generates OTP

Sets expiry time

Verifies user input

Checks expiry condition

OTPApp.java

Presentation layer:

Handles user input

Starts countdown thread

Displays results

🔐 Security Implementation

The application uses:

java.security.SecureRandom


instead of:

java.util.Random


SecureRandom provides cryptographically strong random number generation suitable for authentication systems.

⏳ Countdown Timer

Runs on a separate thread

Decrements from 60 to 0

Displays remaining time in real-time

Automatically expires OTP after timeout

Stops when OTP is verified
