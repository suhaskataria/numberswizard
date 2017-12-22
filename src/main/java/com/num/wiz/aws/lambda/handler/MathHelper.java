package com.num.wiz.aws.lambda.handler;

import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

import java.util.concurrent.ThreadLocalRandom;

public class MathHelper {


    public static Triple getTheGameForLevel(String gameType, String level) {
        //TODO Score should also be sent with the results and stored in session or db update if answer is correct
        Triple triple = null;
        if (GameType.ADDITION.name().equalsIgnoreCase(gameType)) {
            triple = getAdditionGame(level);
        } else if (GameType.SUBTRACTION.name().equalsIgnoreCase(gameType)) {
            triple = getSubtractionGame(level);
        } else if (GameType.DIVISION.name().equalsIgnoreCase(gameType)) {
            triple = getDivisionGame(level);
        } else if (GameType.MULTIPLICATION.name().equalsIgnoreCase(gameType)) {
            triple = getMultiplicationGame(level);
        }
        return triple;
    }

    public static Triple getAdditionGame(String level) {
        Triple triple = null;
        int leftValue = 0;
        int rightValue = 0;
        int result = 0;
        switch(level.toLowerCase()) {
            case "easy" :
                leftValue = getSingleDigitNumber();
                rightValue = getSingleDigitNumber();
                result = leftValue + rightValue;
            case "medium" :
                leftValue = getDoubleDigitNumber();
                rightValue = getDoubleDigitNumber();
                result = leftValue + rightValue;
            case "hard" :
                leftValue = getTripleDigitNumber();
                rightValue = getTripleDigitNumber();
                result = leftValue + rightValue;
        }
        triple = new ImmutableTriple(leftValue,rightValue,result);
        return triple;
    }

    public static Triple getMultiplicationGame(String level) {
        Triple triple = null;
        int leftValue = 0;
        int rightValue = 0;
        int result = 0;
        switch(level.toLowerCase()) {
            case "easy" :
                leftValue = getSingleDigitNumber();
                rightValue = getSingleDigitNumber();
                result = leftValue * rightValue;
            case "medium" : {
                leftValue = getDoubleDigitNumber();
                rightValue = getDoubleDigitNumber();
                result = leftValue * rightValue;
            }
            case "hard" :
                leftValue = getTripleDigitNumber();
                rightValue = getTripleDigitNumber();
                result = leftValue * rightValue;
        }
        triple = new ImmutableTriple(leftValue,rightValue,result);
        return triple;
    }

    public static Triple getSubtractionGame(String level) {
        Triple triple = null;
        int leftValue = 0;
        int rightValue = 0;
        int result = 0;
        switch(level.toLowerCase()) {
            case "easy" :
                leftValue = getSingleDigitNumber();
                rightValue = getSingleDigitNumber();
                result = leftValue - rightValue;
            case "medium" :
                leftValue = getDoubleDigitNumber();
                rightValue = getDoubleDigitNumber();
                result = leftValue - rightValue;
            case "hard" :
                leftValue = getTripleDigitNumber();
                rightValue = getTripleDigitNumber();
                result = leftValue - rightValue;
        }
        triple = new ImmutableTriple(leftValue,rightValue,result);
        return triple;
    }

    public static Triple getDivisionGame(String level) {
        Triple triple = null;
        int leftValue = 0;
        int rightValue = 0;
        int result = 0;
        switch(level.toLowerCase()) {
            case "easy" :
                leftValue = getSingleDigitNumber();
                rightValue = getSingleDigitNumber();
                result = leftValue / rightValue;
            case "medium" :
                leftValue = getDoubleDigitNumber();
                rightValue = getDoubleDigitNumber();
                result = leftValue / rightValue;
            case "hard" :
                leftValue = getTripleDigitNumber();
                rightValue = getTripleDigitNumber();
                result = leftValue / rightValue;
        }
        triple = new ImmutableTriple(leftValue,rightValue,result);
        return triple;
    }

    public static int getSingleDigitNumber() {
        int rand = ThreadLocalRandom.current().nextInt(0,9);
        return rand;
    }

    public static int getDoubleDigitNumber() {
        int rand = ThreadLocalRandom.current().nextInt(10,99);
        return rand;
    }

    public static int getTripleDigitNumber() {
        int rand = ThreadLocalRandom.current().nextInt(100,999);
        return rand;
    }
}