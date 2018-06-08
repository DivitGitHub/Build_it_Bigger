package com.divitngoc.android.myandroidlib;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.ViewHolder> {
    private String[] jokes;

    public JokeAdapter(String[] jokes) {
        this.jokes = jokes;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvJoke;
        public ViewHolder(View v) {
            super(v);
            tvJoke = v.findViewById(R.id.tv_list_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvJoke.setText(jokes[position]);
    }

    @Override
    public int getItemCount() {
        return jokes.length;
    }
}
