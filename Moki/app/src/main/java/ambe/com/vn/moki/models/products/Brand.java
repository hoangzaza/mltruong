package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 08/10/2017.
 */

public class Brand implements Serializable {
    private String id_brand;
    private String brand_name;

    public Brand(String id_brand, String brand_name) {
        this.id_brand = id_brand;
        this.brand_name = brand_name;
    }

    public Brand() {
    }

    public String getId_brand() {
        return id_brand;
    }

    public void setId_brand(String id_brand) {
        this.id_brand = id_brand;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

}
