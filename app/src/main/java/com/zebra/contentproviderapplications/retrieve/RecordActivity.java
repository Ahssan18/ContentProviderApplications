package com.zebra.contentproviderapplications.retrieve;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.zebra.contentproviderapplications.databinding.ActivityRecordBinding;

public class RecordActivity extends AppCompatActivity {

    ActivityRecordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRecordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setData();
    }

    private void setData() {
        String URL = "content://com.zebra.contentproviderapplications";

        Uri students = Uri.parse(URL);
        Cursor c = getContentResolver().query(students, null, null, null, "name");
        if(c.moveToFirst())
        {
            do{
               binding.tvRecord.append(c.getString(c.getColumnIndex("name")));
            }while (c.moveToNext());
        }
    }
}