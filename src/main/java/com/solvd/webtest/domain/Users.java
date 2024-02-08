package com.solvd.webtest.domain;

import com.zebrunner.carina.utils.R;

public enum Users {
    VALID(R.TESTDATA.get("valid.username"), R.TESTDATA.get("valid.pass")),
    INVALID(R.TESTDATA.get("invalid.username"), R.TESTDATA.get("invalid.pass"));

    private final String username;
    private final String pass;

    Users(String username, String password) {
        this.username = username;
        this.pass = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }
}
