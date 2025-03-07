package vn.iotstar.exampleweek5.recycleview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.iotstar.exampleweek5.MonHoc;
import vn.iotstar.exampleweek5.MonhocAdapter;
import vn.iotstar.exampleweek5.R;

public class RecycleViewActivity extends AppCompatActivity {
    private RecyclerView rvSongs;
    private SongAdapter mSongAdapter;
    private List<SongModel> mSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view);
        rvSongs = findViewById(R.id.rv_songs);
        // Tạo danh sách bài hát
        mSongs = new ArrayList<>();
        mSongs.add(new SongModel("60696", "NẾU EM CÒN TỒN TẠI", "Khi anh bắt đầu 1 tình yêu Là lúc anh tự thay", "Trịnh Đình Quang"));
        mSongs.add(new SongModel("60701", "NGỐC", "Có rất nhiều nhưng câu chuyện Em dấu riêng mình em biết", "Khắc Việt"));
        mSongs.add(new SongModel("60710", "HÃY TIN ANH LẦN NỮA", "Dẫu cho ta đã sai khi ở bên nhau có yêu thương", "Thiên Dũng"));
        mSongs.add(new SongModel("60698", "CHUỖI NGÀY VẮNG EM", "Từ khi em bước ra đi cõi lòng anh ngập trắng bao", "Duy Cường"));
        mSongs.add(new SongModel("60716", "KHI NGƯỜI MÌNH YÊU KHÓC", "Nước mắt em đang rơi trên những ngón tay Nước mắt em", "Phan Mạnh Quỳnh"));

        // Khởi tạo Adapter
        mSongAdapter = new SongAdapter(this, mSongs);
        rvSongs.setAdapter(mSongAdapter);

        // Thiết lập Layout Manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvSongs.setLayoutManager(linearLayoutManager);

    }
}