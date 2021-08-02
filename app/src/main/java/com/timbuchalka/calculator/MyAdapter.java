package com.timbuchalka.calculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context mContext;

    ArrayList<Calculation> mList;

    public MyAdapter(Context context, ArrayList<Calculation> list) {
        this.mContext = context;
        this.mList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Calculation calculation = mList.get(position);
        holder.tvCalculation.setText(calculation.getValue0());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvCalculation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCalculation = itemView.findViewById(R.id.tvCalculation);
        }
    }
}
