package vn.iotstar.exampleweek5.recycleview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import vn.iotstar.exampleweek5.R;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder>{
    private static final String TAG = "SongAdapter";
    private List<SongModel> mSongs;
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    public SongAdapter(Context context, List<SongModel> datas) {
        mContext = context;
        mSongs = datas;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.row_item_song, parent, false);
        return new SongViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        // Lấy bài hát tại vị trí hiện tại
        SongModel song = mSongs.get(position);

        // Gán dữ liệu vào ViewHolder
        holder.tvCode.setText(song.getmCode());
        holder.tvTitle.setText(song.getmTitle());
        holder.tvLyric.setText(song.getmLyric());
        holder.tvArtist.setText(song.getmArtist());
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }
    public class SongViewHolder extends RecyclerView.ViewHolder {
        TextView tvCode, tvTitle, tvLyric, tvArtist;

        public SongViewHolder(View itemView) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tv_code);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvLyric = itemView.findViewById(R.id.tv_lyric);
            tvArtist = itemView.findViewById(R.id.tv_artist);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        SongModel song = mSongs.get(position);
                        Toast.makeText(mContext, song.getmTitle(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
