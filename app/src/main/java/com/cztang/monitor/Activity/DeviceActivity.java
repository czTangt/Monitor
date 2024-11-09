package com.cztang.monitor.Activity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cztang.monitor.Adapter.DeviceAdapter;
import com.cztang.monitor.Domain.DeviceDomain;
import com.cztang.monitor.databinding.ActivityDeviceBinding;

import java.util.ArrayList;


public class DeviceActivity extends AppCompatActivity {
    ActivityDeviceBinding binding;
    private RecyclerView.Adapter adapterDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDeviceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerViewDevice();
    }

    private void initRecyclerViewDevice() {
        ArrayList<DeviceDomain> items = new ArrayList<>();
        items.add(new DeviceDomain("1", "2"));
        items.add(new DeviceDomain("3", "2"));
        items.add(new DeviceDomain("4", "2"));

        binding.viewSoftwareDevice.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterDevice = new DeviceAdapter(items);
        binding.viewSoftwareDevice.setAdapter(adapterDevice);
    }
}