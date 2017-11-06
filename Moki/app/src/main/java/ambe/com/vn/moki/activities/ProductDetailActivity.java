package ambe.com.vn.moki.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;

import ambe.com.vn.moki.R;

public class ProductDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ImageView imgBack;
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
    }

    private void addEvents() {

        imgBack.setOnClickListener(this);
        lnlProfileContent.setOnClickListener(this);

    }

    private void addControls() {
        toolbar = findViewById(R.id.tb_product_detail);
        imgBack = findViewById(R.id.img_back);
        scrollViewEx = findViewById(R.id.scroll_detail_product);
        txtTitleToolbar=findViewById(R.id.txt_tittle_tb_product_detail);

        zoomView = LayoutInflater.from(this).inflate(R.layout.product_image_zoom_view, null, false);
        contentView = LayoutInflater.from(this).inflate(R.layout.product_content_view, null, false);
        scrollViewEx.setZoomView(zoomView);
        scrollViewEx.setScrollContentView(contentView);

        txtDescription=contentView.findViewById(R.id.txt_p_conten_description);
        txtXemThem=contentView.findViewById(R.id.txt_xem_them);
        lnlProfileContent=contentView.findViewById(R.id.lnl_profile_content_view);

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
        }
    }

    private void xuLyXemProfile() {

        Intent intent=new Intent(this,ProfileActivity.class);
        startActivity(intent);

    }
}
