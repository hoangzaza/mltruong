package ambe.com.vn.moki.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.activities.ProductDetailActivity;
import ambe.com.vn.moki.models.products.Product;

/**
 * Created by AMBE on 09/10/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private ArrayList<Product> arrayList;
    private ProductViewHolder viewHolder;
    private DecimalFormat decimalFormat;

    public ProductAdapter(Context context, ArrayList<Product> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_product, parent, false);
        viewHolder = new ProductViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        decimalFormat=new DecimalFormat("###,###,###");

        Product product=arrayList.get(position);
        String str=decimalFormat.format(Integer.parseInt(product.getPrice()));
        int x=str.lastIndexOf(".");
        String price=str.substring(0,x);
        viewHolder.txtPrice.setText(price + " K");
        viewHolder.txtLike.setText(product.getLike().size()+"");
        viewHolder.txtMess.setText(product.getComment().size()+"");
//        Picasso.with(context)
//                .load(product.getImage().get(0).getUrl())
//                .error(R.drawable.no_image)
//                .into(viewHolder.imageView);
        viewHolder.imageView.setImageResource(R.drawable.android);

        viewHolder.txtName.setText(product.getName_product());





    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView txtName;
        private TextView txtLike;
        private TextView txtMess;
        private TextView txtPrice;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_custom_product);
            txtName = itemView.findViewById(R.id.txt_custom_name_product);
            txtLike = itemView.findViewById(R.id.txt_custom_like_count);
            txtMess = itemView.findViewById(R.id.txt_custom_mess_count);
            txtPrice = itemView.findViewById(R.id.txt_custom_price_product);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent =new Intent(context, ProductDetailActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}
