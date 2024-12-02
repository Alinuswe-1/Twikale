package com.example.twikale.Views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.twikale.R;

import java.util.ArrayList;

import Adapters.SettingsAdapter;
import Models.SettingModel;

public class SettingFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<SettingModel> settings;

    SettingsAdapter settingsAdapter;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        recyclerView = view.findViewById(R.id.settingsList);
        ArrayList<SettingModel> settings = new ArrayList<>();
        ArrayList<SettingModel> set = populateSettings(settings);

        settingsAdapter = new SettingsAdapter(set,getContext());

        recyclerView.setAdapter(settingsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
    public ArrayList<SettingModel> populateSettings(ArrayList<SettingModel> settings){
        settings.add(new SettingModel("Personal information"));
        settings.add(new SettingModel("Accessibility"));
        settings.add(new SettingModel("Notifications"));
        settings.add(new SettingModel("Support"));
        settings.add(new SettingModel("Terms of service"));
        settings.add(new SettingModel("log out"));


        return settings;
    }
}