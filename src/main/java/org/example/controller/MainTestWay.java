package org.example.controller;

import java.util.*;

public class MainTestWay {
    private static final boolean O = true;
    private static final boolean X = false;
//    private final boolean[][] arr = {
//            {O, O, O, O, O, O,},
//            {O, O, X, O, O, O,},
//            {O, O, X, O, O, O,},
//            {O, O, X, O, O, O,},
//            {O, O, O, O, O, O,},
//            {O, O, O, O, O, O,},
//    };

    private final boolean[][] arr = {
            {O, O, O, O},
            {O, O, X, O},
            {O, O, O, O},
            {O, O, X, O},

    };

    public static void main(String[] args) {
        MainTestWay test = new MainTestWay();
        test.start();
    }

    private final static int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void start() {
        Coordinate from = new Coordinate(arr.length - 1, arr.length - 1);
        Coordinate to = new Coordinate(0, 0);

        Node first = new Node(null, from);

        Set<Node> reachable = new HashSet<>();
        Set<Node> explored = new HashSet<>();

        reachable.add(first);

        Node win = find(explored, reachable);
        System.out.println(win);
        showWay(win);
    }

    private Node find(Set<Node> explored, Set<Node> reachable) {
        while (!reachable.isEmpty()) {
            Node[] nodes = reachable.toArray(new Node[0]);
            for (Node node : nodes) {
                Node result = find(explored, reachable, node);
                if (result != null) {
                    return result;
                }
                reachable.remove(node);
                explored.add(node);
            }
        }
        return null;
    }

    private Node find(Set<Node> explored, Set<Node> reachable, Node node) {
        for (int[] offset : DIRECTIONS) {
            int row = node.coordinate.row + offset[0];
            int column = node.coordinate.column + offset[1];
            if (!isCorrect(row, column)) {
                continue;
            }
            Coordinate coordinate = new Coordinate(row, column);
            Node current = new Node(node, coordinate);
            if (isTarget(coordinate)) {
                return current;
            }
            reachable.add(current);

        }
        return null;
    }

    private void showWay(Node node) {
        char[][] arrWay = new char[arr.length][arr.length];
        for (int i = 0; i < arrWay.length; i++) {
            for (int n = 0; n < arrWay.length; n++) {
                arrWay[i][n] = arr[i][n] ? 'o' : 'x';
            }
        }
        Node current = node;
        while (current != null) {
            arrWay[current.coordinate.row][current.coordinate.column] = 'w';
            current = current.prev;
        }

        for (char[] chars : arrWay) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }

    }


    private boolean isCorrect(int row, int column) {
        return row >= 0 && row < arr.length && column >= 0 && column < arr.length && arr[row][column];
    }

    Coordinate target = new Coordinate(0, 0);

    private boolean isTarget(Coordinate coordinate) {
        return coordinate.equals(target);
    }

    private boolean isOpen(int row, int column) {
        return arr[row][column];
    }


    private static class Node {
        final Node prev;
        final Coordinate coordinate;

        public Node(Node prev, Coordinate coordinate) {
            this.prev = prev;
            this.coordinate = coordinate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(coordinate, node.coordinate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(coordinate);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "prev=" + prev +
                    ", coordinate=" + coordinate +
                    '}';
        }
    }

    private static class Coordinate {
        public final int row;
        public final int column;

        public Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return row == that.row && column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }
    }


}
