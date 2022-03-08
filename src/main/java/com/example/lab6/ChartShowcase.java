package com.example.lab6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class ChartShowcase extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        double[] avgHousingPricesByYear = {
                247381.0,264171.4,287715.3,294736.1,
                308431.4,322635.9,340253.0,363153.7
        };
        double[] avgCommercialPricesByYear = {
                1121585.3,1219479.5,1246354.2,1295364.8,
                1335932.6,1472362.0,1583521.9,1613246.3
        };

        CategoryAxis x = new CategoryAxis();
        x.setLabel("Year");
        NumberAxis y = new NumberAxis();
        y.setLabel("Price");

        BarChart chart1 = new BarChart(x, y);
        XYChart.Series housing = new XYChart.Series();
        housing.setName("Housing Prices");
        for(int i=0;i<avgHousingPricesByYear.length;i++){
            String year= Integer.toString(2000+i);
            housing.getData().add(new XYChart.Data(year, avgHousingPricesByYear[i]));
        }

        XYChart.Series commercial = new XYChart.Series();
        commercial.setName("Commercial Prices");
        for(int i=0;i<avgCommercialPricesByYear.length;i++){
            String year= Integer.toString(2000+i);
            commercial.getData().add(new XYChart.Data(year, avgCommercialPricesByYear[i]));
        }

        chart1.getData().add(housing);
        chart1.getData().add(commercial);









        String[] ageGroups = {
                "18-25", "26-35", "36-45", "46-55", "56-65", "65+"
        };
        int[] purchasesByAgeGroup = {
                648, 1021, 2453, 3173, 1868, 2247
        };
        Color[] pieColours = {
                Color.AQUA, Color.GOLD, Color.DARKORANGE,
                Color.DARKSALMON, Color.LAWNGREEN, Color.PLUM
        };

        PieChart chart2 = new PieChart();

        for(int i=0;i< ageGroups.length;i++){
            chart2.getData().add(new PieChart.Data(ageGroups[i], purchasesByAgeGroup[i]));
        }



        FXMLLoader fxmlLoader = new FXMLLoader(ChartShowcase.class.getResource("hello-view.fxml"));
        TilePane pane1 = new TilePane();
        Scene scene = new Scene(pane1, 1000, 400);
        Pane bar = new Pane();
        Pane pie = new Pane();
        bar.getChildren().addAll(chart1);
        pie.getChildren().addAll(chart2);
        pane1.getChildren().addAll(bar, pie);
        stage.setTitle("Lab6");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}