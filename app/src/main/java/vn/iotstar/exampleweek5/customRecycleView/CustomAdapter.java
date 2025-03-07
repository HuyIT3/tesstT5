package vn.iotstar.exampleweek5.customRecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.iotstar.exampleweek5.R;
import vn.iotstar.exampleweek5.recycleview.RecycleViewActivity;
import vn.iotstar.exampleweek5.recycleview.SongModel;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<Object> mObject;
    public static final int TEXT =0 ;
    public static final int IMAGE =1 ;
    public static final int USER =2 ;
    public CustomAdapter(Context context,List<Object> objects)
    {
        mContext =context;
        mObject =objects;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(mContext);
        switch (viewType) {
            case TEXT:
                View itemView0 = li.inflate(R.layout.row_text, parent, false);
                return new TextViewHolder(itemView0);
            case IMAGE:
                View itemView1 = li.inflate(R.layout.row_image, parent, false);
                return new ImageViewHolder(itemView1);
            case USER:
                View itemView2 = li.inflate(R.layout.row_user, parent, false);
                return new UserViewHolder(itemView2);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TEXT:
                TextViewHolder textViewHolder = (TextViewHolder) holder;
                textViewHolder.tvText.setText(mObject.get(position).toString());
                break;
            case IMAGE:
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                imageViewHolder.imageView.setImageResource((int) mObject.get(position)); //
                break;
            case USER:
                UserModel user = (UserModel) mObject.get(position);
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                userViewHolder.tvName.setText(user.getName());
                userViewHolder.tvAddress.setText(user.getAddress());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mObject.size();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;

        public TextViewHolder(View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_text);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, mObject.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public class ImageViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imv_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, mObject.get(getAdapterPosition()).toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    public class UserViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvAddress;

        public UserViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserModel user = (UserModel) mObject.get(getAdapterPosition());
                    Toast.makeText(mContext, user.getName()+","+user.getAddress(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
    @Override
    public int getItemViewType(int positon){
        if(mObject.get(positon)instanceof String)
            return TEXT;
        else if (mObject.get(positon)instanceof Integer) {
            return IMAGE;
        } else if (mObject.get(positon)instanceof UserModel) {
            return USER;
        }
        return -1;
    }


}

