package com.portalsoup.ai;

import com.portalsoup.RPS;
import com.portalsoup.utils.Turn;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Portalsoup
 * Date: 8/26/13
 * Time: 11:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mimic implements AI {
    @Override
    public RPS.Move makeMove(List<Turn> history) {
        if (history.isEmpty() || history.get(history.size()-1).getTheirMove().equals("ROCK"))
            return RPS.Move.ROCK;
        if (history.get(history.size()-1).equals("PAPER"))
            return RPS.Move.PAPER;
        return RPS.Move.SCISSOR;
    }
}
