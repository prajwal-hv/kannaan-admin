# Kannaan Admin

**Kannaan Admin** is an internal web tool designed to manage and track orders, customers, and inventory for *Kannaan Fashions*, a homegrown clothing and jewelry resale business.

---

## 🧶 Purpose

Help small resellers like Kannaan Fashions streamline their business operations by moving from WhatsApp-based tracking to a proper order management system.

---

## 🛠 Tech Stack

| Layer     | Technology              |
|-----------|--------------------------|
| Frontend  | Angular + Bootstrap 5   |
| Backend   | Java + Spring Boot      |
| Database  | MongoDB (MongoDB Atlas) |
| Deployment | Netlify (Frontend), Render/Railway (Backend) |

---

## 🔑 Features (MVP)

- 🧺 Add & manage products (sarees, dresses, jewelry)
- 👥 Manage customer details
- 🛒 Create and track customer orders
- 📊 Track delivery status
- 📈 Dashboard for pending & completed orders

---

## 📦 Setup Instructions

### Backend
```bash
cd backend
mvn clean install
./mvnw spring-boot:run
