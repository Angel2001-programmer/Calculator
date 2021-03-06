package com.angelwitchell.calculator.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.angelwitchell.calculator.Calculation;
import com.angelwitchell.calculator.DatabaseHelper;
import com.angelwitchell.calculator.R;
import com.angelwitchell.calculator.RecyclerAdapter;
import com.angelwitchell.calculator.databinding.FragmentHistoryBinding;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerAdapter mRecyclerAdapter;
    ArrayList<Calculation> mList;
    DatabaseHelper db;
    private FragmentHistoryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HistoryViewModel historyViewModel = new ViewModelProvider(this).get(HistoryViewModel.class);

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mRecyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        db = new DatabaseHelper(getActivity());
        mList = new ArrayList<>();
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