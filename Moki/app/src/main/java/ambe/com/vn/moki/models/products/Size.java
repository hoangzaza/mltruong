package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 08/10/2017.
 */

public class Size implements Serializable {
    private String id_size;
    private String size_name;

    public Size(String id_size, String size_name) {
        this.id_size = id_size;
        this.size_name = size_name;
    }

    public Size() {
    }

    public String getId_size() {
        return id_size;
    }

    public void setId_size(String id_size) {
        this.id_size = id_size;
    }

    public String getSize_name() {
        return size_name;
    }

    public void setSize_name(String size_name) {
        this.size_name = size_name;
    }
}
