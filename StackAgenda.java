// Implements Agenda using a stack (LIFO) strategy
import java.util.*;

public class StackAgenda extends Agenda {
    private LinkedList<MazeGridLocation> stack; // Underlying data structure for stack

    public StackAgenda() {
        stack = new LinkedList<>(); // Initialize stack
    }

    // Add to top of the stack
    public void addLocation(MazeGridLocation loc) {
        stack.addFirst(loc);
    }

    // Remove from top of the stack
    public MazeGridLocation removeLocation() {
        return stack.removeFirst();
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Clear the stack
    public void clear() {
        stack.clear();
    }

    public static void main(String[] args) {
        StackAgenda sa = new StackAgenda();
        MazeGridLocation loc1 = new MazeGridLocation(0, 0);
        MazeGridLocation loc2 = new MazeGridLocation(1, 1);
        sa.addLocation(loc1); // Push loc1
        sa.addLocation(loc2); // Push loc2

        // Pop and print all elements
        while (!sa.isEmpty()) {
            System.out.println(sa.removeLocation());
        }
    }
}
