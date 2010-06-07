/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.npuzzle.npuzzleui;

import java.awt.Font;
import org.apache.pivot.wtk.Dimensions;
import org.apache.pivot.wtk.ImageView;
import org.apache.pivot.wtk.Label;
import org.apache.pivot.wtk.StackPane;
import org.apache.pivot.wtk.media.Drawing;
import org.apache.pivot.wtk.media.drawing.Canvas;
import org.apache.pivot.wtk.media.drawing.Rectangle;

/**
 *
 * @author thiago
 */
public class Hoax extends StackPane {

    private int width = 110;
    private int height = 110;
    private int value = 0;

    public Hoax(int width, int height, int value) {
        this.width = width;
        this.height = height;
        this.value = value;

        drawHoax();
    }

    public Hoax() {
        drawHoax();
    }

    private void drawHoax() {
        setSize(new Dimensions(width, height));
        Drawing drawing = new Drawing();
        Canvas canvas = new Canvas();
        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(height);
        rectangle.setWidth(width);
        rectangle.setFill("{paintType:'gradient', startX:0, startY:0, startColor:'#009900', endX:0, endY:240, endColor:'#000000'}");
        rectangle.setCornerRadius(10);
        rectangle.setStroke("#FFFFFF");
        rectangle.setStrokeThickness(1);
        canvas.add(rectangle);
        drawing.setCanvas(canvas);
        ImageView imageView = new ImageView(drawing);
        imageView.setStyles("{horizontalAlignment:'left', verticalAlignment:'top'}");
        Label label = new Label();
        label.setText(" " + value + " ");
        label.setStyles("{color:'#FFFFFF', horizontalAlignment:'center', verticalAlignment:'center'}");
        label.getStyles().put("font", new Font("Arial", Font.PLAIN, (int) height / 3));
        add(imageView);
        add(label);
    }
}
