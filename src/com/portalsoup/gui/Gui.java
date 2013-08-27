package com.portalsoup.gui;

import com.portalsoup.RPS;
import java.util.Scanner;

public class Gui {

    private int wins = 0;
    private int loses = 0;
    private int ties = 0;
    private RPS rps = new RPS();

	public void run() {
		Scanner in = new Scanner(System.in);
		String help = "To take your turn, type \"rock\", \"paper\" or \"scissor\".  \nTo view the score, type " +
                "\"score\".\nTo view current AI selection, type \"current\".  \nTo view a list of available AIs, " +
                "type \"list\", to switch to a new AI, type \"swap [AI name]\".  \nTo clear all score data, type " +
                "\"wipe\". \nType \"exit\" to quit";

		boolean run = true;

		while(run) {

			System.out.println("Your turn!  Type \"help\" to get list of commands!");
			String command = in.nextLine();

			if (command.equalsIgnoreCase("help"))
				System.out.println(help);
			else if (command.equalsIgnoreCase("score"))
				System.out.println("Wins: " + wins + "\nLoses: " + loses + "\nTies: " + ties);
            else if (command.equalsIgnoreCase("wipe")) {
                wins = 0;
                loses = 0;
                ties = 0;
            }
            else if (command.equalsIgnoreCase("current"))
                System.out.println(rps.currentAI());
            else if (command.equalsIgnoreCase("list"))
                System.out.println(rps.getAvailableAI());
            else if (command.contains("swap "))
                System.out.println((rps.setAI(command.substring(5))) ? "Success" : "Failure");
			else if (command.equalsIgnoreCase("rock"))
				move(RPS.Move.ROCK);
			else if (command.equalsIgnoreCase("paper"))
				move(RPS.Move.PAPER);
			else if (command.equalsIgnoreCase("scissor"))
			 	move(RPS.Move.SCISSOR);
            else if (command.equalsIgnoreCase("exit"))
                run = false;
            else
                System.out.println("Command not recognized!");

		}
	}

	/**
	* Accepts the player move, returns the com.com.portalsoup.ai.AI move in string form.
	*/
	public void move(RPS.Move move) {

		RPS.Move aiMove = rps.makeMove();
		int win = rps.evaluateRound(move, aiMove);

		System.out.print("Player: " + move.name() + "\tAI: " + aiMove.name() + "\tWinner: ");

		if (win == 1) {
			wins++;
			System.out.println("Player!");
		} 
		else if (win == 0) {
			loses++;
			System.out.println("AI!");
		} 
		else {
			ties++;
			System.out.println("Nobody");
		}
	}

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.run();
    }
}