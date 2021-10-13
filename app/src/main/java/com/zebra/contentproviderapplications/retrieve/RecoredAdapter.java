package com.zebra.contentproviderapplications.retrieve;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zebra.contentproviderapplications.databinding.CustomRecordBinding;

import java.util.List;

public class RecoredAdapter extends RecyclerView.Adapter<RecoredAdapter.CustomLay> {
    Context context;
    List<Data> list;
    CustomRecordBinding binding;
    public RecoredAdapter(Context context, List<Data> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CustomLay onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding=CustomRecordBinding.inflate(LayoutInflater.from(context),parent,false);
        return new CustomLay(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomLay holder, int position) {
        setData(list.get(position),holder);
    }

    private void setData(Data data, CustomLay holder) {
        holder.customRecordBinding.tvName.setText(data.getName());
//        holder.
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CustomLay extends RecyclerView.ViewHolder{
        private CustomRecordBinding customRecordBinding;
        public CustomLay(@NonNull CustomRecordBinding customRecordBinding) {
            super(customRecordBinding.getRoot());
            this.customRecordBinding=customRecordBinding;

        }
    }
}
