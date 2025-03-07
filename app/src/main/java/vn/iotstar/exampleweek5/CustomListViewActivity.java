package vn.iotstar.exampleweek5;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<MonHoc> monHocList;
    private MonhocAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.custom_list_view);
        listView = findViewById(R.id.listViewMonHoc);
        monHocList = new ArrayList<>();
        monHocList.add(new MonHoc("Du Hoang Huy", "Java 1", R.drawable.ic_launcher_background));
        monHocList.add(new MonHoc("Nguyen Văn Bao", "C# 1", R.drawable.ic_launcher_foreground));
        monHocList.add(new MonHoc("Le Dao Nhan Sam", "PHP 1", R.drawable.ic_launcher_background));
        monHocList.add(new MonHoc("Nguyen van kiet", "Kotlin 1", R.drawable.ic_launcher_foreground));
        monHocList.add(new MonHoc("Dao tu", "Dart 1", R.drawable.ic_launcher_background));
        adapter = new MonhocAdapter(this, R.layout.row_monhoc, monHocList);
        listView.setAdapter(adapter);

    }




}
