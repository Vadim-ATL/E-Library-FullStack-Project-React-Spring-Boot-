
# **E-Library Project**

Welcome to the E-Library project! This project is a digital library management system developed using React and Spring Boot. 

## **Short description of Backend controllers:**
    
### **BookController.java**
The BookController class is a REST controller responsible for handling HTTP requests related to books.
It allows requests from a specific origin (http://localhost:3000), which is typically the address of your React application.

### **Endpoints:**
* GET /api/v1/book: Returns a list of all books in the library.
* GET /api/v1/book/borrowedBooks: Returns a list of borrowed books.
* POST /api/v1/book/addNewBook: Adds a new book to the library.
* DELETE /api/v1/book/{bookId}: Deletes the book with the specified ID.
* PUT /api/v1/book/{bookId}: Updates the book with the specified ID. It accepts optional parameters for updating the title and ISBN of the book.

## **Short description of Frontend functions:**

### **App.js**

The App component is the root component of the React application.
It renders three child components:

* BookList: Displays a list of all books in the library.
* AddNewBook: Allows users to add a new book to the library.
* BorrowedBooksList: Displays a list of borrowed books.

### Technologies Used
* React: A JavaScript library for building user interfaces.
* Spring Boot: A Java-based framework for building web applications.

* RESTful API: Used for communication between the frontend and backend.
* Cross-Origin Resource Sharing (CORS): Allows the React frontend to make requests to the Spring Boot backend.

### Getting Started

To run the project locally, follow these steps:

1. Clone the repository.
2. Navigate to the project directory.
3. Start the Spring Boot backend.
4. Start the React frontend.
5. Access the application in your web browser.

### License

This project is licensed under the * [MIT License](https://docs.github.com/en/github/writing-on-github "more info")


Thank you for using E-Library! If you have any questions or feedback, please don't hesitate to contact me. 

Happy reading!
