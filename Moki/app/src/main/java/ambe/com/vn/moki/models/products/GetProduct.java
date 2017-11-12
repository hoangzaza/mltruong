package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 12/11/2017.
 */

public class GetProduct implements Serializable {
    private String code;
    private String message;
    private Product data;

    public GetProduct(String code, String message, Product data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public GetProduct() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Product getData() {
        return data;
    }

    public void setData(Product data) {
        this.data = data;
    }
}
