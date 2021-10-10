package com.sdpd;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Note_Adatper extends RecyclerView.Adapter<Note_Adatper.Note_View_Holder> {

    private List<Note_Data> note_data;
    private Context context;

    public Note_Adatper(Context context1, List<Note_Data> note_data1)
    {
        this.context = context1;
        this.note_data = note_data1;
    }

    @Override
    public Note_View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_card,parent,false);
        return new Note_Adatper.Note_View_Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Note_View_Holder holder, int position) {
        Note_Data current_item = note_data.get(position);
        if(current_item.isCompleted())
        {
            holder.isSelected.setText("Completed");
        }
        else
        {
            holder.isSelected.setText("Not Completed");
        }
        holder.title.setText(current_item.getTitle());
        holder.details.setText(current_item.getDetails());
        holder.time.setText(current_item.getTime());
    }

    @Override
    public int getItemCount() {
        return note_data.size();
    }

    public class Note_View_Holder extends RecyclerView.ViewHolder
    {
        private TextView isSelected;
        private TextView title;
        private TextView details;
        private TextView time;

        public Note_View_Holder(@NonNull View itemView) {
            super(itemView);

            isSelected = itemView.findViewById(R.id.card_status);
            title = itemView.findViewById(R.id.card_heading);
            details = itemView.findViewById(R.id.card_details);
            time = itemView.findViewById(R.id.card_time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Note_Data data12 = note_data.get(getAdapterPosition());

                    Intent intent = new Intent(context, UpdateNote.class);
                    intent.putExtra("data1241", data12);

                    context.startActivity(intent);
                }
            });

        }
    }

}
