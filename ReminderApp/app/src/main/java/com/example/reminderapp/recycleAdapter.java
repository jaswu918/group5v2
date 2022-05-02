package com.example.reminderapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycleAdapter extends RecyclerView.Adapter<recycleAdapter.MyViewHolder> {
    private Context context;
    private ArrayList date, quick_notes;

    recycleAdapter(Context context, ArrayList date, ArrayList quick_notes) {
        this.context = context;
        this.date = date;
        this.quick_notes = quick_notes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.quick_note_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.dateDisplay.setText(String.valueOf(date.get(position)));
        holder.qnDisplay.setText(String.valueOf(quick_notes.get(position)));
    }

    @Override
    public int getItemCount() {
        return date.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dateDisplay, qnDisplay;
        ImageView deleteQN;
        LinearLayout quickNotesLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            dateDisplay = itemView.findViewById(R.id.dateDisplay);
            qnDisplay = itemView.findViewById(R.id.qnDisplay);
            deleteQN = itemView.findViewById(R.id.deleteQN);
            quickNotesLayout = itemView.findViewById(R.id.quickNotesLayout);
        }
    }
}