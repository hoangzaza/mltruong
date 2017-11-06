package ambe.com.vn.moki.models.users;

import java.io.Serializable;
import java.util.ArrayList;

import ambe.com.vn.moki.models.products.Product;

/**
 * Created by AMBE on 09/10/2017.
 */

public class Profile implements Serializable {
    private String id_user;
    private String password;
    private String token;
    private String email;
    private String usename;
    private String phonenumber;
    private ArrayList<Product> list_product;
    private String url;
    private String created;
    private String status;
    private String avatar;
    private String firsname;
    private String lastname;
    private String address;
    private String rates_lv1;
    private String rates_lv2;
    private String rates_lv3;
    private String city;
    private String listing_product;
    private ArrayList<Object> followed;
    private String is_blocked;
    private Default_address default_address;
    private int online;
    private ArrayList<Object> list_like;
    private ArrayList<Object> list_search;
    private ArrayList<Object> list_following;
    private ArrayList<Object> list_chat;
    private ArrayList<Object> list_order_address;

    public Profile(String id_user, String password, String token, String email, String usename, String phonenumber, ArrayList<Product> list_product, String url, String created, String status, String avatar, String firsname, String lastname, String address, String rates_lv1, String rates_lv2, String rates_lv3, String city, String listing_product, ArrayList<Object> followed, String is_blocked, Default_address default_address, int online, ArrayList<Object> list_like, ArrayList<Object> list_search, ArrayList<Object> list_following, ArrayList<Object> list_chat, ArrayList<Object> list_order_address) {
        this.id_user = id_user;
        this.password = password;
        this.token = token;
        this.email = email;
        this.usename = usename;
        this.phonenumber = phonenumber;
        this.list_product = list_product;
        this.url = url;
        this.created = created;
        this.status = status;
        this.avatar = avatar;
        this.firsname = firsname;
        this.lastname = lastname;
        this.address = address;
        this.rates_lv1 = rates_lv1;
        this.rates_lv2 = rates_lv2;
        this.rates_lv3 = rates_lv3;
        this.city = city;
        this.listing_product = listing_product;
        this.followed = followed;
        this.is_blocked = is_blocked;
        this.default_address = default_address;
        this.online = online;
        this.list_like = list_like;
        this.list_search = list_search;
        this.list_following = list_following;
        this.list_chat = list_chat;
        this.list_order_address = list_order_address;
    }

    public Profile() {
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public ArrayList<Product> getList_product() {
        return list_product;
    }

    public void setList_product(ArrayList<Product> list_product) {
        this.list_product = list_product;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirsname() {
        return firsname;
    }

    public void setFirsname(String firsname) {
        this.firsname = firsname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRates_lv1() {
        return rates_lv1;
    }

    public void setRates_lv1(String rates_lv1) {
        this.rates_lv1 = rates_lv1;
    }

    public String getRates_lv2() {
        return rates_lv2;
    }

    public void setRates_lv2(String rates_lv2) {
        this.rates_lv2 = rates_lv2;
    }

    public String getRates_lv3() {
        return rates_lv3;
    }

    public void setRates_lv3(String rates_lv3) {
        this.rates_lv3 = rates_lv3;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getListing_product() {
        return listing_product;
    }

    public void setListing_product(String listing_product) {
        this.listing_product = listing_product;
    }

    public ArrayList<Object> getFollowed() {
        return followed;
    }

    public void setFollowed(ArrayList<Object> followed) {
        this.followed = followed;
    }

    public String getIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(String is_blocked) {
        this.is_blocked = is_blocked;
    }

    public Default_address getDefault_address() {
        return default_address;
    }

    public void setDefault_address(Default_address default_address) {
        this.default_address = default_address;
    }

    public int getOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }

    public ArrayList<Object> getList_like() {
        return list_like;
    }

    public void setList_like(ArrayList<Object> list_like) {
        this.list_like = list_like;
    }

    public ArrayList<Object> getList_search() {
        return list_search;
    }

    public void setList_search(ArrayList<Object> list_search) {
        this.list_search = list_search;
    }

    public ArrayList<Object> getList_following() {
        return list_following;
    }

    public void setList_following(ArrayList<Object> list_following) {
        this.list_following = list_following;
    }

    public ArrayList<Object> getList_chat() {
        return list_chat;
    }

    public void setList_chat(ArrayList<Object> list_chat) {
        this.list_chat = list_chat;
    }

    public ArrayList<Object> getList_order_address() {
        return list_order_address;
    }

    public void setList_order_address(ArrayList<Object> list_order_address) {
        this.list_order_address = list_order_address;
    }
}
