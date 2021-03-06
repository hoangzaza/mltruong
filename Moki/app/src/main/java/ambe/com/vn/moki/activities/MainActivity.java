package ambe.com.vn.moki.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.infideap.drawerbehavior.AdvanceDrawerLayout;
import com.squareup.picasso.Picasso;
import com.tekle.oss.android.animation.AnimationFactory;

import java.util.ArrayList;

import ambe.com.vn.moki.Manifest;
import ambe.com.vn.moki.R;
import ambe.com.vn.moki.adapters.MenuMainAdapter;
import ambe.com.vn.moki.adapters.PagerTrangChuAdapter;
import ambe.com.vn.moki.fragments.ProductMainFragment;
import ambe.com.vn.moki.fragments.TinTucFragment;
import ambe.com.vn.moki.fragments.TrangChuFragment;
import ambe.com.vn.moki.models.others.MenuItem;
import ambe.com.vn.moki.models.users.Profile;
import ambe.com.vn.moki.utils.Utils;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String PREF_USER_FIRST_TIME = "user_first_time";
    public static boolean is_grid = true;
    FragmentManager fragmentManager;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private AdvanceDrawerLayout drawer;
    private NavigationView navigationView;
    private boolean isUserFirstTime;
    private ImageView imgShell;
    private ListView listMenu;
    private ArrayList<MenuItem> arrMenuItem;
    private MenuMainAdapter menuAdapter;
    private ImageView img_message;
    private ImageView img_notification;
    private ImageView img_changeview;
    private ImageView img_search;
    private CircleImageView imgAvatarUser;
    private TextView txtName;
    private  String id_user1;

    private Profile myProfile;
    public static String token = "";
    public static String id_user = "";

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private static final String TAG = MainActivity.class.getSimpleName();

    public static final String REGISTRATION_PROCESS = "registration";
    public static final String MESSAGE_RECEIVED = "message_received";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        isUserFirstTime = Boolean.valueOf(Utils.readSharedSetting(MainActivity.this, PREF_USER_FIRST_TIME, "true"));

//        Intent introIntent = new Intent(MainActivity.this, IntroActivity.class);
//        introIntent.putExtra(PREF_USER_FIRST_TIME, isUserFirstTime);
//
//        if (isUserFirstTime)
//            startActivity(introIntent);

        setContentView(R.layout.activity_main);

        addControls();
        if (checkPlayServices()) {

            startRegisterProcess();
        }
        registerReceiver();

//        Intent intent = getIntent();
//        if (intent != null) {
//            Log.d("DAUMOEMAY",intent.getAction());
//            if (intent.getAction().equals(MESSAGE_RECEIVED)) {
//                String message = intent.getStringExtra("message");
//                showAlertDialog(message);
//            }
//        }
        addEvents();


    }

    private void addControls() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        img_changeview = findViewById(R.id.img_changeview);
        img_search = findViewById(R.id.img_search);
        img_message = findViewById(R.id.img_message);
        img_notification = findViewById(R.id.img_notification);
        imgShell = findViewById(R.id.img_shell);
        imgAvatarUser = findViewById(R.id.img_avatar_profile);
        txtName = findViewById(R.id.txt_dang_nhap_main_atv);


        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toolbar.setNavigationIcon(R.drawable.icon_menu);
        drawer.addDrawerListener(toggle);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fragmentManager = getSupportFragmentManager();
        TrangChuFragment trangChuFragment = TrangChuFragment.newInstance();
        fragmentManager.beginTransaction().replace(R.id.frame_main, trangChuFragment).commit();
        listMenu = findViewById(R.id.list_menu);
        arrMenuItem = new ArrayList<MenuItem>();
        arrMenuItem.add(new MenuItem(R.drawable.setting_home_icon, getString(R.string.trang_chu), 1));
        arrMenuItem.add(new MenuItem(R.drawable.sidemenu_icon_news_normal, getString(R.string.tin_tuc), 0));
        arrMenuItem.add(new MenuItem(R.drawable.sidemenu_icon_like_normal, getString(R.string.danh_sach_yeu_thich), 0));
        arrMenuItem.add(new MenuItem(R.drawable.sidemenu_icon_exhibit_normal, getString(R.string.danh_sach_ban), 0));
        arrMenuItem.add(new MenuItem(R.drawable.product_price_total, getString(R.string.danh_sach_mua), 0));
        arrMenuItem.add(new MenuItem(R.drawable.sidemenu_icon_charity, getString(R.string.tu_thien), 0));
        arrMenuItem.add(new MenuItem(R.drawable.sidemenu_icon_setting_normal, getString(R.string.thiet_lap), 0));
        arrMenuItem.add(new MenuItem(R.drawable.sidemenu_icon_contact_normal, getString(R.string.trung_tam_ho_tro), 0));
        arrMenuItem.add(new MenuItem(R.drawable.setting_account_icon, getString(R.string.gioi_thieu_moki), 0));
        arrMenuItem.add(new MenuItem(R.drawable.sidemenu_icon_logout_normal, getString(R.string.dang_nhap), 0));
        menuAdapter = new MenuMainAdapter(arrMenuItem, this);
        listMenu.setAdapter(menuAdapter);

        drawer.useCustomBehavior(Gravity.START);
        drawer.useCustomBehavior(Gravity.END);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("BUNDLE");
        if (bundle != null) {
            myProfile = (Profile) bundle.getSerializable("PRO");

            Picasso.with(getApplicationContext())
                    .load(myProfile.getAvatar())
                    .error(R.drawable.no_image)
                    .into(imgAvatarUser);
            txtName.setText(myProfile.getUsername());
            id_user1 = myProfile.getId_user();
            Toast.makeText(this, id_user, Toast.LENGTH_SHORT).show();
            arrMenuItem.set(9, new MenuItem(R.drawable.sidemenu_icon_logout_normal, getString(R.string.dang_xuat),0));
            token = myProfile.getToken();
            id_user = myProfile.getId_user();
            Log.d("TOKEN", token);

            arrMenuItem.set(9, new MenuItem(R.drawable.sidemenu_icon_logout_normal, getString(R.string.dang_xuat), 0));
        }


    }

    private void addEvents() {


        img_notification.setOnClickListener(this);
        img_message.setOnClickListener(this);
        img_search.setOnClickListener(this);
        img_changeview.setOnClickListener(this);
        imgShell.setOnClickListener(this);
        imgAvatarUser.setOnClickListener(this);
        txtName.setOnClickListener(this);

        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        TrangChuFragment trangChuFragment = TrangChuFragment.newInstance();
                        fragmentManager.beginTransaction().replace(R.id.frame_main, trangChuFragment).commit();
                        drawer.closeDrawer(GravityCompat.START);
                        for (int j = 0; j < arrMenuItem.size(); j++) {
                            if (j != i) {
                                arrMenuItem.get(j).setCheck(0);
                            } else {
                                arrMenuItem.get(i).setCheck(1);
                            }
                            menuAdapter.notifyDataSetChanged();
                        }


                        break;
                    case 1:
                        TinTucFragment tinTucFragment = TinTucFragment.newInstance();
                        fragmentManager.beginTransaction().replace(R.id.frame_main, tinTucFragment).commit();
                        drawer.closeDrawer(GravityCompat.START);

                        for (int j = 0; j < arrMenuItem.size(); j++) {
                            if (j != i) {
                                arrMenuItem.get(j).setCheck(0);
                            } else {
                                arrMenuItem.get(i).setCheck(1);
                            }

                            menuAdapter.notifyDataSetChanged();
                        }

                        break;

                    case 10:
                        if (arrMenuItem.get(10).getTxtName().equals("Đăng nhập")) {
                            Intent intent = new Intent(getApplicationContext(), TestDangNhapActivity.class);
                            startActivity(intent);
                        }
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_search:
                Toast.makeText(MainActivity.this, "search", Toast.LENGTH_LONG).show();
                xuLySearch();
                break;
            case R.id.img_message:
                Toast.makeText(MainActivity.this, "message", Toast.LENGTH_LONG).show();
                break;
            case R.id.img_changeview:
//                Toast.makeText(MainActivity.this, "changeview", Toast.LENGTH_LONG).show();
                if (is_grid) {

                    img_changeview.setImageResource(R.drawable.icon_grid);
                    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_main);
                    PagerTrangChuAdapter adapter = (PagerTrangChuAdapter) ((TrangChuFragment) fragment).vPagerTrangChu.getAdapter();
                    adapter.notifyDataSetChanged();
                    ViewPager lay = ((TrangChuFragment) fragment).vPagerTrangChu;
                    int current = 0;
                    if (lay.getCurrentItem() != -1) {
                        current = lay.getCurrentItem();
                    }
                    Fragment fragment1 = adapter.getItem(current);

                    AnimationFactory.flipTransition(((ProductMainFragment) fragment1).viewAnimator, AnimationFactory.FlipDirection.LEFT_RIGHT);

//
//
//                    fragment1.getChildFragmentManager().beginTransaction().setCustomAnimations(R.animator.card_flip_right_in, R.animator.card_flip_right_out,
//                            R.animator.card_flip_left_in, R.animator.card_flip_left_out).replace(R.id.pager_xanhdo, new ProductMainFragment()).commit();
//
//
                    is_grid = false;
//
//
                } else {
//
//                    img_changeview.setImageResource(R.drawable.tutorial_change_viewmode);
//                    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_main);
//                    PagerTrangChuAdapter adapter = (PagerTrangChuAdapter) ((TrangChuFragment) fragment).vPagerTrangChu.getAdapter();
//
//                    ViewPager lay = ((TrangChuFragment) fragment).vPagerTrangChu;
//                    int current = 0;
//                    if (lay.getCurrentItem() != -1) {
//                        current = lay.getCurrentItem();
//                    }
//                    Fragment fragment1 = adapter.getItem(current);
//                    Log.d("bundle", is_grid + "");
//                    adapter.notifyDataSetChanged();
//                    fragment1.getChildFragmentManager().beginTransaction().setCustomAnimations(R.animator.card_flip_left_in, R.animator.card_flip_left_out, R.animator.card_flip_right_in, R.animator.card_flip_right_out
//                    ).replace(R.id.pager_xanhdo, new ProductMainFragment()).commit();
//
//                    is_grid = true;
                    img_changeview.setImageResource(R.drawable.tutorial_change_viewmode);
                    Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame_main);
                    PagerTrangChuAdapter adapter = (PagerTrangChuAdapter) ((TrangChuFragment) fragment).vPagerTrangChu.getAdapter();
                    adapter.notifyDataSetChanged();
                    ViewPager lay = ((TrangChuFragment) fragment).vPagerTrangChu;
                    int current = 0;
                    if (lay.getCurrentItem() != -1) {
                        current = lay.getCurrentItem();
                    }
                    Fragment fragment1 = adapter.getItem(current);

                    AnimationFactory.flipTransition(((ProductMainFragment) fragment1).viewAnimator, AnimationFactory.FlipDirection.LEFT_RIGHT);

//
//
//                    fragment1.getChildFragmentManager().beginTransaction().setCustomAnimations(R.animator.card_flip_right_in, R.animator.card_flip_right_out,
//                            R.animator.card_flip_left_in, R.animator.card_flip_left_out).replace(R.id.pager_xanhdo, new ProductMainFragment()).commit();
//
//
                    is_grid = true;
//
                }
                break;
            case R.id.img_notification:
                Toast.makeText(MainActivity.this, "notification", Toast.LENGTH_LONG).show();
                break;
            case R.id.img_shell:
                Toast.makeText(MainActivity.this, "shell", Toast.LENGTH_LONG).show();
                break;
            case R.id.img_avatar_profile:
                xuLyXemMyInfor();
                break;
            case R.id.txt_dang_nhap_main_atv:
                xuLyXemMyInfor();
                break;
        }

    }

    private void xuLyXemMyInfor() {

        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        Bundle bundle = new Bundle();
        intent.putExtra("BUNMAIN", bundle);
        bundle.putSerializable("MYPRO", myProfile);
        startActivity(intent);

    }

    private void xuLySearch() {
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }


    private void startRegisterProcess() {

        if (checkPermission()) {

            startRegisterService();

        } else {

            requestPermission();
        }

    }

    private void startRegisterService() {

        Intent intent = new Intent(MainActivity.this, RegistrationIntentService.class);
        intent.putExtra("DEVICE_ID", getDeviceId());
        intent.putExtra("DEVICE_NAME", getDeviceName());
        intent.putExtra("ID_USER", id_user1);
        startService(intent);
    }

    private void registerReceiver() {

        LocalBroadcastManager bManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(REGISTRATION_PROCESS);
        intentFilter.addAction(MESSAGE_RECEIVED);
        bManager.registerReceiver(broadcastReceiver, intentFilter);

    }

    private void showAlertDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("GCM Message Received !");
        builder.setMessage(message);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    private String getDeviceId() {

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }
        return telephonyManager.getDeviceId();
    }

    private String getDeviceName(){
        String deviceName = Build.MODEL;
        String deviceMan = Build.MANUFACTURER;
        return  deviceMan + " " +deviceName;
    }

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            if(intent.getAction().equals(REGISTRATION_PROCESS)){

                String result  = intent.getStringExtra("result");
                String message = intent.getStringExtra("message");
                Log.d(TAG, "onReceive: "+result+message);
                Snackbar.make(findViewById(R.id.drawer_layout),result + " : " + message,Snackbar.LENGTH_SHORT).show();
            } else if (intent.getAction().equals(MESSAGE_RECEIVED)){

                String message = intent.getStringExtra("message");
                showAlertDialog(message);
            }
        }
    };

    private boolean checkPermission(){
        int result = ContextCompat.checkSelfPermission(this,
                Manifest.permission.C2D_MESSAGE);
        if (result == PackageManager.PERMISSION_GRANTED){

            return true;

        } else {

            return false;
        }
    }

    private void requestPermission(){

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.C2D_MESSAGE},PERMISSION_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    startRegisterService();

                } else {

                    Snackbar.make(findViewById(R.id.drawer_layout),"Permission Denied, Please allow to proceed !.",Snackbar.LENGTH_LONG).show();

                }
                break;
        }
    }

    private boolean checkPlayServices() {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (apiAvailability.isUserResolvableError(resultCode)) {
                apiAvailability.getErrorDialog(this, resultCode, PLAY_SERVICES_RESOLUTION_REQUEST)
                        .show();
            } else {
                Log.i(TAG, "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }
}
