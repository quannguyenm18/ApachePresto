package com.example.materialdl.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdl.R;
import com.example.materialdl.model.Url;

import java.util.ArrayList;

public class WedAdapter extends RecyclerView.Adapter<WedAdapter.ViewHolder> {

    String urls;
    Context context;


    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
        notifyDataSetChanged();
    }

    public WedAdapter(String urls, Context context) {
        this.urls = urls;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview = layoutInflater.inflate(R.layout.item_row, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String url = urls;
        holder.webView.loadUrl(url);
        holder.webView.getSettings().setBuiltInZoomControls(true);
        holder.webView.getSettings().setSupportZoom(true);
        holder.webView.requestFocus();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        WebView webView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            webView = (WebView) itemView.findViewById(R.id.wedview);



        }
    }

}
