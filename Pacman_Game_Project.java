
import java.util.Random;
import java.util.Scanner;

public class PacMan {
    private int x, y;
    private int score;

    public PacMan(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    public void move(char direction, GameBoard board) {
        int newX = x, newY = y;

        switch (direction) {
            case 'W': newX--; break;
            case 'S': newX++; break;
            case 'A': newY--; break;
            case 'D': newY++; break;
        }

        if (board.isValidMove(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public void increaseScore() {
        score += 10;
    }

    public int getScore() { return score; }
    public int getX() { return x; }
    public int getY() { return y; }
}

public class GameBoard {
    private final int SIZE = 5;

    public boolean isValidMove(int x, int y) {
        return x >= 0 && y >= 0 && x < SIZE && y < SIZE;
    }

    public void display(PacMan p, Ghost g, Food f) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                if (i == p.getX() && j == p.getY()) {
                    System.out.print("P ");
                } else if (i == g.getX() && j == g.getY()) {
                    System.out.print("G ");
                } else if (i == f.getX() && j == f.getY()) {
                    System.out.print(". ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}


public class Food {
    private int x, y;
    private Random rand = new Random();

    public Food(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void respawn(GameBoard board) {
        x = rand.nextInt(5);
        y = rand.nextInt(5);
    }

    public int getX() { return x; }
    public int getY() { return y; }
}


public class Ghost {
    private int x, y;
    private Random rand = new Random();

    public Ghost(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(GameBoard board) {
        int newX = x + (rand.nextInt(3) - 1);
        int newY = y + (rand.nextInt(3) - 1);

        if (board.isValidMove(newX, newY)) {
            x = newX;
            y = newY;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}


public class PacManGame {
    public static void main(String[] args) {

        GameBoard board = new GameBoard();
        PacMan pacman = new PacMan(1, 1);
        Ghost ghost = new Ghost(3, 3);
        Food food = new Food(2, 2);

        Scanner sc = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            board.display(pacman, ghost, food);

            System.out.println("Move (W/A/S/D): ");
            char move = sc.next().toUpperCase().charAt(0);

            // Move PacMan
            pacman.move(move, board);

            // Ghost moves automatically
            ghost.move(board);

            // Check if PacMan eats food
            if (pacman.getX() == food.getX() && pacman.getY() == food.getY()) {
                System.out.println("PacMan ate the food! 🎉");
                pacman.increaseScore();
                food.respawn(board);
            }

            // Check collision with ghost
            if (pacman.getX() == ghost.getX() && pacman.getY() == ghost.getY()) {
                System.out.println("Caught by Ghost! Game Over 💀");
                gameRunning = false;
            }

            System.out.println("Score: " + pacman.getScore());
        }

        sc.close();
    }
}