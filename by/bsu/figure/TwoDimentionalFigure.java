package by.bsu.figure;

import java.awt.*;

public abstract class TwoDimentionalFigure extends Figure {

    private Color fillColor;

    public TwoDimentionalFigure(Color c, Color fill) {
        super(c);
        fillColor = fill;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
}