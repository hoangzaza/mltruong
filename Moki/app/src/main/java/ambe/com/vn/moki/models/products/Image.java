package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 08/10/2017.
 */

public class Image implements Serializable {

    private String url;
    private String id;

    public Image(String url, String id) {
        this.url = url;
        this.id = id;
    }

    public Image() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
