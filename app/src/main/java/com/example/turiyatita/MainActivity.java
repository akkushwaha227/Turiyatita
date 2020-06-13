package com.example.turiyatita;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.turiyatita.Carousels.Fifth_carousels_Adapter;
import com.example.turiyatita.Carousels.Fifth_carousels_Helper;
import com.example.turiyatita.Carousels.First_carousels_Helper;
import com.example.turiyatita.Carousels.First_carousels_adapter;
import com.example.turiyatita.Carousels.Fourth_carousels_Helper;
import com.example.turiyatita.Carousels.Fourth_carousels_adapter;
import com.example.turiyatita.Carousels.Second_carousels_Helper;
import com.example.turiyatita.Carousels.Second_carousels_adapter;
import com.example.turiyatita.Carousels.Third_carousels_Helper;
import com.example.turiyatita.Carousels.Third_carousels_adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //region First Carousels variable used
    private ViewPager viewPager_first;
    private com.example.turiyatita.Carousels.First_carousels_adapter First_carousels_adapter;
    private List<First_carousels_Helper> first_carousels_helper_list = new ArrayList<>();
    //endregion

    //region Second Carousels variable used
    private List<Second_carousels_Helper> second_carousels_helpers_list = new ArrayList<>();
    private RecyclerView recyclerView;
    private Second_carousels_adapter second_carousels_adapter;
    //endregion

    //region Third Carousels variable used
    private List<Third_carousels_Helper> third_carousels_helpers_list = new ArrayList<>();
    private RecyclerView recyclerViewNetflix;
    private Third_carousels_adapter third_carousels_adapter;
    //endregion

    //region Forth Carousels variable used
    private List<Fourth_carousels_Helper> fourth_carousels_helpers_list = new ArrayList<>();
    private RecyclerView recyclerViewNetflix_2;
    private Fourth_carousels_adapter fourth_carousels_adapter;
    //endregion

    //region Fifth Carousels variable used
    private ViewPager viewPager;
    private Fifth_carousels_Adapter fifth_carousels_adapter;
    private List<Fifth_carousels_Helper> fifth_carousels_helper = new ArrayList<>();
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        each_carousels_preparedData();


        //region First Carousels Data Binder
        First_carousels_adapter = new First_carousels_adapter(first_carousels_helper_list,this);
        viewPager_first = findViewById(R.id.viewPager_Poster);
        viewPager_first.setAdapter(First_carousels_adapter);
        //endregion

        //region Second Carousels Data Binder
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        second_carousels_adapter = new Second_carousels_adapter(second_carousels_helpers_list, getApplicationContext());
        recyclerView.setAdapter(second_carousels_adapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        //endregion

        //region Third Carousels Data Binder
        recyclerViewNetflix = (RecyclerView)findViewById(R.id.recyclerViewNetflix);
        third_carousels_adapter = new Third_carousels_adapter(third_carousels_helpers_list, getApplicationContext());
        recyclerViewNetflix.setAdapter(third_carousels_adapter);
        RecyclerView.LayoutManager layoutManagerNetflix = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewNetflix.setLayoutManager(layoutManagerNetflix);
        //endregion

        //region Forth Carousels Data Binder
        recyclerViewNetflix_2 = (RecyclerView)findViewById(R.id.recyclerViewNetflix_2);
        fourth_carousels_adapter = new Fourth_carousels_adapter(fourth_carousels_helpers_list, getApplicationContext());
        recyclerViewNetflix_2.setAdapter(fourth_carousels_adapter);
        RecyclerView.LayoutManager layoutManagerNetflix_2 = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewNetflix_2.setLayoutManager(layoutManagerNetflix_2);
        //endregion

        //region Fifth Carousels Data Binder
        fifth_carousels_adapter = new Fifth_carousels_Adapter(fifth_carousels_helper,this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(fifth_carousels_adapter);
        viewPager.setPadding(130,0,130,0);
        //endregion

    }

    private void each_carousels_preparedData() {
        for(int i = 0; i<20; i++) {
            first_carousels_helper_list.add(new First_carousels_Helper(R.drawable.tree, "Sunset and the Tree"));
            second_carousels_helpers_list.add(new Second_carousels_Helper(R.drawable.tree, "Sunset"));
            third_carousels_helpers_list.add(new Third_carousels_Helper(R.drawable.tree, "Tree"));
            fourth_carousels_helpers_list.add(new Fourth_carousels_Helper(R.drawable.tree,"Sunset"));
            fifth_carousels_helper.add(new Fifth_carousels_Helper(R.drawable.tree,"Sunset and the tree"));
        }

    }

}
