package com.warrous.contactpointlatest.base;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;

import com.warrous.contactpointlatest.ContactPointApp;

import butterknife.ButterKnife;

/**
 * Created by sivaprasadg on 11/25/17.
 */

public abstract class BaseFragment extends Fragment implements BaseContract.View {
    @Override
    public Activity getAppActivity() {
        return getActivity();
    }

    @Override
    public void showLoader() {
    }

    @Override
    public void dismissLoader() {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public ContactPointApp getAvailApp() {
        return (ContactPointApp) getAppActivity().getApplication();
    }

    protected void injectButterKnife(View view) {
        ButterKnife.bind(this, view);
    }
}
