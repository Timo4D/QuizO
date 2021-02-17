package com.example.quizo_v1;

public class MainSettings {

    private boolean useTimer;
    private String userName;

    public MainSettings() {

    }

    public MainSettings(String userName) {
        this.userName = userName;
    }

    public MainSettings(boolean useTimer) {
        this.useTimer = useTimer;
    }

    public MainSettings(String userName, boolean useTimer) {
        this.userName = userName;
        this.useTimer = useTimer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isUseTimer() {
        return useTimer;
    }

    public void setUseTimer(boolean useTimer) {
        this.useTimer = useTimer;
    }
}
