package ambe.com.vn.moki.models.products;

import java.io.Serializable;
import java.util.ArrayList;

import ambe.com.vn.moki.models.users.Profile;

/**
 * Created by AMBE on 08/10/2017.
 */

public class Product implements Serializable {
    private String id_product;
    private String name_product;
    private ArrayList<Image> image;
    private String price;
    private String price_precent;
    private String described;
    private String ships_from;
    private Ships_from_id ships_from_id;
    private String condition;
    private String created;
    private ArrayList<Profile> like;
    private ArrayList<Profile> comment;
    private Video video;
    private Size size;
    private Brand brand;
    private Seller seller;
    private Category category;
    private String state;
    private ArrayList<Profile> blocked;
    private ArrayList<Profile> can_edit;
    private String url_share;
    private String weight;
    private Dimention dimention;
    private ArrayList<Object> list_report;

    public Product(String name_product, ArrayList<Image> image, String price, ArrayList<Profile> like, ArrayList<Profile> comment) {
        this.name_product = name_product;
        this.image = image;
        this.price = price;
        this.like = like;
        this.comment = comment;
    }

    public Product(String id_product, String name_product, ArrayList<Image> image, String price, String price_precent, String described, String ships_from, Ships_from_id ships_from_id, String condition, String created, ArrayList<Profile> like, ArrayList<Profile> comment, Video video, Size size, Brand brand, Seller seller, Category category, String state, ArrayList<Profile> blocked, ArrayList<Profile> can_edit, String url_share, String weight, Dimention dimention, ArrayList<Object> list_report) {
        this.id_product = id_product;
        this.name_product = name_product;
        this.image = image;
        this.price = price;
        this.price_precent = price_precent;
        this.described = described;
        this.ships_from = ships_from;
        this.ships_from_id = ships_from_id;
        this.condition = condition;
        this.created = created;
        this.like = like;
        this.comment = comment;
        this.video = video;
        this.size = size;
        this.brand = brand;
        this.seller = seller;
        this.category = category;
        this.state = state;
        this.blocked = blocked;
        this.can_edit = can_edit;
        this.url_share = url_share;
        this.weight = weight;
        this.dimention = dimention;
        this.list_report = list_report;
    }

    public Product() {
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public ArrayList<Image> getImage() {
        return image;
    }

    public void setImage(ArrayList<Image> image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice_precent() {
        return price_precent;
    }

    public void setPrice_precent(String price_precent) {
        this.price_precent = price_precent;
    }

    public String getDescribed() {
        return described;
    }

    public void setDescribed(String described) {
        this.described = described;
    }

    public String getShips_from() {
        return ships_from;
    }

    public void setShips_from(String ships_from) {
        this.ships_from = ships_from;
    }

    public Ships_from_id getShips_from_id() {
        return ships_from_id;
    }

    public void setShips_from_id(Ships_from_id ships_from_id) {
        this.ships_from_id = ships_from_id;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public ArrayList<Profile> getLike() {
        return like;
    }

    public void setLike(ArrayList<Profile> like) {
        this.like = like;
    }

    public ArrayList<Profile> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Profile> comment) {
        this.comment = comment;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<Profile> getBlocked() {
        return blocked;
    }

    public void setBlocked(ArrayList<Profile> blocked) {
        this.blocked = blocked;
    }

    public ArrayList<Profile> getCan_edit() {
        return can_edit;
    }

    public void setCan_edit(ArrayList<Profile> can_edit) {
        this.can_edit = can_edit;
    }

    public String getUrl_share() {
        return url_share;
    }

    public void setUrl_share(String url_share) {
        this.url_share = url_share;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Dimention getDimention() {
        return dimention;
    }

    public void setDimention(Dimention dimention) {
        this.dimention = dimention;
    }

    public ArrayList<Object> getList_report() {
        return list_report;
    }

    public void setList_report(ArrayList<Object> list_report) {
        this.list_report = list_report;
    }
}
