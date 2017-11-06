package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 08/10/2017.
 */

public class Seller implements Serializable {
    private String id_user;
    private String name;
    private String avatar;
    private String score;
    private String listing;

    public Seller(String id_user, String name, String avatar, String score, String listing) {
        this.id_user = id_user;
        this.name = name;
        this.avatar = avatar;
        this.score = score;
        this.listing = listing;
    }

    public Seller() {
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }
}
