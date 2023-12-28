package com.example.kursovavisual.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BruteForce {

    private int assignmentCount;
    private int comparisonCount;

    private void dfs(List<Integer>[] adj, int V, List<Integer> vis,
                     int i, int curr) {
        vis.set(curr, 1);
        assignmentCount++;
        for (int x : adj[curr]) {
            comparisonCount++;
            if (x != i) {
                comparisonCount++;
                if (vis.get(x) == 0) {
                    dfs(adj, V, vis, i, x);
                    assignmentCount++;
                }
            }
        }
    }

    public void AP(List<Integer>[] adj, int V, Set<Integer> result) {

        for (int i = 0; i < V; i++) {
            comparisonCount++;
            assignmentCount++;
            int components = 0;

            List<Integer> vis = new ArrayList<>();

            for (int j = 0; j <= V; j++) {
                comparisonCount++;
                assignmentCount++;

                vis.add(0);
                assignmentCount++;
            }

            for (int j = 0; j < V; j++) {
                comparisonCount++;
                assignmentCount++;

                comparisonCount++;
                if (j != i) {
                    comparisonCount++;
                    if (vis.get(j) == 0) {
                        components++;
                        dfs(adj, V, vis, i, j);
                    }
                }
            }

            if (components > 1) {
                result.add(i);
                assignmentCount++;
            }

        }
    }

    public int getAssignmentCount() {
        return assignmentCount;
    }

    public int getComparisonCount() {
        return comparisonCount;
    }
}
