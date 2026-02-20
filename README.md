🔐 OTP Authentication System (Java CLI)

A secure, modular, and extensible One-Time Password (OTP) authentication system built in Java.

This implementation simulates real-world authentication logic including:

Configurable OTP length (4 or 6 characters)

Numeric or alphanumeric OTP types

60-second expiry window

Maximum 3 verification attempts

Secure random generation

Clean separation of concerns (OOP design)

📌 Features
🔢 OTP Length Selection

4-character OTP

6-character OTP

🔐 OTP Type Selection

Numeric (0–9)

Alphanumeric (A–Z, 0–9)

⏳ Expiry Control

OTP automatically expires after 60 seconds

Expiry validated before each verification attempt

🚫 Attempt Limiting

Maximum 3 attempts

Account lock after exceeding limit

🔒 Security

Uses SecureRandom (cryptographically strong RNG)

Case-insensitive verification for usability

Immutable OTP model object

🏗 Project Structure
OTPApp/
│
├── Main.java          # CLI entry point
├── OTPService.java    # Business logic layer
├── OTP.java           # OTP data model
├── OTPType.java       # Enum for OTP types
└── README.md

🧠 Architecture Overview
1️⃣ Main (Presentation Layer)

Handles user interaction

Collects OTP configuration input

Controls verification attempts

Enforces expiry and lock logic

2️⃣ OTPService (Business Logic Layer)

Generates OTP

Validates input

Checks expiration

Encapsulates security logic

3️⃣ OTP (Data Model)

Immutable object

Stores:

code

expiryTime

4️⃣ OTPType (Enum)

Provides type-safe OTP generation modes:

public enum OTPType {
    NUMERIC,
    ALPHANUMERIC
}

⚙️ How It Works

User selects:

OTP length (4 or 6)

OTP type (Numeric or Alphanumeric)

System generates OTP using:

SecureRandom


OTP validity duration:

60 seconds


User gets:

Maximum 3 attempts


System checks:

Expiry status

Attempt count

Input match

🔢 Security Strength Comparison
Type	Length	Possible Combinations
Numeric	4	10⁴ = 10,000
Numeric	6	10⁶ = 1,000,000
Alphanumeric	4	36⁴ = 1,679,616
Alphanumeric	6	36⁶ = 2,176,782,336

Alphanumeric OTPs significantly increase brute-force resistance.
OUT PUT IMAGE
<img width="1911" height="1023" alt="OTPApp output3" src="https://github.com/user-attachments/assets/95afc10d-992c-4835-99e4-88c045d50bef" />
link to repo:https://github.com/Dheerajparihar111/OTPApp.java

