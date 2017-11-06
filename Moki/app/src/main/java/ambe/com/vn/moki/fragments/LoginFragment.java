package ambe.com.vn.moki.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.activities.IntroActivity;
import ambe.com.vn.moki.activities.MainActivity;
import ambe.com.vn.moki.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText editSoDienThoai;
    private EditText editMatKhau;
    private Button btnDangNhap;
    private TextView txtDangKy;
    private TextView txtBoQua;
    private TextView txtQuenMatKhau;

    private View view;


    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment loginFragment = new LoginFragment();
        return loginFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        editSoDienThoai = view.findViewById(R.id.edit_phone);
        editMatKhau = view.findViewById(R.id.edit_mat_khau);

        btnDangNhap = view.findViewById(R.id.btn_login);

        txtDangKy = view.findViewById(R.id.txt_dang_ky);
        txtBoQua = view.findViewById(R.id.txt_bo_qua);
        txtQuenMatKhau = view.findViewById(R.id.txt_quen_mat_khau);


        txtBoQua.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int idView=view.getId();
        switch (idView){
            case R.id.txt_bo_qua:
                xuLyTxtBoQua();
                break;
            case R.id.txt_dang_ky:
                xuLyTxtDangKy();
                break;
            case R.id.txt_quen_mat_khau:
                xuLyTxtQuenMatKhau();
                break;
            case R.id.btn_login:
                xuLyBtnLogin();
                break;
        }

    }

    private void xuLyBtnLogin() {

    }

    private void xuLyTxtQuenMatKhau() {

    }

    private void xuLyTxtDangKy() {

    }

    private void xuLyTxtBoQua() {
        Utils.saveSharedSetting(getActivity(), MainActivity.PREF_USER_FIRST_TIME, "false");
        Intent intent=new Intent(getActivity(), MainActivity.class);

        startActivity(intent);

    }
}
