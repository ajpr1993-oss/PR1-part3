package edu.uoc.ds.adt;

import edu.uoc.ds.adt.exceptions.SnakeOutOfBoundsException;
import edu.uoc.ds.adt.model.Segment;
import edu.uoc.ds.adt.model.Snake;
import edu.uoc.ds.traversal.Iterator;

public class SnakeGame implements ISnakeGame {

    private char[][] board;
    private Snake snake;
    private Log logs;

    public SnakeGame() {
        this.snake = new Snake();
        this.logs = new Log(MAX_LOG_SIZE);
        this.board = new char[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.board[i][j] = '.';
            }
        }
    }

    @Override
    public void addSegment(int x, int y) {
        this.snake.addSegment(x, y);
    }

    @Override
    public void addSegments(int[][] segments) {
        for (int[] segment : segments) {
            this.addSegment(segment[0], segment[1]);
            this.board[segment[0]][segment[1]] = 'S';
        }
    }

    @Override
    public int size() {
        return this.snake.size();
    }

    @Override
    public void addFood(int x, int y) {
        this.board[x][y] = '@';
    }

    @Override
    public boolean hasFoodAt(int x, int y) {
        return (this.board[x][y] == '@');
    }

    @Override
    public char getSegment(int x, int y) {
        return this.board[x][y];
    }

    @Override
    public Segment head() {
        return this.snake.head();
    }

    @Override
    public Segment tail() {
        return this.snake.tail();
    }

    @Override
    public void move(Direction direction) throws SnakeOutOfBoundsException {
        int actualX = this.snake.head().getX();
        int actualY = this.snake.head().getY();
        int newX = this.head().getX() + direction.getDx();
        int newY = this.head().getY() + direction.getDy();

        if(newX >= BOARD_SIZE || newY >= BOARD_SIZE || newX < 0 || newY < 0) {
            this.logs.add(new LogEntry(actualX, actualY, direction, "COLLISION"));
            throw new SnakeOutOfBoundsException(SnakeOutOfBoundsException.ERROR_OUT_OF_BOUNDS);
        }

        if(this.hasFoodAt(newX, newY)) {
            this.logs.add(new LogEntry(actualX, actualY, direction, "EAT"));
        } else {
            this.board[this.tail().getX()][this.tail().getY()] = '.';
            this.snake.deleteTail();
        }

        this.snake.addHead(new Segment(newX, newY));
        this.board[newX][newY] = 'S';

        this.logs.add(new LogEntry(actualX, actualY, direction, "MOVE"));
    }

    @Override
    public Iterator<LogEntry> logEntries() {
        return logs.getQueue().values();
    }
}
