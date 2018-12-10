package com.warrous.contactpointlatest.dashboard.models;

public class DashBoardTopBarPannel {
    public String title;
    public String subTitle;
    public boolean isSelected;

    public DashBoardTopBarPannel(String title, String subTitle, boolean isSelected) {
        this.title = title;
        this.subTitle = subTitle;
        this.isSelected = isSelected;
    }
}
