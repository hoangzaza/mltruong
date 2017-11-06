package ambe.com.vn.moki.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

import ambe.com.vn.moki.activities.MainActivity;

/**
 * Created by AMBE on 16/09/2017.
 */

public class PagerTrangChuAdapter extends FragmentStatePagerAdapter {
    private ArrayList<Fragment> arr;


    public PagerTrangChuAdapter(FragmentManager fm, ArrayList<Fragment> arr) {
        super(fm);
        this.arr = arr;

    }

    @Override
    public Fragment getItem(int position) {

        Bundle bundle = new Bundle();
        bundle.putInt("ID", position);
        bundle.putBoolean("xanhdo", MainActivity.is_grid);
        arr.get(position).setArguments(bundle);


        return arr.get(position);

    }


    @Override
    public int getCount() {
        return arr.size();
    }
}

