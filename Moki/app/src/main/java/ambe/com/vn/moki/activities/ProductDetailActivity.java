package ambe.com.vn.moki.activities;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.utils.CheckConnect;

public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView imgBack;
    private ImageView imgBaCham;
    private RelativeLayout rl1;
    private RelativeLayout rl2;
    private LinearLayout lnl5;
    private TextView txtQuayVeTrangChu;
    private TextView txtBaoCaoViPham;
    private TextView txtDong;
    private TextView txtTitleToolbar;
    private PullToZoomScrollViewEx scrollViewEx;
    private View zoomView;
    private View contentView;
    private TextView txtDescription;
    private TextView txtXemThem;
    private LinearLayout lnlProfileContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        addControls();
        setUpActionBar();
        addEvents();
//        if (CheckConnect.isNetworkConnected(this)) {
//        } else {
//            showMyDialog();
//            addEvents();
//
//        }
    }

    private void showMyDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dont_connect_network);
//            WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
//            lp.copyFrom(dialog.getWindow().getAttributes());
//            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
//            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//            lp.gravity = Gravity.CENTER;
//
//            dialog.getWindow().setAttributes(lp);

        Button btnDong = dialog.findViewById(R.id.btn_dong);
        btnDong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void addEvents() {

        imgBack.setOnClickListener(this);
        lnlProfileContent.setOnClickListener(this);
        imgBaCham.setOnClickListener(this);
        txtDong.setOnClickListener(this);
        txtQuayVeTrangChu.setOnClickListener(this);
        txtBaoCaoViPham.setOnClickListener(this);
        lnl5.setOnClickListener(this);

    }

    private void addControls() {
        toolbar = findViewById(R.id.tb_product_detail);
        imgBack = findViewById(R.id.img_back);
        scrollViewEx = findViewById(R.id.scroll_detail_product);
        txtTitleToolbar = findViewById(R.id.txt_tittle_tb_product_detail);
        imgBaCham = findViewById(R.id.img_ba_cham);
        rl1 = findViewById(R.id.rll_productdetail_1);
        rl2 = findViewById(R.id.rll_productdetail_2);
        txtBaoCaoViPham = findViewById(R.id.txt_bao_cao_vi_pham);
        txtQuayVeTrangChu = findViewById(R.id.txt_quay_ve_trang_chu);
        txtDong = findViewById(R.id.btn_dong_product_detail);
        lnl5 = findViewById(R.id.lnl_5);

        zoomView = LayoutInflater.from(this).inflate(R.layout.product_image_zoom_view, null, false);
        contentView = LayoutInflater.from(this).inflate(R.layout.product_content_view, null, false);
        scrollViewEx.setZoomView(zoomView);
        scrollViewEx.setScrollContentView(contentView);

        txtDescription = contentView.findViewById(R.id.txt_p_conten_description);
        txtXemThem = contentView.findViewById(R.id.txt_xem_them);
        lnlProfileContent = contentView.findViewById(R.id.lnl_profile_content_view);

        //xu ly su kien bam vao nut xem them
        txtDescription.post(new Runnable() {
            @Override
            public void run() {
                final int x = txtDescription.getLineCount();
                if (txtDescription.getLineCount() < 2) {
                    txtXemThem.setVisibility(View.GONE);
                }
                if (txtDescription.getLineCount() >= 2) {
                    txtXemThem.setVisibility(View.VISIBLE);
                    txtDescription.setMaxLines(2);

                }


                txtXemThem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (txtXemThem.getText().equals("Xem thêm")) {
                            txtDescription.setMaxLines(x);
                            txtXemThem.setText(R.string.thu_lai);
                        } else if (txtXemThem.getText().equals("Thu lại")) {
                            txtDescription.setMaxLines(2);
                            txtXemThem.setText("Xem thêm");
                        }
                    }
                });

            }
        });

        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        scrollViewEx.setHeaderLayoutParams(localObject);


    }

    private void setUpActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
//      toolbar.setNavigationIcon(R.drawable.icon_back);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.lnl_profile_content_view:
                xuLyXemProfile();
                break;
            case R.id.img_ba_cham:
                xuLyBaCham();
                break;

            case R.id.lnl_5:
                xuLyLnl5();
                break;
            case R.id.txt_quay_ve_trang_chu:
                xuLyQuayVeTrangChu();
                break;

            case R.id.btn_dong_product_detail:
                xuLyLnl5();
                break;
        }
    }

    private void xuLyQuayVeTrangChu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void xuLyLnl5() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide_out_from_bottom);
        rl2.setAnimation(anim);
        rl2.setVisibility(View.GONE);
    }

    private void xuLyBaCham() {


        Animation anim = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_bottom);
        rl2.setAnimation(anim);
        rl2.setVisibility(View.VISIBLE);
    }

    private void xuLyXemProfile() {

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

    }
}
