package com.cztang.monitor.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cztang.monitor.Adapter.OngoingAdapter;
import com.cztang.monitor.Domain.OngoingDomain;
import com.cztang.monitor.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private RecyclerView.Adapter adapterOngoing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();
        ComponentsInit();
        bottomNavigationInit();
    }

    private void ComponentsInit() {
        binding.ComponentTextMain.setText("Hello World!");
    }

    private void bottomNavigationInit() {
        binding.profileBtnMain.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ProfileActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<OngoingDomain> items = new ArrayList<>();
        items.add(new OngoingDomain("Device Information", "Nov 8, 2024", 50, "ongoing1"));
        items.add(new OngoingDomain("2Food App", "Jun 12, 2023", 60, "ongoing4"));
        items.add(new OngoingDomain("3Food App", "Jun 12, 2023", 25, "ongoing3"));
        items.add(new OngoingDomain("4Food App", "Jun 12, 2023", 80, "ongoing2"));
        binding.viewOngoing.setLayoutManager(new GridLayoutManager(this, 2));
        adapterOngoing = new OngoingAdapter(items);
        binding.viewOngoing.setAdapter(adapterOngoing);
    }

}