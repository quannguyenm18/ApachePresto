package com.example.materialdl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.materialdl.adapter.WedAdapter;
import com.example.materialdl.model.Url;

import java.util.ArrayList;

public class WedViewActivity extends AppCompatActivity {
    /* private WebView webView;*/

    int position = -1;
    private TextView tv_count;
    WedAdapter wedAdapter;
    ArrayList<Url> urlArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wed_view);
        position = getIntent().getIntExtra("POSITION", -1);
        initView();

    }
  /* private void init(){
        webView = (WebView)findViewById(R.id.wedview);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/wed/0.html");
        webView.requestFocus();

    }*/


    public void initView() {
        tv_count = findViewById(R.id.tv_count);

        RecyclerView recyclerView = findViewById(R.id.rv_display);
        recyclerView.setHasFixedSize(true);//tối ưu hóa
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        urlArrayList = new ArrayList<>();
        urlArrayList.add(new Url("file:///android_asset/wed/0.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/1.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/2.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/3.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/4.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/5.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/6.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/7.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/8.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/9.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/10.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/11.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/12.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/13.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/14.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/15.html"));
        urlArrayList.add(new Url("file:///android_asset/wed/16.html"));
        tv_count.setText((position + 1) + "/" + (urlArrayList.size() - 1) + "");
        wedAdapter = new WedAdapter(urlArrayList.get(position).getUrl(), getApplicationContext());
        recyclerView.setAdapter(wedAdapter);

    }

    public void ButtonPre(View view) {
       if (position > 0){
           position--;
           tv_count.setText((position + 1) + "/" + (urlArrayList.size() - 1) + "");
           wedAdapter.setUrls(urlArrayList.get(position).getUrl());
       }
    }

    public void ButtonNext(View view) {
      if (position < 15){
          position++;
          tv_count.setText((position + 1) + "/" + (urlArrayList.size() - 1) + "");
          wedAdapter.setUrls(urlArrayList.get(position).getUrl());
      }
    }
}
