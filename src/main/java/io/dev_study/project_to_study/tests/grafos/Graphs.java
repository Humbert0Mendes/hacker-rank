package io.dev_study.project_to_study.tests.grafos;

import java.util.ArrayList;
import java.util.Objects;

public class Graphs<Type> {

    private ArrayList<Node<Type>> nodes;
    private ArrayList<Edge<Type>> edges;

    public Graphs() {
        this.nodes = new ArrayList<Node<Type>>();
        this.edges = new ArrayList<Edge<Type>>();
    }

    public void addNode(Type node) {
        var newNode = new Node(node);
        this.nodes.add(newNode);
    }


    public void addEdge(Type from, Type to, Double weight) {
        var nodeFrom = this.getNode(from);
        var nodeTo = this.getNode(to);

        if (Objects.nonNull(nodeFrom) && Objects.nonNull(nodeTo)) {
            var newEdge = new Edge<Type>(weight, nodeFrom, nodeTo);

            nodeFrom.addEdgeOut(newEdge);
            nodeTo.addEdgeEnty(newEdge);
            this.edges.add(newEdge);
        }

    }

    public void printIfF1AndF2AreFriends(String f1, String f2) {

        var nodeF1 = findNode(f1);
        if (Objects.isNull(nodeF1)) {
            throw new IllegalArgumentException("Node not found");
        }

        var areFriends = verifyIfAreFriends(nodeF1, f2);
        if (areFriends) {
            System.out.printf("F1 (%s) é amigo de F2 (%s)  \n", f1, f2);
        }else{
            System.out.printf("F1 (%s) não é amigo de F2 (%s) \n", f1, f2);
        }
    }

    public void verifyFriendsConections(){

        for (int i = 0; i < this.nodes.size(); i++) {
            var node = this.nodes.get(i);
            this.nodes.forEach(currentyN -> {
                var isFriend = verifyIfAreFriends(node, currentyN.getData().toString());
                if(isFriend){
                    System.out.printf(" %s é amigo de %s  \n", node.getData(), currentyN.getData());
                }
            });
        }
    }


    public void widthSearch() {
        var marked = new ArrayList<Node<Type>>();
        var queue = new ArrayList<Node<Type>>();

        Node<Type> current = this.nodes.get(0);

        marked.add(current);
        System.out.printf("The node was visited: %s%n", current.getData());
        queue.add(current);

        while (queue.size() > 0) {
            Node<Type> visited = queue.get(0);

            for (int i = 0; i < visited.getEdgesOut().size(); i++) {
                var nextNode = visited.getEdgesOut().get(i).getEnd();
                if (!marked.contains(nextNode)) {
                    marked.add(nextNode);
                    System.out.printf("The node was visited: %s%n", nextNode.getData());
                    queue.add(nextNode);
                }
            }

            queue.remove(0);
        }
    }

    private Node<Type> getNode(Type dataNode) {
        Node<Type> node = null;
        for (int i = 0; i < this.nodes.size(); i++) {
            if (this.nodes.get(i).getData().equals(dataNode)) {
                node = this.nodes.get(i);
                break;
            }
        }
        return node;
    }

    private Node<Type> findNode(String data) {
        for (Node<Type> node : this.nodes) {
            if (node.getData().equals(data)) {
                return node;
            }
        }
        return null;
    }

    private boolean verifyIfAreFriends(Node<Type> node1, String node2) {
        return node1.getEdgesOut().stream()
                .anyMatch(f -> f.getEnd().getData().equals(node2));
    }
}
