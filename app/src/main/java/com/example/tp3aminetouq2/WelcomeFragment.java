package com.example.tp3aminetouq2;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;


public class WelcomeFragment extends Fragment {
    private View rootView;
    private TextView txtWelcome;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_welcome, container, false);
        txtWelcome=rootView.findViewById(R.id.txtWelcome);
        Random random=new Random();
        int color=Color.argb(255,random.nextInt(256),random.nextInt(256),random.nextInt(256));
        rootView.setBackgroundColor(color);
        return  rootView ;
    }
}