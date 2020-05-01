package com.alquran.assudais.Models;

public class SimilarAppsList {

    String appName;
    String appLink;
    int appIcon;

    public SimilarAppsList(String appName, String appLink, int appIcon) {
        this.appName = appName;
        this.appLink = appLink;
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppLink() {
        return appLink;
    }

    public void setAppLink(String appLink) {
        this.appLink = appLink;
    }

    public int getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(int appIcon) {
        this.appIcon = appIcon;
    }
}
