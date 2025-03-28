// MazeSolver class that uses an Agenda (Stack or Queue) to solve a maze
import java.util.*;

public class MazeSolver {
    private Agenda agenda; // Stack or Queue for managing maze exploration
    private HashMap<MazeGridLocation, MazeGridLocation> cameFrom; // Tracks path history

    public MazeSolver(Agenda a) {
        agenda = a;
        cameFrom = new HashMap<>(); // Initialize path tracker
    }

    // Main method to solve the maze using the selected agenda
    public ArrayList<MazeGridLocation> solveMaze(Maze m, MazeGUI mg) {
        agenda.clear(); // Clear agenda before starting
        cameFrom.clear(); // Clear path map

        MazeGridLocation start = m.getStartLocation();
        agenda.addLocation(start); // Start exploring from the start point
        cameFrom.put(start, null); // Start has no parent
        mg.addLocToAgenda(start); // Visual update

        while (!agenda.isEmpty()) {
            MazeGridLocation current = agenda.removeLocation(); // Get next location
            mg.visitLoc(current); // Mark as visited on GUI

            if (m.getGoalLocation().equals(current)) {
                return reconstructPath(current); // Found goal, reconstruct path
            }

            for (MazeGridLocation neighbor : getNeighbors(current, m)) {
                if (!cameFrom.containsKey(neighbor)) {
                    agenda.addLocation(neighbor); // Add to agenda
                    cameFrom.put(neighbor, current); // Track how we reached here
                    mg.addLocToAgenda(neighbor); // Visual update
                }
            }

            mg.pause(50); // Delay for visualization
        }

        return new ArrayList<>(); // No solution found
    }

    // Helper to get valid neighbors (N, S, E, W) of a location
    private ArrayList<MazeGridLocation> getNeighbors(MazeGridLocation loc, Maze m) {
        ArrayList<MazeGridLocation> neighbors = new ArrayList<>();
        int row = loc.getRow();
        int col = loc.getCol();
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // N, S, W, E

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            MazeGridLocation neighbor = new MazeGridLocation(newRow, newCol);

            // Only add valid, non-wall, unvisited locations
            if (m.isValidLocation(neighbor) && !m.isWall(neighbor) && !m.isVisited(neighbor)) {
                neighbors.add(neighbor);
            }
        }

        return neighbors;
    }

    // Reconstruct the path from goal to start using cameFrom map
    private ArrayList<MazeGridLocation> reconstructPath(MazeGridLocation goal) {
        ArrayList<MazeGridLocation> path = new ArrayList<>();
        for (MazeGridLocation loc = goal; loc != null; loc = cameFrom.get(loc)) {
            path.add(0, loc); // Insert at beginning to reverse the path
        }
        return path;
    }
}
