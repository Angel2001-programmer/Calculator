package com.timbuchalka.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<com.timbuchalka.calculator.RecyclerAdapter.MyViewHolder> {

    public static final String TAG = "RecyclerAdapter";
    Context mContext;
    ArrayList<Calculation> mList;

    public RecyclerAdapter(Context context, ArrayList<Calculation> mList) {
        this.mContext = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvCalculation.setText(mList.get(position).getValue0());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCalculation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCalculation = itemView.findViewById(R.id.tvCalculation);
        }
    }
}