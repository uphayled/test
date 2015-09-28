package com.cs616.demointents;

import android.graphics.Color;

import java.io.Serializable;

/**
 * Created by ian on 15-09-21.
 */
public class RGBAColor implements Serializable {
    private int red;
    private int green;
    private int blue;
    private int alpha;

    public static RGBAColor fromInt(int color) {
        return new RGBAColor(Color.red(color), Color.blue(color), Color.green(color), Color.alpha(color));
    }

    public RGBAColor(int red, int green, int blue, int alpha) {
        this.blue = blue;
        this.green = green;
        this.red = red;
        this.alpha = alpha;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public int asInt() {
        return Color.argb(alpha, red, green, blue);
    }
}
