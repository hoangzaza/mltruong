package ambe.com.vn.moki.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import ambe.com.vn.moki.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;
    private Toolbar toolbar;
    private ImageView imgBack;
    private TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        addControls();
    }

    private void addControls() {

        webView = findViewById(R.id.web_view);
        imgBack = findViewById(R.id.img_back_web_view);
        txtName = findViewById(R.id.txt_name_web_view);
        toolbar = findViewById(R.id.tb_web_view);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        Intent intent = getIntent();
        String name = intent.getStringExtra("CHINHSACH");

        if (name.equals("chinh_sach_tra_hang")) {
            txtName.setText("Chính Sách Trả Hàng");
        }

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        String url = "file:///android_asset/" + name + ".html";
        webView.loadUrl(url);
    }
}
