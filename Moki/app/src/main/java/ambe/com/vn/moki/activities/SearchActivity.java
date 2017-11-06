package ambe.com.vn.moki.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.models.products.Image;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{
    
    private ImageView imgBack;
    private ImageView imgRecycleBin;
    private LinearLayout lnlDanhMuc;
    private LinearLayout lnlNhanHieu;
    private LinearLayout lnlKichCo;
    private LinearLayout lnlGia;
    private LinearLayout lnlTrangThai;
    private Button btnTimKiem;
    private TextView txtHuongDanTimKiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        
        addControls();
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

        addEvents();
    }

    private void addEvents() {
        imgBack.setOnClickListener(this);

    }

    private void addControls() {
        imgBack=findViewById(R.id.img_back_activity_search);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back_activity_search:
            finish();
            break;
        }
    }
}
