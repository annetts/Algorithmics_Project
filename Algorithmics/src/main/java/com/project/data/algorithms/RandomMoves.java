package com.project.data.algorithms;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class RandomMoves {

    public static void main(String[] args) {

        // initial board configuration
        // 0 - cell is empty, not occupied by any button
        // 1 - cell is occupied by white player's button
        // 2 - cell is occupied by black player's button

        List<List<Integer>> afterMove = asList(
                    // 0. 1. 2. 3. 4. 5. 6. 7. element (i)
                asList(0, 0, 0, 0, 0, 0, 0, 0), // 0. rida (j)
                asList(0, 0, 0, 0, 0, 0, 0, 0), // 1. rida
                asList(0, 0, 0, 0, 0, 0, 0, 0), // 2. rida
                asList(0, 0, 0, 0, 0, 0, 0, 0), // 3. rida
                asList(0, 1, 0, 0, 0, 0, 0, 0), // 4. rida
                asList(0, 0, 1, 0, 0, 0, 0, 0), // 5. rida
                asList(0, 0, 0, 1, 0, 0, 0, 0), // 6. rida
                asList(0, 0, 0, 0, 2, 0, 0, 0)  // 7. rida
        );

        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("0 - cell is empty, not occupied by any button");
        System.out.println("1 - cell is occupied by white player's button");
        System.out.println("2 - cell is occupied by black player's button");
        System.out.println();

        // new arraylist for storing board configuration before next move
        ArrayList<ArrayList<Integer>> beforeMove = new ArrayList<ArrayList<Integer>>();

        for (List<Integer> elements : afterMove) {
            beforeMove.add(new ArrayList(elements));
        }

        long timer = 0;
        long temp;

        for (int a = 0; a < 1; a++) {
            long startTime = System.currentTimeMillis();
            RandomMove(afterMove);
            long endTime = System.currentTimeMillis();

            System.out.println("Time elapsed for move: " + (endTime - startTime) + " ms.");
            System.out.println();

            temp = endTime - startTime;
            timer += temp;
        }

        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("Board before random legal move:");
        System.out.println();
        System.out.println(beforeMove);
        System.out.println();
        System.out.println("Board after random legal move");
        System.out.println();
        System.out.println(afterMove);
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println();
        System.out.println("*** Total time elapsed for game: " + timer + " ms. ***");
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println();
    }

// ---------------------------------------------------------------------------------------------------------------------
// generating next random move

    private static List<List<Integer>> RandomMove(List<List<Integer>> updatedBoard) {

        // new arraylist for storing board configuration before next move
        ArrayList<ArrayList<Integer>> initialBoard = new ArrayList<ArrayList<Integer>>();

        for (List<Integer> elements : updatedBoard) {
            initialBoard.add(new ArrayList(elements));
        }

        //List<List<Integer>> updatedBoard = new ArrayList<List<Integer>>();

        //                                                  0. 1. 2. 3. 4. 5. 6. 7. element (i)
        /*List<Integer> firstRow =   new ArrayList<>(asList(0, 0, 0, 0, 0, 0, 0, 0));// 0. rida (j)
        List<Integer> secondRow =  new ArrayList<>(asList(0, 0, 0, 0, 2, 0, 1, 0));// 1. rida
        List<Integer> thirdRow =   new ArrayList<>(asList(0, 1, 0, 1, 0, 0, 0, 0));// 2. rida
        List<Integer> fourthRow =  new ArrayList<>(asList(2, 0, 2, 0, 2, 0, 0, 0));// 3. rida
        List<Integer> fifthRow =   new ArrayList<>(asList(0, 2, 0, 0, 0, 0, 0, 0));// 4. rida
        List<Integer> sixthRow =   new ArrayList<>(asList(0, 0, 0, 0, 0, 0, 0, 0));// 5. rida
        List<Integer> seventhRow = new ArrayList<>(asList(0, 0, 0, 2, 0, 0, 0, 0));// 6. rida
        List<Integer> eightRow =   new ArrayList<>(asList(0, 0, 0, 0, 0, 0, 0, 0));// 7. rida

        initialBoard.add(firstRow);
        initialBoard.add(secondRow);
        initialBoard.add(thirdRow);
        initialBoard.add(fourthRow);
        initialBoard.add(fifthRow);
        initialBoard.add(sixthRow);
        initialBoard.add(seventhRow);
        initialBoard.add(eightRow);*/

        boolean movesAvailable;
        boolean mustMakeMove;
        boolean canMakeMove;
        String buttonValue = null;
        List buttonMove = new ArrayList<>();

// ---------------------------------------------------------------------------------------------------------------------
// searching elements through 2-dimensional arraylist

        System.out.println("-------------------------------------------------------------");
        System.out.println("*** MY TURN ***");

        // liigub ridades, alustab indexiga 7 ja lõpetab indexiga 0
        for (int j = updatedBoard.size() - 1; j >= 0; j--) {

            System.out.println("-------------------------------------------------------------");
            System.out.println();
            System.out.println("Searcing for black buttons on board, currently in row indexed: " + j);
            System.out.println();

            // liigub tulpades, alustab indexiga 0 (kõige alt) ja lõpetab
            // indexiga 7
            for (int i = 0; i < updatedBoard.size(); i++) {

// ---------------------------------------------------------------------------------------------------------------------
                                            // REGULAR MOVES
// ---------------------------------------------------------------------------------------------------------------------
// searcing for elements valued 2

                // otsib elemente väärtusega 2, on teada, et elementi
                // väärtusega 1 selle käiguga võtta ei saanud
                if (updatedBoard.get(j).get(i) == 2) {

// ---------------------------------------------------------------------------------------------------------------------
// searcing for regular moves for regular button (left upside)

                    // kui ülemises reas on vaba lahter vasakul üleval, siis
                    // saab käigu teha sinna
                    if (i != 0 && j != 0 && updatedBoard.get(j - 1).get(i - 1) == 0) {
                        System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There does not exists an element in upper left row " + (j - 1) + ". column " + (i - 1)
                                + ". its value is " + updatedBoard.get(j - 1).get(i - 1));
                        System.out.println();
                        System.out.println("canMakeMove");
                        System.out.println();

                        canMakeMove = true;
                        buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                        buttonMove.add("START");
                        buttonMove.add("canMakeMove");
                        buttonMove.add(canMakeMove);
                        buttonMove.add("Button value");
                        buttonMove.add(buttonValue);
                        buttonMove.add("startingPosition");
                        buttonMove.add(j);
                        buttonMove.add(i);
                        buttonMove.add("endingPosition");
                        buttonMove.add(j - 1);
                        buttonMove.add(i - 1);
                        buttonMove.add("DONE");
                    }

                    // kui ülemises reas on element 2, mis asub vasakul üleval
                    // diagonaalis, siis käiku teha ei saa
                    if (i != 0 && j != 0 && (updatedBoard.get(j - 1).get(i - 1) == 2)) {
                        System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There exists an element in upper left row " + (j - 1) + ". column " + (i - 1)
                                + ". and its value is " + updatedBoard.get(j - 1).get(i - 1));
                        System.out.println();
                        System.out.println("cannotMakeMove, friendly button in upper left row");
                        System.out.println();

                        //canMakeMove = false;
                        //buttonValue = String.valueOf(updatedBoard.get(j).get(i));
                    }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for regular moves for regular button (right upside)

                    // kui ülemises reas on vaba lahter paremal üleval, siis
                    // saab käigu teha sinna
                    if (i != 7 && j != 0 && updatedBoard.get(j - 1).get(i + 1) == 0) {
                        System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There does not exists an element in upper right row " + (j - 1) + ". column " + (i + 1)
                                + ". its value is " + updatedBoard.get(j - 1).get(i + 1));
                        System.out.println();
                        System.out.println("canMakeMove");
                        System.out.println();

                        canMakeMove = true;
                        buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                        buttonMove.add("START");
                        buttonMove.add("canMakeMove");
                        buttonMove.add(canMakeMove);
                        buttonMove.add("Button value");
                        buttonMove.add(buttonValue);
                        buttonMove.add("startingPosition");
                        buttonMove.add(j);
                        buttonMove.add(i);
                        buttonMove.add("endingPosition");
                        buttonMove.add(j - 1);
                        buttonMove.add(i + 1);
                        buttonMove.add("DONE");
                    }

                    // kui ülemises reas on element 2, mis asub paremal üleval
                    // diagonaalis, siis käiku teha ei saa
                    if (i != 7 && j != 0 && (updatedBoard.get(j - 1).get(i + 1) == 2)) {
                        System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There exists an element in upper right row  " + (j - 1) + ". column " + (i + 1)
                                + ". and its value is " + updatedBoard.get(j - 1).get(i + 1));
                        System.out.println();
                        System.out.println("cannotMakeMove, friendly button in upper right row");
                        System.out.println();

                        //canMakeMove = false;
                        //buttonValue = String.valueOf(updatedBoard.get(j).get(i));
                    }
                }

// ---------------------------------------------------------------------------------------------------------------------
// special conditions for king button

                // erijuht kuningnupu jaoks, mille väärtus on 3
                if (updatedBoard.get(j).get(i) == 3) {

// ---------------------------------------------------------------------------------------------------------------------
// searcing for regular moves for king button (left downside)

                    // kontrollib mänguväljakut diagonaalis vasakule alla
                    for (int p = 1; p < (updatedBoard.size() - j); p++) {

                        // et mänguväljakult välja ei läheks
                        if ((i - p) >= 0 && (j + p) <= 7) {

                            // kui alumises reas on vaba lahter kuskil vasakul all, siis
                            // saab käigu teha sinna
                            if (i != 0 && j != 7 && updatedBoard.get(j + p).get(i - p) == 0) {
                                System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There does not exists an element in lower left row " + (j + p) + ". column " + (i - p)
                                        + ". its value is " + updatedBoard.get(j + p).get(i - p));
                                System.out.println();
                                System.out.println("canMakeMove");
                                System.out.println();

                                canMakeMove = true;
                                buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                buttonMove.add("START");
                                buttonMove.add("canMakeMove");
                                buttonMove.add(canMakeMove);
                                buttonMove.add("Button value");
                                buttonMove.add(buttonValue);
                                buttonMove.add("startingPosition");
                                buttonMove.add(j);
                                buttonMove.add(i);
                                buttonMove.add("endingPosition");
                                buttonMove.add(j + p);
                                buttonMove.add(i - p);
                                buttonMove.add("DONE");
                            }

                            // teekond vasakule alla ei ole vaba, üle nuppude ei saa käiku teha
                            else {
                                /*System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There exists an element in somewhere lower left from row: " + (j + p) + ". column: " + (i - p) + ". and its valued: " + updatedBoard.get(j + p).get(i - p));
                                System.out.println();
                                System.out.println("cannotMakeMove, button in somewhere lower left row or landing index out of bounds");
                                System.out.println();*/

                                break;
                            }
                        } else {
                            /*System.out.println("*** Element found in initial position row " + j + ". column " + i + ". cannotMakeMove, landing index out of bounds");
                            System.out.println();*/
                        }
                    }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for regular moves for king button (left upside)

                    // kontrollib mänguväljakut diagonaalis vasakule üles
                    for (int p = 1; p < (updatedBoard.size() - j); p++) {

                        // et mänguväljakult välja ei läheks
                        if ((i - p) >= 0 && (j - p) >= 0) {

                            // kui ülemises reas on vaba lahter kuskil vasakul üleval, siis
                            // saab käigu teha sinna
                            if (i != 0 && j != 0 && updatedBoard.get(j - p).get(i - p) == 0) {
                                System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There does not exists an element in upper left row " + (j - p) + ". column " + (i - p)
                                        + ". its value is " + updatedBoard.get(j - p).get(i - p));
                                System.out.println();
                                System.out.println("canMakeMove");
                                System.out.println();

                                canMakeMove = true;
                                buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                buttonMove.add("START");
                                buttonMove.add("canMakeMove");
                                buttonMove.add(canMakeMove);
                                buttonMove.add("Button value");
                                buttonMove.add(buttonValue);
                                buttonMove.add("startingPosition");
                                buttonMove.add(j);
                                buttonMove.add(i);
                                buttonMove.add("endingPosition");
                                buttonMove.add(j - p);
                                buttonMove.add(i - p);
                                buttonMove.add("DONE");
                            }

                            // teekond vasakule üles ei ole vaba, üle nuppude ei saa käiku teha
                            else {
                                /*System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There exists an element in somewhere upper left from row: " + (j - p) + ". column: " + (i - p) + ". and its valued: " + updatedBoard.get(j - p).get(i - p));
                                System.out.println();
                                System.out.println("cannotMakeMove, button in somewhere upper left row or landing index out of bounds");
                                System.out.println();*/

                                break;
                            }
                        } else {
                            /*System.out.println("cannotMakeMove, landing index out of bounds");*/
                        }
                    }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for regular moves for king button (right downside)

                    // kontrollib mänguväljakut diagonaalis paremale alla
                    for (int u = 1; u < (updatedBoard.size() - i); u++) {

                        // et mänguväljakult välja ei läheks
                        if ((i + u) <= 7 && (j + u) <= 7) {

                            // kui alumises reas on vaba lahter kuskil paremal all, siis
                            // saab käigu teha sinna
                            if (i != 7 && j != 7 && updatedBoard.get(j + u).get(i + u) == 0) {
                                System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There does not exists an element in lower right row " + (j + u) + ". column " + (i + u)
                                        + ". its value is " + updatedBoard.get(j + u).get(i + u));
                                System.out.println();
                                System.out.println("canMakeMove");
                                System.out.println();

                                canMakeMove = true;
                                buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                buttonMove.add("START");
                                buttonMove.add("canMakeMove");
                                buttonMove.add(canMakeMove);
                                buttonMove.add("Button value");
                                buttonMove.add(buttonValue);
                                buttonMove.add("startingPosition");
                                buttonMove.add(j);
                                buttonMove.add(i);
                                buttonMove.add("endingPosition");
                                buttonMove.add(j + u);
                                buttonMove.add(i + u);
                                buttonMove.add("DONE");
                            }

                            // teekond paremale alla ei ole vaba, üle nuppude ei saa käiku teha
                            else {
                                /*System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There exists an element in somewhere lower right from row: " + (j + u) + ". column: " + (i + u) + ". and its valued: " + updatedBoard.get(j + u).get(i + u));
                                System.out.println();
                                System.out.println("cannotMakeMove, button in somewhere lower right row or landing index out of bounds");
                                System.out.println();*/

                                break;
                            }

                        } else {
                            /*System.out.println("cannotMakeMove, landing index out of bounds");*/
                        }
                    }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for regular moves for king button (right upside)

                    // kontrollib mänguväljakut diagonaalis paremale üles
                    for (int u = 1; u < (updatedBoard.size() - i); u++) {

                        // et mänguväljakult välja ei läheks
                        if ((i + u) <= 7 && (j - u) >= 0) {

                            // kui ülemises reas on vaba lahter kuskil paremal üleval, siis
                            // saab käigu teha sinna
                            if (i != 7 && j != 0 && updatedBoard.get(j - u).get(i + u) == 0) {
                                System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There does not exists an element in upper right row " + (j - u) + ". column " + (i + u)
                                        + ". its value is " + updatedBoard.get(j - u).get(i + u));
                                System.out.println();
                                System.out.println("canMakeMove");
                                System.out.println();

                                canMakeMove = true;
                                buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                buttonMove.add("START");
                                buttonMove.add("canMakeMove");
                                buttonMove.add(canMakeMove);
                                buttonMove.add("Button value");
                                buttonMove.add(buttonValue);
                                buttonMove.add("startingPosition");
                                buttonMove.add(j);
                                buttonMove.add(i);
                                buttonMove.add("endingPosition");
                                buttonMove.add(j - u);
                                buttonMove.add(i + u);
                                buttonMove.add("DONE");
                            }

                            // teekond paremale alla ei ole vaba, üle nuppude ei saa käiku teha
                            else {
                                /*System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is " + updatedBoard.get(j).get(i) + ". There exists an element in somewhere upper right from row: " + (j - u) + ". column: " + (i + u) + ". and its valued: " + updatedBoard.get(j - u).get(i + u));
                                System.out.println();
                                System.out.println("cannotMakeMove, button in somewhere upper right row or landing index out of bounds");
                                System.out.println();*/

                                break;
                            }

                        } else {
                            /*System.out.println("cannotMakeMove, landing index out of bounds");*/
                        }
                    }
                }
// ---------------------------------------------------------------------------------------------------------------------
                                            // JUMPING MOVES
// ---------------------------------------------------------------------------------------------------------------------
// searching for elements valued 2 (regular)

                    // tavajuht, otsib elemente väärtusega 2
                    if (updatedBoard.get(j).get(i) == 2) {

// ---------------------------------------------------------------------------------------------------------------------
// searching for elements on the far end of the board

                        // kui nupp on viimasel lahtril
                        for (int k = 0; k < updatedBoard.size(); k++) {
                            if (updatedBoard.get(0).get(k) == 2) {
                                System.out.println("*** Element found in initial position row " + 0 + ". column " + k + ". and its value is "
                                        + updatedBoard.get(0).get(k) + ". It will be upgraded to KING button!!!");

                                System.out.println();

                                updatedBoard.get(0).set(k, 3);
                                //buttonValue = String.valueOf(updatedBoard.get(0).get(k));
                            }
                        }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for jumping moves for regular button (left upside)

                        // kui ülemises reas leidub element 1, mis asub vasakul
                        // üleval diagonaalis, prindib selle välja ja kontrollib
                        // edasi
                        if (i != 0 && j != 0 && updatedBoard.get(j - 1).get(i - 1) == 1) {
                            System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is "
                                    + updatedBoard.get(j).get(i) + ". There exists an element in upper left row " + (j - 1) + ". column "
                                    + (i - 1) + ". and its value is " + updatedBoard.get(j - 1).get(i - 1));
                            System.out.println();

                            //buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                            // kui üle-ülemises reas on vaba lahter vasakul üleval
                            // diagonaalis, et elementi 1 ära võtta, tuleb kontrollida, et ülevalt või vasakult mängulaualt välja ei läheks
                            if (i == 1 && j == 1) {
                                System.out.println("cannotMakeMove, landing index out of bounds");
                                System.out.println();
                            }

                            // et mänguväljalt välja ei läheks
                            if (i > 1 && j > 1) {

                                // kui üle-ülemises reas on vaba lahter vasakul üleval
                                // diagonaalis, et elementi 1 ära võtta, siis tuleb see
                                // käik kindlasti teha
                                if (updatedBoard.get(j - 2).get(i - 2) == 0) {
                                    System.out
                                            .println("*** There is also a free cell in upper left row " + (j - 2) + ". column "
                                                    + (i - 2) + ". and its value is " + updatedBoard.get(j - 2).get(i - 2));
                                    System.out.println();
                                    System.out.println("mustMakeMove");
                                    System.out.println();

                                    mustMakeMove = true;
                                    buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                    buttonMove.add("START");
                                    buttonMove.add("mustMakeMove");
                                    buttonMove.add(mustMakeMove);
                                    buttonMove.add("Button value");
                                    buttonMove.add(buttonValue);
                                    buttonMove.add("startingPosition");
                                    buttonMove.add(j);
                                    buttonMove.add(i);
                                    buttonMove.add("endingPosition");
                                    buttonMove.add(j - 2);
                                    buttonMove.add(i - 2);
                                    buttonMove.add("tookButtonFrom");
                                    buttonMove.add(j - 1);
                                    buttonMove.add(i - 1);
                                    buttonMove.add("DONE");

                                } else {
                                    System.out.println("cannotMakeMove, button in upper-upper left row " + (j - 2) + ". column " + (i - 2) + ". valued " + updatedBoard.get(j - 2).get(i - 2));
                                    System.out.println();
                                }
                                if (i > 2 && j > 2 && updatedBoard.get(j - 3).get(i - 3) == 1 && updatedBoard.get(j - 4).get(i - 4) == 0){
                                    System.out.println("*** CAN JUMP OVER FOR MORE!!! ***");
                                }
                            }
                            // kui üle-ülemises reas vasakul ei ole vaba lahtrit, et
                            // käiku teha
                            else {
                                System.out.println("cannotMakeMove, no free landing space");
                                System.out.println();
                            }
                        }
// ---------------------------------------------------------------------------------------------------------------------
// searcing for jumping moves for regular button (left downside)

                        // kui alumises reas leidub element 1, mis asub vasakul
                        // all diagonaalis, prindib selle välja ja kontrollib
                        // edasi
                        if (i != 0 && j != 7 && updatedBoard.get(j + 1).get(i - 1) == 1) {
                            System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is "
                                    + updatedBoard.get(j).get(i) + ". There exists an element in lower left row " + (j + 1) + ". column "
                                    + (i - 1) + ". and its value is " + updatedBoard.get(j + 1).get(i - 1));
                            System.out.println();

                            // kui üle-alumises reas on vaba lahter vasakul all
                            // diagonaalis, et elementi 1 ära võtta, tuleb kontrollida, et ülevalt või vasakult mängulaualt välja ei läheks
                            if (i == 1 && j == 6) {
                                System.out.println("cannotMakeMove, landing index out of bounds");
                                System.out.println();
                            }

                            // et mänguväljalt välja ei läheks
                            if (i > 1 && j < 6) {

                                // kui üle-alumises reas on vaba lahter vasakul all
                                // diagonaalis, et elementi 1 ära võtta, siis tuleb see
                                // käik kindlasti teha
                                if (updatedBoard.get(j + 2).get(i - 2) == 0) {
                                    System.out
                                            .println("*** There is also a free cell in lower left row " + (j + 2) + ". column "
                                                    + (i - 2) + ". and its value is " + updatedBoard.get(j + 2).get(i - 2));
                                    System.out.println();
                                    System.out.println("mustMakeMove");
                                    System.out.println();

                                    mustMakeMove = true;
                                    buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                    buttonMove.add("START");
                                    buttonMove.add("mustMakeMove");
                                    buttonMove.add(mustMakeMove);
                                    buttonMove.add("Button value");
                                    buttonMove.add(buttonValue);
                                    buttonMove.add("startingPosition");
                                    buttonMove.add(j);
                                    buttonMove.add(i);
                                    buttonMove.add("endingPosition");
                                    buttonMove.add(j + 2);
                                    buttonMove.add(i - 2);
                                    buttonMove.add("tookButtonFrom");
                                    buttonMove.add(j + 1);
                                    buttonMove.add(i - 1);
                                    buttonMove.add("DONE");
                                } else {
                                    System.out.println("cannotMakeMove, button in lower-lower left row " + (j + 2) + ". column " + (i - 2) + ". valued " + updatedBoard.get(j + 2).get(i - 2));
                                    System.out.println();
                                }
                                if (i > 2 && j < 5 && updatedBoard.get(j + 3).get(i - 3) == 1 && updatedBoard.get(j + 4).get(i - 4) == 0){
                                    System.out.println("*** CAN JUMP OVER FOR MORE!!! ***");
                                }
                            }
                            // kui üle-alumises reas vasakul ei ole vaba lahtrit, et
                            // käiku teha
                            else {
                                System.out.println("cannotMakeMove, no free landing space");
                                System.out.println();
                            }
                        }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for jumping moves for regular button (right upside)

                        // kui ülemises reas leidub element 1, mis asub paremal
                        // üleval diagonaalis, prindib selle välja ja kontrollib
                        // edasi
                        if (i != 7 && j != 0 && updatedBoard.get(j - 1).get(i + 1) == 1) {
                            System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and value is "
                                    + updatedBoard.get(j).get(i) + ". There exists an element in upper right row " + (j - 1) + ". column "
                                    + (i + 1) + ". and its value is " + updatedBoard.get(j - 1).get(i + 1));
                            System.out.println();

                            //buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                            // kui üle-ülemises reas on vaba lahter paremal üleval
                            // diagonaalis, et elementi 1 ära võtta, tuleb kontrollida, et ülevalt või paremalt mängulaualt välja ei läheks
                            if (i == 6 && j == 1) {
                                System.out.println("cannotMakeMove, landing index out of bounds");
                                System.out.println();
                            }

                            // et mänguväljalt välja ei läheks
                            if (i < 6 && j > 1) {

                                // kui üle-ülemises reas on vaba lahter paremal üleval
                                // diagonaalis, et elementi 1 ära võtta, siis tuleb see
                                // käik kindlasti teha
                                if (updatedBoard.get(j - 2).get(i + 2) == 0 && j > 1) {
                                    System.out
                                            .println("*** There is also a free cell in upper right row " + (j - 2) + ". column "
                                                    + (i + 2) + ". and its value is " + updatedBoard.get(j - 2).get(i + 2));
                                    System.out.println();
                                    System.out.println("mustMakeMove");
                                    System.out.println();

                                    mustMakeMove = true;
                                    buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                    buttonMove.add("START");
                                    buttonMove.add("mustMakeMove");
                                    buttonMove.add(mustMakeMove);
                                    buttonMove.add("Button value");
                                    buttonMove.add(buttonValue);
                                    buttonMove.add("startingPosition");
                                    buttonMove.add(j);
                                    buttonMove.add(i);
                                    buttonMove.add("endingPosition");
                                    buttonMove.add(j - 2);
                                    buttonMove.add(i + 2);
                                    buttonMove.add("tookButtonFrom");
                                    buttonMove.add(j - 1);
                                    buttonMove.add(i + 1);
                                    buttonMove.add("DONE");
                                } else {
                                    System.out.println("cannotMakeMove, button in upper-upper right row " + (j - 2) + ". column " + (i + 2) + ". valued " + updatedBoard.get(j - 2).get(i + 2));
                                    System.out.println();
                                }
                                if (i < 5 && j > 2 && updatedBoard.get(j - 3).get(i + 3) == 1 && updatedBoard.get(j - 4).get(i + 4) == 0){
                                    System.out.println("*** CAN JUMP OVER FOR MORE!!! ***");
                                }
                            }
                            // kui üle-ülemises reas paremal ei ole vaba lahtrit, et
                            // käiku teha
                            else {
                                System.out.println("cannotMakeMove, no free landing space");
                                System.out.println();
                            }
                        }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for jumping moves for regular button (right downside)

                        // kui alumises reas leidub element 1, mis asub paremal
                        // all diagonaalis, prindib selle välja ja kontrollib
                        // edasi
                        if (i != 7 && j != 7 && updatedBoard.get(j + 1).get(i + 1) == 1) {
                            System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and value is "
                                    + updatedBoard.get(j).get(i) + ". There exists an element in lower right row " + (j + 1) + ". column "
                                    + (i + 1) + ". and its value is " + updatedBoard.get(j + 1).get(i + 1));
                            System.out.println();

                            //buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                            // kui üle-alumises reas on vaba lahter paremal all
                            // diagonaalis, et elementi 1 ära võtta, tuleb kontrollida, et alt või paremalt mängulaualt välja ei läheks
                            if (i == 6 && j == 6) {
                                System.out.println("cannotMakeMove, landing index out of bounds");
                                System.out.println();
                            }

                            // et mänguväljalt välja ei läheks
                            if (i < 6 && j < 6) {

                                // kui üle-alumises reas on vaba lahter paremal all
                                // diagonaalis, et elementi 1 ära võtta, siis tuleb see
                                // käik kindlasti teha
                                if (updatedBoard.get(j + 2).get(i + 2) == 0 && j > 1) {
                                    System.out
                                            .println("*** There is also a free cell in lower right row " + (j + 2) + ". column "
                                                    + (i + 2) + ". and its value is " + updatedBoard.get(j + 2).get(i + 2));
                                    System.out.println();
                                    System.out.println("mustMakeMove");
                                    System.out.println();

                                    mustMakeMove = true;
                                    buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                    buttonMove.add("START");
                                    buttonMove.add("mustMakeMove");
                                    buttonMove.add(mustMakeMove);
                                    buttonMove.add("Button value");
                                    buttonMove.add(buttonValue);
                                    buttonMove.add("startingPosition");
                                    buttonMove.add(j);
                                    buttonMove.add(i);
                                    buttonMove.add("endingPosition");
                                    buttonMove.add(j + 2);
                                    buttonMove.add(i + 2);
                                    buttonMove.add("tookButtonFrom");
                                    buttonMove.add(j + 1);
                                    buttonMove.add(i + 1);
                                    buttonMove.add("DONE");
                                } else {
                                    System.out.println("cannotMakeMove, button in lower-lower right row " + (j + 2) + ". column " + (i + 2) + ". valued " + updatedBoard.get(j + 2).get(i + 2));
                                    System.out.println();
                                }
                                if (i < 5 && j < 5 && updatedBoard.get(j + 3).get(i + 3) == 1 && updatedBoard.get(j + 4).get(i + 4) == 0){
                                    System.out.println("*** CAN JUMP OVER FOR MORE!!! ***");
                                }
                            }
                            // kui üle-alumises reas paremal ei ole vaba lahtrit, et
                            // käiku teha
                            else {
                                System.out.println("cannotMakeMove, no free landing space");
                                System.out.println();
                            }
                        }
                    }

// ---------------------------------------------------------------------------------------------------------------------
// special conditions for king button

                    // erijuht kuningnupu jaoks, mille väärtus on 3
                    if (updatedBoard.get(j).get(i) == 3) {

// ---------------------------------------------------------------------------------------------------------------------
// searcing for jumping moves for king button (left downside)

                        // kontrollib mänguväljakut diagonaalis vasakule alla
                        for (int n = 1; n < (updatedBoard.size() - j); n++) {

                            // et mänguväljalt välja ei läheks
                            if ((i - n) >= 0 && (j + n) <= 7) {

                                // kui alumises reas leidub element 1, mis asub vasakul
                                // all diagonaalis, prindib selle välja ja kontrollib
                                // edasi
                                if (i != 0 && j != 7 && updatedBoard.get(j + n).get(i - n) == 1) {
                                    System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is "
                                            + updatedBoard.get(j).get(i) + ". There exists an element in lower left row " + (j + n) + ". column "
                                            + (i - n) + ". and its value is " + updatedBoard.get(j + n).get(i - n));
                                    System.out.println();

                                    // kui üle-alumises reas on vaba lahter vasakul all
                                    // diagonaalis, et elementi 1 ära võtta, tuleb kontrollida, et alt või vasakult mängulaualt välja ei läheks
                                    if (i <= 1 && j >= 6) {
                                        System.out.println("cannotMakeMove, landing index out of bounds");
                                        System.out.println();
                                    }

                                    // et mänguväljakult välja ei läheks
                                    if ((j + n) <= 6 && (i - n) >= 1) {

                                        // kui üle-alumises reas on vaba lahter vasakul all
                                        // diagonaalis, et elementi 1 ära võtta, siis tuleb see
                                        // käik kindlasti teha
                                        if (updatedBoard.get((j + n) + 1).get((i - n) - 1) == 0) {
                                            //System.out.println("testin: " + updatedBoard.get((n - 1) + s).get(r - s) + " " + (n) + " " + (r));
                                            System.out
                                                    .println("*** There is also a free cell in lower left row " + ((j + n) + 1) + ". column "
                                                            + ((i - n) - 1) + ". and its value is " + updatedBoard.get((j + n) + 1).get((i - n) - 1));
                                            System.out.println();
                                            System.out.println("mustMakeMove");
                                            System.out.println();

                                            mustMakeMove = true;
                                            buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                            buttonMove.add("START");
                                            buttonMove.add("mustMakeMove");
                                            buttonMove.add(mustMakeMove);
                                            buttonMove.add("Button value");
                                            buttonMove.add(buttonValue);
                                            buttonMove.add("startingPosition");
                                            buttonMove.add(j);
                                            buttonMove.add(i);
                                            buttonMove.add("endingPosition");
                                            buttonMove.add((j + n) + 1);
                                            buttonMove.add((i - n) - 1);
                                            buttonMove.add("tookButtonFrom");
                                            buttonMove.add(j + n);
                                            buttonMove.add(i - n);
                                            buttonMove.add("DONE");

                                            break;

                                        } else {
                                            System.out.println("cannotMakeMove, button in lower-lower left row " + ((j + n) + 1) + ". column " + ((i - n) - 1) + ". valued " + updatedBoard.get((j + n) + 1).get((i - n) - 1));
                                            System.out.println();

                                            break;
                                        }
                                    }
                                    // kui üle-alumises reas vasakul ei ole vaba lahtrit, et
                                    // käiku teha
                                    else {
                                        System.out.println("cannotMakeMove, landing space index out of bounds");
                                        System.out.println();

                                        break;
                                    }
                                }
                            }
                        }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for jumping moves for king button (right downside)

                        // kontrollib mänguväljakut diagonaalis paremale alla
                        for (int v = 1; v < (updatedBoard.size() - j); v++) {

                            // et mänguväljalt välja ei läheks
                            if ((i + v) <= 7 && (j + v) <= 7) {

                                // kui alumises reas leidub element 1, mis asub paremal
                                // all diagonaalis, prindib selle välja ja kontrollib
                                // edasi

                                System.out.println("i value: " + i);
                                if (i != 7 && j != 7 && updatedBoard.get(j + v).get(i + v) == 1) {
                                    System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is "
                                            + updatedBoard.get(j).get(i) + ". There exists an element in lower right row " + (j + v) + ". column "
                                            + (i + v) + ". and its value is " + updatedBoard.get(j + v).get(i + v));
                                    System.out.println();

                                    // kui üle-alumises reas on vaba lahter paremal all
                                    // diagonaalis, et elementi 1 ära võtta, tuleb kontrollida, et alt või paremalt mängulaualt välja ei läheks
                                    if (i <= 1 && j >= 6) {
                                        System.out.println("cannotMakeMove, landing index out of bounds");
                                        System.out.println();
                                    }

                                    // et mänguväljakult välja ei läheks
                                    if ((j + v) <= 6 && (i + v) <= 6) {

                                        // kui üle-alumises reas on vaba lahter paremal all
                                        // diagonaalis, et elementi 1 ära võtta, siis tuleb see
                                        // käik kindlasti teha
                                        if (updatedBoard.get((j + v) + 1).get((i + v) + 1) == 0) {
                                            System.out
                                                    .println("*** There is also a free cell in lower right row " + ((j + v) + 1) + ". column "
                                                            + ((i + v) + 1) + ". and its value is " + updatedBoard.get((j + v) + 1).get((i + v) + 1));
                                            System.out.println();
                                            System.out.println("mustMakeMove");
                                            System.out.println();

                                            mustMakeMove = true;
                                            buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                            buttonMove.add("START");
                                            buttonMove.add("mustMakeMove");
                                            buttonMove.add(mustMakeMove);
                                            buttonMove.add("Button value");
                                            buttonMove.add(buttonValue);
                                            buttonMove.add("startingPosition");
                                            buttonMove.add(j);
                                            buttonMove.add(i);
                                            buttonMove.add("endingPosition");
                                            buttonMove.add((j + v) + 1);
                                            buttonMove.add((i + v) + 1);
                                            buttonMove.add("tookButtonFrom");
                                            buttonMove.add(j + v);
                                            buttonMove.add(i + v);
                                            buttonMove.add("DONE");

                                            break;

                                        } else {
                                            System.out.println("cannotMakeMove, button in lower-lower right row " + ((j + v) + 1) + ". column " + ((i + v) - 1) + ". valued " + updatedBoard.get((j + v) + 1).get((i + v) + 1));
                                            System.out.println();

                                            break;
                                        }
                                    }
                                    // kui üle-alumises reas paremal ei ole vaba lahtrit, et
                                    // käiku teha
                                    else {
                                        System.out.println("cannotMakeMove, landing space index out of bounds");
                                        System.out.println();

                                        break;
                                    }
                                }
                            }
                        }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for jumping moves for king button (left upside)
                        //BUGINE KUI ELEMENT ASUB 7;7 - TSÜKKEL LÄBI MÕELDA
                        // kontrollib mänguväljakut diagonaalis vasakule üles
                        for (int s = 1; s < (updatedBoard.size() - j); s++) {

                            // et mänguväljalt välja ei läheks
                            if ((i - s) >= 0 && (j - s) >= 0) {

                                // kui alumises reas leidub element 1, mis asub vasakul
                                // üleval diagonaalis, prindib selle välja ja kontrollib
                                // edasi
                                if (i != 0 && j != 0 && updatedBoard.get(j - s).get(i - s) == 1) {
                                    System.out.println("*** Element found in initial position row " + j + ". column " + i + ". and its value is "
                                            + updatedBoard.get(j).get(i) + ". There exists an element in upper left row " + (j - s) + ". column "
                                            + (i - s) + ". and its value is " + updatedBoard.get(j - s).get(i - s));
                                    System.out.println();

                                    // kui üle-ülemises reas on vaba lahter vasakul üleval
                                    // diagonaalis, et elementi 1 ära võtta, tuleb kontrollida, et ülevalt või vasakult mängulaualt välja ei läheks
                                    if (i <= 1 && j <= 1) {
                                        System.out.println("cannotMakeMove, landing index out of bounds");
                                        System.out.println();
                                    }

                                    // et mänguväljakult välja ei läheks
                                    if ((j - s) >= 1 && (i - s) >= 1) {

                                        // kui üle-ülemises reas on vaba lahter vasakul üleval
                                        // diagonaalis, et elementi 1 ära võtta, siis tuleb see
                                        // käik kindlasti teha
                                        if (updatedBoard.get((j - s) - 1).get((i - s) - 1) == 0) {
                                            //System.out.println("testin: " + updatedBoard.get((n - 1) + s).get(r - s) + " " + (n) + " " + (r));
                                            System.out
                                                    .println("*** There is also a free cell in upper left row " + ((j - s) - 1) + ". column "
                                                            + ((i - s) - 1) + ". and its value is " + updatedBoard.get((j - s) - 1).get((i - s) - 1));
                                            System.out.println();
                                            System.out.println("mustMakeMove");
                                            System.out.println();

                                            mustMakeMove = true;
                                            buttonValue = String.valueOf(updatedBoard.get(j).get(i));

                                            buttonMove.add("START");
                                            buttonMove.add("mustMakeMove");
                                            buttonMove.add(mustMakeMove);
                                            buttonMove.add("Button value");
                                            buttonMove.add(buttonValue);
                                            buttonMove.add("startingPosition");
                                            buttonMove.add(j);
                                            buttonMove.add(i);
                                            buttonMove.add("endingPosition");
                                            buttonMove.add((j - s) - 1);
                                            buttonMove.add((i - s) - 1);
                                            buttonMove.add("tookButtonFrom");
                                            buttonMove.add(j - s);
                                            buttonMove.add(i - s);
                                            buttonMove.add("DONE");

                                            break;

                                        } else {
                                            System.out.println("cannotMakeMove, button in upper-upper left row " + ((j - s) - 1) + ". column " + ((i - s) - 1) + ". valued " + updatedBoard.get((j - s) - 1).get((i - s) - 1));
                                            System.out.println();

                                            break;
                                        }
                                    }
                                    // kui üle-ülemises reas vasakul ei ole vaba lahtrit, et
                                    // käiku teha
                                    else {
                                        System.out.println("cannotMakeMove, landing space index out of bounds");
                                        System.out.println();

                                        break;
                                    }
                                }
                            }
                        }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for jumping moves for king button (right upside)
                        //BUGINE KUI ELEMENT ASUB 0;7 - TSÜKKEL LÄBI MÕELDA


                    }

// ---------------------------------------------------------------------------------------------------------------------

            }
        }

// ---------------------------------------------------------------------------------------------------------------------
// searcing for random move from possible moves list

        if (buttonMove.isEmpty()) {
            System.out.println("-------------------------------------------------------------");
            System.out.println();
            System.out.println("No available moves left!");

            movesAvailable = false;
        } else {
            System.out.println("-------------------------------------------------------------");
            System.out.println();
            System.out.println("Possible moves list: " + buttonMove);

            movesAvailable = true;
        }
        List randomIndex = new ArrayList<>();
        Collection boardBeforeMove;
        Collection boardAfterMove;

        // kui võtta saab, siis see on prioriteetsem käik
        for (int k = 0; k < buttonMove.size(); k++) {
            if (buttonMove.get(k).equals("mustMakeMove")) {

                // lisab listi kõik mustMakeMove käigud
                randomIndex.add(k);
            }
        }

        // kui võtta ei saa, siis vaatab, kas saab üldse käia
        if (randomIndex.isEmpty()) {
            for (int m = 0; m < buttonMove.size(); m++) {
                if (buttonMove.get(m).equals("canMakeMove")) {

                    // lisab listi kõik canMakeMove käigud
                    randomIndex.add(m);
                }
            }
        }

        //System.out.println(randomIndex);

        // valib suvalise (võimalusel prioriteetsema) käigu
        if (!randomIndex.isEmpty()) {
            Random random = new Random();
            int index = random.nextInt(randomIndex.size());

            int startingRowIndex;
            int startingColumnIndex;
            int endingRowIndex;
            int endingColumnIndex;
            int tookButtonRowIndex;
            int tookButtonColumnIndex;

            System.out.println();
            System.out.println("Random generator found: " + buttonMove.get((int) randomIndex.get(index)) + " in possible moves list and its index is " + randomIndex.get(index));
            System.out.println();

// ---------------------------------------------------------------------------------------------------------------------
// applying random jump move

            if (buttonMove.get((int) randomIndex.get(index)).equals("mustMakeMove")) {

                startingRowIndex = (int) randomIndex.get(index) + 5;
                startingColumnIndex = (int) randomIndex.get(index) + 6;
                endingRowIndex = (int) randomIndex.get(index) + 8;
                endingColumnIndex = (int) randomIndex.get(index) + 9;
                tookButtonRowIndex = (int) randomIndex.get(index) + 11;
                tookButtonColumnIndex = (int) randomIndex.get(index) + 12;

                // testin indexeid
                System.out.println("startingRowIndexInList: " + startingRowIndex);
                System.out.println("startingRowIndexOnTable: " + buttonMove.get(startingRowIndex));
                System.out.println("startingColumnIndexInList: " + startingColumnIndex);
                System.out.println("startingColumnIndexOnTable: " + buttonMove.get(startingColumnIndex));
                System.out.println("endingRowIndexInList: " + endingRowIndex);
                System.out.println("endingRowIndexOnTable: " + buttonMove.get(endingRowIndex));
                System.out.println("endingColumnIndexInList: " + endingColumnIndex);
                System.out.println("endingColumnIndexOnTable: " + buttonMove.get(endingColumnIndex));
                System.out.println("tookButtonRowIndexInList: " + tookButtonRowIndex);
                System.out.println("tookButtonRowIndexOnTable: " + buttonMove.get(tookButtonRowIndex));
                System.out.println("tookButtonColumnIndexInList: " + tookButtonColumnIndex);
                System.out.println("tookButtonColumnIndexOnTable: " + buttonMove.get(tookButtonColumnIndex));
                System.out.println();

                System.out.println("-------------------------------------------------------------");
                System.out.println();

                System.out.println("mustMakeMove");
                System.out.println();

                boardBeforeMove = initialBoard;

                System.out.println(boardBeforeMove);
                System.out.println();

// ---------------------------------------------------------------------------------------------------------------------
// initial position on board for button before jump move

                // nupu startimise koht
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("0")) {
                    //firstRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(0).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("1")) {
                    //secondRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(1).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("2")) {
                    //thirdRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(2).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("3")) {
                    //fourthRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(3).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("4")) {
                    //fifthRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(4).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("5")) {
                    //sixthRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(5).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("6")) {
                    //seventhRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(6).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("7")) {
                    //eightRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(7).set((int) buttonMove.get(startingColumnIndex), 0);
                }

// ---------------------------------------------------------------------------------------------------------------------
// subsequent position on board for button after jump move

                // nupu maandumise koht
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("0") && buttonValue.equals("2")) {
                    //firstRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(0).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("0") && buttonValue.equals("3")) {
                    //firstRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(0).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("1") && buttonValue.equals("2")) {
                    //secondRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(1).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("1") && buttonValue.equals("3")) {
                    //secondRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(1).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("2") && buttonValue.equals("2")) {
                    //thirdRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(2).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("2") && buttonValue.equals("3")) {
                    //thirdRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(2).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("3") && buttonValue.equals("2")) {
                    //fourthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(3).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("3") && buttonValue.equals("3")) {
                    //fourthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(3).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("4") && buttonValue.equals("2")) {
                    //fifthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(4).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("4") && buttonValue.equals("3")) {
                    //fifthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(4).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("5") && buttonValue.equals("2")) {
                    //sixthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(5).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("5") && buttonValue.equals("3")) {
                    //sixthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(5).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("6") && buttonValue.equals("2")) {
                    //seventhRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(6).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("6") && buttonValue.equals("3")) {
                    //seventhRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(6).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("7") && buttonValue.equals("2")) {
                    //eightRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(7).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("7") && buttonValue.equals("3")) {
                    //eightRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(7).set((int) buttonMove.get(endingColumnIndex), 3);
                }

// ---------------------------------------------------------------------------------------------------------------------
// opposite player button position after being jumped

                // äravõetud nupp
                if (String.valueOf(buttonMove.get(tookButtonRowIndex)).equals("0")) {
                    //firstRow.set((int) buttonMove.get(tookButtonColumnIndex), 0);
                    updatedBoard.get(0).set((int) buttonMove.get(tookButtonColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(tookButtonRowIndex)).equals("1")) {
                    //secondRow.set((int) buttonMove.get(tookButtonColumnIndex), 0);
                    updatedBoard.get(1).set((int) buttonMove.get(tookButtonColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(tookButtonRowIndex)).equals("2")) {
                    //thirdRow.set((int) buttonMove.get(tookButtonColumnIndex), 0);
                    updatedBoard.get(2).set((int) buttonMove.get(tookButtonColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(tookButtonRowIndex)).equals("3")) {
                    //fourthRow.set((int) buttonMove.get(tookButtonColumnIndex), 0);
                    updatedBoard.get(3).set((int) buttonMove.get(tookButtonColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(tookButtonRowIndex)).equals("4")) {
                    //fifthRow.set((int) buttonMove.get(tookButtonColumnIndex), 0);
                    updatedBoard.get(4).set((int) buttonMove.get(tookButtonColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(tookButtonRowIndex)).equals("5")) {
                    //sixthRow.set((int) buttonMove.get(tookButtonColumnIndex), 0);
                    updatedBoard.get(5).set((int) buttonMove.get(tookButtonColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(tookButtonRowIndex)).equals("6")) {
                    //seventhRow.set((int) buttonMove.get(tookButtonColumnIndex), 0);
                    updatedBoard.get(6).set((int) buttonMove.get(tookButtonColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(tookButtonRowIndex)).equals("7")) {
                    //eightRow.set((int) buttonMove.get(tookButtonColumnIndex), 0);
                    updatedBoard.get(7).set((int) buttonMove.get(tookButtonColumnIndex), 0);
                }

// ---------------------------------------------------------------------------------------------------------------------
// showing initial board configuration and subsequent board configuration

                System.out.println("moveCompleted");
                System.out.println();

                boardAfterMove = updatedBoard;

                System.out.println(boardAfterMove);
                System.out.println();

                List<Integer> beforeMustMakeMove = new ArrayList<Integer>(boardBeforeMove);
                List<Integer> afterMustMakeMove = new ArrayList<Integer>(boardAfterMove);

                beforeMustMakeMove.removeAll(boardAfterMove);
                afterMustMakeMove.removeAll(boardBeforeMove);

                System.out.println("-------------------------------------------------------------");
                System.out.println();
                System.out.println("Showing only difference on board: before move:");
                System.out.println();
                System.out.println(beforeMustMakeMove);
                System.out.println();
                System.out.println("Showing only difference on board: after move:");
                System.out.println();
                System.out.println(afterMustMakeMove);
                System.out.println();
                System.out.println("-------------------------------------------------------------");
                System.out.println();
            }

// ---------------------------------------------------------------------------------------------------------------------
// applying random regular move

            if (buttonMove.get((int) randomIndex.get(index)).equals("canMakeMove")) {

                startingRowIndex = (int) randomIndex.get(index) + 5;
                startingColumnIndex = (int) randomIndex.get(index) + 6;
                endingRowIndex = (int) randomIndex.get(index) + 8;
                endingColumnIndex = (int) randomIndex.get(index) + 9;

                // testin indexeid
                System.out.println("startingRowIndexInList: " + startingRowIndex);
                System.out.println("startingRowIndexOnTable: " + buttonMove.get(startingRowIndex));
                System.out.println("startingColumnIndexInList: " + startingColumnIndex);
                System.out.println("startingColumnIndexOnTable: " + buttonMove.get(startingColumnIndex));
                System.out.println("endingRowIndexInList: " + endingRowIndex);
                System.out.println("endingRowIndexOnTable: " + buttonMove.get(endingRowIndex));
                System.out.println("endingColumnIndexInList: " + endingColumnIndex);
                System.out.println("endingColumnIndexOnTable: " + buttonMove.get(endingColumnIndex));
                System.out.println();

                System.out.println("-------------------------------------------------------------");
                System.out.println();

                System.out.println("canMakeMove");
                System.out.println();

                boardBeforeMove = initialBoard;

                System.out.println(boardBeforeMove);
                System.out.println();

// ---------------------------------------------------------------------------------------------------------------------
// initial position on board for button before regular move

                // nupu startimise koht
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("0")) {
                    //firstRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(0).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("1")) {
                    //secondRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(1).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("2")) {
                    //thirdRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(2).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("3")) {
                    //fourthRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(3).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("4")) {
                    //fifthRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(4).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("5")) {
                    //sixthRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(5).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("6")) {
                    //seventhRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(6).set((int) buttonMove.get(startingColumnIndex), 0);
                }
                if (String.valueOf(buttonMove.get(startingRowIndex)).equals("7")) {
                    //eightRow.set((int) buttonMove.get(startingColumnIndex), 0);
                    updatedBoard.get(7).set((int) buttonMove.get(startingColumnIndex), 0);
                }

// ---------------------------------------------------------------------------------------------------------------------
// subsequent position on board for button after regular move

                // nupu maandumise koht
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("0") && buttonValue.equals("2")) {
                    //firstRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(0).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("0") && buttonValue.equals("3")) {
                    //firstRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(0).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("1") && buttonValue.equals("2")) {
                    //secondRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(1).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("1") && buttonValue.equals("3")) {
                    //secondRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(1).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("2") && buttonValue.equals("2")) {
                    //thirdRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(2).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("2") && buttonValue.equals("3")) {
                    //thirdRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(2).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("3") && buttonValue.equals("2")) {
                    //fourthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(3).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("3") && buttonValue.equals("3")) {
                    //fourthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(3).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("4") && buttonValue.equals("2")) {
                    //fifthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(4).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("4") && buttonValue.equals("3")) {
                    //fifthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(4).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("5") && buttonValue.equals("2")) {
                    //sixthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(5).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("5") && buttonValue.equals("3")) {
                    //sixthRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(5).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("6") && buttonValue.equals("2")) {
                    //seventhRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(6).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("6") && buttonValue.equals("3")) {
                    //seventhRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(6).set((int) buttonMove.get(endingColumnIndex), 3);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("7") && buttonValue.equals("2")) {
                    //eightRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(7).set((int) buttonMove.get(endingColumnIndex), 2);
                }
                if (String.valueOf(buttonMove.get(endingRowIndex)).equals("7") && buttonValue.equals("3")) {
                    //eightRow.set((int) buttonMove.get(endingColumnIndex), 2);
                    updatedBoard.get(7).set((int) buttonMove.get(endingColumnIndex), 3);
                }

// ---------------------------------------------------------------------------------------------------------------------
// showing initial board configuration and subsequent board configuration

                System.out.println("moveCompleted");
                System.out.println();

                boardAfterMove = updatedBoard;

                System.out.println(boardAfterMove);
                System.out.println();

                List<Integer> beforeCanMakeMove = new ArrayList<Integer>(boardBeforeMove);
                List<Integer> afterCanMakeMove = new ArrayList<Integer>(boardAfterMove);

                beforeCanMakeMove.removeAll(boardAfterMove);
                afterCanMakeMove.removeAll(boardBeforeMove);

                System.out.println("-------------------------------------------------------------");
                System.out.println();
                System.out.println("Showing only difference on board: before move");
                System.out.println();
                System.out.println(beforeCanMakeMove);
                System.out.println();
                System.out.println("Showing only difference on board: after move:");
                System.out.println();
                System.out.println(afterCanMakeMove);
                System.out.println();
                System.out.println("-------------------------------------------------------------");
                System.out.println();
            }
        }

// ---------------------------------------------------------------------------------------------------------------------
// losing condition

        if (!movesAvailable) {
            System.out.println();
            System.out.println("*** No more moves available. You have lost the game! ***");
            System.out.println();
            System.out.println("-------------------------------------------------------------");
            System.out.println();
        }

// ---------------------------------------------------------------------------------------------------------------------
// returning subsequent board after random move

        return updatedBoard;
    }
}