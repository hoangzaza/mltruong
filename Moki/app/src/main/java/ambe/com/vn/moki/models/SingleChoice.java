package ambe.com.vn.moki.models;

import java.io.Serializable;

/**
 * Created by AMBE on 12/10/2017.
 */

public class SingleChoice implements Serializable {
    private String txtName;
    private int check;

    public SingleChoice(String txtName, int check) {
        this.txtName = txtName;
        this.check = check;
    }

    public SingleChoice() {
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
