package com.timbuchalka.calculator;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mDatabaseHelper = new DatabaseHelper(this);
//
//        populateListView();
//    }
//
//    private void populateListView() {
//        Log.d(TAG, "populateListView: Displaying data in the RecyclerView");
//
//        Cursor data = mDatabaseHelper.getData();
//        ArrayList<String> listData = new ArrayList<>();
//        while (data.moveToNext()){
//            listData.add(data.getString(1));
//        }
//        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
//        binding.r
//    }

public class RecyclerAdapter extends RecyclerView.Adapter<com.timbuchalka.calculator.RecyclerAdapter.MyViewHolder> {

    public static final String TAG = "RecyclerAdapter";
    Context mContext;
    ArrayList<Calculation> mList;
    DatabaseHelper mDatabaseHelper;


    public RecyclerAdapter(Context context, ArrayList<Calculation> list) {
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

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvCalculation;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCalculation = itemView.findViewById(R.id.tvCalculation);
        }
    }
}