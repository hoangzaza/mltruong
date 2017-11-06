package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 08/10/2017.
 */

public class Category implements Serializable {
    private String category_id;
    private String name;
    private String has_brand;
    private String has_name;

    public Category(String category_id, String name, String has_brand, String has_name) {
        this.category_id = category_id;
        this.name = name;
        this.has_brand = has_brand;
        this.has_name = has_name;
    }

    public Category() {
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHas_brand() {
        return has_brand;
    }

    public void setHas_brand(String has_brand) {
        this.has_brand = has_brand;
    }

    public String getHas_name() {
        return has_name;
    }

    public void setHas_name(String has_name) {
        this.has_name = has_name;
    }
}
