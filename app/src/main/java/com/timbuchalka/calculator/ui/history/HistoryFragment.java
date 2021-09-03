package com.timbuchalka.calculator.ui.history;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.timbuchalka.calculator.Calculation;
import com.timbuchalka.calculator.DatabaseHelper;
import com.timbuchalka.calculator.RecyclerAdapter;
import com.timbuchalka.calculator.R;
import com.timbuchalka.calculator.databinding.FragmentHistoryBinding;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {

    private HistoryViewModel historyViewModel;
    private FragmentHistoryBinding binding;

    RecyclerView mRecyclerView;
    DatabaseReference mDatabaseReference;
    RecyclerAdapter mRecyclerAdapter;
    ArrayList<Calculation> mList;
    DatabaseHelper db;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        historyViewModel =
                new ViewModelProvider(this).get(HistoryViewModel.class);

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mRecyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Calculation");
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        db = new DatabaseHelper(getActivity());
        mList = new ArrayList<Calculation>();
        mList = (ArrayList<Calculation>) db.getAllData();

        mRecyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);


        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setLayoutManager(mRecyclerView.getLayoutManager());

        mRecyclerAdapter = new RecyclerAdapter(getContext(), mList);
        mRecyclerView.setAdapter(mRecyclerAdapter);

        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}