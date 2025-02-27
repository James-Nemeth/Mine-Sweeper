# Project: Minesweeper

## MVP

- Recreate a simplified version of the game Minesweeper to be played in the java console
- The game should be able to randomly generate 10 mines in a 10x10 grid
- The user will be able to enter a command that represents a coordinate to check a location for a mine
- The application will display a number from 0-8 depending on how many mines surround that location
- If the user selects a mine, the game will respond "boom!" and the game will be lost
- If every non-mine square has been revealed, the game is won
- Render the grid to the console after every user command
- Allow for the user to configure their grid size.
- Discovering an empty square should reveal all squares around it, and cascade into other nearby empty squares

```java
[0] [1] [ ]
[ ] [1] [ ]
```

```java
   1   2
  +---+---+
1 | 1 | 2 |
  +---+---+
```

### Stacks Used

- **Programming Language:** Java
- **Development Environment:** VSCode

## Build Steps

1. Clone the repository

```bash
https://github.com/James-Nemeth/Mine-Sweeper.git
cd Mine-Sweeper/src
```

2. Compile the game

```bash
javac App.java
```

3. Run the game

```bash
java App
```

- You will then prompted to choose a grid size (recommeded to do it from 4 - 10).
- Can then Input row and column coordinates to play Minesweepers.
- Game can be reset at the end if you lose or win.

## Purpose of project:

- First Project using Java
- Learn more about OOP programming
- Working with a terminal based application

  ## Design Goals / Approach

- Wasn't as much styling involed as it's just using the terminal. Did want to add colour to make it easier for the user to visualise what they were doing.
- Brackets were used to display the grid as it made it easy to show numbers inside them when revealed.

## Features

- Works the way that a normal minesweeper game would but in the terminal.
- Allows users to input numbers for the row and columns.
- Reveals the number of bombs that surround the cell selected
- If it is "0", it will spread and keeping revealing any surrounding 0's
- If a cell that is inputed is a bomb, the game will end
- The user will be prompted is they would like to start the game again if they input the term "yes"

## Known Issues

- Grid size doesn't work properly when its over 10

## Future Goals

- To break the code done more into sub-classes
- Implement letting the user choose how many bombs are in the grid

## What did you struggle with

- Creating the grid was a struggle at first, hard to make it look the way l wanted it. Multi-Dimentional Arrays were still a bit foreign to me so took some research to find the solution.
- Was stuck on how to find the adjacent cells and reveal if they have bombs near them. Found a solution that l'm not the happiest with but works. Will like to refactor it in the future.

## Further details, related projects, reimplementations

- N/A
