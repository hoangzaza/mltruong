package ambe.com.vn.moki.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.models.products.Image;
import ambe.com.vn.moki.models.products.Product;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by HoangNV on 10/20/2017.
 */

public class ListviewMainAdapter extends BaseAdapter implements StickyListHeadersAdapter, View.OnClickListener {

    private ArrayList<Product> arr;
    private LayoutInflater inflater;
    private Context context;

    public ListviewMainAdapter(Context context, ArrayList<Product> arr) {
        this.context = context;
        this.arr = arr;
        inflater = LayoutInflater.from(context);


    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderView headerView;
        if (convertView == null) {
            headerView = new HeaderView();
            convertView = inflater.inflate(R.layout.listview_main_header, parent, false);
            headerView.img_icon = convertView.findViewById(R.id.icon_user);
            headerView.username = convertView.findViewById(R.id.user_name);
            headerView.timeago = convertView.findViewById(R.id.tvTimeago);
            convertView.setTag(headerView);
        } else {
            headerView = (HeaderView) convertView.getTag();
        }
        headerView.username.setText("hafshhsa");   //arr.get(position).getSeller().getName()
        headerView.timeago.setText("asdahdha");  //arr.get(position).getCreated()
//        Picasso.with(context).load(arr.get(position).getSeller().getAvatar()).error(R.drawable.no_image).into(headerView.img_icon);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return arr.size();
    }

    @Override
    public Object getItem(int i) {
        return arr.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemView itemView;
        if (view == null) {
            itemView = new ItemView();
            view = inflater.inflate(R.layout.item_listview_main, viewGroup, false);

            itemView.tvname = view.findViewById(R.id.tvnameproduct);
            itemView.tvprice = view.findViewById(R.id.tv_price_product);
            itemView.tvdescription = view.findViewById(R.id.tvdescription);
            itemView.btn_love = view.findViewById(R.id.btn_love_product);
            itemView.btn_comment = view.findViewById(R.id.btn_comment_product);
            itemView.btn_share = view.findViewById(R.id.btn_share);
            switch (arr.get(i).getImage().size()) {
                case 1:
                    itemView.img1 = (ImageView) view.findViewById(R.id.img_item_one);
                    break;
                case 2:
                    itemView.img1 = (ImageView) view.findViewById(R.id.item2_1);
                    itemView.img2 = (ImageView) view.findViewById(R.id.item2_2);
                    break;
                case 3:
                    itemView.img1 = (ImageView) view.findViewById(R.id.item3_1);
                    itemView.img2 = (ImageView) view.findViewById(R.id.item3_2);
                    itemView.img3 = (ImageView) view.findViewById(R.id.item3_3);
                    break;
                case 4:
                    itemView.img1 = (ImageView) view.findViewById(R.id.item4_1);
                    itemView.img2 = (ImageView) view.findViewById(R.id.item4_2);
                    itemView.img3 = (ImageView) view.findViewById(R.id.item4_3);
                    itemView.img4 = (ImageView) view.findViewById(R.id.item4_4);
                    break;
            }
            view.setTag(itemView);
        } else {
            itemView = (ItemView) view.getTag();
        }
        switch (arr.get(i).getImage().size()) {
            case 1:
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(0).getUrl())
                        .error(R.drawable.no_image).into(itemView.img1);
                break;
            case 2:
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(0).getUrl())
                        .error(R.drawable.no_image).into(itemView.img1);
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(1).getUrl())
                        .error(R.drawable.no_image).into(itemView.img2);
                break;
            case 3:
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(0).getUrl())
                        .error(R.drawable.no_image).into(itemView.img1);
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(1).getUrl())
                        .error(R.drawable.no_image).into(itemView.img2);
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(2).getUrl())
                        .error(R.drawable.no_image).into(itemView.img3);
                break;
            case 4:
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(0).getUrl())
                        .error(R.drawable.no_image).into(itemView.img1);
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(1).getUrl())
                        .error(R.drawable.no_image).into(itemView.img2);
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(2).getUrl())
                        .error(R.drawable.no_image).into(itemView.img3);
                Picasso.with(context)
                        .load(arr.get(i).getImage().get(3).getUrl())
                        .error(R.drawable.no_image).into(itemView.img4);

                break;
        }
        itemView.tvname.setText(arr.get(i).getName_product());

        itemView.tvdescription.setText(arr.get(i).getDescribed());
        DecimalFormat dcf= new DecimalFormat("###,###,###");

        itemView.tvprice.setText(dcf.format(Integer.parseInt(arr.get(i).getPrice()))+" VNĐ ");
        itemView.btn_love.setText(arr.get(i).getLike().size() + "");
        itemView.btn_comment.setText(arr.get(i).getComment().size() + "");
        itemView.btn_love.setOnClickListener(this);
        itemView.btn_comment.setOnClickListener(this);
        itemView.btn_share.setOnClickListener(this);


        return view;


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_love_product:
                Toast.makeText(context, "like", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_comment_product:
                Toast.makeText(context, "comment", Toast.LENGTH_LONG).show();
                break;
            case R.id.btn_share:
                Toast.makeText(context, "share", Toast.LENGTH_LONG).show();
                break;
        }

    }

    private class HeaderView {
        private ImageView img_icon;
        private TextView username, timeago;
    }

    private class ItemView {
        private ImageView img1, img2, img3, img4;
        private TextView tvname, tvprice, tvdescription;
        private Button btn_love, btn_comment;
        private LinearLayout btn_share;
    }
}
