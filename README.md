# maze
Scala maze path finder.

This simple app will find the shortest path in a given maze from the entrance to the exit.

The maze is provided via text file found in the resources directory.
The app parses the maze file to build a Maze consisting of Cells.  The mazes dimensions are given in the first line of the maze file.  Each cell has a value (E, X, #, or o), an x position, and y position in the maze.

Once the maze is constructed, the app attempts to find the shortest path from the entrance using recursion and some basic Collections functionality.  When it finds two paths that both reach the exit, it chooses the shortest path.
