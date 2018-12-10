package com.warrous.contactpointlatest.dashboard.adapter;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.dashboard.DashBoardActivity;

import java.util.ArrayList;

public class SentEmailsAdapter extends RecyclerView.Adapter<
        SentEmailsAdapter.ImageVH>{
    //private ArrayList<Attachment> mShareImages;
    private ImageVH.ClickListener clickListener;
    DashBoardActivity dashBoardActivity;


    public SentEmailsAdapter(DashBoardActivity activity,ImageVH.ClickListener clickListener) {
        // this.mShareImages = mShareImages;
        this.clickListener = clickListener;
        this.dashBoardActivity = activity;
    }


//    public void refreshData(ArrayList<Attachment> mShareImages) {
//        this.mShareImages = mShareImages;
//        this.notifyDataSetChanged();
//    }


    @Override
    public ImageVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_sent_emails, null);

        // create ViewHolder
        return new ImageVH(itemLayoutView, clickListener);


    }

    @Override
    public void onBindViewHolder(ImageVH holder, final int position) {

//        final Attachment attachment = mShareImages.get(position);
//        if (attachment.getFilePath() != null) {
//            if(attachment.getFilePath().contains("pdf")) {
//                holder.ivImage.setImageResource(R.drawable.ic_pdf_green);
//            }else {
//
//                GlideManager.loadImage(addWarrantyActivity, attachment.getFilePath(), holder.ivImage);
//
//            }
//        } else {
//            if(attachment.getImageUrl().contains("pdf")){
//                holder.ivImage.setImageResource(R.drawable.ic_pdf_green);
//            }else {
//
//                GlideManager.loadImage(addWarrantyActivity, attachment.getImageUrl(), holder.ivImage);
//            }
//        }
//        holder.ivImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String filePath=null;
//                if (attachment != null) {
//                    Bundle bundle = new Bundle();
//                    if (attachment.getFilePath() != null && !attachment.getFilePath().isEmpty()) {
//                        bundle.putString("ImgUrl", attachment.getFilePath());
//                        filePath= attachment.getFilePath();
//                    } else {
//                        bundle.putString("ImgUrl", attachment.getImageUrl());
//                        filePath=attachment.getImageUrl();
//                    }
//
//
//                    if(filePath.contains("pdf")){
//                        loadPdf(filePath);
//
//                    }
//                    else
//                    {
//                        ActivityUtils.startActivity(addWarrantyActivity, FullImageActivty.class, bundle);
//
//                    }
//                }
//            }
//        });
//        holder.ivDelete.setVisibility(View.GONE);

    }




    @Override
    public int getItemCount() {
        // return mShareImages == null ? 0 : mShareImages.size();
        return 15;
    }

    public static class ImageVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ClickListener listener;


        ImageView ivImage;
        ImageView ivDelete;

        public ImageVH(View itemView) {
            super(itemView);


        }

        public ImageVH(View itemLayoutView, ClickListener listener) {
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
