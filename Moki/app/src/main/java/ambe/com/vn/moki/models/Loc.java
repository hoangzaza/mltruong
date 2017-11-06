package ambe.com.vn.moki.models;

import java.io.Serializable;

/**
 * Created by AMBE on 18/09/2017.
 */

public class Loc implements Serializable {
    private String titLe;
    private String subTitle;
    private int check;

    public Loc(String titLe, String subTitle, int check) {
        this.titLe = titLe;
        this.subTitle = subTitle;
        this.check = check;
    }

    public Loc() {
    }

    public String getTitLe() {
        return titLe;
    }

    public void setTitLe(String titLe) {
        this.titLe = titLe;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
}
