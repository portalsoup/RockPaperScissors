package com.portalsoup;

import com.portalsoup.ai.AI;
import com.portalsoup.ai.AIAlwaysRock;
import com.portalsoup.ai.AIDemo;
import com.portalsoup.ai.Mimic;
import com.portalsoup.utils.Turn;

import java.util.ArrayList;
import java.util.List;

public class RPS {
	public enum Move {SCISSOR, PAPER, ROCK}
	class AIBox {
		private AI aiPlayer;
		private String name;

		public AIBox (AI aiPlayer, String name) {
			this.aiPlayer = aiPlayer;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public AI getAIPlayer() {
			return aiPlayer;
		}
	}


	private List<Turn> history;
	private List<AIBox> listOfAI;
	private AIBox currentAI;

	public RPS() {
		history = new ArrayList<Turn>();
		listOfAI = new ArrayList<AIBox>();
		//add AIs
		listOfAI.add(new AIBox(new AIDemo(), "demo"));
        listOfAI.add(new AIBox(new Mimic(), "mimic"));
        listOfAI.add(new AIBox(new AIAlwaysRock(), "always_rock"));

		//Set default com.com.portalsoup.ai.AI
		currentAI = listOfAI.get(0);
	}

    public Move makeMove() {
        Move aiMove = currentAI.getAIPlayer().makeMove(history);
        return aiMove;
    }

    public void addToHistory(Move myMove, Move theirMove) {
        history.add(new Turn(myMove.name(), theirMove.name()));
    }

    /**
	* returns false if a bad name is provided.
	*/
	public boolean setAI(String ai) {
		boolean pass = false;
		for (AIBox box : listOfAI) {
			if (box.getName().equalsIgnoreCase(ai)) {
				pass = true;
				currentAI = box;
			}
		}
		return pass;
	}

	public String getAvailableAI() {
		String result = "";

		for (AIBox box : listOfAI) {
			result += box.getName() + "\n";
		}
		return result;
	}

	public String currentAI() {
		return currentAI.getName();
	}

	/**
	* Returns 1 for win, 0 for loss, -1 for neither
	*/
	public int evaluateRound(Move playerMove, Move aiMove) {

		if (playerMove.equals(aiMove))
			return -1;

		if (playerMove == Move.SCISSOR) {
			if (aiMove == Move.PAPER)
                return 1;
            else if (aiMove == Move.ROCK)
                return 0;
        }

        if (playerMove == Move.PAPER) {
            if (aiMove == Move.ROCK)
                return 1;
            else if (aiMove == Move.SCISSOR)
                return 0;
        }

        if (playerMove == Move.ROCK) {
            if (aiMove == Move.SCISSOR)
                return 1;
            else
            return 0;
        }
        return 0;
    }


}