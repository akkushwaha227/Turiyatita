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
import androidx.viewpager.widget.PagerAdapter;

public class Fifth_carousels_Adapter extends PagerAdapter {

    private List<Fifth_carousels_Helper> fifth_carousels_helper;
    private LayoutInflater layoutInflater;
    private Context context;

    public Fifth_carousels_Adapter(List<Fifth_carousels_Helper> fifth_carousels_helper, Context context) {
        this.fifth_carousels_helper = fifth_carousels_helper;
        this.context = context;
    }

    @Override
    public int getCount() {
        return fifth_carousels_helper.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.activity_fifth_carousels, container, false);

        ImageView CoverImage;
        TextView textView;

        CoverImage = view.findViewById(R.id.CoverImage);
        textView = view.findViewById(R.id.Fifth_textView);
        CoverImage.setImageResource(fifth_carousels_helper.get(position).getImage());
        textView.setText(fifth_carousels_helper.get(position).getTextView());
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
