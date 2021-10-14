package com.zebra.contentproviderapplications.retrieve;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zebra.contentproviderapplications.Provider;
import com.zebra.contentproviderapplications.R;
import com.zebra.contentproviderapplications.databinding.CustomRecordBinding;
import com.zebra.contentproviderapplications.save.MainActivity;

import java.util.List;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.CustomLay> {
    Context context;
    List<Data> list;
    CustomRecordBinding binding;

    public RecordAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomLay onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CustomRecordBinding.inflate(LayoutInflater.from(context), parent, false);
        return new CustomLay(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomLay holder, int position) {
        setData(list.get(position), holder);
    }

    private void setData(Data data, CustomLay holder) {
        holder.customRecordBinding.tvName.setText(data.getName());
        holder.customRecordBinding.tvAge.setText(data.getAge());
        holder.customRecordBinding.tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.getContentResolver().delete(Provider.CONTENT_URI, String.valueOf(data.getId()), null);
                list.remove(data);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class CustomLay extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final CustomRecordBinding customRecordBinding;

        public CustomLay(@NonNull CustomRecordBinding customRecordBinding) {
            super(customRecordBinding.getRoot());
            customRecordBinding.tvEdit.setOnClickListener(this);
            this.customRecordBinding = customRecordBinding;

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.tv_edit:
                    Intent intent=new Intent(context, MainActivity.class);
                    intent.putExtra("name",list.get(getLayoutPosition()).getName());
                    intent.putExtra("age",list.get(getLayoutPosition()).getAge());
                    intent.putExtra("id",list.get(getLayoutPosition()).getId());
//                    context.startActivity(intent);
//                    ((Activity)context).finish();
                    break;
            }
        }
    }
}
