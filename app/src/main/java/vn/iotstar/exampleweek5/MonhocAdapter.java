package vn.iotstar.exampleweek5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MonhocAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<MonHoc> monHocList;

    public MonhocAdapter(Context context, int layout, List<MonHoc> monHocList) {
        this.context = context;
        this.layout = layout;
        this.monHocList = monHocList;
    }

    @Override
    public int getCount() {
        return monHocList.size();
    }

    @Override
    public Object getItem(int position) {
        return monHocList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layout, viewGroup, false);

            viewHolder = new ViewHolder();
            // Ánh xạ view
            viewHolder.textName = view.findViewById(R.id.textName);
            viewHolder.textDesc = view.findViewById(R.id.textDesc);
            viewHolder.imagePic = view.findViewById(R.id.imagePic);

            // Lưu ViewHolder vào convertView
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        // Gán giá trị vào view
        MonHoc monHoc = monHocList.get(position);
        viewHolder.textName.setText(monHoc.getName());
        viewHolder.textDesc.setText(monHoc.getDesc());
        viewHolder.imagePic.setImageResource(monHoc.getPic());

        return view;
    }
    private static class ViewHolder {
        TextView textName, textDesc;
        ImageView imagePic;
    }
}
