package fr.ensicaen.ecole.genielogiciel.view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.util.List;

public class SpiralPath {

    public static int[][] computeSpiralPath(int gridsize){
        int currentRow = 0;
        int currentCol = -1;
        int dep = 1;
        int[][] array = new int[gridsize][gridsize];
        int value = 0;

        for (int i = 0; i < gridsize - 1;i++){ // number of patterns (horizontal + vertical)
            for (int j = 0; j < gridsize - i;j++){

                currentCol += dep;
                array[currentRow][currentCol] = value;
                value++;
            }
            for (int j = 1; j < gridsize - i;j++){
                currentRow += dep;
                array[currentRow][currentCol] = value;
                value++;
            }
            dep = -dep;
        }
        array[currentRow][currentCol+dep] = value;
        return array;
    }
}