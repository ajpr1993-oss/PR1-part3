package edu.uoc.ds.adt.model;

import edu.uoc.ds.adt.sequential.LinkedList;

public class Snake implements ISnake {

    private LinkedList<Segment> body = new LinkedList<>();

    @Override
    public Segment head() { return this.body.peekFirst(); }

    @Override
    public Segment tail() {
        return this.body.peekLast();
    }

    @Override
    public void addSegment(int x, int y) {
        this.body.insertEnd(new Segment(x, y));
    }

    @Override
    public void addHead(Segment newHead) {
        this.body.insertBeginning(newHead);
    }

    @Override
    public Segment deleteTail() {
        return this.body.deleteLast();
    }

    @Override
    public int size() {
        return this.body.size();
    }
}
