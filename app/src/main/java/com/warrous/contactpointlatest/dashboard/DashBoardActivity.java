package com.warrous.contactpointlatest.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.accountpreferences.AccountPreferencesActivity;
import com.warrous.contactpointlatest.consumers.ConsumersActivity;
import com.warrous.contactpointlatest.dashboard.adapter.ITopBarAdapter;
import com.warrous.contactpointlatest.dashboard.adapter.SentEmailsAdapter;
import com.warrous.contactpointlatest.dashboard.adapter.TopBarAdapter;
import com.warrous.contactpointlatest.dashboard.models.DashBoardTopBarPannel;
import com.warrous.contactpointlatest.framework.ActivityUtils;
import com.warrous.contactpointlatest.framework.Utility;
import com.warrous.contactpointlatest.library.LibraryActivity;
import com.warrous.contactpointlatest.library.adapter.LibraryImagesAdapter;
import com.warrous.contactpointlatest.library.adapter.LibraryImagesListViewAdapter;
import com.warrous.contactpointlatest.login.LoginActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DashBoardActivity  extends AppCompatActivity implements ITopBarAdapter,SentEmailsAdapter.ImageVH.ClickListener,LibraryImagesAdapter.ImageVH.ClickListener,LibraryImagesListViewAdapter.ImageVH.ClickListener{
    @BindView(R.id.nav_view)
    public NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    public DrawerLayout drawer;
    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.tvTopBarItem)
    TextView tvTopBarItem;
    @BindView(R.id.tv_header)
    TextView tvHeader;
    @BindView(R.id.recyclerViewTopBar)
    RecyclerView recyclerViewTopBar;
    ITopBarAdapter iITopBarAdapter;
    int previous = 0;
    List<DashBoardTopBarPannel> listTopBarPanel = Utility.getTopBarPanelElements(0);
    @BindView(R.id.llTopBarPanel)
    LinearLayout llTopBarPanel;
    @BindView(R.id.rv_emails)
    RecyclerView rvEmails;
    @BindView(R.id.llMainHead)
            LinearLayout llMainHead;
    TopBarAdapter topBarAdapter;
    SentEmailsAdapter sentEmailsAdapter;
    BottomSheetDialog bottomSheetDialog;
    boolean showingFirst = true;
    LibraryImagesListViewAdapter libraryImagesListViewAdapter;
    LibraryImagesAdapter libraryImagesAdapter;

    @BindView(R.id.iv_password)
    ImageView ivGrid;






    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        Fresco.initialize(this);
        iITopBarAdapter = this;
        tvTopBarItem.setText(listTopBarPanel.get(0).title);
        recyclerViewTopBar.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTopBar.setAdapter(topBarAdapter = new TopBarAdapter(listTopBarPanel,this,iITopBarAdapter));
        rvEmails.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        sentEmailsAdapter=new SentEmailsAdapter(this,this);
        rvEmails.setAdapter(sentEmailsAdapter);
//        ivGrid.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (showingFirst == true) {
//                    ivGrid.setBackgroundResource(R.drawable.ic_squares);
//                    setListView();
//                    showingFirst = false;
//                } else {
//                    ivGrid.setBackgroundResource(R.drawable.ic_list_image);
//                    //image1.setTag(70);
//                    setGridView();
//                    showingFirst = true;
//                }
//
//            }
//        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                drawer.closeDrawers();
                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_consumers:
                        ActivityUtils.startActivity(DashBoardActivity.this, ConsumersActivity.class, null);
                        break;
//                    case R.id.nav_warranty:
//                        ActivityUtils.startActivity(DashBoardActivity.this, WarrantyTipsActivity.class, null);
//                        break;
                    case R.id.nav_emails:
//                        tvHeader.setText("Emails");
//                        tvTopBarItem.setVisibility(View.VISIBLE);
//                        recyclerViewTopBar.setVisibility(View.VISIBLE);
//                        llMainHead.setVisibility(View.VISIBLE);
//                        ivGrid.setBackgroundResource(R.drawable.ic_filter);
//                        setEmails();


                       // if (PermissionUtils.isUserLogedIn(getApplicationContext())) {
                           // ActivityUtils.startActivity(DashBoardActivity.this, .class, null);
//                        } else {
//                            AlertUtil.showSignInDialog(DashBoardActivity.this);
//                        }
                        break;
                    case R.id.nav_help:
//                        if (PermissionUtils.isUserLogedIn(getApplicationContext())) {
//                            if (DataManager.getInstance().getMyProducts(getContext()) != null && !DataManager.getInstance().getMyProducts(getContext()).isEmpty()) {
//                                ActivityUtils.startActivity(DashBoardActivity.this, ReviewListActivity.class, null);
//                            } else {
//                                AndroidUtil.showSnackBarSafe(DashBoardActivity.this, "No Products to add a Review");
//                            }
//                        } else {
//                            ActivityUtils.startActivity(DashBoardActivity.this, ReviewListActivity.class, null);
//
//                        }
//                        return true;
                        break;
                    case R.id.nav_library:
//                        tvHeader.setText("Library");
//                        tvTopBarItem.setVisibility(View.GONE);
//                        recyclerViewTopBar.setVisibility(View.GONE);
//                        llMainHead.setVisibility(View.GONE);
//                        if (showingFirst) {
//                            setGridView();
//                        } else {
//
//                            setListView();
//                        }

                       ActivityUtils.startActivity(DashBoardActivity.this, LibraryActivity.class, null);
                        return true;
                    case R.id.nav_settings:
                        ActivityUtils.startActivity(DashBoardActivity.this, AccountPreferencesActivity.class, null);
                        return true;
//                    case R.id.nav_about_us:
//                        ActivityUtils.startActivity(DashBoardActivity.this, AboutUsActivity.class, null);
//                        return true;
//                    case R.id.nav_settings:
//                        ActivityUtils.startActivity(DashBoardActivity.this, SettingsActivity.class, null);
//                        break;
                    case R.id.nav_signout:
                        ActivityUtils.startActivity(DashBoardActivity.this,LoginActivity.class,null);
                       // if (!PermissionUtils.isUserLogedIn(getApplicationContext())) {
//                            PreferenceManager.storeValue(DashBoardActivity.this, PreferenceManager.KEY_FIRST_LOGIN, true);
//                            ActivityUtils.startActivity(DashBoardActivity.this, GetStartedActivity.class, null);
//                            finishAffinity();
//                        } else {
//                            String fcmToken = PreferenceManager.getStringValue(DashBoardActivity.this, PreferenceManager.KEY_FCM_TOKEN);
//                            PreferenceManager.clearAllPreferences(DashBoardActivity.this);
//                            PreferenceManager.storeValue(getContext(), PreferenceManager.KEY_FIRST_LOGIN, true);
//                            PreferenceManager.storeValue(getContext(), PreferenceManager.KEY_FCM_TOKEN, fcmToken);
//                            ActivityUtils.startActivity(DashBoardActivity.this, SignInActivity.class, null);
//                            finishAffinity();
//                        }

                }

                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer,toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
        tvTopBarItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llTopBarPanel.setVisibility(View.VISIBLE);

            }

        });

        llTopBarPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llTopBarPanel.setVisibility(View.GONE);
            }


        });

    }

    @OnClick(R.id.iv_add_user)
    public void onClickNewEmail(){
        ActivityUtils.startActivity(this,NewEmailActivity.class,null);
    }

    public void setGridView() {
        ivGrid.getLayoutParams().height = 36;
        ivGrid.getLayoutParams().width = 36;
        ivGrid.setBackgroundResource(R.drawable.ic_list_image);
        tvHeader.setText("Library");
        rvEmails.setLayoutManager(
                new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false));

     //   libraryImagesAdapter = new LibraryImagesAdapter(DashBoardActivity.this, null);
        rvEmails.setAdapter(libraryImagesAdapter);
    }
    public void setEmails(){
        tvTopBarItem.setText(listTopBarPanel.get(0).title);
        recyclerViewTopBar.setLayoutManager(new LinearLayoutManager(DashBoardActivity.this));
        recyclerViewTopBar.setAdapter(topBarAdapter = new TopBarAdapter(listTopBarPanel,DashBoardActivity.this,iITopBarAdapter));
        rvEmails.setLayoutManager(new LinearLayoutManager(DashBoardActivity.this, LinearLayoutManager.VERTICAL, false));
        sentEmailsAdapter=new SentEmailsAdapter(DashBoardActivity.this,this);
        rvEmails.setAdapter(sentEmailsAdapter);
    }

    public void setListView() {
        rvEmails.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
       // libraryImagesListViewAdapter = new LibraryImagesListViewAdapter(this, null);
        rvEmails.setAdapter(libraryImagesListViewAdapter);
    }

    @Override
    public void itemClick(DashBoardTopBarPannel topBarPanel, int position) {


        llTopBarPanel.setVisibility(View.GONE);
        if(previous == -1)
        {
            listTopBarPanel.get(position).isSelected = true;
        }
        else
        {
            listTopBarPanel.get(previous).isSelected = false;
            listTopBarPanel.get(position).isSelected = true;
        }
        previous = position;
        tvTopBarItem.setText(topBarPanel.title);
        topBarAdapter.notifyDataSetChanged();
    }

    public void showBottomSheet() {
        if (bottomSheetDialog == null) {
            bottomSheetDialog = new BottomSheetDialog(this);
            View view = LayoutInflater.from(this).inflate(R.layout.emails_bottom_sheet, null);
//            view.findViewById(R.id.tv_pdf).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onClickPdf();
//                }
//            });
//
//            view.findViewById(R.id.tv_image_from_gallery).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onClickGalleryImage();
//                }
//            });
//
//            view.findViewById(R.id.tv_take_photo).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    onClickCamera();
//                }
//            });
            bottomSheetDialog.setContentView(view);

        }

        bottomSheetDialog.show();
    }

    private void dismissBottomSheet() {
        if (bottomSheetDialog != null) {
            bottomSheetDialog.dismiss();
        }
    }

    @Override
    public void onItemClicked(int position) {
        showBottomSheet();
    }

    @Override
    public void onItemClickedList(int position) {

    }
}
