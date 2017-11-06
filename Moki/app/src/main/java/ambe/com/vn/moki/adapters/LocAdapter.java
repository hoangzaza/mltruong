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
import ambe.com.vn.moki.models.Loc;

/**
 * Created by AMBE on 18/09/2017.
 */

public class LocAdapter extends BaseAdapter {

    private ArrayList<Loc> arrLoc;
    private Context context;
    private ItemViewHolder itemViewHolder;

    public LocAdapter(ArrayList<Loc> arrLoc, Context context) {
        this.arrLoc = arrLoc;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrLoc.size();
    }

    @Override
    public Object getItem(int i) {
        return arrLoc.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        itemViewHolder = null;
        if (view == null) {
            itemViewHolder = new ItemViewHolder();

            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_loc, viewGroup, false);

            itemViewHolder.txtTitle = view.findViewById(R.id.txt_title_loc);
            itemViewHolder.txtSubTitle = view.findViewById(R.id.txt_subtitle_loc);
            itemViewHolder.imgCheck = view.findViewById(R.id.imge_check_loc);

            view.setTag(itemViewHolder);
        } else {

            itemViewHolder = (ItemViewHolder) view.getTag();
        }
        Loc loc = (Loc) getItem(i);
        itemViewHolder.txtTitle.setText(loc.getTitLe());
        itemViewHolder.txtSubTitle.setText(loc.getSubTitle());
        if (loc.getCheck() == 0) {
            itemViewHolder.imgCheck.setVisibility(View.VISIBLE);
            itemViewHolder.imgCheck.setImageResource(R.drawable.icon_nextarrow_normal);
        } else if (loc.getCheck() == 1) {
            itemViewHolder.imgCheck.setVisibility(View.VISIBLE);
            itemViewHolder.imgCheck.setImageResource(R.drawable.tick);
        } else if (loc.getCheck() ==2){
            itemViewHolder.imgCheck.setVisibility(View.GONE);
        }

        return view;
    }

    public class ItemViewHolder {

        private TextView txtTitle;
        private TextView txtSubTitle;
        private ImageView imgCheck;

    }
}
