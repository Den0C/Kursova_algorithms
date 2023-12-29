package com.example.kursovavisual.algorithm;

import java.util.*;

public class Graph {

    public List<Integer>[] generateConnectedGraph(int numVertices) {
        ArrayList[] graph;
        Random random = new Random();

        // Вийти із циклу, якщо граф зв'язний
        do {
            graph = new ArrayList[numVertices];

            for (int i = 0; i < numVertices; i++) {
                graph[i] = new ArrayList<>();
            }

            // Додавання ребер між випадковими вершинами
            for (int i = 0; i < numVertices * 2; i++) {
                int vertex1 = random.nextInt(numVertices);
                int vertex2 = random.nextInt(numVertices);

                if (vertex1 != vertex2) {
                    addEdge(graph, vertex1, vertex2);
                }
            }

            // Перевірка, чи граф є зв'язним
        } while (!isConnected(graph, numVertices));

        return graph;
    }
    private void addEdge(List<Integer>[] graph, int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    private boolean isConnected(List<Integer>[] graph, int numVertices) {
        boolean[] visited = new boolean[numVertices];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // Почати BFS з першої вершини

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            visited[currentVertex] = true;

            for (int neighbor : graph[currentVertex]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }

        for (boolean vertexVisited : visited) {
            if (!vertexVisited) {
                return false; // Якщо яка-небудь вершина не відвідана, граф не є зв'язним
            }
        }

        return true; // Всі вершини відвідані, граф є зв'язним
    }
}
