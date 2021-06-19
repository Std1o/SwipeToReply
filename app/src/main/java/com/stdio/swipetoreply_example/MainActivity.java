package com.stdio.swipetoreply_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import com.stdio.swipetoreply.ISwipeControllerActions;
import com.stdio.swipetoreply.SwipeController;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> dataList;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        rv = findViewById(R.id.rv);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        SwipeController controller = new SwipeController(this, new ISwipeControllerActions() {
            @Override
            public void onSwipePerformed(int position) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(controller);
        itemTouchHelper.attachToRecyclerView(rv);
        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        dataList = new ArrayList<>();
        dataList.add(new DataModel(getString(R.string.news_header_top_stories), getString(R.string.news_body1)));
        dataList.add(new DataModel(getString(R.string.news_header_world), getString(R.string.news_body4)));
        dataList.add(new DataModel(getString(R.string.news_header_australia), getString(R.string.news_body6)));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(dataList, this);
        rv.setAdapter(adapter);
    }
}
