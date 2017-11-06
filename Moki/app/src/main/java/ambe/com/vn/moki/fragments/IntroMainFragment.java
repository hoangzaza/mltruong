package ambe.com.vn.moki.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.adapters.IntroAdapter;
import ambe.com.vn.moki.interfaces.ClickBoQua;

public class IntroMainFragment extends Fragment implements ClickBoQua{

    private ViewPager viewPager;
    private View view;
    private ArrayList<Fragment> arrFragments;


    public IntroMainFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static IntroMainFragment newInstance() {
        IntroMainFragment fragment = new IntroMainFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main_intro, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewPager = view.findViewById(R.id.vp_intro);
        IntroFragment introFragment1 = IntroFragment.newInstance(this);
        IntroFragment introFragment2 = IntroFragment.newInstance(this);
        IntroFragment introFragment3 = IntroFragment.newInstance(this);
        LoginFragment loginFragment = LoginFragment.newInstance();

        arrFragments = new ArrayList<>();
        arrFragments.add(introFragment1);
        arrFragments.add(introFragment2);
        arrFragments.add(introFragment3);
        arrFragments.add(loginFragment);
        IntroAdapter introAdapter = new IntroAdapter(getFragmentManager(), arrFragments);
        viewPager.setAdapter(introAdapter);
        viewPager.setPageTransformer(true, new DepthPageTransformer());

    }

    @Override
    public void onClickBoQua() {
        viewPager.setCurrentItem(3,true);
    }

    public class DepthPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 0) { // [-1,0]
                // Use the default slide transition when moving to the left page
                view.setAlpha(1);
                view.setTranslationX(0);
                view.setScaleX(1);
                view.setScaleY(1);

            } else if (position <= 1) { // (0,1]
                // Fade the page out.
                view.setAlpha(1 - position);

                // Counteract the default slide transition
                view.setTranslationX(pageWidth * -position);

                // Scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE
                        + (1 - MIN_SCALE) * (1 - Math.abs(position));
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

}
