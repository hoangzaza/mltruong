package ambe.com.vn.moki.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.adapters.ProductAdapter;
import ambe.com.vn.moki.models.products.Image;
import ambe.com.vn.moki.models.products.Product;
import ambe.com.vn.moki.models.users.Profile;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListProductFragment extends Fragment {

    private RecyclerView rcvProduct;
    private View view;
    private ProductAdapter adapter;
    private ArrayList<Product> arrProducts;


    public ListProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_list_product, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rcvProduct=view.findViewById(R.id.rcv_list_product);


        rcvProduct.setLayoutManager(new GridLayoutManager(getActivity(),2));
        arrProducts=new ArrayList<Product>();
        ArrayList<Profile> test=new ArrayList<Profile>();
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

        adapter=new ProductAdapter(getActivity(),arrProducts);
        rcvProduct.setAdapter(adapter);

    }
}
