# 📔 Journal Application (REST API)

A production-ready Backend application built with **Spring Boot**, designed to help users manage their daily journals while providing administrators powerful management tools.

---

## 🚀 Core Functionalities

### 🔐 Security & Authentication
* **JWT (JSON Web Token):** Secure authentication system. No one can access the data without a valid token.
* **RBAC (Role-Based Access Control):** * **USER:** Can manage their own journals.
    * **ADMIN:** Can view all users, manage the system, and promote users to Admin status.

### 📝 User Features
* **Full CRUD Operations:** Users can Create, Read, Update, and Delete their journal entries.
* **Sentiment Analysis:** Integrated logic to track the "mood" or sentiment of journal entries (Spelling fixed: `sentimentAnalysis` ✅).

### ⚙️ Performance & Database
* **Database (MongoDB Atlas):** Using a cloud-based NoSQL database for flexible data storage.
* **Caching (Redis):** Integrated Redis server for high-performance data retrieval and caching.

### 🛠️ Admin Powers
* **User Management:** Admins can monitor all registered users in the system.
* **Promote to Admin:** Specialized endpoint to upgrade existing users to Admin status without losing data.

---

## 🛠 Tech Stack
* **Language:** Java 8 / 17
* **Framework:** Spring Boot 3.x
* **Security:** Spring Security & JWT
* **Database:** MongoDB (Cloud Atlas)
* **Cloud Deployment:** Render
