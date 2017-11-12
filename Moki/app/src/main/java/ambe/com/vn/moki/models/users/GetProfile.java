package ambe.com.vn.moki.models.users;

import java.io.Serializable;

/**
 * Created by AMBE on 11/11/2017.
 */

public class GetProfile implements Serializable {
    private String code;
    private String message;
    private Profile data;

    public GetProfile(String code, String message, Profile data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public GetProfile() {
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

    public Profile getData() {
        return data;
    }

    public void setData(Profile data) {
        this.data = data;
    }
}
