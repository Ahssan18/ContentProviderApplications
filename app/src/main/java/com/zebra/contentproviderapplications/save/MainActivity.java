package com.zebra.contentproviderapplications.save;

import static com.zebra.contentproviderapplications.R.id.btn_save;
import static com.zebra.contentproviderapplications.R.id.btn_view;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zebra.contentproviderapplications.Provider;
import com.zebra.contentproviderapplications.databinding.ActivityMainBinding;
import com.zebra.contentproviderapplications.retrieve.RecordActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    public static String TAG="MainActivity";
    int id;

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
                if (id != -1) {
                    getContentResolver().update(Provider.CONTENT_URI, values, "id" + "=" + id, null);
                } else {
                    Uri uri = getContentResolver().insert(Provider.CONTENT_URI, values);
                    Toast.makeText(this, "" + uri, Toast.LENGTH_SHORT).show();
                }

                break;
            case btn_view:
                Intent intent = new Intent(this, RecordActivity.class);
                startActivity(intent);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG," Main onNewIntent");
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");
        int id = intent.getIntExtra("id", -1);
        binding.etName.setText(name);
        binding.etAge.setText(age);
        binding.btnSave.setText("Update");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }
}