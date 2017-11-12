package ambe.com.vn.moki.models.users;

import java.io.Serializable;
import java.util.ArrayList;

import ambe.com.vn.moki.models.products.Product;

/**
 * Created by AMBE on 12/11/2017.
 */

public class GetMyLike implements Serializable {
    private String code;
    private String message;
    private ArrayList<Product> data;

    public GetMyLike(String code, String message, ArrayList<Product> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public GetMyLike() {
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

    public ArrayList<Product> getData() {
        return data;
    }

    public void setData(ArrayList<Product> data) {
        this.data = data;
    }
}
