package com.example.rafaelsmartin.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

/**
 * Created by Rafael S Martin on 25/07/2017.
 */

public class ActivityRecyclerListCardView extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    private List<Data> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_list_card_view);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.LstOpciones);
        data = createData();

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.notifyDataSetChanged();

        // set up the RecyclerView
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.LstOpciones);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new MyRecyclerViewAdapter(this, animalNames);
//        adapter.setClickListener(this);
//        recyclerView.setAdapter(adapter);
    }

    public List<Data> createData() {
        // data to populate the RecyclerView with
        List<Data> data = new ArrayList<>();
        data.add(new Data(R.mipmap.ic_launcher_round, "Ficha\nPrimera"));
        data.add(new Data(R.mipmap.ic_launcher, "Ficha segunda"));
        data.add(new Data(R.mipmap.ic_launcher, "Ficha\nTercera"));
        data.add(new Data(R.mipmap.ic_launcher, "Cuarta"));
        data.add(new Data(R.mipmap.ic_launcher, "Quinta"));
        data.add(new Data(R.mipmap.ic_launcher_round, "Sexta"));
        return data;
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItemId(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}