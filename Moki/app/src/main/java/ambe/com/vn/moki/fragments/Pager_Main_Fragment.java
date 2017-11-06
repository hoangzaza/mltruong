package ambe.com.vn.moki.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.models.products.Image;

/**
 * Created by HoangNV on 10/16/2017.
 */

public class Pager_Main_Fragment extends Fragment{
    private int position;
    ImageView img;
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         v=inflater.inflate(R.layout.fragment_pager,container,false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        img=(ImageView)v.findViewById(R.id.img_pager);
        Bundle bundle = getArguments();
        if (bundle != null) {
            position = bundle.getInt("POSITION", -1);
        }
        if(position%2==0){
            Picasso.with(getActivity()).load("https://moki.vn//files/banner/banner_1497926374_35.png").into(img);
            img.setScaleType(ImageView.ScaleType.FIT_XY);

        } else{
            Picasso.with(getActivity()).load("https://moki.vn//files/banner/banner_1507083436_36.png").into(img);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        //https://moki.vn//files/banner/banner_1497926374_35.png
    }
}
