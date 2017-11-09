package ambe.com.vn.moki.models.users;

import java.io.Serializable;

/**
 * Created by AMBE on 07/11/2017.
 */

public class Login implements Serializable {
    private String code;
    private String messge;
    private Profile profile;

    public Login(String code, String messge, Profile profile) {
        this.code = code;
        this.messge = messge;
        this.profile = profile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
