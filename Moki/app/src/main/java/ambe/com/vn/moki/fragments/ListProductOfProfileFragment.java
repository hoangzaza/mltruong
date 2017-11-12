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
public class ListProductOfProfileFragment extends Fragment {

    private RecyclerView rcvProduct;
    private View view;
    private ProductAdapter adapter;
    private ArrayList<Product> arrProducts;
    private ArrayList<String> arrIdProduct;


    public ListProductOfProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_product_of_profile, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        rcvProduct = view.findViewById(R.id.rcv_list_product);
        Bundle bundle = getArguments();
        arrIdProduct = new ArrayList<>();
        arrIdProduct = bundle.getStringArrayList("ARR");


        rcvProduct.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        arrProducts = new ArrayList<Product>();

        adapter = new ProductAdapter(rcvProduct, getActivity(), arrProducts);
        rcvProduct.setAdapter(adapter);

    }
}
