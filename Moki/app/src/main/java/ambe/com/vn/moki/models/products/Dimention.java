package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 08/10/2017.
 */

public class Dimention implements Serializable {
    private float width;
    private float height;
    private float length;

    public Dimention(float width, float height, float length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public Dimention() {
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }
}
