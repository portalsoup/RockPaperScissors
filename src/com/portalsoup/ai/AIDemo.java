package com.portalsoup.ai;

import com.portalsoup.RPS.Move;
import com.portalsoup.utils.Turn;

import java.util.List;
import java.util.Random;

public class AIDemo implements AI {

	public Move makeMove(List<Turn> history) {
		Random r = new Random();

		int move = r.nextInt(3);

		if (move == 0)
			return Move.ROCK;
		if (move == 1)
			return Move.PAPER;
		else
			return Move.SCISSOR;


	}
}