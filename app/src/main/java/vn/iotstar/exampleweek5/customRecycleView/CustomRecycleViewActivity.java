package vn.iotstar.exampleweek5.customRecycleView;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.iotstar.exampleweek5.R;

public class CustomRecycleViewActivity extends AppCompatActivity {
    private static final String TAG = "RecycleActivity";
    private RecyclerView rvMultipleViewType;
    private List<Object> mData;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_recycle_view);
        rvMultipleViewType = findViewById(R.id.rv_multiple_view_type);
        mData = new ArrayList<>();
        mData.add(new UserModel("Nguyen Van Nghia", "Quan 11"));
        mData.add(R.drawable.ic_launcher_foreground);
        mData.add("Text 0");
        mData.add("Text 1");
        mData.add(new UserModel("Nguyen Hoang Minh", "Quan 3"));
        mData.add(R.drawable.ic_launcher_foreground);
        mData.add(R.drawable.ic_launcher_background);
        mData.add("Text 2");
        mData.add(new UserModel("Pham Nguyen Tam Phu", "Quan 10"));
        mData.add("Text 3");
        mData.add("Text 4");
        mData.add(new UserModel("Tran Van Phuc", "Quan 1"));
        mData.add(R.drawable.ic_launcher_foreground);
        CustomAdapter adapter = new CustomAdapter(this, mData);
        rvMultipleViewType.setAdapter(adapter);
        rvMultipleViewType.setLayoutManager(new LinearLayoutManager(this));
    }
}