package com.example.t_e_hnolog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WheaterDetails{

    private Main main;

    public WheaterDetails(Main main) {
        this.main = main;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

