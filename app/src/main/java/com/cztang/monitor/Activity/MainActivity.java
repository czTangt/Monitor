package com.cztang.monitor.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cztang.monitor.Adapter.OngoingAdapter;
import com.cztang.monitor.Domain.OngoingDomain;
import com.cztang.monitor.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    static {
//        System.loadLibrary("monitor");
//    }

    private ActivityMainBinding binding;
    private RecyclerView.Adapter adapterOngoing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<OngoingDomain> items = new ArrayList<>();
        items.add(new OngoingDomain("1Food App", "Jun 12, 2023", 50, "ongoing1"));
        items.add(new OngoingDomain("2Food App", "Jun 12, 2023", 50, "ongoing1"));
        items.add(new OngoingDomain("3Food App", "Jun 12, 2023", 50, "ongoing1"));
        items.add(new OngoingDomain("4Food App", "Jun 12, 2023", 50, "ongoing1"));
        binding.viewOngoing.setLayoutManager(new GridLayoutManager(this, 2));
        adapterOngoing = new OngoingAdapter(items);
        binding.viewOngoing.setAdapter(adapterOngoing);
    }

}