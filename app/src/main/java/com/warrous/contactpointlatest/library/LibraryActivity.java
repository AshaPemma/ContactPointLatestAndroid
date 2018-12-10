package com.warrous.contactpointlatest.library;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.framework.ActivityUtils;
import com.warrous.contactpointlatest.library.adapter.LibraryImagesAdapter;
import com.warrous.contactpointlatest.library.adapter.LibraryImagesListViewAdapter;
import com.warrous.contactpointlatest.library.model.GridSelected;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LibraryActivity extends AppCompatActivity implements LibraryImagesAdapter.ImageVH.ClickListener,LibraryImagesListViewAdapter.ImageVH.ClickListener {
    @BindView(R.id.rv_library_images)
    RecyclerView rvLibraryImages;
    @BindView(R.id.iv_password)
    ImageView ivGrid;

    @BindView(R.id.tv_header)
    TextView tvHeader;
    LibraryImagesAdapter libraryImagesAdapter;
    LibraryImagesListViewAdapter libraryImagesListViewAdapter;
    GridSelected gridSelected;
    boolean showingFirst = true;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.iv_add_user)
    ImageView ivAdd;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_grid_view);
        ButterKnife.bind(this);
        ivBack.setVisibility(View.VISIBLE);
        Fresco.initialize(this);
        gridSelected = new GridSelected();
        if (showingFirst) {
            setGridView();
        } else {

            setListView();
        }

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.startActivity(LibraryActivity.this,AddNewImageActivity.class,null);
            }
        });
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        ivGrid.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                gridSelected.setSelected(true);
//                if(gridSelected.isSelected()==true){
//                    ivGrid.setBackgroundResource(R.drawable.ic_squares);
//                }else{
//                    ivGrid.setBackgroundResource(R.drawable.ic_list_image);
//                }
//            }
//        });

        ivGrid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (showingFirst == true) {
                    ivGrid.setBackgroundResource(R.drawable.ic_squares);
                    setListView();
                    showingFirst = false;
                } else {
                    ivGrid.setBackgroundResource(R.drawable.ic_list_image);
                    //image1.setTag(70);
                    setGridView();
                    showingFirst = true;
                }

            }
        });
    }

    public void setGridView() {
        ivGrid.getLayoutParams().height = 36;
        ivGrid.getLayoutParams().width = 36;
        ivGrid.setBackgroundResource(R.drawable.ic_list_image);
        tvHeader.setText("Library");
        rvLibraryImages.setLayoutManager(
                new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));

        libraryImagesAdapter = new LibraryImagesAdapter(this, this);
        rvLibraryImages.setAdapter(libraryImagesAdapter);
    }

    public void setListView() {
        rvLibraryImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
       libraryImagesListViewAdapter = new LibraryImagesListViewAdapter(this, this);
        rvLibraryImages.setAdapter(libraryImagesListViewAdapter);
    }

    @Override
    public void onItemClicked(int position) {
    showFullImage();
    }

    @Override
    public void onItemClickedList(int position) {
        showFullImage();
    }
    public void showFullImage(){
        ActivityUtils.startActivity(this,FullImageActivity.class,null);
    }
}
