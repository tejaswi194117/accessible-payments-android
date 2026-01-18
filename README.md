Accessible Payments Dashboard (Android)

An accessible Android application that allows users to add, store, and view payment transactions in a simple and user-friendly dashboard.
Built using Android Studio (Java) with a focus on clarity, accessibility, and clean architecture.

Features

Dashboard to view saved transactions

Add new transactions (Amount & Merchant)

Local data persistence using SharedPreferences + Gson

Automatic update of dashboard after saving transactions

Simple, accessible UI components

Runs on Android Emulator and physical devices

Tech Stack

Language: Java

IDE: Android Studio

UI: XML (ConstraintLayout)

Data Storage: SharedPreferences

Serialization: Gson

Build System: Gradle

Project Structure
AccessiblePaymentsApp/
│
├── app/
│   ├── src/main/java/com/tejaswi/accessiblepayments/
│   │   ├── MainActivity.java
│   │   ├── AddTransactionActivity.java
│   │   ├── Transaction.java
│   │
│   ├── src/main/res/layout/
│   │   ├── activity_main.xml
│   │   ├── activity_add_transaction.xml
│   │
│   └── AndroidManifest.xml
│
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── .gitignore
└── README.md

Screenshots:
Available at app/res/drawable


or a /screenshots folder in the root.

How to Run the App

Clone the repository:

git clone https://github.com/tejaswi194117/accessible-payments-android.git


Open Android Studio

Click Open Project → select the cloned folder

Let Gradle sync finish

Start an Android Emulator or connect a physical device

Click : Run

Learning Outcomes

Android Activity lifecycle

Intent-based navigation

XML layout design

Data persistence with SharedPreferences

Debugging common Android crashes

Git & GitHub workflow for Android projects

Future Improvements

RecyclerView for better transaction listing

Delete / Edit transactions

Total amount summary

Material UI enhancements

Accessibility improvements (TalkBack support)

Author:

D R Tejaswi Yadav
GitHub: https://github.com/tejaswi194117

License

This project is for learning and educational purposes.
