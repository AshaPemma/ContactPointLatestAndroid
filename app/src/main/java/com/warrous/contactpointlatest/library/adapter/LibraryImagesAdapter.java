package com.warrous.contactpointlatest.library.adapter;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.dashboard.DashBoardActivity;
import com.warrous.contactpointlatest.library.LibraryActivity;

import java.util.ArrayList;

public class LibraryImagesAdapter extends RecyclerView.Adapter<LibraryImagesAdapter.ImageVH>  {

    LibraryActivity activity;
    int deleteUser;
   // private ArrayList<Attachment> mShareImages = null;
    private ImageVH.ClickListener clickListener;


    public LibraryImagesAdapter(LibraryActivity activity, ImageVH.ClickListener clickListener) {
       // this.mShareImages = mShareImages;
        this.clickListener = clickListener;
        this.activity = activity;
    }


//    public void refreshData(ArrayList<Attachment> mShareImages) {
//        this.mShareImages = mShareImages;
//        this.notifyDataSetChanged();
//
//    }


    @Override
    public LibraryImagesAdapter.ImageVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_library_item, null);

        // create ViewHolder
        return new ImageVH(itemLayoutView, clickListener);


    }

    @Override
    public void onBindViewHolder(final ImageVH holder, final int position) {









    }


    @Override
    public int getItemCount() {
       // return mShareImages == null ? 0 : mShareImages.size();
        return 15;
    }

    public static class ImageVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView ivImage;
        ImageView ivDelete;
        private ImageVH.ClickListener listener;

        public ImageVH(View itemView) {
            super(itemView);


        }

        public ImageVH(View itemLayoutView, ImageVH.ClickListener listener) {
            super(itemLayoutView);
            this.listener = listener;
//            ivImage = itemView.findViewById(R.id.iv_invoice_copy);
//            ivDelete = itemView.findViewById(R.id.iv_image_delete);

            itemLayoutView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClicked(getAdapterPosition());
            }
        }

        public interface ClickListener {
            void onItemClicked(int position);
        }

    }



}
