package ambe.com.vn.moki.models.products;

import java.io.Serializable;
import java.util.ArrayList;

import ambe.com.vn.moki.utils.StringUrl;

/**
 * Created by AMBE on 08/11/2017.
 */

public class ListProductLoadMore implements Serializable {
    private String code;
    private String message;
    private ArrayList<Product> data;
    private String last_id;

    public ListProductLoadMore(String code, String message, ArrayList<Product> data,String last_id) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.last_id=last_id;
    }

    public ListProductLoadMore() {
    }

    public String getLast_id() {
        return last_id;
    }

    public void setLast_id(String last_id) {
        this.last_id = last_id;
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
