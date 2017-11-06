package ambe.com.vn.moki.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.adapters.ProductAdapter;
import ambe.com.vn.moki.models.products.Image;
import ambe.com.vn.moki.models.products.Product;
import ambe.com.vn.moki.models.users.Profile;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private ArrayList<String> arrayList;
    int position;
    private View view;
    private RecyclerView rcvProduct;
    private ArrayList<Product> arrProducts;
    private ProductAdapter productAdapter;


    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addControls();
        addEvents();



    }

    private void addEvents() {



    }

    private void addControls() {
        rcvProduct=view.findViewById(R.id.rcv_main_product);

        rcvProduct.setLayoutManager(new GridLayoutManager(getActivity(),2));
        arrProducts=new ArrayList<Product>();
        ArrayList<Profile> test=new ArrayList<>();
        ArrayList<Image> images=new ArrayList<>();
        Image image=new Image("https://cdn.tgdd.vn/Products/Images/42/91131/samsung-galaxy-s8-plus-tim-khoi-400-400x460.png","1");
        images.add(image);

        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));
        arrProducts.add(new  Product("Sam sung galaxy S8",images,"1250000",test,test));


        productAdapter=new ProductAdapter(getActivity(),arrProducts);
        rcvProduct.setAdapter(productAdapter);
    }
}
