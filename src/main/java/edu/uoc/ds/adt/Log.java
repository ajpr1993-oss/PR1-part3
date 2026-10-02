package edu.uoc.ds.adt;

import edu.uoc.ds.adt.sequential.QueueArrayImpl;

public class Log {
    private QueueArrayImpl<LogEntry> queue;

    public Log(int capacity) {
        newQueue(capacity);
    }
    public void newQueue(int capacity) {
        this.queue = new QueueArrayImpl<>(capacity);
    }

    public QueueArrayImpl<LogEntry> getQueue() {
        return this.queue;
    }

    public void add(LogEntry c) {
        this.queue.add(c);
    }

    public LogEntry poll() {
        return this.queue.poll();
    }
}
