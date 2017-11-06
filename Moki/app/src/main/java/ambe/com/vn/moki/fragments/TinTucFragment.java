package ambe.com.vn.moki.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ambe.com.vn.moki.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TinTucFragment extends Fragment {


    public TinTucFragment() {
        // Required empty public constructor
    }

    public static TinTucFragment newInstance(){
        TinTucFragment tinTucFragment=new TinTucFragment();
        return tinTucFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tin_tuc, container, false);
    }

}
