package com.zebra.contentproviderapplications.retrieve;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.zebra.contentproviderapplications.databinding.ActivityRecordBinding;

import java.util.ArrayList;
import java.util.List;

public class RecordActivity extends AppCompatActivity {

    ActivityRecordBinding binding;
    List<Data> list;
    RecordAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initViews();
        setData();
    }

    public void initViews() {
        list = new ArrayList<>();

    }

    private void setData() {
        String URL = "content://com.zebra.contentproviderapplications";

        Uri students = Uri.parse(URL);
        Cursor c = getContentResolver().query(students, null, null, null, "name");
        if (c.moveToFirst()) {
            do {
                Data data = new Data(c.getString(c.getColumnIndex("name")),
                        c.getString(c.getColumnIndex("age")),
                        c.getInt(c.getColumnIndex("id")));
                list.add(data);
            } while (c.moveToNext());
        }
        setAdapter();
    }

    private void setAdapter() {
        adapter = new RecordAdapter(this, list);
        binding.recycleview.setLayoutManager(new LinearLayoutManager(this));
        binding.recycleview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}