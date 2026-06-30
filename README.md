# TCP Client Server Assignment

## Overview

This project implements a TCP Client-Server application using Java Socket Programming. The client communicates with the server over TCP sockets. Messages exchanged between the client and server are encrypted using AES encryption.

---

## Features

- TCP Client-Server Communication
- Multi-threaded Server
- AES Encryption & Decryption
- Nested HashMap Data Storage
- Configurable IP Address
- Configurable Port Number
- Configurable Encryption Key
- Maven Project Structure
- Handles Invalid Requests by returning "EMPTY"

---

## Technologies Used

- Java 17
- Maven
- Java Socket Programming
- Java Collections Framework
- Multithreading
- AES Cryptography

---

## Project Structure

```
SocketProgrammingAssignment
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── client
│   │   │   ├── server
│   │   │   ├── security
│   │   │   └── util
│   │   │
│   │   └── resources
│   │       └── config.properties
│
├── pom.xml
└── README.md
```

---

## Configuration

Edit `config.properties`

```properties
server.ip=localhost
server.port=5000
aes.key=1234567890123456
```

---

## How to Run

### Start the Server

Run

```
Server.java
```

Output

```
Server Started
Listening on Port : 5000
```

### Start the Client

Run

```
Client.java
```

Enter input

```
SetA-Two
```

Output

```
30-06-2026 11:50:59
30-06-2026 11:51:00
```

---

## Sample Test Cases

| Input | Output |
|--------|--------|
| SetA-One | Current time 1 time |
| SetA-Two | Current time 2 times |
| SetB-Four | Current time 4 times |
| SetE-Ten | Current time 10 times |
| SetX-One | EMPTY |

---

## Author

**Anirudha Shinde**

