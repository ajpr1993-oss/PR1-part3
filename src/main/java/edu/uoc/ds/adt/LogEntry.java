package edu.uoc.ds.adt;

import edu.uoc.ds.adt.ISnakeGame.Direction;

public class LogEntry {
    private int X;
    private int Y;
    private Direction direction;
    private String msg;

    public LogEntry(int x, int y, Direction direction, String msg) {
        this.X = x;
        this.Y = y;
        this.direction = direction;
        this.msg = msg;
    }

    public int getX() {
        return this.X;
    }
    public int getY() {
        return this.Y;
    }
    public Direction getDirection() { return this.direction; }
    public String getMsg() {
        return this.msg;
    }
}
