package com.example.kursovavisual;

import java.net.URL;
import java.util.*;

import com.example.kursovavisual.algo.BruteForce;
import com.example.kursovavisual.algo.TarjanAlgo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.ResourceBundle;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML
    private LineChart<?, ?> lineCharForBruteForce;

    @FXML
    private LineChart<?, ?> lineChartForTarjan;

    @FXML
    private LineChart<?, ?> lineChartForTwoAlgo;

    @FXML
    private TableColumn<AlgorithmData, Integer> numVertex;

    @FXML
    private TableColumn<?, ?> numArticulationPoint;

    @FXML
    private TableView<AlgorithmData> tableInfo;

    @FXML
    private TableColumn<AlgorithmData, Integer> timeBrudeForce;

    @FXML
    private TableColumn<AlgorithmData, Long> timeTarjans;

    @FXML
    private TextField textFiledForNumVertex;

    @FXML
    private Label textToUser;

    @FXML
    private TableColumn<OperationData, Long> numAssignmentBruteForce;

    @FXML
    private TableColumn<OperationData, Long> numAssignmentTarjan;

    @FXML
    private TableColumn<OperationData, Long> numComparisonBruteForce;

    @FXML
    private TableColumn<OperationData, Long> numComparisonTarjan;

    @FXML
    private TableView<OperationData> infoOperations;

    @FXML
    private TableColumn<OperationData, Integer> numVertex2;

    @FXML
    private TableColumn<OperationData, Long> sumBruteForce;

    @FXML
    private TableColumn<OperationData, Long> sumTarjan;


    @FXML
    void enterDataFromUser(ActionEvent event) {
        System.out.println(textFiledForNumVertex.getText());
        int enteredNum = checkToStartProgram(textFiledForNumVertex.getText());

        if (enteredNum > 0) startAlgorithms(enteredNum);
        else textToUser.setText("Ви ввели некоректні дані!");
    }

    private int checkToStartProgram(String string) {
        try {
            int num = Integer.parseInt(string);
            textToUser.setText("Дані введено успішно!");
            return num;
        } catch (Exception ignored) {
            textToUser.setText("Ви ввели некоректні дані!");
            return -1;
        }
    }

    private void startAlgorithms(Integer num) {
        clearCharts();
        XYChart.Series series = new XYChart.Series();
        XYChart.Series series1 = new XYChart.Series();
        XYChart.Series seriesTarjan = new XYChart.Series();
        XYChart.Series seriesBruteForce = new XYChart.Series();


        List<AlgorithmData> dataList = new ArrayList<>();
        List<OperationData> dataListForOperation = new ArrayList<>();

        for (int k = 3; k <= num; k++) {

            BruteForce bruteForce = new BruteForce();
            TarjanAlgo tarjanAlgo = new TarjanAlgo();
            int numVertices = k;

            List<Integer>[] graph1 = generateConnectedGraph(numVertices);

            boolean[] visited1 = new boolean[numVertices];
            Arrays.fill(visited1, false);

            int[] parent1 = new int[numVertices];
            Arrays.fill(parent1, -1);

            int[] low1 = new int[numVertices];
            Arrays.fill(low1, 0);

            int[] disc1 = new int[numVertices];
            Arrays.fill(disc1, 0);

            Set<Integer> resultT = new HashSet<>();
            Set<Integer> resultB = new HashSet<>();

            long startTimeT = System.nanoTime();
            tarjanAlgo.findArticulationPoints(graph1, disc1, low1, visited1, parent1, resultT, 0);
            long endTimeT = System.nanoTime();
            long elapsedTimeT = endTimeT - startTimeT;


            long startTimeB = System.nanoTime();
            bruteForce.AP(graph1, numVertices, resultB);
            long endTimeB = System.nanoTime();
            long elapsedTimeB = endTimeB - startTimeB;

            if (k % 10 == 0) {
                series.getData().add(new XYChart.Data<>(String.valueOf(k), elapsedTimeT));
                series1.getData().add(new XYChart.Data<>(String.valueOf(k), elapsedTimeB));
                seriesTarjan.getData().add(new XYChart.Data<>(String.valueOf(k), elapsedTimeT));
                seriesBruteForce.getData().add(new XYChart.Data<>(String.valueOf(k), elapsedTimeB));

            }

            AlgorithmData data = new AlgorithmData(k, resultT.size(), elapsedTimeT, endTimeT);
            dataList.add(data);

            OperationData operationData = new OperationData(k, tarjanAlgo.getAssignmentCount(), bruteForce.getAssignmentCount(),
                    tarjanAlgo.getComparisonCount(), bruteForce.getComparisonCount());
            dataListForOperation.add(operationData);


        }

        printLineCharForTwoAlgo(series, series1);
        printLineCartForTarjanAndBruteForce(seriesTarjan, seriesBruteForce);

        dataForTable(dataList);
        dataForOperationTable(dataListForOperation);
    }

    @FXML
    void initialize() {
    }

    private void printLineCharForTwoAlgo(XYChart.Series series, XYChart.Series series1) {
        //Вивід двох на один графік
        lineChartForTwoAlgo.getData().addAll(series);
        lineChartForTwoAlgo.getData().addAll(series1);
    }

    private void printLineCartForTarjanAndBruteForce(XYChart.Series series, XYChart.Series series1) {
        //Вивід алгоритму Тар'яна
        lineChartForTarjan.getData().addAll(series);

        //Вивід алгоритму грубої сили
        lineCharForBruteForce.getData().addAll(series1);
    }

    private void clearCharts() {
        lineCharForBruteForce.getData().clear();
        lineChartForTarjan.getData().clear();
        lineChartForTwoAlgo.getData().clear();
    }

    private void dataForTable(List<AlgorithmData> dataList) {
        numVertex.setCellValueFactory(new PropertyValueFactory<>("numVertices"));
        numArticulationPoint.setCellValueFactory(new PropertyValueFactory<>("numArticulationPoint"));
        timeTarjans.setCellValueFactory(new PropertyValueFactory<>("timeTarjan"));
        timeBrudeForce.setCellValueFactory(new PropertyValueFactory<>("timeBruteForce"));

        ObservableList<AlgorithmData> observableData = FXCollections.observableArrayList(dataList);
        tableInfo.setItems(observableData);
    }

    private void dataForOperationTable(List<OperationData> dataList) {
        numVertex2.setCellValueFactory(new PropertyValueFactory<>("numVertex2"));
        numAssignmentTarjan.setCellValueFactory(new PropertyValueFactory<>("numAssignmentTarjan"));
        numAssignmentBruteForce.setCellValueFactory(new PropertyValueFactory<>("numAssignmentBruteForce"));
        numComparisonTarjan.setCellValueFactory(new PropertyValueFactory<>("numComparisonTarjan"));
        numComparisonBruteForce.setCellValueFactory(new PropertyValueFactory<>("numComparisonBruteForce"));
        sumTarjan.setCellValueFactory(new PropertyValueFactory<>("sumTarjan"));
        sumBruteForce.setCellValueFactory(new PropertyValueFactory<>("sumBruteForce"));

        ObservableList<OperationData> observableData = FXCollections.observableArrayList(dataList);
        infoOperations.setItems(observableData);
    }

    private void addEdge(List<Integer>[] graph, int u, int v) {
        graph[u].add(v);
        graph[v].add(u);
    }

    private List<Integer>[] generateConnectedGraph(int numVertices) {
        List<Integer>[] graph;
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

    public boolean isConnected(List<Integer>[] graph, int numVertices) {
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
