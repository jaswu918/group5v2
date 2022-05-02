package com.example.reminderapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class reminderAdapter extends RecyclerView.Adapter<reminderAdapter.ViewHolder> {

    Context context;
    private ArrayList rDates, rTitles, rNotes;

    reminderAdapter(Context context, ArrayList rDates, ArrayList rTitles, ArrayList rNotes) {
        this.context = context;
        this.rDates = rDates;
        this.rTitles = rTitles;
        this.rNotes = rNotes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view=layoutInflater.inflate(R.layout.reminder_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.reminderDate.setText(String.valueOf(rDates.get(position)));
        holder.reminderTitle.setText(String.valueOf(rTitles.get(position)));
        holder.reminderNote.setText(String.valueOf(rNotes.get(position)));
    }

    @Override
    public int getItemCount() {
        return rDates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView reminderDate, reminderTitle, reminderNote;
        LinearLayout reminderLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reminderDate=itemView.findViewById(R.id.reminderDate);
            reminderTitle=itemView.findViewById(R.id.reminderTitle);
            reminderNote=itemView.findViewById(R.id.reminderNote);
            reminderLayout=itemView.findViewById(R.id.reminderLayout);
        }
    }
}
