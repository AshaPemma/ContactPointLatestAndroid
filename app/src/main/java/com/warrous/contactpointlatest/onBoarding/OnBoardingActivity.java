package com.warrous.contactpointlatest.onBoarding;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;


import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.dashboard.DashBoardActivity;
import com.warrous.contactpointlatest.framework.ActivityUtils;
import com.warrous.contactpointlatest.onBoarding.lib.PaperOnboardingFragment;
import com.warrous.contactpointlatest.onBoarding.lib.PaperOnboardingPage;
import com.warrous.contactpointlatest.onBoarding.lib.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

/**
 * Created by gauravs on 25/12/17.
 */

public class OnBoardingActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        fragmentManager = getSupportFragmentManager();

        final PaperOnboardingFragment onBoardingFragment = PaperOnboardingFragment.newInstance(getDataForOnboarding());

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, onBoardingFragment);
        fragmentTransaction.commit();

        onBoardingFragment.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                onBoardingButtonClicked();
            }
        });
    }

    private ArrayList<PaperOnboardingPage> getDataForOnboarding() {
        // prepare data
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Get Worry-Free", "Save Warranties & Invoices of all your Products in one place",
                getColorFromCode(R.color.colorAccent),0, 0);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Don't Lose Money", "Check Warranties Status & receive timely Alerts before they expire",
                getColorFromCode(R.color.colorAccent), 0,0);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Don't Ever Lose Time ", "Contact Customer Support or top rated nearby Service Centers",
                getColorFromCode(R.color.colorAccent), 0,0);
        PaperOnboardingPage scr4 = new PaperOnboardingPage("Never Miss Goodies", "Avail special Offers related to Products or Services",
                getColorFromCode(R.color.colorAccent), 0, 0);
        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        elements.add(scr4);
        return elements;
    }

    public void onBoardingButtonClicked() {
//        PreferenceManager.storeValue(OnBoardingActivity.this, PreferenceManager.KEY_LAUNCH, Boolean.TRUE);
       ActivityUtils.startActivity(OnBoardingActivity.this, DashBoardActivity.class, null);
    }

    private int getColorFromCode(int colorCode) {
        return ContextCompat.getColor(this, colorCode);
    }
}

