# Maze-Solver-Java-
A maze solver creating using OOP principles in Java

## 🚀 Features

- Abstract `Agenda` interface with `StackAgenda` and `QueueAgenda` implementations
- Flexible architecture to support multiple search strategies
- Visual maze display with interactive updates
- Path reconstruction and animation of the solution
- Clean, modular code that separates algorithm logic from UI

---

## 📁 Files

- `Agenda.java`: Abstract class defining the interface for data structures used in search (Stack or Queue)
- `StackAgenda.java`: Implements a LIFO search strategy (depth-first search)
- `QueueAgenda.java`: Implements a FIFO search strategy (breadth-first search)
- `MazeSolver.java`: Core maze-solving logic, independent of data structure used
- `Maze.java`, `MazeGridLocation.java`, `MazeGUI.java`: Provided GUI and utility files

---

## 🧠 How It Works

The solver reads a maze from a text file and explores it using either a stack (DFS) or queue (BFS), depending on user input. At each step, it:
1. Removes the next location from the agenda
2. Checks if it's the goal
3. Adds valid, unvisited neighbors to the agenda
4. Tracks the path using a `cameFrom` map for backtracking

The final path is highlighted in gold if a solution is found.

---
