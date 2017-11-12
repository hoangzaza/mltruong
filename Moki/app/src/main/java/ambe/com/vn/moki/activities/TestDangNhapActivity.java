package ambe.com.vn.moki.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.models.users.Login;
import ambe.com.vn.moki.models.users.Profile;
import ambe.com.vn.moki.utils.StringUrl;

public class TestDangNhapActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editPhone;
    private EditText editPass;
    private Button btnLogin;
    private TextView txtBoQua;
    private TextView txtDangKy;
    private TextView txtQuenMatKhau;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dang_nhap);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnLogin.setOnClickListener(this);
        txtQuenMatKhau.setOnClickListener(this);
        txtDangKy.setOnClickListener(this);
        txtBoQua.setOnClickListener(this);

    }

    private void addControls() {
        txtBoQua = findViewById(R.id.txt_bo_qua_atv);
        txtDangKy = findViewById(R.id.txt_dang_ky_atv);
        txtQuenMatKhau = findViewById(R.id.txt_quen_mat_khau_atv);
        btnLogin = findViewById(R.id.btn_login_atv);
        editPass = findViewById(R.id.edit_mat_khau_atv);
        editPhone = findViewById(R.id.edit_phone_atv);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login_atv:
                xuLyLogin();
                break;
            case R.id.txt_bo_qua_atv:
                xuLyBoQua();
                break;
            case R.id.txt_dang_ky_atv:
                xuLyDangKy();
                break;
            case R.id.txt_quen_mat_khau_atv:
                xuLyQuenMatKhau();
                break;
        }

    }

    private void xuLyQuenMatKhau() {

    }

    private void xuLyDangKy() {

    }

    private void xuLyBoQua() {
        Intent intent=new Intent(TestDangNhapActivity.this,MainActivity.class);
        startActivity(intent);

    }

    private void xuLyLogin() {
        final String phone = editPhone.getText().toString().trim();
        final String pass = editPass.getText().toString().trim();
        if (phone.equals("") || pass.equals("")) {
            Toast.makeText(this, "Vui lòng nhập tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
        } else {
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            StringRequest stringRequest = new StringRequest(Request.Method.POST, StringUrl.urlLogin, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    if (response != null) {

                        Toast.makeText(TestDangNhapActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Login login = new Gson().fromJson(response, Login.class);
                        Log.d("LOI",login.getProfile().getEmail()+"");
                        Intent intent=new Intent(TestDangNhapActivity.this,MainActivity.class);
                        Bundle bundle =new Bundle();
                        bundle.putSerializable("PRO",login.getProfile());
                        intent.putExtra("BUNDLE",bundle);
                        startActivity(intent);

                    }

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("ABC", error.getMessage()+"");
                    Toast.makeText(TestDangNhapActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("phonenumber", phone);
                    hashMap.put("password", pass);
                    return hashMap;
                }
            };

            requestQueue.add(stringRequest);

        }

    }
}
