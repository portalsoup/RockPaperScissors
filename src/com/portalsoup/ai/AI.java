package com.portalsoup.ai;

import com.portalsoup.RPS;
import com.portalsoup.utils.Turn;

import java.util.List;

public interface AI {
	
	public RPS.Move makeMove(List<Turn> history);
}