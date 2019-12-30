package com.example.materialdl;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.materialdl.model.Name;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ListView lv_item;
    private ArrayList<Name> nameArrayList;

    private ListAdapter listAdapter;
    private  SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_item = findViewById(R.id.lv_item);

        nameArrayList= new ArrayList<>();
        nameArrayList.add(new Name("0.APT-Home"));
        nameArrayList.add(new Name("1.APT-Overview"));
        nameArrayList.add(new Name("2.APT-Architecture"));
        nameArrayList.add(new Name("3.APT-Installation"));
        nameArrayList.add(new Name("4.APT-Configuration Settings"));
        nameArrayList.add(new Name("5.APT-Administration Tools"));
        nameArrayList.add(new Name("6.APT-Basic SQL Operations"));
        nameArrayList.add(new Name("7.APT-SQL Functions"));
        nameArrayList.add(new Name("8.APT-MySQL Connector"));
        nameArrayList.add(new Name("9.APT-JMX Connector"));
        nameArrayList.add(new Name( "10.APT- HIVE Connector"));
        nameArrayList.add(new Name( "11.APT-KAFKA Connector"));
        nameArrayList.add(new Name("12.APT-JDBC Interface"));
        nameArrayList.add(new Name("13.APT-Custom Function Application"));
        nameArrayList.add(new Name("14.APT-Quick Guide"));
        nameArrayList.add(new Name("15.APT-Useful Resources"));
        nameArrayList.add(new Name("16.APT-Discuss Apache Presto"));




         listAdapter= new com.example.materialdl.adapter.ListAdapter(this,R.layout.item_listview,nameArrayList);


          searchView = findViewById(R.id.sv_search);
          searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
              @Override
              public boolean onQueryTextSubmit(String text) {

                  return false;
              }

              @Override
              public boolean onQueryTextChange(String newText) {


                  return false;
              }
          });


        lv_item.setAdapter(listAdapter);
        lv_item.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent it = new Intent(MainActivity.this, WedViewActivity.class);
                it.putExtra("POSITION", position);
                startActivity(it);


            }
        });




    }


    public void ButtonShare(View view) {
        Intent shareIntent =   new Intent(android.content.Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_SUBJECT,"Insert Subject here");
        String app_url = "#";
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
        startActivity(Intent.createChooser(shareIntent, "Share"));

    }

    public void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit");
        builder.setMessage("\n" +
                "Do you want to close the application?");
        builder.setCancelable(false);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                    }
                });
          builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        onBackPressed();

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            event.startTracking();
            showAlertDialog();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
        super.onBackPressed();
    }


}
