package ambe.com.vn.moki.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewAnimator;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.activities.MainActivity;
import ambe.com.vn.moki.adapters.ListviewMainAdapter;
import ambe.com.vn.moki.adapters.ProductAdapter;
import ambe.com.vn.moki.interfaces.OnLoadMoreListener;
import ambe.com.vn.moki.models.products.ListProductLoadMore;
import ambe.com.vn.moki.models.products.Product;
import ambe.com.vn.moki.utils.StringUrl;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductMainFragment extends Fragment {


    private ArrayList<String> arrayList;
    int position;
    StickyListHeadersListView lv;
    private View view;
    private int index = 0;
    private String last_id = "";
    private RecyclerView rcvProduct;
    private ArrayList<Product> arrProducts;
    private ProductAdapter productAdapter;
    public ViewAnimator viewAnimator;
    private ListProductLoadMore listProductLoadMore;
    private GridLayoutManager gr;
    private boolean isLoadMore;


    public ProductMainFragment() {

    }



    public static ProductMainFragment newInstance() {
        ProductMainFragment productMainFragment = new ProductMainFragment();
        return productMainFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_product_main, container, false);
        addControls();
        //loadListProduct(index);
        initData();
       // productAdapter.setLoaded();
        addEvents();
        ListviewMainAdapter listviewMainAdapter = new ListviewMainAdapter(this.getActivity(), arrProducts);
        lv.setAdapter(listviewMainAdapter);
        return view;
    }

    private void loadListProduct(final int x) {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, StringUrl.urlGetListProduct, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    listProductLoadMore = new Gson().fromJson(response, ListProductLoadMore.class);
                    last_id = listProductLoadMore.getLast_id();
                    arrProducts.addAll(listProductLoadMore.getData());
                    Log.d("BBB", "last_idssssss: " + last_id + "- " + index);
                    Log.d("BBB", "last_id: " + last_id + "- " + index);
                    rcvProduct.setAdapter(productAdapter);
                    productAdapter.notifyDataSetChanged();


                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("category_id", "1");
                hashMap.put("index", index + "");
                hashMap.put("last_id", last_id);


                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }


    private void initData() {
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        StringRequest stringRequest = new StringRequest(Request.Method.POST, StringUrl.urlGetListProduct, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    listProductLoadMore = new Gson().fromJson(response, ListProductLoadMore.class);
                    last_id = listProductLoadMore.getLast_id();
                    arrProducts.addAll(listProductLoadMore.getData());
                    Log.d("BBB", "last_id: " + last_id + "- " + index);
                    rcvProduct.setAdapter(productAdapter);
                    productAdapter.notifyDataSetChanged();
                    productAdapter.setLoaded();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("ERROR", error.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("category_id", "1");
                hashMap.put("index", 0 + "");

                return hashMap;
            }
        };
        requestQueue.add(stringRequest);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayList = new ArrayList<>();
        TrangChuFragment trangChuFragment = TrangChuFragment.newInstance();
        arrayList = trangChuFragment.getArr();

        Bundle bundle = getArguments();
        if (bundle != null) {
            position = bundle.getInt("ID", -1);
        }

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();

        boolean a = true;
        if (bundle != null) {
            a = bundle.getBoolean("xanhdo", true);
            Log.d("bundle", a + "");
        }
        if (a && (MainActivity.is_grid)) {
//            grid view
            rcvProduct.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            productAdapter = new ProductAdapter(rcvProduct, getActivity(), arrProducts);
            rcvProduct.setAdapter(productAdapter);


        } else {
//              listview
            lv.setVisibility(View.VISIBLE);
            rcvProduct.setVisibility(View.GONE);
            ListviewMainAdapter listviewMainAdapter = new ListviewMainAdapter(this.getActivity(), arrProducts);
            lv.setAdapter(listviewMainAdapter);
        }


    }

    private void addEvents() {



        productAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {


            }
        });



    }

    private void addControls() {
        rcvProduct = view.findViewById(R.id.rcv_main_product);
        viewAnimator = view.findViewById(R.id.viewFlipper);

        lv = view.findViewById(R.id.xxx);

        arrProducts = new ArrayList<Product>();
        gr = new GridLayoutManager(getActivity(), 2);
        rcvProduct.setLayoutManager(gr);
        rcvProduct.setHasFixedSize(true);
        productAdapter = new ProductAdapter(rcvProduct, getActivity(), arrProducts);


        productAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
                    @Override
                    public void onLoadMore() {

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


                               loadListProduct(++index);

                           // index = index+1;
                            productAdapter.setLoaded();

                        }
                    }, 5000);



            }
        });



    }



}
