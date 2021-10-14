package com.sdpd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.io.Serializable;
import java.util.List;

public class Word_Adapter extends RecyclerView.Adapter<Word_Adapter.Word_View_Holder>{

    private Context wContext;
    private List<Word_Item> wList;
    private Word_Database wordDatabase;
    private Word_Dao wordDao;
    private ItemClickHandler handler;

    public void setHandler(ItemClickHandler handler1)
    {
        this.handler = handler1;
    }

    public interface ItemClickHandler
    {
        public void onItemdeleted(Word_Item item, int position);
    }

    public Word_Adapter(Context context, List<Word_Item> word_List, Word_Database database, Word_Dao dao)
    {
        this.wContext = context;
        this.wList = word_List;
        this.wordDatabase = database;
        this.wordDao = dao;
    }

    @Override
    public Word_View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.word_card,parent,false);
        Word_View_Holder word_view_holder = new Word_View_Holder(v,wContext,handler,wList);
        return word_view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Word_View_Holder holder, int position) {
        Word_Item current_item = wList.get(position);
        holder.word.setText(current_item.getWord());
    }

    @Override
    public int getItemCount() {
        return wList.size();
    }

    public static class Word_View_Holder extends RecyclerView.ViewHolder
    {
        private TextView word;

        public Word_View_Holder(@NonNull View itemView, Context context12, ItemClickHandler handler12, List<Word_Item> items) {
            super(itemView);

            word = itemView.findViewById(R.id.card_word);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(context12);
                        builder.setTitle("Delete")
                        .setMessage("Do you want to delete this word?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                handler12.onItemdeleted(items.get(position),position);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.create().show();
                    }
                    return true;
                }
            });

        }
    }

}
