package com.example.kursovavisual;

public class AlgorithmData {
    private int numVertices;
    private int numArticulationPoint;
    private long timeTarjan;
    private long timeBruteForce;

    public AlgorithmData(int numVertices,int numArticulationPoint, long timeTarjan, long timeBruteForce) {
        this.numVertices = numVertices;
        this.numArticulationPoint = numArticulationPoint;
        this.timeTarjan = timeTarjan;
        this.timeBruteForce = timeBruteForce;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getNumArticulationPoint() {
        return numArticulationPoint;
    }

    public void setNumArticulationPoint(int numArticulationPoint) {
        this.numArticulationPoint = numArticulationPoint;
    }

    public long getTimeTarjan() {
        return timeTarjan;
    }

    public void setTimeTarjan(long timeTarjan) {
        this.timeTarjan = timeTarjan;
    }

    public long getTimeBruteForce() {
        return timeBruteForce;
    }

    public void setTimeBruteForce(long timeBruteForce) {
        this.timeBruteForce = timeBruteForce;
    }
}
