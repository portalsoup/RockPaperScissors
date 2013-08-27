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
public class AIAlwaysRock implements AI {
    @Override
    public RPS.Move makeMove(List<Turn> history) {
        return RPS.Move.ROCK;
    }
}
