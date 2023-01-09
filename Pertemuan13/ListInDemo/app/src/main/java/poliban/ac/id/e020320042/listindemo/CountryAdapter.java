package poliban.ac.id.e020320042.listindemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.LinkedList;

public class CountryAdapter extends BaseAdapter {
    private final Context mContext;
    private final LinkedList<String> mList;


    public CountryAdapter(Context mContext, LinkedList<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private final class ViewHolder{
        TextView tvItem;

        public ViewHolder(View view) {
            tvItem = view.findViewById(R.id.tv_item);
        }
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_layout, viewGroup, false);

            holder= new ViewHolder(view);
            view.setTag(holder);
        }
        else
            holder = (ViewHolder) view.getTag();

        holder.tvItem.setText(mList.get(i));

        return view;
    }
}
