package com.example.turiyatita.Carousels;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.turiyatita.R;
import com.example.turiyatita.Second_Page_Audio_Activity;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Fourth_carousels_adapter extends RecyclerView.Adapter<Fourth_carousels_adapter.MyViewHolder> {

    private List<Fourth_carousels_Helper> fourth_carousels_helpers_list;
    Context mcontext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.Fifth_photo);
            textView = itemView.findViewById(R.id.Fourth_textView);
        }
    }

    public Fourth_carousels_adapter(List<Fourth_carousels_Helper> fourth_carousels_helpers_list, Context mcontext) {
        this.fourth_carousels_helpers_list = fourth_carousels_helpers_list;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public Fourth_carousels_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fourth_carousels,parent,false);
        return new Fourth_carousels_adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Fourth_carousels_adapter.MyViewHolder holder, final int position) {
        final Fourth_carousels_Helper fourth_carousels_helper = fourth_carousels_helpers_list.get(position);
        holder.imageView.setImageResource(fourth_carousels_helper.getImageView());
        holder.textView.setText(fourth_carousels_helper.getString());

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
        return fourth_carousels_helpers_list.size();
    }

}
