package ambe.com.vn.moki.models.users;

import java.io.Serializable;

/**
 * Created by AMBE on 09/10/2017.
 */

public class Default_address implements Serializable {
    private String address_id;
    private String address;
    private String pick_support;

    public Default_address(String address_id, String address, String pick_support) {
        this.address_id = address_id;
        this.address = address;
        this.pick_support = pick_support;
    }

    public Default_address() {
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPick_support() {
        return pick_support;
    }

    public void setPick_support(String pick_support) {
        this.pick_support = pick_support;
    }
}
