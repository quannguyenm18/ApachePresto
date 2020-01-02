package com.example.materialdl;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    private ListView lv_item;
    private String[] title={"0.APT- Home","1.APT- Overview","2.APT- Architecture","3.APT- Installation",
            "4.APT- Configuration Settings","5.APT- Administration Tools","6.APT-Basic SQL Operations",
            "7.APT- SQL Functions",
            "8.APT- MySQL Connector","9.APT- JMX Connector","10.APT- HIVE Connector","11.APT- KAFKA Connector",
            "12.APT- JDBC Interface","13.APT- Custom Function Application","14.APT- Quick Guide","15.APT- Useful Resources",
            "16.APT- Discuss Apache Presto"};

    private  SearchView searchView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_item = findViewById(R.id.lv_item);


        final ArrayAdapter adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,title);
        lv_item.setAdapter(adapter);
        searchView = (SearchView)findViewById(R.id.sv_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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


    public void danhsachfv(View view) {
        Intent intent= new Intent(getApplicationContext(),ListFavoritesActivity.class);
        startActivity(intent);
    }
}
