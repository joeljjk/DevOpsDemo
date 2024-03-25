package ch.zhaw.iwi.devops.bowling;


public class Game {
    private int[] rolls = new int[21]; // 21 is the max number of rolls in a game
    private int currentRoll = 0;
    
    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }
    
    public int score() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(frameIndex)) { // Strike
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;
            } else if (isSpare(frameIndex)) { // Spare
                score += 10 + spareBonus(frameIndex);
                frameIndex += 2;
            } else {
                score += sumOfBallsInFrame(frameIndex);
                frameIndex += 2;
            }
        }
        return score;
    }
    
    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }
    
    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }
    
    private int sumOfBallsInFrame(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }
    
    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }
    
    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }
}
