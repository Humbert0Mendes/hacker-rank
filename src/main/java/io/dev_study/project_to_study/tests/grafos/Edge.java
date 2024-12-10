package io.dev_study.project_to_study.tests.grafos;

public class Edge<Type>{
    private Double weight;
    private Node<Type> begin;
    private Node<Type> end;

    public Edge(Double weight, Node<Type> begin, Node<Type> end) {
        this.weight = weight;
        this.begin = begin;
        this.end = end;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {}

    public Node<Type> getBegin() {
        return begin;
    }

    public void setBegin(Node<Type> begin) {
        this.begin = begin;
    }

    public Node<Type> getEnd() {
        return end;
    }

    public void setEnd(Node<Type> end) {
        this.end = end;
    }
}
