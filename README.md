
# Othello Game - Summer 2025

**Developers**:  
- **Bhumika Patel** - 0110bhumi  
- **[Team member 1 name]** - [Team member 1 GitHub username]  

---

## **Project Overview**

This is a project on the **Othello** (also called Reversi), a board game. The game is played between two participants and each of them places his own pieces (`X` and `O`) in an 8x8 grid with turns in the game order. Its aim is to leave most of your pieces in the board at the end of the game. The board is updated at every move and the game ends when neither of the players possesses a valid move.

The project contains the implementation in **Java** and the ideologies of object-oriented programming. It tests using **JUnit 4** and is compatible with running on JDK17.

---

## **Features**

- **Game Board**: A game board representing the state of the game is a dynamic space (8x8), in which to present the current game state.
- **Gameplay**: The game is played by turns, every participant placing their pieces on the board.
- **Flip Mechanism**: The tokens of the player of an opposite side would be overturned when his piece has been placed next to him.
- **Win Condition**: The game determines whether it is time to win by counting whether a player has the majority of his/her pieces at the end of the game.
- **Player Input**: The row and column where the player wants to place his/her piece could be entered, which is validated so that the move is legal.
- **Turn-based Play**: The game alternates between two players (X and O).

---

## **Technologies Used**

- **Java**: JDK 17.
- **JUnit 4**: For writing and running unit tests.
- **Git/GitHub**: For version control and collaboration.

---

## **Installation**

### **Prerequisites**

1. **JDK 17**: This project is developed using Java 17. Ensure you have JDK 17 installed. 

2. **JUnit 4**: The project uses JUnit 4 for testing. 

---

### **Steps to Clone the Repository**

1. Clone the repository:
   ```bash
   git clone https://github.com/[Your GitHub Username]/CPSC2150-Othello-Summer2025.git
   ```

2. Navigate to the project directory:
   ```bash
   cd CPSC2150-Othello-Summer2025
   ```

3. If you are using an **IDE** like IntelliJ IDEA, Eclipse, or Visual Studio Code, simply **import the project** as a Java project.

---

### **Running the Game**

1. **Build the project**:
   - Use your IDE to build the project:
     

2. **Run the main class**:
   - To play the game, run the **`OthelloFE`** class. 



3. **Follow the game prompts**:  
   - The game will prompt players to enter the row and column where they want to place their piece (`X` or `O`).
   - The game will switch turns between players after each valid move.
   - The game ends when neither player has any valid moves left. The final score will be displayed.

---

## **Running Tests**

To ensure that everything works as expected, you can run unit tests using **JUnit 4**.

1. **Using IDE**:  
   - In IntelliJ or Eclipse, right-click the `TestOthelloBoard.java` file or the test directory and choose **Run Tests**.
  


---

## **Known Issues / Bugs**

- **Move Validation**: There may be edge cases where the validation logic could misinterpret valid moves near the board boundaries. This is a known issue that needs further testing.
- **User Input**: The game currently assumes that the player will always input valid integers. Input validation should be improved for non-numeric inputs.
  
If you encounter any other bugs or issues, feel free to open an issue in the **GitHub repository**.

---

## **Future Improvements**

- **AI Player**: Implementing an AI opponent using algorithms such as **Minimax** could make the game more interesting.
- **Graphical User Interface (GUI)**: A graphical representation of the board and pieces would improve the user experience. This can be achieved using JavaFX or Swing.
- **Score History**: Allow the game to track and display the scores from previous games.

---

## **Contributors**

- **Bhumika Patel** - [0110bhumi](https://github.com/0110bhumi)
- **[Team member 1 name]** - [Team member 1 GitHub username]

---

## **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

