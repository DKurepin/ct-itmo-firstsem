package game;

import java.util.*;

public class TicTacToeBoard implements Board, Position {
    private static final Map<Cell, String> CELL_TO_STRING = Map.of(
            Cell.E, ".",
            Cell.X, "X",
            Cell.O, "0"
    );

    private final Cell[][] field;
    private Cell turn;
    public int m;
    public int n;
    public int k;

    public TicTacToeBoard() {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Choose m n k parameters");
                m = in.nextInt();
                n = in.nextInt();
                k = in.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter numbers not other symbols: ");
                in.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Bye Bye...");
                break;
            }
        }
        field = new Cell[m][n];

        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }

    @Override
    public Cell getTurn() {
        return turn;
    }

    @Override
    public Position getPosition() {
        return this;
    }

    @Override
    public GameResult makeMove(Move move) {
        if (!isValid(move)) {
            return GameResult.LOOSE;
        }

        field[move.getRow()][move.getCol()] = move.getValue();
        if (checkWin(move)) {
            return GameResult.WIN;
        }

        if (checkDraw()) {
            return GameResult.DRAW;
        }

        turn = turn == Cell.X ? Cell.O : Cell.X;
        return GameResult.UNKNOWN;
    }

    @Override
    public int getM() {
        return m;
    }

    @Override
    public int getN() {
        return n;
    }

    private boolean checkDraw() {
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (field[r][c] == Cell.E) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return true;
        }
        return false;
    }

    private boolean checkWin(Move move) {
        int row = move.getRow();
        int column = move.getCol();
        return check(column, row, 0, 1) || check(column, row, 1, 0)
                || check(column, row, 1, 1) || check(column, row, 1, -1)
                || check(column, row, 0, -1) || check(column, row, -1, 0)
                || check(column, row, -1, -1) || check(column, row, -1, 1);
    }

    private boolean check(int col, int row, int up, int sides) {
        int count = 1;
        int rows = row + up;
        int cols = col + sides;
        while (rows >= 0 && rows < n && count < k && cols >= 0 && cols < n) {
            if (field[rows][cols] == turn) {
                count++;
            } else {
                break;
            }
            cols += sides;
            rows += up;
        }
        return count >= k;
    }

    public boolean isValid(final Move move) {
        return 0 <= move.getRow() && move.getRow() < m
                && 0 <= move.getCol() && move.getCol() < n
                && field[move.getRow()][move.getCol()] == Cell.E
                && turn == move.getValue();
    }

    @Override
    public Cell getCell(int row, int column) {
        return field[row][column];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(" ");
        for (int i = 1; i < m + 1; i++) {
            sb.append(" ").append(i).append(" ");
        }
        sb.append(System.lineSeparator());
        for (int r = 0; r < n; r++) {
            sb.append(r + 1);
            for (Cell cell : field[r]) {
                sb.append(" ").append(CELL_TO_STRING.get(cell)).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        sb.setLength(sb.length() - System.lineSeparator().length());
        return sb.toString();
    }

    public void clear() {
        for (Cell[] row : field) {
            Arrays.fill(row, Cell.E);
        }
        turn = Cell.X;
    }
}
