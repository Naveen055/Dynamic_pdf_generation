# Invoice PDF Generator

A Spring Boot application that generates PDF invoices dynamically based on provided data. The application exposes a REST API to accept invoice details, generate a PDF, and allow users to download it.

---

## Features
- **Dynamic PDF Generation**: Generates PDF invoices using Thymeleaf templates and iText.
- **REST API**: Exposes a POST endpoint to accept invoice data and return a PDF file.
- **Local Storage**: Stores generated PDFs locally for future retrieval.
- **Test Cases**: Includes sample test cases for validation and edge cases.

---

## Technologies Used
- **Spring Boot**: Backend framework for building the REST API.
- **Thymeleaf**: Templating engine for generating HTML.
- **iText**: Library for converting HTML to PDF.
- **Maven**: Build tool for managing dependencies.
- **Postman**: Tool for testing the API.

---

## Prerequisites
Before running the project, ensure you have the following installed:
1. **Java Development Kit (JDK)**: Version 17 or higher.
2. **Maven**: For building and managing dependencies.
3. **Postman** (optional): For testing the API.

---

## Setup and Installation
Follow these steps to set up and run the project locally:

### 1. Clone the Repository
```bash
git clone https://github.com/Naveen055/invoice-pdf-generator.git
cd invoice-pdf-generator
```

### 2. Build the Project
Run the following command to build the project using Maven:
```bash
mvn clean install
```

### 3. Run the Application
Start the Spring Boot application:
```bash
mvn spring-boot:run
```
The application will start on `http://localhost:8080`

---

## API Documentation
The application exposes the following REST API:

**Generate PDF Invoice**
- **Endpoint**: `POST /api/invoice/generate`
- **Request Body**:
  ```json
  {
    "seller": "XYZ Pvt. Ltd.",
    "sellerGstin": "29AABBCCDD121ZD",
    "sellerAddress": "New Delhi, India",
    "buyer": "Vedant Computers",
    "buyerGstin": "29AABBCCDD131ZD",
    "buyerAddress": "New Delhi, India",
    "items": [
      {
        "name": "Product 1",
        "quantity": "12 Nos",
        "rate": 123.00,
        "amount": 1476.00
      }
    ]
  }
  ```
- **Response**:
  - Status: `200 OK`
  - Body: A PDF file named `invoice.pdf.`

---

## Testing the API
You can test the API using **Postman** or **cURL**.

### Using Postman
1. Open Postman.
2. Set the request type to **POST**.
3. Enter the URL: `http://localhost:8080/api/invoice/generate`.
4. Set the body to **raw** and **JSON**.
5. Paste the JSON input (as shown above).
6. Click **Send** and download the PDF file.

### Using cURL
Run the following command in your terminal:
```bash
curl -X POST http://localhost:8080/api/invoice/generate \
-H "Content-Type: application/json" \
-d '{
  "seller": "XYZ Pvt. Ltd.",
  "sellerGstin": "29AABBCCDD121ZD",
  "sellerAddress": "New Delhi, India",
  "buyer": "Vedant Computers",
  "buyerGstin": "29AABBCCDD131ZD",
  "buyerAddress": "New Delhi, India",
  "items": [
    {
      "name": "Product 1",
      "quantity": "12 Nos",
      "rate": 123.00,
      "amount": 1476.00
    }
  ]
}' --output invoice.pdf
```

---

## Test Cases
Here are some test cases to validate the API:

| **Test Case**               | **Input**                                                                 | **Expected Output**                     |
|-----------------------------|---------------------------------------------------------------------------|-----------------------------------------|
| Valid Input                 | Complete JSON with seller, buyer, and items.                              | `200 OK` with a valid PDF file.         |
| Missing Required Fields     | JSON without `items`.                                                    | `400 Bad Request` with an error message.|
| Empty Items List            | JSON with an empty `items` array.                                         | `400 Bad Request` with an error message.|
| Invalid Data Types          | JSON with `rate` as a string instead of a number.                         | `400 Bad Request` with an error message.|
| Large Input Data            | JSON with a large number of items in the `items` list.                    | `200 OK` with a valid PDF file.         |
| Special Characters in Fields| JSON with special characters in `seller`, `buyer`, or `items.name`.       | `200 OK` with a valid PDF file.         |

---

## Contributing
Contributions are welcome! If you find any issues or want to add new features, feel free to open a pull request.


---

## Acknowledgments
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [iText](https://itextpdf.com/)

---

## Contact
For any questions or feedback, please reach out to:

- **Your Name**: Naveen  
- **Email**: [spnaveenkumar623@gmail.com](mailto:spnaveenkumar623@gmail.com)  
- **GitHub**: [Naveen055](https://github.com/Naveen055)
