package vn.iotstar.exampleweek5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CustomGridViewActivity extends AppCompatActivity {


    private GridView gridView;
    private ArrayList<MonHoc> monHocList;
    private MonhocAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.custom_grid_view);
        gridView = findViewById(R.id.gridViewMonHoc);
        monHocList = new ArrayList<>();
        monHocList.add(new MonHoc("Du Hoang Huy", "Java 1", R.drawable.ic_launcher_background));
        monHocList.add(new MonHoc("Nguyen Văn Bao", "C# 1", R.drawable.ic_launcher_foreground));
        monHocList.add(new MonHoc("Le Dao Nhan Sam", "PHP 1", R.drawable.ic_launcher_background));
        monHocList.add(new MonHoc("Nguyen van kiet", "Kotlin 1", R.drawable.ic_launcher_foreground));
        monHocList.add(new MonHoc("I Lov U", "Dart 1", R.drawable.ic_launcher_background));
        adapter = new MonhocAdapter(this, R.layout.row_monhoc_grid, monHocList);
        gridView.setAdapter(adapter);

    }
}

