### Installation

   ```bash
   git clone https://github.com/balasravatsal/edu_init.git
   cd edu_init/Exercise1
   cd edu_init/AstronautDailyScheduler
   ```

# Design Patterns Implementation

## Overview

This project contains implementations of various design patterns in Java, organized into three main categories: Behavioral, Creational, and Structural. Each category demonstrates specific design patterns through practical examples, showcasing their application and benefits in software design.

## Categories and Patterns

### Behavioral Patterns
- **Iterator**: Implements an iterator to traverse a collection without exposing its underlying representation.
- **Memento**: Captures and restores an object's internal state without violating encapsulation.

### Creational Patterns
- **Singleton**: Ensures a class has only one instance and provides a global point of access to it.
- **Abstract Factory**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

### Structural Patterns
- **Adapter**: Allows incompatible interfaces to work together by converting the interface of a class into another interface that a client expects.
- **Facade**: Provides a simplified interface to a complex subsystem, making it easier to use.

## Project Structure

```
Exercise1/
├── behavioral/
│   ├── iterator/
│   └── memento/
├── creational/
│   ├── AbstractFactory/
│   └── Singleton/
└── structural/
    ├── adapter/
    └── facade/
```



---
# Astronaut Schedule Manager

## Overview

The Astronaut Schedule Manager is a console-based application designed to help manage tasks for astronauts. This application allows users to add, remove, edit, and view tasks, as well as mark tasks as completed. It employs several design patterns, including Singleton, Factory, and Observer, to ensure clean and maintainable code.

## Features

- **Add Task**: Input a task description, start time, end time, and priority level.
- **Remove Task**: Delete a task based on its description.
- **Edit Task**: Modify existing task details.
- **Mark Task as Completed**: Mark a task as finished.
- **View Tasks**: Display all tasks.
- **View Tasks by Priority**: Filter tasks based on priority (Low, Medium, High).
- **Exit Application**: Cleanly exit the application.

## Getting Started

### Prerequisites

- JDK 11 or higher
- Maven (optional for managing dependencies)

### Usage

1. Start the application.
2. Follow the on-screen menu to perform various operations.
3. Use the option numbers to navigate through the application.
4. Type 'back' to return to the previous menu where applicable.

## Design Patterns Used

- **Singleton**: Ensures a single instance of the `ScheduleManager` throughout the application.
- **Factory**: Simplifies object creation for tasks and related entities.

## Code Structure

- `Client.java`: Main entry point for the application.
- `ScheduleManager.java`: Manages the task list and operations.
- `Task.java`: Represents individual tasks.
- `ConsoleHelper.java`: Provides utility methods for console interactions.
- `Menu.java`: Handles menu options and displays.
