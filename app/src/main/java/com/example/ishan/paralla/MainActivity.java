package com.example.ishan.paralla;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements AbsListView.OnScrollListener {

    private int lastTopValue = 0;


    private ListView listView;
    private ImageView backgroundImage;
    private ArrayAdapter adapter;
    String[] news={"Meister's Deli","AJA Fresh, Grilled, Healthy","Boston Bites","Fraiche","Bon Nourriture",
            "Gusto","Foodsbury","Get Desserted","arbitrary","to","increase","the","length","of","list",":P"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);


        adapter = new ArrayAdapter(this, R.layout.list_row, news);
        listView.setAdapter(adapter);

        // inflate custom header and attach it to the list
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup header = (ViewGroup) inflater.inflate(R.layout.custom_header, listView, false);
        listView.addHeaderView(header, null, false);

        // we take the background image and button reference from the header
        backgroundImage = (ImageView) header.findViewById(R.id.listHeaderImage);
        listView.setOnScrollListener(this);
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Rect rect = new Rect();
        backgroundImage.getLocalVisibleRect(rect);
        if (lastTopValue != rect.top) {
            lastTopValue = rect.top;
            backgroundImage.setY((float) (rect.top / 2.0));
        }
    }

}