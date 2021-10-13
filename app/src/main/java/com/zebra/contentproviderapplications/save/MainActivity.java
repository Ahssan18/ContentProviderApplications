package com.zebra.contentproviderapplications.save;

import static com.zebra.contentproviderapplications.R.id.btn_save;
import static com.zebra.contentproviderapplications.R.id.btn_view;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zebra.contentproviderapplications.Provider;
import com.zebra.contentproviderapplications.databinding.ActivityMainBinding;
import com.zebra.contentproviderapplications.retrieve.RecordActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        clickListener();
    }

    private void clickListener() {
        binding.btnSave.setOnClickListener(this);
        binding.btnView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case btn_save:
                String name = binding.etName.getText().toString();
                String age = binding.etAge.getText().toString();
                ContentValues values = new ContentValues();
                values.put("name", name);
                values.put("age", age);
                Uri uri = getContentResolver().insert(Provider.CONTENT_URI, values);
                Toast.makeText(this, "" + uri, Toast.LENGTH_SHORT).show();
                break;
            case btn_view:
                startActivity(new Intent(this, RecordActivity.class));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}