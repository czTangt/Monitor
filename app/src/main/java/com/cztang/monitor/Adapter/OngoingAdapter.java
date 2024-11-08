package com.cztang.monitor.Adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.cztang.monitor.Domain.OngoingDomain;
import com.cztang.monitor.R;

import java.util.ArrayList;

public class OngoingAdapter extends RecyclerView.Adapter<OngoingAdapter.ViewHolder> {
    private ArrayList<OngoingDomain> items;
    private Context context;

    public OngoingAdapter(ArrayList<OngoingDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public OngoingAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflator = LayoutInflater.from(context).inflate(R.layout.viewholder_ongoing, parent, false);
        return new ViewHolder(inflator);
    }

    @Override
    public void onBindViewHolder(@NonNull OngoingAdapter.ViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.date.setText(items.get(position).getData());
        holder.progressBarPercent.setText(items.get(position).getProgressPercent() + "%");

        int drawaleResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable", context.getPackageName());

        Glide.with(context)
                .load(drawaleResourceId)
                .into(holder.pic);

        holder.progressBar.setProgress(items.get(position).getProgressPercent());

        // 配置 position 0 的背景颜色为深色，其他为浅色
        if (position == 0) {
            holder.layout.setBackgroundResource(R.drawable.dark_background);
            holder.title.setTextColor(context.getColor(R.color.white));
            holder.date.setTextColor(context.getColor(R.color.white));
            holder.progressText.setTextColor(context.getColor(R.color.white));
            holder.progressBarPercent.setTextColor(context.getColor(R.color.white));
            holder.pic.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_IN);
            holder.progressBar.setProgressTintList(ColorStateList.valueOf(context.getColor(R.color.white)));
        } else {
            holder.layout.setBackgroundResource(R.drawable.light_background);
            holder.title.setTextColor(context.getColor(R.color.dark_blue));
            holder.date.setTextColor(context.getColor(R.color.dark_blue));
            holder.progressText.setTextColor(context.getColor(R.color.dark_blue));
            holder.progressBarPercent.setTextColor(context.getColor(R.color.dark_blue));
            holder.pic.setColorFilter(ContextCompat.getColor(context, R.color.dark_blue), PorterDuff.Mode.SRC_IN);
            holder.progressBar.setProgressTintList(ColorStateList.valueOf(context.getColor(R.color.dark_blue)));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, date, progressBarPercent, progressText;
        ProgressBar progressBar;
        ImageView pic;
        ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.layout);
            progressText = itemView.findViewById(R.id.progressText_ongoing);
            title = itemView.findViewById(R.id.titleText_ongoing);
            date = itemView.findViewById(R.id.dataText_ongoing);
            progressBar = itemView.findViewById(R.id.progressBar_ongoing);
            progressBarPercent = itemView.findViewById(R.id.percentText_ongoing);
            pic = itemView.findViewById(R.id.pic_ongoing);
        }
    }
}
