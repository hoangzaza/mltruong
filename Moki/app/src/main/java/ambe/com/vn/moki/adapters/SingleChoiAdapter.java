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
import ambe.com.vn.moki.models.SingleChoice;

/**
 * Created by AMBE on 12/10/2017.
 */

public class SingleChoiAdapter extends BaseAdapter {

    private ArrayList<SingleChoice> arrayList;
    private Context context;

    public SingleChoiAdapter(ArrayList<SingleChoice> arrayList, Context context) {
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
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ItemViewHolder itemViewHolder;
        if (view == null) {
            itemViewHolder = new ItemViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.custom_single_choice, viewGroup, false);
            itemViewHolder.txtText = view.findViewById(R.id.txt_single_choice);
            itemViewHolder.imgCheck = view.findViewById(R.id.img_check_single_choice);


            view.setTag(itemViewHolder);
        } else {
            itemViewHolder= (ItemViewHolder) view.getTag();
        }

        SingleChoice str= (SingleChoice) getItem(i);
        itemViewHolder.txtText.setText(str.getTxtName());

            if (str.getCheck() == 1){
                itemViewHolder.imgCheck.setVisibility(View.VISIBLE);
                itemViewHolder.imgCheck.setImageResource(R.drawable.tick);
            } else {
                itemViewHolder.imgCheck.setVisibility(View.GONE);
            }



        return view;
    }


    public class ItemViewHolder {
        private TextView txtText;
        private ImageView imgCheck;
    }
}
