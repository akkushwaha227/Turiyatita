package com.example.turiyatita.Carousels;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.turiyatita.R;
import com.example.turiyatita.Second_Page_Audio_Activity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Third_carousels_adapter extends RecyclerView.Adapter<Third_carousels_adapter.MyViewHolder> {

    private List<Third_carousels_Helper> third_carousels_helpers_list;
    Context mcontext;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Third_photo);
            textView = itemView.findViewById(R.id.Third_textView);
        }
    }

    public Third_carousels_adapter(List<Third_carousels_Helper> third_carousels_helpers_list, Context context){
        this.third_carousels_helpers_list = third_carousels_helpers_list;
        mcontext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_third_carousels,parent,false);
        return new Third_carousels_adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Third_carousels_Helper third_carousels_helper = third_carousels_helpers_list.get(position);
        holder.imageView.setImageResource(third_carousels_helper.getImageView());
        holder.textView.setText(third_carousels_helper.getString());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext, Second_Page_Audio_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return third_carousels_helpers_list.size();
    }

}
