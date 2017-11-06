package ambe.com.vn.moki.models;

import java.io.Serializable;

/**
 * Created by AMBE on 14/10/2017.
 */

public class MenuItem implements Serializable {
    private int idIcon;
    private String txtName;
    private int check;


    public MenuItem(int idIcon, String txtName, int check) {
        this.idIcon = idIcon;
        this.txtName = txtName;
        this.check = check;
    }

    public MenuItem() {
    }

    public int getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(int idIcon) {
        this.idIcon = idIcon;
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
