package com.skynet;

import static com.skynet.State.*;

enum Direction {

    NORTH {
        @Override
        Direction left() {
            return WEST;
        }

        @Override
        Direction right() {
            return EAST;
        }

        @Override
        Point forward(Point point) {
            return new Point(point.x, point.y + 1);
        }

        @Override
        State merge(State state) {
            return state == NONE || state == VERTICAL ? VERTICAL : CROSS;
        }
    },
    SOUTH {
        @Override
        Direction left() {
            return EAST;
        }

        @Override
        Direction right() {
            return WEST;
        }

        @Override
        Point forward(Point point) {
            return new Point(point.x, point.y - 1);
        }

        @Override
        State merge(State state) {
            return state == NONE || state == VERTICAL ? VERTICAL : CROSS;
        }
    },
    EAST {
        @Override
        Direction left() {
            return NORTH;
        }

        @Override
        Direction right() {
            return SOUTH;
        }

        @Override
        Point forward(Point point) {
            return new Point(point.x + 1, point.y);
        }

        @Override
        State merge(State state) {
            return state == NONE || state == HORIZONTAL ? HORIZONTAL : CROSS;
        }
    },
    WEST {
        @Override
        Direction left() {
            return SOUTH;
        }

        @Override
        Direction right() {
            return NORTH;
        }

        @Override
        Point forward(Point point) {
            return new Point(point.x - 1, point.y);
        }

        @Override
        State merge(State state) {
            return state == NONE || state == HORIZONTAL ? HORIZONTAL : CROSS;
        }
    };

    abstract Direction left();

    abstract Direction right();

    abstract Point forward(Point point);

    abstract State merge(State state);
}
