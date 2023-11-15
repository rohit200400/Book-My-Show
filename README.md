# Welcome to Book My Show API

Thanks for checking out the Book My Show API documentation! This is a tool that helps manage shows, theaters, movies, and ticket bookings for an online ticketing platform.

## What is Book My Show?

Book My Show is an online platform that allows users to book tickets for movies and shows. This API is the behind-the-scenes system that makes it all work.

## Getting Started

To use the Book My Show API, follow these simple steps:

1. **Clone the Repository**
   - If you're a developer, this means making a copy of the code on your computer.

2. **Install Dependencies**
   - This is like installing the necessary tools to make everything run smoothly.

3. **Run the Server**
   - Start up the system so you can access it through a web address (like a URL).

The API will be available at `http://localhost:8080`.

## Documentation Link
The Swagger Documentation will be available at `http://localhost:8080/swagger-ui/index.html`.

## Demo Link
In this video, I provide a quick overview of the recently created Book My Show API. The API consists of four different controllers and multiple endpoints. I explain the purpose of each controller, including the registration controller for theatre registration, the movie controller for adding new movies, the ticket controller for booking tickets, and the show controller for creating shows for different auditoriums. I also highlight the access permissions for each controller, with some being restricted to staff members and others being accessible to general users. Important data handling techniques, such as file processing and data isolation, are also discussed. 
Please watch the video for a comprehensive understanding of the Book My Show API.
`https://www.loom.com/share/8ce48a1d939e4308b235e8a247e57cb4?sid=6ca3f672-90d6-423d-b981-160ad6d5801b`

## How to Use

Book My Show API has different features that you can use:

### Show Controller
- **Create Show:** This is used to add a new show.

### Registration Controller
- **Register Theatre:** Add a new theater to the system.
- **Add Auditorium:** Include a new auditorium in an existing theater.
- **Remove Auditorium:** Remove an auditorium from a theater.
- **Deregister Theatre:** Remove a theater from the system.

### Movie Controller
- **Add Movie:** Add a new movie to the database.

### Ticket Controller
- **Book Ticket:** Book tickets for a show.

