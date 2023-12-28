package com.example.kursovavisual.algo;

import java.util.List;
import java.util.Set;

public class TarjanAlgo {
    private int time1 = 0;
    private int assignmentCount;
    private int comparisonCount;

    public void findArticulationPoints(List<Integer>[] graph, int[] disc, int[] low,
                                       boolean[] visited, int[] parent, Set<Integer> result,
                                       int v) {
        visited[v] = true;
        assignmentCount++;

        time1++;
        disc[v] = low[v] = time1;
        assignmentCount++;

        int child = 0;
        assignmentCount++;

        for (int av : graph[v]) {
            comparisonCount++;
            assignmentCount++;

            comparisonCount++;
            if (!visited[av]) {
                child++;
                parent[av] = v;
                findArticulationPoints(graph, disc, low, visited, parent, result, av);
                low[v] = Math.min(low[v], low[av]);
                assignmentCount += 2;

                comparisonCount++;
                if (parent[v] == -1 && child > 1) {
                    result.add(v);
                    assignmentCount++;
                } else if (parent[v] != -1 && low[av] >= disc[v]) {
                    result.add(v);
                    assignmentCount++;
                }

            } else if (av != parent[v]) {
                low[v] = Math.min(low[v], disc[av]);
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
