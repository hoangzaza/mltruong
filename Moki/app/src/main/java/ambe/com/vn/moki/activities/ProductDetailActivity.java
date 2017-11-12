package ambe.com.vn.moki.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.models.products.GetProduct;
import ambe.com.vn.moki.models.products.Image;
import ambe.com.vn.moki.models.products.Like;
import ambe.com.vn.moki.models.products.Product;
import ambe.com.vn.moki.models.products.Seller;
import ambe.com.vn.moki.models.products.SetLike;
import ambe.com.vn.moki.models.users.GetMyLike;
import ambe.com.vn.moki.utils.CheckConnect;
import ambe.com.vn.moki.utils.StringUrl;
import de.hdodenhof.circleimageview.CircleImageView;

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
    private Product productSelected;
    private ImageView imgZoom;
    private TextView txtDanhMuc1;
    private TextView txtDanhMuc2;
    private TextView txtDanhMuc3;
    private TextView txtKhoiLuong;
    private TextView txtKichThuoc;
    private TextView txtTrangThai;
    private TextView txtNoiBan;
    private ListView listCmtDauTien;
    private TextView txtComment;
    private TextView txtMua;
    private TextView txtGia;
    private TextView txtSlBl;
    private TextView txtSlLike;
    private CircleImageView imgAvatrSeller;
    private TextView txtNameSeller;
    private TextView txtScoreSeller;
    private TextView txtSpSeller;
    private LinearLayout lnlChinhSach;
    private ImageView imgHeart;
    private boolean isLike;
    private String idProduct;
    private int slLike = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        addControls();
        setUpActionBar();
        getData();
        addEvents();
//        if (CheckConnect.isNetworkConnected(this)) {
//        } else {
//            showMyDialog();
//            addEvents();
//
//        }
    }

    private void getData() {
//        int gia = Integer.parseInt(productSelected.getPrice()+"");
//        DecimalFormat dcf = new DecimalFormat("###,###,###");
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BUN");
        if (bundle != null) {
            productSelected = (Product) bundle.getSerializable("PRO");
            Picasso.with(getApplicationContext()).load(productSelected.getImage().get(0).getUrl())
                    .error(R.drawable.no_image)
                    .into(imgZoom);

            txtDanhMuc1.setText(productSelected.getCategory().getName() + "");
            txtKhoiLuong.setText(productSelected.getWeight() + " KG ");
            txtKichThuoc.setText(productSelected.getDimention().getWidth() + " x " + productSelected.getDimention().getHeight() + " x " + productSelected.getDimention().getLength());
            txtTrangThai.setText(productSelected.getState() + "");
            txtNoiBan.setText(productSelected.getShips_from() + "");
            txtGia.setText("Giá: " + productSelected.getPrice() + " VND ");
            slLike = productSelected.getLike().size();
            txtDescription.setText(productSelected.getDescribed());
            txtSlBl.setText(productSelected.getComment().size() + " bình luận");
            txtSlLike.setText(slLike + " thích và ");
            txtNameSeller.setText(productSelected.getSeller().getName());
            txtSpSeller.setText("Sản phẩm: 62");
            idProduct = productSelected.getId_product();
            getMyLike();


            if (productSelected.getSeller().getAvatar() == null) {
                imgAvatrSeller.setImageResource(R.drawable.unknown_user);
            } else {
                Picasso.with(getApplicationContext()).load(productSelected.getSeller().getAvatar())
                        .error(R.drawable.no_image)
                        .into(imgAvatrSeller);
            }

            if (productSelected.getComment().size() != 0) {
                txtComment.setText("Xem và viết bình luận");
            }


        }


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
        lnlChinhSach.setOnClickListener(this);
        imgHeart.setOnClickListener(this);
        txtComment.setOnClickListener(this);

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
        txtGia = findViewById(R.id.txt_product_detail_gia);
        txtMua = findViewById(R.id.txt_product_detail_mua);

        zoomView = LayoutInflater.from(this).inflate(R.layout.product_image_zoom_view, null, false);
        contentView = LayoutInflater.from(this).inflate(R.layout.product_content_view, null, false);
        scrollViewEx.setZoomView(zoomView);
        scrollViewEx.setScrollContentView(contentView);

        txtDescription = contentView.findViewById(R.id.txt_p_conten_description);
        txtXemThem = contentView.findViewById(R.id.txt_xem_them);
        lnlProfileContent = contentView.findViewById(R.id.lnl_profile_content_view);
        imgZoom = zoomView.findViewById(R.id.iv_zoom);
        txtDanhMuc1 = contentView.findViewById(R.id.txt_danh_muc_1);
        txtDanhMuc2 = contentView.findViewById(R.id.txt_danh_muc_2);
        txtDanhMuc3 = contentView.findViewById(R.id.txt_danh_muc_3);
        txtKhoiLuong = contentView.findViewById(R.id.txt_khoi_luong);
        txtKichThuoc = contentView.findViewById(R.id.txt_kich_thuoc);
        txtTrangThai = contentView.findViewById(R.id.txt_trang_thai);
        txtNoiBan = contentView.findViewById(R.id.txx_noi_ban);
        listCmtDauTien = contentView.findViewById(R.id.list_commt);
        txtComment = contentView.findViewById(R.id.txt_comment_dau_tien);
        txtSlBl = contentView.findViewById(R.id.txt_content_sl_binhluan);
        txtSlLike = contentView.findViewById(R.id.txt_content_sl_thich);
        imgAvatrSeller = contentView.findViewById(R.id.img_profile_content);
        txtNameSeller = contentView.findViewById(R.id.txt_profile_content_name);
        txtScoreSeller = contentView.findViewById(R.id.txt_profile_content_diem);
        txtSpSeller = contentView.findViewById(R.id.txt_profile_content_sl_san_pham);
        lnlChinhSach = contentView.findViewById(R.id.lnl_p_content_chinh_sach_moki);
        imgHeart = contentView.findViewById(R.id.img_heart);


//
//        if (!isLike) {
//            imgHeart.setImageResource(R.drawable.grid_heart_off);
//        } else {
//            imgHeart.setImageResource(R.drawable.grid_heart_on);
//        }

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

    private void getMyLike() {

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, StringUrl.urlGetMyLike, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response != null) {

                    GetMyLike getMyLike = new Gson().fromJson(response, GetMyLike.class);
                    if (getMyLike.getData().size() == 0) {
                        imgHeart.setImageResource(R.drawable.grid_heart_off);
                    } else {
                        for (Product product : getMyLike.getData()) {
                            if (product.getId_product().equals(idProduct)) {
                                imgHeart.setImageResource(R.drawable.grid_heart_on);
                            } else {
                                imgHeart.setImageResource(R.drawable.grid_heart_off);

                            }
                        }
                    }

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.getMessage().toString());

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("token", MainActivity.token);
                return hashMap;
            }
        };

        requestQueue.add(stringRequest);

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
            case R.id.lnl_p_content_chinh_sach_moki:
                xuLyLnlChinhSach();
                break;
            case R.id.img_heart:
                xuLyLike();
                break;
            case R.id.txt_comment_dau_tien:
                xuLyComment();
                break;
        }
    }

    private void xuLyComment() {
        Intent intent=new Intent(getApplicationContext(),CommentActivity.class);
        startActivity(intent);
    }

    private void xuLyLike() {

        final RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, StringUrl.urlSetLike, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    SetLike setLike = new Gson().fromJson(response, SetLike.class);
                    if (setLike.getData().size() != 0) {
                        for (Like like : setLike.getData()) {
                            if (like.getId_user().trim().equals(MainActivity.id_user)) {
                                //          isLike = false;
                                imgHeart.setImageResource(R.drawable.grid_heart_on);
                            } else {
                                //          isLike = true;
                                imgHeart.setImageResource(R.drawable.grid_heart_off);

                            }
                        }
                    } else {
                        //          isLike = true;
                        imgHeart.setImageResource(R.drawable.grid_heart_off);

                    }

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            RequestQueue requestQueue1 = Volley.newRequestQueue(getApplicationContext());
                            StringRequest stringRequest1 = new StringRequest(Request.Method.POST, StringUrl.urlGetProduct, new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {

                                    if (response != null) {
                                        GetProduct getProduct = new Gson().fromJson(response, GetProduct.class);
                                        slLike = getProduct.getData().getLike().size();
                                        txtSlLike.setText(slLike + " thích và");

                                    }

                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.d("ERROR", error.getMessage().toString());

                                }
                            }) {
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError {
                                    HashMap<String, String> hashMap = new HashMap<>();
                                    hashMap.put("id_product", idProduct);
                                    return hashMap;
                                }
                            };

                            requestQueue1.add(stringRequest1);

                        }
                    }, 500);


                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("ERROR", error.getMessage() + "");

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("id_user", MainActivity.id_user);
                hashMap.put("id_product", idProduct);
                return hashMap;
            }
        };

        requestQueue.add(stringRequest);
    }

    private void xuLyLnlChinhSach() {
        Intent intent = new Intent(getApplicationContext(), WebViewActivity.class);
        intent.putExtra("CHINHSACH", "chinh_sach_tra_hang");
        startActivity(intent);
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
        Seller seller = productSelected.getSeller();
        Bundle bundle = new Bundle();
        bundle.putSerializable("SELLER", seller);
        intent.putExtra("BUNDLE", bundle);
        startActivity(intent);

    }
}
