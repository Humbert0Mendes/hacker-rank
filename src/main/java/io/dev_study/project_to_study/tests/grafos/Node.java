package io.dev_study.project_to_study.tests.grafos;

import java.util.ArrayList;

public class Node <Type>{
    private Type data;
    private ArrayList<Edge<Type>> edgesEnty;
    private ArrayList<Edge<Type>> edgesOut;

    public Node(Type data){
        this.data = data;
        this.edgesEnty = new ArrayList<Edge<Type>>();
        this.edgesOut = new ArrayList<Edge<Type>>();
    }

    public void addEdgeEnty(Edge<Type> edge){
        this.edgesEnty.add(edge);
    }

    public void addEdgeOut(Edge<Type> edge){
        this.edgesOut.add(edge);
    }

    public Type getData(){
        return data;
    }

    public void setData(Type data){
        this.data = data;
    }

    public ArrayList<Edge<Type>> getEdgesEnty() {
        return edgesEnty;
    }

    public ArrayList<Edge<Type>> getEdgesOut() {
        return edgesOut;
    }

}
