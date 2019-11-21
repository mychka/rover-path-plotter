# Rover path plotter 

A rover can move `Forward` (F), or turn `Left` (L) or `Right` (R)  
Note that when the rover turns only its orientation changes, not its position.  
Design a rover plotter, which given a set of instruction as input, plots the corresponding path to standard output  
When the rover moves horizontally the character `-` has to be printed.  
When the rover moves vertically the character `|` has to be printed.  
When the rover moves turns the character `+` has to be printed.  
Intersections between horizontal and vertical path segments have to be marked with `+`  
At the beginning the rover is pointing EAST  
Examples:
1. Horizontal path. Instructions: "FFF"  
   Output:---
1. Vertical path. Instructions: "RFFF"  
   Output:<pre>
        +
        |
        |
        |</pre>
1. Another vertical path. Instructions: "LFFF"  
   Output:<pre>
          |
          |
          |
          +</pre>
1. Path with intersection: "FFFFLFFLFFLFFF"
   Output:<pre>
           +-+
           | |
          -+-+
           |</pre>
           
## Build

Java 8 or newer is required.

`gradlew clean build`

## Run

1. `java -jar build\libs\rover-path-plotter-1.0-SNAPSHOT.jar`
1. Enter instructions for the robot.
