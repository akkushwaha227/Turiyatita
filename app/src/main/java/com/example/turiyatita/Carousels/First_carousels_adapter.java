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
import androidx.viewpager.widget.PagerAdapter;


public class First_carousels_adapter extends PagerAdapter {

    private List<First_carousels_Helper> first_carousels_helpers_list;
    Context context;
    private LayoutInflater layoutInflater;

    public First_carousels_adapter(List<First_carousels_Helper> first_carousels_helpers_list, Context context) {
        this.first_carousels_helpers_list = first_carousels_helpers_list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return first_carousels_helpers_list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_first_carousels, container, false);

        ImageView CoverImage;
        TextView textView;

        CoverImage = view.findViewById(R.id.first_poster);
        textView = view.findViewById(R.id.First_textView);
        CoverImage.setImageResource(first_carousels_helpers_list.get(position).getImage());
        textView.setText(first_carousels_helpers_list.get(position).getString());
        container.addView(view, 0);
        CoverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, Second_Page_Audio_Activity.class));
            }
        });

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
