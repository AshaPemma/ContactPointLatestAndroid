package com.warrous.contactpointlatest.onBoarding.lib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.warrous.contactpointlatest.R;
import com.warrous.contactpointlatest.dashboard.DashBoardActivity;
import com.warrous.contactpointlatest.framework.ActivityUtils;
import com.warrous.contactpointlatest.login.LoginActivity;
import com.warrous.contactpointlatest.onBoarding.lib.listeners.PaperOnboardingOnChangeListener;
import com.warrous.contactpointlatest.onBoarding.lib.listeners.PaperOnboardingOnLeftOutListener;
import com.warrous.contactpointlatest.onBoarding.lib.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

/**
 * Created by gauravs on 25/12/17.
 */

public class PaperOnboardingFragment extends Fragment {

    private static final String ELEMENTS_PARAM = "elements";

    private PaperOnboardingOnChangeListener mOnChangeListener;
    private PaperOnboardingOnRightOutListener mOnRightOutListener;
    private PaperOnboardingOnLeftOutListener mOnLeftOutListener;
    private ArrayList<PaperOnboardingPage> mElements;


    public static PaperOnboardingFragment newInstance(ArrayList<PaperOnboardingPage> elements) {
        PaperOnboardingFragment fragment = new PaperOnboardingFragment();
        Bundle args = new Bundle();
        args.putSerializable(ELEMENTS_PARAM, elements);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mElements = (ArrayList<PaperOnboardingPage>) getArguments().get(ELEMENTS_PARAM);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_test, container, false);

        // create engine for onboarding element
        PaperOnboardingEngine mPaperOnboardingEngine = new PaperOnboardingEngine(view.findViewById(R.id.onboardingRootView), mElements, getActivity().getApplicationContext());
        // set listeners
        mPaperOnboardingEngine.setOnChangeListener(mOnChangeListener);
        mPaperOnboardingEngine.setOnLeftOutListener(mOnLeftOutListener);
        mPaperOnboardingEngine.setOnRightOutListener(mOnRightOutListener);

        mPaperOnboardingEngine.setActivity(getActivity());

        Button getStarted = view.findViewById(R.id.btn_get_started);
        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               ActivityUtils.startActivity(getActivity(), LoginActivity.class, null);
            }
        });

        Button btnTakeTour = view.findViewById(R.id.btn_take_look);
        btnTakeTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // ((ContactPointApp) getActivity().getApplication()).setHasTakeTour(true);
               // ActivityUtils.startActivity(getActivity(), DashBoardActivity.class, null);
            }
        });

        return view;
    }

    public ArrayList<PaperOnboardingPage> getElements() {
        return mElements;
    }

    public void setElements(ArrayList<PaperOnboardingPage> elements) {
        this.mElements = elements;
    }

    public void setOnChangeListener(PaperOnboardingOnChangeListener onChangeListener) {
        this.mOnChangeListener = onChangeListener;
    }

    public void setOnRightOutListener(PaperOnboardingOnRightOutListener onRightOutListener) {
        this.mOnRightOutListener = onRightOutListener;
    }

    public void setOnLeftOutListener(PaperOnboardingOnLeftOutListener onLeftOutListener) {
        this.mOnLeftOutListener = onLeftOutListener;
    }

}

