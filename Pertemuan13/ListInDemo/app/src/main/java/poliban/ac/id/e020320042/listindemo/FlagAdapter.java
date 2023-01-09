package poliban.ac.id.e020320042.listindemo;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import poliban.ac.id.e020320042.listindemo.model.Flag;

public class FlagAdapter extends BaseAdapter {
    private Context mContext;
    private List<Flag> mList;

    public FlagAdapter(Context mContext, List<Flag> mList) {
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
        return 0;
    }
    private static class ViewHolder {
     ImageView imageFlag;
     TextView tvCountryName;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }


}
}
