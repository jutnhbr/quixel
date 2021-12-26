package com.example.quizz.gameLogic.gamemodes;


import com.example.quizz.exceptions.QueryException;

import java.io.IOException;

/**
 * Implements all methods needed to perform the game loop.
 * Updates the GUI, updates relevant data, calls the API,
 * interprets incoming intents and ends the game loop.
 */
public interface IGamemode {


    /**
     * Updates to GUI based on the answer
     *
     * @param option true / false / question / time
     * for specific GUI reaction
     */
    public void updateGUI(String option);

    /**
     * Updates the GUI based on the type of active question
     */
    public void updateButtons();

    /**
     * Receives the Category String from the Recycler View
     * and saves it to a global variable.
     * In case there is no Text, it return
     * the String "No Date Found"
     */
    public void receiveCategory(String type, int value);

    /**
     * Interprets the incoming intent String and returns
     * the category ID from the API
     * @return 9-32 Category ID or -2 as an error code
     */
    public int interpretIncomingData();

    /**
     * Makes the API Call for the specific Category and
     * saves the Question(s)
     *
     * @param ID category ID
     * @throws IOException
     * @throws QueryException if input is invalid
     *                     (e.g. questionNumber=0)
     */
    public void callAPI(int ID, int value, String type)
                    throws IOException, QueryException;

    /**
     * Tries to receive the Questions generated by the API call
     * based on the incoming intent String. Fills the list with a
     * new set of questions and displays a new questions from the
     * list after the active questions was answered.
     * If the max questions limit is reached, the method will
     * call the endGame() method
     * @see #updateGUI(String)
     * @see #endGame()
     */
    public void receiveQuestion();
    /**
     * Starts and creates a new Countdown Timer.
     */
    public void startTimer();
    /**
     * Starts the end screen activity and passes all relevant data
     */
    public void endGame();
}