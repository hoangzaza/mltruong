package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 08/10/2017.
 */

public class Dimention implements Serializable {
    private String width;
    private String height;
    private String length;

    public Dimention(String width, String height, String length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public Dimention() {
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
