### README.md for Small E-health Management System

---

#### Small E-health Management System

The Small E-health Management System is a Java-based application created by Michael, designed to simulate a digital healthcare environment. This project leverages Object-Oriented Programming principles to manage patient and doctor data, appointments, diseases, drug prescriptions, and integrates entities like pharmacies and universities.

---

### Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [System Requirements](#system-requirements)
- [Installation](#installation)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [Using and Extending the Code](#using-and-extending-the-code)
- [About PlantUML](#about-plantuml)

---

### Introduction

Developed by SacitDev, this project is an educational tool to demonstrate practical applications of OOP concepts in healthcare data management. It provides a console-based interface for intuitive and user-friendly interaction with health-related data.

### Features

- **User Account Management**: Secure management for patient, doctor, and administrator accounts.
- **Appointment Scheduling**: Manage and track appointments efficiently.
- **Disease and Drug Management**: Handle diseases and drug prescriptions effectively.
- **Data Persistence**: Utilizes file management for storing and retrieving data.
- **Extensibility**: The system can be expanded to include pharmacies and universities.
- **Administrative Controls**: Overarching control of the system through the admin panel.

### System Requirements

- Java Runtime Environment (JRE) 8 or above.
- Java IDE (e.g., IntelliJ IDEA, Eclipse) for code editing.

### Installation

1. Clone the repository:
   ```
   git clone https://github.com/SacitDev/E-HealthSample.git
   ```
2. Navigate to the project directory:
   ```
   cd Small-E-health-Management-System
   ```

### Usage

To run the program:
1. Open the project in a Java IDE.
2. Run the `Main` class to start the application.
3. Use the console-based menu to interact with the system.

### Code Structure

The system comprises several classes:
- `Person`: Abstract base class for `Doctor` and `Patient`.
- `Doctor`, `Patient`: Represent respective entities.
- `Disease`, `Drug`, `Appointment`, `Report`: Handle medical data.
- `FileManager`: Manages data storage and retrieval.
- `HealthMinistry`: Provides administrative control.
- `Pharmacy`, `University`: Additional entity integration.
- `Types`: Contains enums and constants.

### Using and Extending the Code

Feel free to use and extend this code in your projects. If you do so, please acknowledge SacitDev as the original creator. This openness to community usage and extension is intended to foster collaboration and innovation.

### About PlantUML

The class diagrams in this project were created using PlantUML, a powerful tool for generating UML diagrams from a simple text language. PlantUML was instrumental in visualizing the relationships and structure of the classes, aiding in the design and documentation of the system.
