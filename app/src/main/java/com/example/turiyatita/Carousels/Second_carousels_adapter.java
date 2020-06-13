package com.example.turiyatita.Carousels;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.turiyatita.R;
import com.example.turiyatita.Second_Page_Audio_Activity;

import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class Second_carousels_adapter extends RecyclerView.Adapter<Second_carousels_adapter.MyViewHolder> {

    private List<Second_carousels_Helper> second_carousels_helpers_list;
    Context mcontext;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private CircleImageView circleImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.Second_Text);
            circleImageView = itemView.findViewById(R.id.Second_photo);
        }
    }

    public Second_carousels_adapter(List<Second_carousels_Helper> second_carousels_helpers_list, Context context){
        this.second_carousels_helpers_list = second_carousels_helpers_list;
        mcontext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_second_carousels,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        final Second_carousels_Helper second_carousels_helper = second_carousels_helpers_list.get(position);
        holder.circleImageView.setImageResource(second_carousels_helper.getCircleImage());
        holder.textView.setText(second_carousels_helper.getText());

        holder.circleImageView.setOnClickListener(new View.OnClickListener() {
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
        return second_carousels_helpers_list.size();
    }


}
