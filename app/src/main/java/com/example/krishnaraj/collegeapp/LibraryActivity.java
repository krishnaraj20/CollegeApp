package com.example.krishnaraj.collegeapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LibraryActivity extends Activity

{
    ListView lv;
    SearchView sv;
    String[] books = {"Artificial Intelligence", "Database Management System", "Java", "Operating System", "Mobile Computing", "Heat Mass Transfer", "Total Quality Management", "Circuit Therory", "Analog and Digital Communication", "Basic civil Mechanics", "Engineering Physics", "Engineering Physics", "OOAD", "Compiler design", "C", "C++", "Oracle Database"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

        setContentView(R.layout.activity_library);
        sv = (SearchView) findViewById(R.id.searchview);
        lv = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, books);
        lv.setTextFilterEnabled(true);
        lv.setAdapter(adapter);
        setupSearchView();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Book is Available", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setupSearchView() {
        sv.setIconifiedByDefault(false);

        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("Search Here");

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

    }


}
