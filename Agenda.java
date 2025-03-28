// Abstract base class for stack and queue agendas used in maze solving
import java.util.*;

public abstract class Agenda {
    // Add a location to the agenda (stack or queue)
    public abstract void addLocation(MazeGridLocation loc);

    // Remove and return the next location from the agenda
    public abstract MazeGridLocation removeLocation();

    // Check if the agenda is empty
    public abstract boolean isEmpty();

    // Clear all items from the agenda
    public abstract void clear();

    @Override
    public String toString() {
        return super.toString(); // Default toString method
    }
}
