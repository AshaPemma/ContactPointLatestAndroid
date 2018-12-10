package com.warrous.contactpointlatest.onboardingviewpager;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.dashboard.DashBoardActivity;
import com.warrous.contactpointlatest.framework.ActivityUtils;
import com.warrous.contactpointlatest.login.LoginActivity;

public class OnBoardingViewPagerActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView[] indicators;
    private SectionsPagerAdapter mSectionsPagerAdapter;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private int[] colorList;
    private ArgbEvaluator evaluator;

    private Button btnSkip;
    private Button btnFinish;
    private Button btnNext;
    private TextView tvLogin;
    TextView tvName;
    private int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pager_test);

        btnSkip = (Button) findViewById(R.id.footer_control_button_skip);
        btnFinish = (Button) findViewById(R.id.footer_control_button_finish);
        btnNext =  findViewById(R.id.footer_control_button_next);
        tvName=findViewById(R.id.section_label);
        tvLogin=findViewById(R.id.tv_login);

        indicators = new ImageView[]{
                (ImageView) findViewById(R.id.footer_control_indicator_1),
                (ImageView) findViewById(R.id.footer_control_indicator_2),
                (ImageView) findViewById(R.id.footer_control_indicator_3)};

        colorList = new int[]{
                Color.parseColor("#FFFFFF"),
                Color.parseColor("#FFFFFF"),
                Color.parseColor("#FFFFFF")};
        evaluator = new ArgbEvaluator();
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager =  findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setBackgroundColor(colorList[0]);
        mViewPager.setClipToPadding(false);
        mViewPager.setPadding(130,0,130,0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int colorUpdate = (Integer) evaluator.evaluate(positionOffset,
                        colorList[position], position == colorList.length-1 ? colorList[position] : colorList[position+1]);
                mViewPager.setBackgroundColor(colorUpdate);
            }

            @Override
            public void onPageSelected(int position) {
                // update indicator
                page = position;
                updateIndicator(position);
                mViewPager.setBackgroundColor(colorList[position]);


                btnSkip.setVisibility(position == 2? View.INVISIBLE: View.VISIBLE);
                btnNext.setVisibility(position == 2? View.GONE : View.VISIBLE);
                btnFinish.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
                if(position==0){
                    tvName.setText(getResources().getString(R.string.try_email_marketing));
                }else if(position==1){
                    tvName.setText(getResources().getString(R.string.create_n_send_emails));
                }else{
                    tvName.setText(getResources().getString(R.string.view_reporting));
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnNext.setOnClickListener(this);
        btnSkip.setOnClickListener(this);
        btnFinish.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    private void updateIndicator(int position){
        for (int i = 0; i < indicators.length; i++) {
            if(i == position){
                indicators[i].setImageResource(R.drawable.indicator_selected);
            }else
                indicators[i].setImageResource(R.drawable.indicator_unselected);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.footer_control_button_next:
                page++;
                mViewPager.setCurrentItem(page, true);
                break;
            case R.id.footer_control_button_finish:
                ActivityUtils.startActivity(OnBoardingViewPagerActivity.this,LoginActivity.class,null);
                break;
            case R.id.footer_control_button_skip:
                ActivityUtils.startActivity(OnBoardingViewPagerActivity.this,LoginActivity.class,null);
                break;
            case R.id.tv_login:
                ActivityUtils.startActivity(OnBoardingViewPagerActivity.this,LoginActivity.class,null);
                break;
        }

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_onboarding, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.slider_image);

            int sectNumb = getArguments().getInt(ARG_SECTION_NUMBER);
            int[] images = {R.drawable.onboardng_email_icon, R.drawable.onboarding_create_icon, R.drawable.onboarding_report_icon};
            imageView.setImageResource(images[sectNumb]);
//            textView.setText(getString(R.string.section_format, sectNumb));

            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }
}
