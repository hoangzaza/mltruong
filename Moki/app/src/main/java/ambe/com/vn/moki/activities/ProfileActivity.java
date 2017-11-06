package ambe.com.vn.moki.activities;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.fragments.FollowFragment;
import ambe.com.vn.moki.fragments.ListProductFragment;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    public static int NUM_PAGES = 3;

    private Typeface typeface;


    private ViewPager viewPager;
    private Toolbar toolbar;
    private ImageView imgBack;
    private MyAdapter myAdapter;
    private Button btnSanPham, btnNguoiTheoDoi, btnDangTheoDoi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setSupportActionBar(toolbar);
        addControls();
        setUpActionBar();
        addEvents();


    }

    private void addControls() {
        viewPager = findViewById(R.id.view_pager_profile_detail);
        toolbar = findViewById(R.id.tb_profile_detail);
        imgBack = findViewById(R.id.img_back_profile_detail);
        btnDangTheoDoi = findViewById(R.id.txt_activity_profile_dang_theo_doi);
        btnNguoiTheoDoi = findViewById(R.id.txt_activity_profile_ng_theo_doi);
        btnSanPham = findViewById(R.id.txt_activity_profile_san_pham);

        typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");


 //       btnDangTheoDoi.setTypeface(typeface);
        myAdapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

    }

    private void setUpActionBar() {

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

    private void addEvents() {
        imgBack.setOnClickListener(this);
        btnSanPham.setOnClickListener(this);
        btnDangTheoDoi.setOnClickListener(this);
        btnNguoiTheoDoi.setOnClickListener(this);


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        xuLyChonTxtSanPham();
                        break;
                    case 1:
                        xuLyChonDangTheoDoi();
                        break;
                    case 2:
                        xuLyChonNguoiTheoDoi();
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    private void xuLyChonNguoiTheoDoi() {
        btnSanPham.setTextColor(getResources().getColor(R.color.colorBlack));
        btnSanPham.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_san_pham_trang));
        btnDangTheoDoi.setTextColor(getResources().getColor(R.color.colorBlack));
        btnDangTheoDoi.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_dang_theo_doi));
        btnNguoiTheoDoi.setTextColor(getResources().getColor(R.color.colorWhite));
        btnNguoiTheoDoi.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_nguoi_theo_doi_do));


    }


    private void xuLyChonDangTheoDoi() {
        btnSanPham.setTextColor(getResources().getColor(R.color.colorBlack));
        btnSanPham.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_san_pham_trang));
        btnDangTheoDoi.setTextColor(getResources().getColor(R.color.colorWhite));
        btnDangTheoDoi.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_dang_theo_doi_do));
        btnNguoiTheoDoi.setTextColor(getResources().getColor(R.color.colorBlack));
        btnNguoiTheoDoi.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_nguoi_theo_doi));


    }

    private void xuLyChonTxtSanPham() {
        btnSanPham.setTextColor(getResources().getColor(R.color.colorWhite));
        btnSanPham.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_san_pham));
        btnDangTheoDoi.setTextColor(getResources().getColor(R.color.colorBlack));
        btnDangTheoDoi.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_dang_theo_doi));
        btnNguoiTheoDoi.setTextColor(getResources().getColor(R.color.colorBlack));
        btnNguoiTheoDoi.setBackgroundDrawable(getResources().getDrawable(R.drawable.bg_nguoi_theo_doi));


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back_profile_detail:
                finish();
                break;
            case R.id.txt_activity_profile_san_pham:
                xuLyChonTxtSanPham();
                viewPager.setCurrentItem(0, true);
                break;
            case R.id.txt_activity_profile_dang_theo_doi:
                xuLyChonTxtSanPham();
                viewPager.setCurrentItem(1, true);
                break;
            case R.id.txt_activity_profile_ng_theo_doi:
                xuLyChonTxtSanPham();
                viewPager.setCurrentItem(2, true);
                break;
        }
    }

    private class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ListProductFragment listProductFragment = new ListProductFragment();
                    return listProductFragment;
                case 1:
                    FollowFragment myFollowFragment = new FollowFragment();
                    return myFollowFragment;
                case 2:
                    FollowFragment followFragment = new FollowFragment();
                    return followFragment;

            }

            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public class ZoomOutPageTransformer implements ViewPager.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0);
            }
        }
    }

}
