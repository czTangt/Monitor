package com.cztang.monitor.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cztang.monitor.Adapter.ArchiveAdapter;
import com.cztang.monitor.Adapter.TeamAdapter;
import com.cztang.monitor.Domain.TeamDomain;
import com.cztang.monitor.databinding.ActivityProfileBinding;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    ActivityProfileBinding binding;
    private RecyclerView.Adapter adapterArchive, adapterTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerViewArchive();
        initRecyclerViewTeam();
    }

    private void initRecyclerViewTeam() {
        ArrayList<TeamDomain> items = new ArrayList<>();
        items.add(new TeamDomain("1", "2"));
        items.add(new TeamDomain("3", "2"));
        items.add(new TeamDomain("4", "2"));
        items.add(new TeamDomain("5", "2"));

        binding.viewTeam.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterTeam = new TeamAdapter(items);
        binding.viewTeam.setAdapter(adapterTeam);
    }

    private void initRecyclerViewArchive() {
        ArrayList<String> items = new ArrayList<>();
        items.add("UI/UX ScreenShot");
        items.add("Kotlin Source Code");
        items.add("Source Code");

        binding.viewArchive.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapterArchive = new ArchiveAdapter(items);
        binding.viewArchive.setAdapter(adapterArchive);

    }
}