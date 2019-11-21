package com.skynet;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.Scanner;

import static com.skynet.Direction.EAST;
import static com.skynet.State.CROSS;
import static com.skynet.State.NONE;

enum State {

    HORIZONTAL('-'), VERTICAL('|'), CROSS('+'), NONE(' ');

    final char code;

    State(char code) {
        this.code = code;
    }
}

public class RoverPathPlotter {

    private final Map<Point, State> matrix = new HashMap<>();

    private Point position = new Point();

    private Direction direction = EAST;

    private void setState(State state) {
        matrix.put(position, state);
    }

    private void left() {
        setState(CROSS);
        direction = direction.left();
    }

    private void right() {
        setState(CROSS);
        direction = direction.right();
    }

    private void forward() {
        position = direction.forward(position);
        setState(direction.merge(
                matrix.getOrDefault(position, NONE)
        ));
    }

    RoverPathPlotter executeInstructions(String instructions) {
        instructions.chars().forEach(instruction -> {
            switch (instruction) {
                case 'L':
                    left();
                    break;
                case 'R':
                    right();
                    break;
                case 'F':
                    forward();
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        });

        return this;
    }

    String getPathString() {
        if (matrix.isEmpty()) {
            return "";
        }

        IntSummaryStatistics xStats = matrix.keySet().stream().mapToInt(point -> point.x).summaryStatistics();
        IntSummaryStatistics yStats = matrix.keySet().stream().mapToInt(point -> point.y).summaryStatistics();

        StringBuilder sb = new StringBuilder();

        for (int y = yStats.getMax(); y >= yStats.getMin(); y--) {
            for (int x = xStats.getMin(); x <= xStats.getMax(); x++) {
                sb.append(matrix.getOrDefault(new Point(x, y), NONE).code);
            }
            sb.append('\n');
        }

        return sb.toString();
    }

    public void plot(String instructions) {
        executeInstructions(instructions);
        System.out.println(getPathString());
    }

    public static void main(String[] args) {
        final String instructions = new Scanner(System.in).nextLine();
        new RoverPathPlotter().plot(instructions);
    }
}
