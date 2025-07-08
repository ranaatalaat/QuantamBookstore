Quantum Bookstore Implementation 

This is a minimal and extensible system for managing an online bookstore.

Book Types
	•	Paper Book – Shipped to a physical address.
	•	EBook – Sent via email.
	•	Showcase Book – Not for sale.

Features
	•	Add books with ISBN, title, author, year, and price.
	•	Remove outdated books.
	•	Buy books by ISBN and quantity:
	•	Reduces stock.
	•	Sends via ShippingService or MailService (not implemented).
	•	Returns total paid or throws error if unavailable.

All output is prefixed with Quantum Book Store.

Testing

Includes a class to demonstrate and test functionality.

test cases:
![Screenshot (470)](https://github.com/user-attachments/assets/3aad88b0-9143-49a3-ac5d-09ca1970103f)
![Screenshot (472)](https://github.com/user-attachments/assets/0d81335b-ae7f-407c-9961-a129d9920a79)
![Screenshot (471)](https://github.com/user-attachments/assets/5cb8e35a-1b6c-4eb8-afb1-cc8c5e75e309)
