package ambe.com.vn.moki.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ambe.com.vn.moki.R;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by AMBE on 25/09/2017.
 */

public class StickyHeaderAdapter extends BaseAdapter implements StickyListHeadersAdapter, Filterable {
    private ArrayList<String> arr;
    private LayoutInflater inflater;
    private ArrayList<String> arrFilter;

    public StickyHeaderAdapter(Context context, ArrayList<String> arr) {
        inflater = LayoutInflater.from(context);
        this.arr = arr;
        this.arrFilter = arr;

    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeaderView headerView;
        if (convertView == null) {
            headerView = new HeaderView();
            convertView = inflater.inflate(R.layout.listview_header, parent, false);
            headerView.txtHeader = convertView.findViewById(R.id.header_text);

            convertView.setTag(headerView);
        } else {
            headerView = (HeaderView) convertView.getTag();
        }

        String header = "" + arrFilter.get(position).subSequence(0, 1).charAt(0);
        headerView.txtHeader.setText(header);
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return arrFilter.get(position).subSequence(0, 1).charAt(0);
    }

    @Override
    public int getCount() {
        return arrFilter == null ? 0 : arrFilter.size();
    }

    @Override
    public Object getItem(int i) {
        return arrFilter.get(i);
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
            view = inflater.inflate(R.layout.custom_single_choice, viewGroup, false);

            itemView.txtItem = view.findViewById(R.id.txt_single_choice);
            itemView.imgCheck = view.findViewById(R.id.img_check_single_choice);

            view.setTag(itemView);
        } else {
            itemView = (ItemView) view.getTag();
        }

        itemView.txtItem.setText(arrFilter.get(i));
        itemView.imgCheck.setVisibility(View.GONE);
        return view;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String text = charSequence.toString().toLowerCase().trim();
                if (text.isEmpty()) {
                    arrFilter = arr;
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    for (String str : arr) {
                        if (str.toLowerCase().trim().contains(text)) {
                            list.add(str);
                        }
                    }

                    arrFilter = list;

                }

                FilterResults results = new FilterResults();
                results.values = arrFilter;
                results.count = arrFilter.size();

                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                arrFilter = (ArrayList<String>) filterResults.values;
                notifyDataSetChanged();

            }
        };
    }

    private class HeaderView {
        private TextView txtHeader;
    }

    private class ItemView {
        private TextView txtItem;
        private ImageView imgCheck;
    }
}
