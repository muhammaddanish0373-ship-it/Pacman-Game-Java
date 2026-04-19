# Pacman-Game-Java
This is console based Pacman Game in Java
🎮 PacMan Console Game (Java)

This is a simple console-based PacMan game implemented in Java using Object-Oriented Programming (OOP) concepts. The game runs on a 5×5 grid, where the player controls PacMan, collects food, and avoids a ghost.

🚀 Features
🟡 PacMan movement using keyboard input (W, A, S, D)
👻 Random ghost movement
🍎 Food spawning and respawning
📊 Score tracking system
🧠 Boundary checking for valid moves
💀 Game over when PacMan is caught by the ghost
🧱 Game Structure (Classes)

The project is divided into the following classes:

1. PacMan
Handles player position and movement
Tracks score
Methods:
move()
increaseScore()
Getters for position and score
2. GameBoard
Represents a 5×5 grid
Displays game state in console
Validates movement within boundaries
3. Ghost
Moves randomly on the board
Causes game over on collision with PacMan
4. Food
Represents collectible item
Respawns randomly after being eaten
5. PacManGame (Main Class)
Controls game loop
Handles user input
Updates game state
🎮 How to Play
Use the following keys to move PacMan:
Key	Direction
W	Up
S	Down
A	Left
D	Right
Objective:
Eat food (.) to gain points
Avoid the ghost (G)
Survive as long as possible
🖥️ Sample Output
- - - - -
- P - - -
- - . - -
- - - G -
- - - - -

Move (W/A/S/D):
⚙️ How to Run
1. Compile the code
javac PacManGame.java
2. Run the program
java PacManGame
⚠️ Important Note

Make sure:

All classes are placed correctly
If using a single file, only one class should be public (Java rule)

👉 Recommended:

Put each class in a separate .java file:
PacMan.java
GameBoard.java
Ghost.java
Food.java
PacManGame.java
🛠️ Technologies Used
Java
OOP Concepts (Encapsulation, Classes, Methods)
Java Standard Libraries (Scanner, Random)
📌 Future Improvements
Add GUI using Java Swing / JavaFX
Add multiple levels
Smarter ghost AI
Add walls and maze structure
👨‍💻 Author

Muhammad Danish
