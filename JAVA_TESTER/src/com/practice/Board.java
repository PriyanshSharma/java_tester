package com.practice;

enum Color {
    WHITE, BLACK
}

class Position {
    int x, y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

abstract class Piece {
    Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean isValidMove(Position from, Position to, Board board);
}

class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public boolean isValidMove(Position from, Position to, Board board) {
        if (from.y != to.y) { // Pawns can't move sideways unless capturing
            return false;
        }

        int direction = (color == Color.WHITE) ? 1 : -1; // White moves up, Black moves down
        int startRow = (color == Color.WHITE) ? 1 : 6;

        // Move forward one square if it's empty
        if (to.x == from.x + direction && board.getPiece(to) == null) {
            return true;
        }

        // Move two squares forward if it's the pawn's first move and both squares are empty
        if (from.x == startRow && to.x == from.x + 2 * direction &&
                board.getPiece(to) == null && board.getPiece(new Position(from.x + direction, from.y)) == null) {
            return true;
        }

        // Capture diagonally
        if (Math.abs(from.y - to.y) == 1 && to.x == from.x + direction) {
            Piece target = board.getPiece(to);
            return target != null && target.color != this.color; // Must capture opposite color
        }

        return false;
    }
}

public class Board {
    public Piece[][] state = new Piece[8][8];
    private Color turnColor = Color.WHITE;

    public Board() {
        for (int y = 0; y < 8; y++) {
            state[1][y] = new Pawn(Color.WHITE); // White Pawns
            state[6][y] = new Pawn(Color.BLACK); // Black Pawns
        }
    }

    public void move(Position from, Position to) throws IllegalArgumentException {
        Piece piece = getPiece(from);

        if (piece == null) {
            throw new IllegalArgumentException("No piece at given position.");
        }
        if (piece.color != turnColor) {
            throw new IllegalArgumentException("It's not " + piece.color + "'s turn.");
        }
        if (!piece.isValidMove(from, to, this)) {
            throw new IllegalArgumentException("Invalid move.");
        }

        state[to.x][to.y] = piece;
        state[from.x][from.y] = null; // Remove piece from old position

        turnColor = (turnColor == Color.WHITE) ? Color.BLACK : Color.WHITE; // Switch turns
    }

    public Piece getPiece(Position pos) {
        if (pos.x < 0 || pos.x >= 8 || pos.y < 0 || pos.y >= 8) {
            return null;
        }
        return state[pos.x][pos.y];
    }

    public Color getPieceColor(Position pos) {
        Piece piece = getPiece(pos);
        return (piece != null) ? piece.color : null;
    }

    public void printBoard() {
        System.out.println("Chess Board:");
        for (int row = 7; row >= 0; row--) {
            System.out.print(row + " | ");
            for (int col = 0; col < 8; col++) {
                Piece piece = state[row][col];
                if (piece == null) System.out.print(". ");
                else System.out.print((piece.color == Color.WHITE ? "W" : "B") + " ");
            }
            System.out.println();
        }
        System.out.println("   -----------------");
        System.out.println("    0 1 2 3 4 5 6 7");
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();

        // Example move (White Pawn from 1,3 to 3,3)
        try {
            board.move(new Position(1, 3), new Position(3, 3));
            board.printBoard();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
