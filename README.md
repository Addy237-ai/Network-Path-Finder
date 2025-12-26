# Network-Path-Finder

#FeaturesShortest Path: Uses BFS to find the most efficient route ($O(V+E)$ complexity).
CSV Support: Automatically loads network data from CSV files.
Modular Code: Separates data loading, validation, and search logic.
Performance: Tracks the number of hops and time taken to find the path.

# File StructureMain.java: The entry point for the application.
Graph.java: Handles the graph structure and BFS algorithm.
CsvLoader.java: Reads and parses the network CSV file.
PathInfo.java: Stores and displays the search results.
CheckFile.java: Validates file paths and inputs.

# How to Run
Open your terminal in the project folder.
Compile all files:
Bash
javac *.java
Run the program:
Bash
java Main

# Example
Enter CSV path: network.csv
From: A
To: D
Path: A -> B -> D (2 hops)
