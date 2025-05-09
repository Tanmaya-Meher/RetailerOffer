# Retailers Reward Points Calculator

This project calculates reward points for customers based on their monthly purchases. It is implemented as a RESTful Spring Boot application.

## 🔧 Features
- Accepts customer transactions via API.
- Calculates reward points based on amount spent.
- Returns rewards grouped by customer and month.
- Follows clean code practices and layered architecture.

## 📦 Technologies Used
- Java 17
- Spring Boot
- Maven
- JUnit for testing
- Postman for API testing

## 🚀 API Endpoints

### POST `/customer/rewards/calculate`

**Request Body (JSON):**
```json
[
  {
    "customerId": "CUST1001",
    "transactionDate": "2025-04-15",
    "amount": 120
  },
  {
    "customerId": "CUST1001",
    "transactionDate": "2025-05-05",
    "amount": 75
  },
  {
    "customerId": "CUST1002",
    "transactionDate": "2025-04-01",
    "amount": 110
  }
]