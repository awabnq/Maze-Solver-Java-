// Implements Agenda using a queue (FIFO) strategy
import java.util.*;

public class QueueAgenda extends Agenda {
    private LinkedList<MazeGridLocation> queue; // Underlying data structure for queue

    public QueueAgenda() {
        queue = new LinkedList<>(); // Initialize queue
    }

    // Add to end of the queue
    public void addLocation(MazeGridLocation loc) {
        queue.addLast(loc);
    }

    // Remove from front of the queue
    public MazeGridLocation removeLocation() {
        return queue.removeFirst();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Clear the queue
    public void clear() {
        queue.clear();
    }

    public static void main(String[] args) {
        QueueAgenda qa = new QueueAgenda();
        MazeGridLocation loc1 = new MazeGridLocation(0, 0);
        MazeGridLocation loc2 = new MazeGridLocation(1, 1);
        qa.addLocation(loc1); // Enqueue loc1
        qa.addLocation(loc2); // Enqueue loc2

        // Dequeue and print all elements
        while (!qa.isEmpty()) {
            System.out.println(qa.removeLocation());
        }
    }
}
