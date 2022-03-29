package com.example.bulsandcows1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    // 3629
    // 1239 2 коровы (2 и 3) 1 бык (9)

    public static class BullCowCount{
        private int bulls;
        private int cows;

        public BullCowCount(int bulls, int cows) {
            this.bulls = bulls;
            this.cows = cows;
        }

        public int getBulls() {
            return bulls;
        }

        public void setBulls(int bulls) {
            this.bulls = bulls;
        }

        public int getCows() {
            return cows;
        }

        public void setCows(int cows) {
            this.cows = cows;
        }
    }

    private final int[] guessNumber;

    public Game() {
        this.guessNumber = generateNumber();
    }

    public String getGuessNumber(){
        return "" + guessNumber[0] + guessNumber[1] + guessNumber[2] + guessNumber[3];
    }

    private int[] generateNumber() {
        final Random random = new Random();
        List<Integer> integers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(integers);//перемешивает коллекцию
        int a[] = {0,1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < 100; i++) {
            final int i1 = random.nextInt(10);
            final int i2 = random.nextInt(10);
            int c = a[i1];
            a[i1] = a[i2];
            a[i2] = c;
        }
        return new int[]{a[0], a[2], a[3], a[4]};
    }

    public BullCowCount calcBullsAndCows(String userNumber){
        int bulls = 0, cows=0;
        for (int i = 0; i < 4; i++) {
            if(guessNumber[i] == userNumber.charAt(i)-'0'){
                bulls++;
            } else if (userNumber.contains(String.valueOf(guessNumber[i]))){
                cows++;
            }
        }
        return new BullCowCount(bulls, cows);
    }
}
