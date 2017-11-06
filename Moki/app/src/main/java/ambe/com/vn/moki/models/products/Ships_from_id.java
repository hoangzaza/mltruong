package ambe.com.vn.moki.models.products;

import java.io.Serializable;

/**
 * Created by AMBE on 08/10/2017.
 */

public class Ships_from_id implements Serializable {
    private String province;
    private String district;
    private String ward;

    public Ships_from_id(String province, String district, String ward) {
        this.province = province;
        this.district = district;
        this.ward = ward;
    }

    public Ships_from_id() {
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}
