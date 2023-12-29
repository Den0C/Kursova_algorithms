package com.example.kursovavisual.data;

public class AlgorithmData {
    private int numVertices;
    private int numArticulationPoint;
    private long timeTarjan;
    private long timeBruteForce;
    private double timeTarjanMilliSec;
    private double timeBruteForceMilliSec;

    public AlgorithmData(int numVertices, int numArticulationPoint, long timeTarjan, long timeBruteForce) {
        this.numVertices = numVertices;
        this.numArticulationPoint = numArticulationPoint;
        this.timeTarjan = timeTarjan;
        this.timeBruteForce = timeBruteForce;
        this.timeBruteForceMilliSec = (double) timeBruteForce / 1000000;
        this.timeTarjanMilliSec = (double) timeTarjan / 1000000;
    }

    public double getTimeTarjanMilliSec() {
        return timeTarjanMilliSec;
    }

    public void setTimeTarjanMilliSec(double timeTarjanMilliSec) {
        this.timeTarjanMilliSec = timeTarjanMilliSec;
    }

    public double getTimeBruteForceMilliSec() {
        return timeBruteForceMilliSec;
    }

    public void setTimeBruteForceMilliSec(double timeBruteForceMilliSec) {
        this.timeBruteForceMilliSec = timeBruteForceMilliSec;
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
