package ambe.com.vn.moki.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.activities.ProductDetailActivity;
import ambe.com.vn.moki.interfaces.OnHideToolBar;
import ambe.com.vn.moki.interfaces.OnLoadMoreListener;
import ambe.com.vn.moki.models.products.Product;

/**
 * Created by AMBE on 09/10/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<Product> arrayList;
    private DecimalFormat decimalFormat;
    private final int VIEW_TYPE_ITEM = 1;
    private final int VIEW_TYPE_LOADING = 0;
    private int previousTotal = 0;
    private OnHideToolBar mOnHideToolBar;

    private boolean mWithFooter = true;


    private OnLoadMoreListener mOnLoadMoreListener;
    private boolean isLoading = false;
    private int visibleThreshold = 1;
    private int lastVisibleItem,
            totalItemCount, visibleItemCount, firstVisibleItem;

    public ProductAdapter(final RecyclerView mRecyclerView, Context context, final ArrayList<Product> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
        final GridLayoutManager gr = (GridLayoutManager) mRecyclerView.getLayoutManager();

        if (gr instanceof GridLayoutManager) {

            gr.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    //        if (getItemViewType(position) == VIEW_TYPE_LOADING)
                    if (getItemViewType(position) == VIEW_TYPE_LOADING)
                        return gr.getSpanCount();
                    else return 1;
                }
            });
        }
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) { // scroll down
                    visibleItemCount = mRecyclerView.getChildCount();
                    totalItemCount = gr.getItemCount();
                    firstVisibleItem = gr.findFirstVisibleItemPosition();
                    lastVisibleItem = gr.findLastVisibleItemPosition();
                    //           Log.d("BBB", " total: "+ totalItemCount+  " visit: " + visibleItemCount + " past: " + pastVisiblesItems);
                    //                   Log.d("BBB", " total: " + totalItemCount + "vissit: " + visibleItemCount + " last: " + lastVisibleItem + " first: " + firstVisibleItem);

                    if (!isLoading && (totalItemCount <= (firstVisibleItem + visibleItemCount))) {
                        Log.d("BBB", "size " + arrayList.size() + "-" + "grid " + gr.getItemCount());
                        if (mOnLoadMoreListener != null) {
                            mOnLoadMoreListener.onLoadMore();
                        }
                        isLoading = true;
                    }
                }


            }


        });
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View view = LayoutInflater.from(context).inflate(R.layout.custom_product, parent, false);
            return new ProductViewHolder(view);
        } else if (viewType == VIEW_TYPE_LOADING) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_loading_item, parent, false);

            return new LoadingViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ProductViewHolder) {
            decimalFormat = new DecimalFormat("###,###,###");
            ProductViewHolder productViewHolder = (ProductViewHolder) holder;
            Product product = arrayList.get(position);
            String str = decimalFormat.format(Integer.parseInt(product.getPrice()));
            int x = str.lastIndexOf(".");
            String price = str.substring(0, x);
            productViewHolder.txtPrice.setText(price + " K");
            productViewHolder.txtLike.setText(product.getLike().size() + "");
            productViewHolder.txtMess.setText(product.getComment().size() + "");
            Picasso.with(context)
                    .load(product.getImage().get(0).getUrl())
                    .error(R.drawable.no_image)
                    .into(productViewHolder.imageView);
//        viewHolder.imageView.setImageResource(R.drawable.android);

            productViewHolder.txtName.setText(product.getName_product());
        } else if (holder instanceof LoadingViewHolder) {
            LoadingViewHolder loadingViewHolder = (LoadingViewHolder) holder;
            loadingViewHolder.progressBar.setIndeterminate(true);

        }

    }

    public void setLoaded() {
        isLoading = false;
    }

    @Override
    public int getItemViewType(int position) {
//       if (position == getItemCount() -1 )
//            return VIEW_TYPE_LOADING;
//        return VIEW_TYPE_ITEM;

        return (mWithFooter && position >= arrayList.size()) ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;


    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.mOnLoadMoreListener = mOnLoadMoreListener;
    }


    @Override
    public int getItemCount() {
        return (mWithFooter) ? arrayList.size() + 1 : arrayList.size();

    }


    public class LoadingViewHolder extends RecyclerView.ViewHolder {

        public ProgressBar progressBar;

        public LoadingViewHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.progressBar1);
        }
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
                    Intent intent = new Intent(context, ProductDetailActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("PRO", arrayList.get(getPosition()));
                    intent.putExtra("BUN", bundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                }
            });
        }
    }
}
