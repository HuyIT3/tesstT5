package vn.iotstar.exampleweek5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import vn.iotstar.exampleweek5.customRecycleView.CustomRecycleViewActivity;
import vn.iotstar.exampleweek5.recycleview.RecycleViewActivity;

public class MainActivity extends AppCompatActivity {
    Button buttonListView;
    Button buttonCustomListView;
    Button buttonCustomGridView;
    Button buttonRecycleView;
    Button buttonCustomRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        buttonListView = findViewById(R.id.button);
        buttonCustomListView = findViewById(R.id.buttonCLV);
        buttonCustomGridView = findViewById(R.id.buttonCGV);
        buttonRecycleView = findViewById(R.id.buttonRCV);
        buttonCustomRecycleView = findViewById(R.id.buttonCRCV);
        buttonListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intent);
            }
        });
        // Xử lý insets nếu cần
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonCustomListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomListViewActivity.class);
                startActivity(intent);
            }
        });

        buttonCustomGridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomGridViewActivity.class);
                startActivity(intent);
            }
        });
        buttonRecycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                startActivity(intent);
            }
        });
        buttonCustomRecycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CustomRecycleViewActivity.class);
                startActivity(intent);
            }
        });



    }
}