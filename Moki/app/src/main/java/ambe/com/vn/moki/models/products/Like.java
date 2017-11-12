package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 11/11/2017.
 */

public class Like implements Serializable {
    private String id_user;
    private String name;

    public Like(String id_user, String name) {
        this.id_user = id_user;
        this.name = name;
    }

    public Like() {
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
