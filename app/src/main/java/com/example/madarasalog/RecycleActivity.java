//package com.example.madarasalog;
//
//import android.annotation.SuppressLint;
//import android.os.Bundle;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class RecycleActivity extends AppCompatActivity {
//    List<RecordLog> friendsList = new ArrayList<>();
//    RecyclerView recyclerView;
//    RecyclerView.Adapter adapter;
//    RecyclerView.LayoutManager layoutManager;
//
//    @SuppressLint("MissingInflatedId")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        recyclerView = findViewById(R.id.reycle_view_log);
//
//        ArrayList<RecordLog> records = dbHandler.selectAllRecords(id);
//        recyclerView.setHasFixedSize(true);
//
//        //LinearLayoutManager GridLayoutManager
//        layoutManager = new LinearLayoutManager(RecycleActivity.this);
////        layoutManager = new LinearLayoutManager(MainActivity.this,
////                LinearLayoutManager.HORIZONTAL,
////                true);
//        recyclerView.setLayoutManager(layoutManager);
//
//        adapter = new RecyclerViewAdapter(friendsList) ;
//        recyclerView.setAdapter(adapter);
//        //adapter.notifyDataSetChanged();
//
//
//    }
//}
