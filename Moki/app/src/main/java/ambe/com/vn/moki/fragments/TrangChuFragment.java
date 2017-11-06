package ambe.com.vn.moki.fragments;


import android.app.Dialog;
import android.app.VoiceInteractor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.util.Log;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.crystal.crystalrangeseekbar.interfaces.OnRangeSeekbarChangeListener;
import com.crystal.crystalrangeseekbar.widgets.BubbleThumbRangeSeekbar;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.activities.MainActivity;
import ambe.com.vn.moki.adapters.IntroAdapter;
import ambe.com.vn.moki.adapters.LocAdapter;
import ambe.com.vn.moki.adapters.PagerTrangChuAdapter;
import ambe.com.vn.moki.adapters.SingleChoiAdapter;
import ambe.com.vn.moki.adapters.StickyHeaderAdapter;
import ambe.com.vn.moki.models.Loc;
import ambe.com.vn.moki.models.SingleChoice;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrangChuFragment extends Fragment implements View.OnClickListener {


    private View view;
    public ViewPager vPagerTrangChu;
    public TabLayout tableLayoutTrangChu;
    public PagerTrangChuAdapter pagerTrangChuAdapter;
    private ArrayList<String> arrTabs;
    private ArrayList<Loc> arrLocs;
    private ViewPager viewFlipper;
    private LinearLayout llSapXep;
    private LinearLayout llLoc;
    private LinearLayout llXungQuanh;
    private Dialog dialogSapXep;
    private Dialog dialogLoc;
    private LocAdapter locAdapter;
    private BubbleThumbRangeSeekbar seekbar;
    private View v1,v2;
    private boolean flag = true;
    public ArrayList<Fragment> arrpager;

    ArrayList<Fragment> arr;
    IntroAdapter introAdapter;

    Button btnHuy;
    Button btnXoaHet;

    public TrangChuFragment() {
        // Required empty public constructor
    }

    public static TrangChuFragment newInstance() {
        TrangChuFragment trangChuFragment = new TrangChuFragment();
        return trangChuFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_trang_chu, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addControls();
        addViewFlipper();
        addEvents();


    }

    private void addViewFlipper() {
//        ArrayList<String> urlHinhAnhs = new ArrayList<String>();
//        urlHinhAnhs.add("http://diendanso.net/wp-content/uploads/2015/12/anh-dep-17.jpg");
//        urlHinhAnhs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnNwpPOkNoh7r3sc4X2KKpmZp07bCLZFIBU8WZyDhFNvlOyXjIYg");
//        urlHinhAnhs.add("http://taihinhanhdep.xyz/wp-content/uploads/2016/09/hinh-anh-dep-ve-thien-nhien-va-tinh-yeu.jpg");
//        urlHinhAnhs.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJRpc-Ymeo8O-MrkFOCbcjYV5IAhpPKDM4vJbaVzaPQIzxkaDh");
//        urlHinhAnhs.add("http://hinhdep.com.vn/wp-content/uploads/2013/06/anh-dep-tinh-ban007.jpg");
//
//        for (String str : urlHinhAnhs) {
//            ImageView imageView = new ImageView(getActivity());
//            Picasso.with(getActivity()).load(str)
//                    .into(imageView);
//            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            viewFlipper.addView(imageView);
//        }
//
//        viewFlipper.setFlipInterval(5000);
//        viewFlipper.setAutoStart(true);
//        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right);
//        Animation animation1 = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right);
//        viewFlipper.setInAnimation(animation);
//        viewFlipper.setOutAnimation(animation1);
        Pager_Main_Fragment pager_1=new Pager_Main_Fragment();
        Pager_Main_Fragment pager_2=new Pager_Main_Fragment();
        arr=new ArrayList<>();
        arr.add(pager_1);
        arr.add(pager_2);
        introAdapter=new IntroAdapter(getFragmentManager(),arr);
        viewFlipper.setAdapter(introAdapter);
        v1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewFlipper.getCurrentItem()%2==0){
//                    viewFlipper.setCurrentItem(arr.size()-2);
                } else {
                    viewFlipper.setCurrentItem(viewFlipper.getCurrentItem()-1);
                }
            }
        });
        v2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(viewFlipper.getCurrentItem()%2==0){
                    viewFlipper.setCurrentItem(viewFlipper.getCurrentItem()-1);
                } else {
//                    viewFlipper.setCurrentItem(arr.size()-2);
                }
            }
        });

        viewFlipper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position%2==0){
                    v1.setBackgroundResource(R.drawable.hinh_tron_hong);
                    v2.setBackgroundResource(R.drawable.hinh_tron_xam);
                }else {
                    v1.setBackgroundResource(R.drawable.hinh_tron_xam);
                    v2.setBackgroundResource(R.drawable.hinh_tron_hong);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });








    }

    @Override
    public void onStart() {
        super.onStart();
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                if (flag && (getActivity() != null)){
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                            if(arr.size()<19){
                                Pager_Main_Fragment a=new Pager_Main_Fragment();
                                arr.add(a);
                                introAdapter.notifyDataSetChanged();
                                viewFlipper.setCurrentItem(arr.size());}
                                else{
                                arr.clear();
                                Pager_Main_Fragment a=new Pager_Main_Fragment();
                                arr.add(a);
                                introAdapter.notifyDataSetChanged();
                            }

                        }
                });}
            }
        };
        timer.scheduleAtFixedRate(timerTask,3000,5000);
    }

    private void addEvents() {


        vPagerTrangChu.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tableLayoutTrangChu));

        tableLayoutTrangChu.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vPagerTrangChu.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        tableLayoutTrangChu.setupWithViewPager(vPagerTrangChu);

//        vPagerTrangChu.setPageTransformer(true, new DepthPageTransformer());


        llSapXep.setOnClickListener(this);
        llXungQuanh.setOnClickListener(this);
        llLoc.setOnClickListener(this);

    }


    private void addControls() {
        vPagerTrangChu = view.findViewById(R.id.view_pager_trang_chu);
        tableLayoutTrangChu = view.findViewById(R.id.tab_layout_trang_chu);
        viewFlipper = view.findViewById(R.id.view_flipper);
        llSapXep = view.findViewById(R.id.ll_sap_xep);
        llLoc = view.findViewById(R.id.ll_loc);
        llXungQuanh = view.findViewById(R.id.ll_xung_quanh);
        v1=(View) view.findViewById(R.id.view_pager_1);
        v2=(View) view.findViewById(R.id.view_pager_2);


        arrTabs = new ArrayList<>();

        String[] test = getResources().getStringArray(R.array.arrTabs);
        for (int i = 0; i < test.length; i++) {
            arrTabs.add(test[i]);
        }


        for (String str : arrTabs) {
            tableLayoutTrangChu.addTab(tableLayoutTrangChu.newTab().setText(str));
        }
        tableLayoutTrangChu.setTabGravity(TabLayout.GRAVITY_FILL);
        arrpager=new ArrayList<>();
        for(int i=0;i<tableLayoutTrangChu.getTabCount();i++){
            arrpager.add(new ProductMainFragment());
        }
        pagerTrangChuAdapter = new PagerTrangChuAdapter(getChildFragmentManager(),arrpager);
        vPagerTrangChu.setAdapter(pagerTrangChuAdapter);
        pagerTrangChuAdapter.notifyDataSetChanged();


    }

    public ArrayList<String> getArr() {
        return arrTabs;
    }

    @Override
    public void onClick(View view) {
        int idView = view.getId();
        switch (idView) {
            case R.id.ll_sap_xep:
                xuLySapXep();
                break;
            case R.id.ll_loc:
                xuLyLoc();
                break;
            case R.id.ll_xung_quanh:
                xuLyXungQuanh();
                break;



        }
    }

    private void xuLyXungQuanh() {}

    private void xuLySapXep() {

        dialogSapXep = new Dialog(getActivity());
        dialogSapXep.setContentView(R.layout.layout_dialog_sap_xep);


        ListView listSapXep = dialogSapXep.findViewById(R.id.list_sap_xep);
        Button btnHuy = dialogSapXep.findViewById(R.id.btn_huy_sap_xep);
        Button btnAdpDung = dialogSapXep.findViewById(R.id.btn_ap_dung_sap_xep);


        String[] arrSapXep = getResources().getStringArray(R.array.arrSapXep);
        final ArrayList<SingleChoice> arrayList=new ArrayList<SingleChoice>();

        for (int i=0;i<arrSapXep.length;i++){

            arrayList.add(new SingleChoice(arrSapXep[i],0));

        }

        final SingleChoiAdapter adapter=new SingleChoiAdapter(arrayList,getActivity());
        listSapXep.setAdapter(adapter);

        listSapXep.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                for (int x = 0; x < arrayList.size(); ++x) {
                    if (x != i) {
                        arrayList.get(x).setCheck(0);
                        adapter.notifyDataSetChanged();
                    } else {
                        arrayList.get(x).setCheck(1);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogSapXep.dismiss();
            }
        });
        btnAdpDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyApDungSapXep();
            }
        });


        dialogSapXep.show();


    }

    private void xuLyApDungSapXep() {}

    private void xuLyLoc() {


        dialogLoc = new Dialog(getActivity());
        dialogLoc.setContentView(R.layout.layout_dialog_loc);

        btnHuy = dialogLoc.findViewById(R.id.btn_huy_loc);
        btnXoaHet = dialogLoc.findViewById(R.id.btn_xoa_het_loc);
        Button btnLoc = dialogLoc.findViewById(R.id.btn_loc);
        ListView listLoc = dialogLoc.findViewById(R.id.list_loc);

        arrLocs = new ArrayList<Loc>();
        arrLocs.add(new Loc("Danh mục", "Tất cả", 0));
        arrLocs.add(new Loc("Nhãn hiệu", "Tất cả", 0));
        arrLocs.add(new Loc("Giá", "Tất cả", 0));
        arrLocs.add(new Loc("Trạng thái", "Tất cả", 0));

        locAdapter = new LocAdapter(arrLocs, getActivity());

        listLoc.setAdapter(locAdapter);
        btnXoaHet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Loc loc:arrLocs){
                    loc.setCheck(0);
                    loc.setSubTitle("Tất cả");
                    btnXoaHet.setVisibility(View.GONE);
                    btnHuy.setVisibility(View.VISIBLE);

                }
                locAdapter.notifyDataSetChanged();
            }
        });


        listLoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        xuLyDanhMuc();
                        break;
                    case 1:
                        xuLyNhanHieu();
                        break;
                    case 2:
                        xuLyGia();
                        break;
                    case 3:
                        xuLyTrangThai();
                        break;
                }
            }
        });



        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogLoc.dismiss();
            }
        });


        dialogLoc.show();

    }
    private void setNut(ArrayList<Loc> ds){
        for(int i=0;i<ds.size();i++){
            if(ds.get(i).getCheck()==1)
            {
                btnHuy.setVisibility(View.GONE);
                btnXoaHet.setVisibility(View.VISIBLE);
            }
        }
    }

    private void xuLyTrangThai() {

        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.layout_dialog);
        final ListView listTrangThai = dialog.findViewById(R.id.list_dialog);
        TextView txtTitle = dialog.findViewById(R.id.txt_title_dialog);
        ImageView imgBack = dialog.findViewById(R.id.img_back_dialog);
        Button btnHuy = dialog.findViewById(R.id.btn_huy_dialog);
        Button btnLoc = dialog.findViewById(R.id.btn_loc_dialog);
        txtTitle.setText(R.string.trang_thai);

        final ArrayList<Loc> arrTrangThai = new ArrayList<Loc>();
        arrTrangThai.add(new Loc("Mới", "Sản phẩm mới 100% nguyên seal chưa qua sử dụng.", 2));
        arrTrangThai.add(new Loc("Gần như mới", "Sản phẩm dùng lướt - chất lượng như mới.", 2));
        arrTrangThai.add(new Loc("Tốt", "Sản phẩm đã qua sử dụng -  chất lượng khá cao.", 2));
        arrTrangThai.add(new Loc("Khá tốt", "Sản phẩm đã qua sử dụng -  chất lượng đảm bảo.", 2));
        arrTrangThai.add(new Loc("Cũ", "Sản phẩm cũ.", 2));
        final LocAdapter trangThaiAdapter = new LocAdapter(arrTrangThai, getActivity());

        listTrangThai.setAdapter(trangThaiAdapter);
        listTrangThai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                for (int x = 0; x < arrTrangThai.size(); ++x) {
                    if (x != i) {
                        arrTrangThai.get(x).setCheck(2);
                        trangThaiAdapter.notifyDataSetChanged();
                    } else {
                        arrTrangThai.get(x).setCheck(1);
                        trangThaiAdapter.notifyDataSetChanged();
                    }
                }
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();

            }
        });

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subTitle = "";
                for (Loc loc : arrTrangThai) {
                    if (loc.getCheck() == 1) {
                        subTitle = loc.getTitLe();
                    }
                }
                if(subTitle!="") {
                    arrLocs.get(3).setSubTitle(subTitle + "");

                    arrLocs.get(3).setCheck(1);
                } else{
                    arrLocs.get(3).setSubTitle("Tất cả");
                }

                locAdapter.notifyDataSetChanged();
                setNut(arrLocs);

                dialog.dismiss();
            }
        });


        dialog.show();


    }

    private void xuLyGia() {
        final Dialog dialogGia = new Dialog(getActivity());
        dialogGia.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogGia.setContentView(R.layout.layout_dialog_loc_gia);

        final TextView txtMin = dialogGia.findViewById(R.id.txt_min);
        final TextView txtMax = dialogGia.findViewById(R.id.txt_max);
        TextView txtTitle = dialogGia.findViewById(R.id.txt_title_dialog_gia);
        ImageView imgBack = dialogGia.findViewById(R.id.img_back_dialog_gia);
        seekbar = dialogGia.findViewById(R.id.seek_bar);
        final ListView listGia = dialogGia.findViewById(R.id.list_dialog_gia);
        Button btnHuy = dialogGia.findViewById(R.id.btn_huy_dialog_gia);
        Button btnLoc = dialogGia.findViewById(R.id.btn_loc_dialog_gia);
        final DecimalFormat format = new DecimalFormat("###,###,###");
        final ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("0 - 300.000 VNĐ");
        arrayList.add("300.000 - 500.000 VNĐ");
        arrayList.add("500.000 - 1.000.000 VNĐ");
        arrayList.add("1.000.000 - 2.000.000 VNĐ");
        arrayList.add("2.000.000 - 5.000.000 VNĐ");
        arrayList.add("5.000.000 - 10.000.000 VNĐ");
        arrayList.add("10.000.000 - 30.000.000 VNĐ");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_single_choice,
                arrayList
        );

        listGia.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        listGia.setAdapter(adapter);


        txtTitle.setText(R.string.gia);

        seekbar.setOnRangeSeekbarChangeListener(new OnRangeSeekbarChangeListener() {
            @Override
            public void valueChanged(Number minValue, Number maxValue) {
                if (((long) minValue == 0 && (long) maxValue == 300000)
                        || ((long) minValue == 300000 && (long) maxValue == 500000)
                        || ((long) minValue == 500000 && (long) maxValue == 1000000)
                        || ((long) minValue == 1000000 && (long) maxValue == 2000000)
                        || ((long) minValue == 2000000 && (long) maxValue == 5000000)
                        || ((long) minValue == 5000000 && (long) maxValue == 10000000)
                        || ((long) minValue == 10000000 && (long) maxValue == 30000000)) {
                    txtMin.setText(format.format(minValue) + " VNĐ");
                    txtMax.setText(format.format(maxValue) + " VNĐ");
                } else {
                    txtMin.setText(format.format(minValue) + " VNĐ");
                    txtMax.setText(format.format(maxValue) + " VNĐ");
                    listGia.setItemChecked(-1, true);

                }
            }


        });


        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((long)seekbar.getSelectedMinValue()!=0&&(long)seekbar.getSelectedMinValue()!=30000000){
                arrLocs.get(2).setSubTitle(format.format(seekbar.getSelectedMinValue()) + " VNĐ" + " - " + format.format(seekbar.getSelectedMaxValue()) + " VNĐ");
                    arrLocs.get(2).setCheck(1);
                }
                locAdapter.notifyDataSetChanged();
                setNut(arrLocs);
                dialogGia.dismiss();
            }
        });


        seekbar.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                listGia.setItemChecked(-1, false);
            }
        });


        listGia.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        setPositionSeekBar(seekbar, 0, 300000);
                        break;
                    case 1:
                        setPositionSeekBar(seekbar, 300000, 500000);

                        break;
                    case 2:
                        setPositionSeekBar(seekbar, 500000, 1000000);
                        break;
                    case 3:
                        setPositionSeekBar(seekbar, 1000000, 2000000);
                        break;
                    case 4:
                        setPositionSeekBar(seekbar, 2000000, 5000000);
                        break;
                    case 5:
                        setPositionSeekBar(seekbar, 5000000, 10000000);
                        break;
                    case 6:
                        setPositionSeekBar(seekbar, 10000000, 30000000);

                        break;
                    default:
                        break;
                }
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                dialogGia.dismiss();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                dialogGia.dismiss();
            }
        });


        dialogGia.show();
    }

    private void setPositionSeekBar(BubbleThumbRangeSeekbar s, int min, int max) {

        s.setMinStartValue(min).setMaxStartValue(max).apply();


    }

    private void xuLyNhanHieu() {
        final Dialog dialogNhanHieu = new Dialog(getActivity());
        dialogNhanHieu.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogNhanHieu.setContentView(R.layout.layout_dialog_loc_nhan_hieu);


        TextView txtTitle = dialogNhanHieu.findViewById(R.id.txt_title_dialog_nhan_hieu);
        ImageView imgBack = dialogNhanHieu.findViewById(R.id.img_back_dialog_nhan_hieu);
        Button btnHuy = dialogNhanHieu.findViewById(R.id.btn_huy_dialog_nhan_hieu);
        Button btnLoc = dialogNhanHieu.findViewById(R.id.btn_loc_dialog_nhan_hieu);
        SearchView searchView = dialogNhanHieu.findViewById(R.id.search_nhan_hieu);
        final StickyListHeadersListView stickyListHeadersListView = dialogNhanHieu.findViewById(R.id.list_stick_header);

        stickyListHeadersListView.setVisibility(View.VISIBLE);
        searchView.requestFocus();
        searchView.setQueryHint("Tìm kiếm");
        txtTitle.setText(R.string.nhan_hieu);
        ArrayList<String> arrTinhThanhs = new ArrayList<String>();

        String[] arr = getActivity().getResources().getStringArray(R.array.arrTinhThanh);
        for (String str : arr) {
            arrTinhThanhs.add(str);
        }

        Collections.sort(arrTinhThanhs);

        final StickyHeaderAdapter adapter = new StickyHeaderAdapter(getActivity(), arrTinhThanhs);
        stickyListHeadersListView.setAdapter(adapter);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogNhanHieu.dismiss();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogNhanHieu.dismiss();
            }
        });
        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNut(arrLocs);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

        dialogNhanHieu.show();


    }

    private void xuLyDanhMuc() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.layout_dialog);
        final ListView listView = dialog.findViewById(R.id.list_dialog);
        TextView txtTitle = dialog.findViewById(R.id.txt_title_dialog);

        Button btnHuy = dialog.findViewById(R.id.btn_huy_dialog);
        Button btnLoc = dialog.findViewById(R.id.btn_loc_dialog);
        ImageView imgBack = dialog.findViewById(R.id.img_back_dialog);
        txtTitle.setText(R.string.danh_muc);


        final String[] arr = getResources().getStringArray(R.array.arrTabs);

//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                getActivity(),
//                android.R.layout.simple_list_item_single_choice,
//                arr
//        );
//
//
//        listView.setAdapter(adapter);
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
//        listView.setItemsCanFocus(true);


        final ArrayList<SingleChoice> arrDanhMuc=new ArrayList<SingleChoice>();

        for (int i=0;i<arr.length;i++){

            arrDanhMuc.add(new SingleChoice(arr[i],0));

        }

        final SingleChoiAdapter adapter=new SingleChoiAdapter(arrDanhMuc,getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                for (int x = 0; x < arrDanhMuc.size(); ++x) {
                    if (x != i) {
                        arrDanhMuc.get(x).setCheck(0);
                        adapter.notifyDataSetChanged();
                    } else {
                        arrDanhMuc.get(x).setCheck(1);
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        String subTitle = arrLocs.get(0).getSubTitle();
        for (int i = 0; i < arr.length; ++i) {
            if (subTitle.equals(arr[i])) {
                listView.setItemChecked(i, true);
            }
        }


        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subTitle="";

                for (SingleChoice str: arrDanhMuc){
                    if (str.getCheck() == 1){
                        subTitle+=str.getTxtName();
                    }
                }

                arrLocs.get(0).setSubTitle(subTitle + "");
                if(!arrLocs.get(0).getSubTitle().equals("Tất cả"))
                arrLocs.get(0).setCheck(1);

                locAdapter.notifyDataSetChanged();
                setNut(arrLocs);

                dialog.dismiss();


            }
        });

        dialog.show();

    }
    public void onDestroy() {
        flag = false;
        super.onDestroy();
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
