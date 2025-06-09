# 🚀 Elevator System Design - LLD

A Low-Level Design (LLD) implementation of an Elevator (Lift) System that models real-world elevator behavior in a multi-floor building. Designed with object-oriented programming principles and extensibility in mind.

---

## 📚 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Design Principles](#design-principles)
- [Class Diagram (UML)](#class-diagram-uml)
- [System Components](#system-components)
- [Technologies Used](#technologies-used)
- [How to Run](#how-to-run)
- [Future Improvements](#future-improvements)
- [Contributing](#contributing)

---

## 🧾 Overview

This project demonstrates the **object-oriented low-level design** of an Elevator System. It simulates elevator operations in a multi-floor building, handling requests from users both inside the elevator (cabin buttons) and from building floors (hall calls).

---

## 🎯 Features

- Support for multiple elevators
- Handles internal and external requests
- Elevator states: **Moving**, **Idle**, **Maintenance**, **Stop**
- Direction-based scheduling (up/down)
- Priority and queue management
- Emergency stop (optional)
- Fault handling (optional)

---

## 🧠 Design Principles

- **Single Responsibility Principle** – each class handles a specific part of the system.
- **Open/Closed Principle** – easily extend the system to support new features like express elevators.
- **Encapsulation** – all state changes are managed through methods.
- **Separation of Concerns** – scheduling logic is decoupled from elevator motion.


Main components:

- `ElevatorSystem`
- `Elevator`
- `Request`
- `Scheduler`
- `Floor`

---

## 🧩 System Components

### ElevatorSystem
- Manages a fleet of elevators
- Delegates request handling

### Elevator
- Tracks current floor, direction, and state
- Maintains queues for up and down requests

### Scheduler
- Decides which elevator should respond to a request
- Optimizes for minimal wait time and distance

### Request
- Represents a user's input (floor + direction)
- Types: `ExternalRequest`, `InternalRequest`

### Floor & Button
- Floor has up/down buttons
- Elevator has cabin buttons for destination floors

---

## 🛠 Technologies Used

- Language: Java 
- IDE: IntelliJ / VSCode
---

## 🚀 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/elevator-system-LLD.git
   cd elevator-system-LLD
