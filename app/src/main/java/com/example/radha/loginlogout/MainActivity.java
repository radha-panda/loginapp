package com.example.radha.loginlogout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnLogout;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.lo_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        TextAdapter textAdapter = new TextAdapter();
        recyclerView.setAdapter(textAdapter);


        List<String> stringList = new ArrayList<>();
        stringList.add("cakes");
        stringList.add("chocolates");
        stringList.add("oranges");
        stringList.add("strawberry");
        stringList.add("blackcurrent");
        stringList.add("rasaberry");
        stringList.add("android");

        List<String> list = new ArrayList<>();
        list.addAll(stringList);
        list.addAll(stringList);
        list.addAll(stringList);
        list.addAll(stringList);


        textAdapter.setItems(list);


        session = new Session(this);
        if (!session.loggedin()) {
            logout();
        }
        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }

    private void logout() {
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(MainActivity.this, loginactivity.class));
    }
}