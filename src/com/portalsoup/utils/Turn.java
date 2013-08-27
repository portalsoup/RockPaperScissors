package com.portalsoup.utils;

public class Turn {
    private String myMove;
    private String theirMove;

    public Turn(String myMove, String theirMove) {
        this.myMove = myMove;
        this.theirMove = theirMove;
    }

    public String getMyMove() {
        return myMove;
    }

    public String getTheirMove() {
        return theirMove;
    }
}
