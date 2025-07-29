# Maze

A Java-based maze game designed with intuitive algorithms for an immersive and challenging experience. Perfect for puzzle enthusiasts and Java developers looking to hone their skills.

## Features

- **Maze Generation:** Creates complex and unique mazes using algorithmic generation.
- **Interactive Gameplay:** Navigate through the maze using keyboard controls.
- **Object-Oriented Design:** Clean and modular Java code for easy understanding and modification.
- **Customizable:** Maze size or complexity can be adjusted to increase difficulty.
- **Visual Feedback:** The game provides graphical feedback as the player moves through the maze.

## Project Structure

- `Main.java` – Entry point for running the application.
- `MazeGenerator.java` – Contains the maze generation logic.
- `MazePanel.java` – Handles rendering and user interaction.
- Additional utility or helper classes as required for UI or maze logic.

## How It Works

1. Upon launch, the application generates a new maze using a depth-first search or similar algorithm.
2. The user navigates the maze using the arrow keys.
3. The goal is to find the exit, moving from the start position through valid paths.

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/BharathSadineni/Maze.git
   cd Maze
   ```

2. **Compile the code**
   ```bash
   javac *.java
   ```

3. **Run the application**
   ```bash
   java Main
   ```

4. **Controls**
   - Use arrow keys to move.

## Requirements

- Java 8 or higher

## Customization

- You can modify maze size or generation algorithm in `MazeGenerator.java`.
- UI tweaks can be made in `MazePanel.java`.

---
