package com.codetreatise.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class GraphicsUtils {

    public static Image getImageTipoTransporte(Integer idTransporte) {

        switch (idTransporte) {
            case 1: case 2: return new Image(GraphicsUtils.class.getResourceAsStream("/images/airplane.png"));
            case 3: return new Image(GraphicsUtils.class.getResourceAsStream("/images/ship.png"));
            case 4: case 5: return new Image(GraphicsUtils.class.getResourceAsStream("/images/delivery-truck.png"));
            default: return null;
        }
    }

    public static Circle getEstadoEntrega(Integer idEstadoEntrega) {

        switch (idEstadoEntrega) {
            case 1: return new Circle(10,Color.YELLOW);
            case 2: return new Circle(10,Color.BLUE);
            case 3: return new Circle(10,Color.RED);
            case 4: return new Circle(10,Color.GREEN);
            default: return new Circle(10,Color.GRAY);
        }
    }

    public static ImageView getImageCadena(int id) {
        switch (id) {
            case 1: return imageCadena(id,50,15); //ZARA
            case 2: return imageCadena(id,75,15); //ZARA HOME
            case 3: return imageCadena(id,70,15); //PULL & BEAR
            case 4: return imageCadena(id,65,15); //BERSHKA
            case 5: return imageCadena(id,90,15); //MASSIMO DUTTI
            case 6: return imageCadena(id,85,15); //STRADIVARIUS
            case 7: return imageCadena(id,70,15); //OYSHO
            case 8: return imageCadena(id,75,15); //UTERQÜE
            default: return null;
        }
    }

    private static ImageView imageCadena(int id, double width, double height) {
        Image image = new Image(GraphicsUtils.class.getResourceAsStream("/images/cadenas/" + id + ".png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
        return imageView;
    }

    public static Color getColorById(int id) {

        switch (id) {
            case 1: return Color.WHITE;
            case 2: return Color.BLACK;
            case 3: return Color.RED;
            case 4: return Color.BLUE;
            case 5: return Color.GREEN;
            case 6: return Color.PINK;
            case 7: return Color.BROWN;
            case 9: return Color.LIGHTPINK;
            case 10: return Color.LAVENDER;
            case 11: return Color.OLIVE;
            default: return Color.GRAY;
        }
    }

    public static Circle getCircleById(int radius,int id) {
        return new Circle(radius,getColorById(id));
    }
}
