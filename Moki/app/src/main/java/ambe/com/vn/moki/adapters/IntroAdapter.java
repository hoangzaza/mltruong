package ambe.com.vn.moki.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by AMBE on 13/09/2017.
 */

public class IntroAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrFragments;

    public IntroAdapter(FragmentManager fm, ArrayList<Fragment> arrFragments) {
        super(fm);
        this.arrFragments = arrFragments;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = arrFragments.get(position);
        Bundle bundle = new Bundle();

            bundle.putInt("POSITION", position);
            fragment.setArguments(bundle);


        return fragment;
    }

    @Override
    public int getCount() {
        return arrFragments.size();
    }
}
