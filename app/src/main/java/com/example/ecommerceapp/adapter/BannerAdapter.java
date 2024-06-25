package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ecommerceapp.R;
import com.example.ecommerceapp.databinding.CellHomeBannerItemBinding;
import com.example.ecommerceapp.model.homeBanner.BannerItem;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.holder> {

    Context context;
    List<BannerItem> bannerItems;

    public BannerAdapter(Context context, List<BannerItem> bannerItems) {
        this.context = context;
        this.bannerItems = bannerItems;
    }

    @NonNull
    @Override
    public BannerAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_home_banner_item, parent , false);
       return  new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerAdapter.holder holder, int position) {

        Glide.with(context)
                .load(bannerItems.get(position).getBannerImage())
                .into(holder.binding.bannerImage);


    }

    @Override
    public int getItemCount() {
        return bannerItems.size();
    }

    public class holder extends RecyclerView.ViewHolder{
        CellHomeBannerItemBinding binding;
        public holder(@NonNull View itemView) {
            super(itemView);
            binding = CellHomeBannerItemBinding.bind(itemView);
        }
    }
}
