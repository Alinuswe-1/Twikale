package com.example.twikale.Views;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.twikale.R;
import com.google.firebase.Timestamp;

import java.util.ArrayList;

import Adapters.PostAdapter;
import Models.Post;

public class HomeFragment extends Fragment {
    Button btn1,btn2,btn3,btn4;
    RecyclerView recyclerView;

    ArrayList<Post> posts;

    PostAdapter adapter;

    public HomeFragment() {
        // Required empty public constructor
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.home_recyclerView);
        posts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            posts.add(new Post("","Copperbelt Provice","Alinuswwe","Mufulira", Timestamp.now(),4800));
        }
        adapter = new PostAdapter(posts, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }

}