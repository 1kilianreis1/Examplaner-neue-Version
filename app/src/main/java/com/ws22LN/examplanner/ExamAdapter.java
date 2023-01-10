package com.ws22LN.examplanner;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//Adapter für den Recycler in MainActivity
public class ExamAdapter extends RecyclerView.Adapter<ExamAdapter.ExamViewHolder>
{
    private final LayoutInflater mLayoutinflator;

    public ExamAdapter(LayoutInflater mLayoutInflator)
    {
        this.mLayoutinflator =mLayoutInflator;
    }

    @NonNull
    @Override
    public ExamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view=mLayoutinflator.inflate(R.layout.list_item, parent, false);
        return new ExamViewHolder(this, view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamViewHolder holder, int position)
    {
        Exam e = ExamCollection.allExams.get(position);
        holder.setDate(e.getDate());
        holder.setTime(e.getTime());
        holder.setSubject(e.getSubject());
        holder.setRoom(e.getRoom());
        holder.setComment(e.getComment());
    }

    @Override
    public int getItemCount() {
        return ExamCollection.allExams.size();
    }

    public class ExamViewHolder extends RecyclerView.ViewHolder
    {
        final ExamAdapter adapter;
        TextView date;
        TextView time;
        TextView subject;
        TextView room;
        TextView comment;


        public ExamViewHolder(ExamAdapter examAdapter, View view)
        {
            super(view);
            this.adapter=examAdapter;
            this.date=view.findViewById(R.id.textViewDate);
            this.time=view.findViewById(R.id.textViewTime);
            this.subject=view.findViewById(R.id.textViewSubject);
            this.room=view.findViewById(R.id.textViewRoom);
            this.comment=view.findViewById(R.id.textViewComment);

            itemView.findViewById(R.id.button_Edit).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Log.d ("test", "onClick: Edit Exam "+)
                }
            });
        }

        public void setDate(String date) {this.date.setText(date);}
        public void setTime(String time) {this.time.setText(time);}
        public void setSubject(String subject) {this.subject.setText(subject);}
        public void setRoom(String room) {this.room.setText(room);}
        public void setComment(String comment) {this.comment.setText(comment);}
    }
}
