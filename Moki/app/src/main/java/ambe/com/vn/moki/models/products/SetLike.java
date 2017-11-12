package ambe.com.vn.moki.models.products;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by AMBE on 11/11/2017.
 */

public class SetLike implements Serializable {
    private String code;
    private String message;
    private ArrayList<Like> data;

    public SetLike(String code, String message, ArrayList<Like> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public SetLike() {
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

    public ArrayList<Like> getData() {
        return data;
    }

    public void setData(ArrayList<Like> data) {
        this.data = data;
    }
}
