package ambe.com.vn.moki.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ambe.com.vn.moki.R;
import ambe.com.vn.moki.models.MenuItem;
import ambe.com.vn.moki.models.products.Image;

/**
 * Created by AMBE on 13/10/2017.
 */

public class MenuMainAdapter extends BaseAdapter {
    private ArrayList<MenuItem> arrayList;
    private Context context;

    public MenuMainAdapter(ArrayList<MenuItem> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ItemViewHolder itemViewHolder;
        if (view == null){
            itemViewHolder = new ItemViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.custom_menu,viewGroup,false);
            itemViewHolder.imgIcon=view.findViewById(R.id.img_icon_menu);
            itemViewHolder.imgNext=view.findViewById(R.id.img_next_menu);
            itemViewHolder.txtName=view.findViewById(R.id.txt_title_menu);

            view.setTag(itemViewHolder);
        } else {
            itemViewHolder= (ItemViewHolder) view.getTag();
        }
        MenuItem menuItem= (MenuItem) getItem(i);
        itemViewHolder.txtName.setText(menuItem.getTxtName());
        itemViewHolder.imgIcon.setImageResource(menuItem.getIdIcon());

        if (menuItem.getCheck() == 1){
            itemViewHolder.txtName.setTextColor(context.getResources().getColor(R.color.colorRed));

        } else if (menuItem.getCheck() == 0){
            itemViewHolder.txtName.setTextColor(context.getResources().getColor(R.color.colorBlack));

        }
        return view;
    }


    public class ItemViewHolder {
        private ImageView imgIcon;
        private TextView txtName;
        private ImageView imgNext;
    }
}
