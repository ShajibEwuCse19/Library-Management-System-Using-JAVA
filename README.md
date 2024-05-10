# Library Management System

## Project Description

This is a console application developed in Java. The project utilizes object-oriented programming concepts and collections. It simulates a library management system with features for both administrative staff and users.

## How to Run the Project

1. Clone or download the files.
2. Open the directory using a Java code editor or IDE (e.g., IntelliJ IDEA).
3. Simply run the 'application.java' file.
4. Use the features according to your choices.

## Actors

### Administrative Actors
- Librarian (Admin)

### User Actors
- Students
- Guest

## Features

### Admin Features
- Create, modify, and delete books
- Add/remove users
- View user list
- Logout

### Student Features
- View, edit, delete, and update profile information
- Change password
- Search books by title, author, or publisher
- Checkout, renew, and return books
- View book availability
- Logout

### Guest Features
- Search books by title, author, or publisher
- View book list, author list, and publisher list
- View book availability

## Database

### Book Database
- Fields: book id, title, author, publisher, date

### Student Database
- Fields: name, student id, address, password

### Admin Database
- Fields: name, employee id, contact, address, password

## Flow Diagram

<img src="flow_Diagram/Library_Management_System.png" alt="Library Management System Flow Diagram" width="300"/>

## Implementation Details

### Home Page
1. Registration
2. Login
3. Run as a guest user

### Registration Page (not applicable for Admin)
- Insert (name, id, password, contact, address) and save information in the database
- Go to Login page
- Option to go back to the home page

### Login Page
- Insert (id, password)
- Verify information
- Option to go back to the home page
- Success (Go to Students/Admin/Guest Page)
- Unsuccessful login (notification and prompt to enter login information again)

### Students/Admin/Guest Page Choices
- Create, modify, and delete books
- Add/remove users
- View, edit, delete, and update profile information
- Change password
- Search books by title, author, or publisher
- Checkout, renew, and return books (only for students)
- View book availability
- View book, author, and publisher lists (with categorical searching option)
- Logout/Exit option
