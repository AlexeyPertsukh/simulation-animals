package org.example.model.entity;

import org.example.model.map.Coordinate;
import org.example.model.map.GameMap;

import java.util.*;

public abstract class Creature implements Entity {

    protected final GameMap gameMap;
    protected final int speed;
    protected int hp;

    public Creature(GameMap gameMap, int speed, int hp) {
        this.gameMap = gameMap;
        this.speed = speed;
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void makeMove() {
        Coordinate coordinate = gameMap.coordinate(this);
        Node current = new Node(coordinate);
        Set<Node> reachable = new HashSet<>();
        reachable.add(current);
        Node wayNode = find(new HashSet<>(), reachable);
        if (wayNode == null) {
            return;
        }
        Stack<Coordinate> stack = new Stack<>();
        while (wayNode != current) {
            stack.push(wayNode.coordinate);
            wayNode = wayNode.prev;
        }
        int count = speed;
        Coordinate step = null;
        while (!stack.isEmpty() && count > 0) {
            step = stack.pop();
            count--;
        }

        gameMap.remove(coordinate);
        gameMap.put(step, this);
    }

    private final static int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

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
            if (explored.contains(current)) {
                continue;
            }
            if (isTarget(coordinate)) {
                return current;
            }
            reachable.add(current);
        }
        return null;
    }

    private boolean isTarget(Coordinate coordinate) {
        if (gameMap.isEmpty(coordinate)) {
            return false;
        }
        return isFood(gameMap.get(coordinate));
    }

    private boolean isCorrect(int row, int column) {
        if (row < 0 || row >= gameMap.rows() || column < 0 || column >= gameMap.columns()) {
            return false;
        }

        Coordinate coordinate = new Coordinate(row, column);

        if (gameMap.isEmpty(coordinate)) {
            return true;
        }
        return isFood(gameMap.get(coordinate));
    }


    private boolean isFoodNear(Coordinate me, Coordinate food) {
        return Math.abs(me.row - food.row) == 1 || Math.abs(me.column - food.column) == 1;
    }

    protected abstract boolean isFood(Entity entity);

    private static class Node {
        final Node prev;
        final Coordinate coordinate;

        public Node(Node prev, Coordinate coordinate) {
            this.prev = prev;
            this.coordinate = coordinate;
        }

        public Node(Coordinate coordinate) {
            this(null, coordinate);
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


}
