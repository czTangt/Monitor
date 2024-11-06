package com.cztang.monitor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.cztang.monitor.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    static {
//        System.loadLibrary("monitor");
//    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

}