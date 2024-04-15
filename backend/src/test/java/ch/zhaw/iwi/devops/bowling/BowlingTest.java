package ch.zhaw.iwi.devops.bowling;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingTest {


    @Test
    public void testEmptyGame() {
        Game game = new Game();
        Assertions.assertEquals(0, game.score());
    }

    @Test
    public void testAllZeros() {
        Game game = new Game();
        for(int i=0; i<20; i++) game.roll(0);
        Assertions.assertEquals(0, game.score());
    }

    @Test
    public void testAllOnes() {
        Game game = new Game();
        for(int i=0; i<20; i++) game.roll(1);
        Assertions.assertEquals(20, game.score());
    }
    
    @Test
    public void testOneSpare() {
        Game game = new Game();
        game.roll(7); // Spare part 1
        game.roll(3); // Spare part 2
        game.roll(3); // First roll after spare
        for(int i=0; i<17; i++) game.roll(0);
        Assertions.assertEquals(16, game.score());
    }

    @Test
    public void testOneStrike() {
        Game game = new Game();
        game.roll(10); // Strike
        game.roll(3);
        game.roll(4);
        for(int i=0; i<16; i++) game.roll(0);
        Assertions.assertEquals(24, game.score());
    }
    
    @Test
    public void testPerfectGame() {
        Game game = new Game();
        for(int i=0; i<12; i++) game.roll(10);
        Assertions.assertEquals(300, game.score());
    }

    @Test
    public void testEndOfArray() {
        Game game = new Game();
        for(int i=0; i<18; i++) game.roll(0);
        game.roll(5);
        game.roll(5); // Spare in last frame
        game.roll(5); // Bonus roll
        Assertions.assertEquals(15, game.score());
    }

    @Test
    public void testSampleGame() {
        Game game = new Game();
        int[] rolls = {1,4, 4,5, 6,4, 5,5, 10, 0,1, 7,3, 6,4, 10, 2,8,6};
        for(int pins : rolls) game.roll(pins);
        Assertions.assertEquals(133, game.score());
    }

    @Test
    public void testAllSparesWithFinalFive() {
        Game game = new Game();
        for(int i=0; i<21; i++) game.roll(5);
        Assertions.assertEquals(150, game.score());
    }

    @Test
    public void testRandomGameNoStrikesOrSpares() {
        Game game = new Game();
        int[] rolls = {2, 6, 3, 4, 5, 1, 3, 6, 4, 4, 2, 7, 3, 5, 1, 5, 3, 2, 4, 5};
        for (int pins : rolls) {
            game.roll(pins);
        }
        Assertions.assertEquals(75, game.score());
    }



/* 


    @Test
    public void bowlingTest1(){
        Game game = new Game();
        game.roll(3);
        Assertions.assertEquals(3, game.score());
    }

    @Test
    public void bowlingTest2(){
        Game game = new Game();
        game.roll(1);
        Assertions.assertEquals(1, game.score());
    }

    @Test
    public void bowlingTest3(){
        Game game = new Game();
        game.roll(3);
        game.reset();
        game.roll(3);
        Assertions.assertEquals(, game.score());
    }









    @Test
    public void fizzBuzzConverter1() {

        Bowling fizzBuzz = new Bowling();
        Assertions.assertEquals("1", bowling.convert(1));

    }

    @Test
    public void fizzBuzzConvertor2() {

        Bowling bowling = new Bowling();
        Assertions.assertEquals("2", bowling.convert(2));

    }

    @Test
    public void fizzBuzzConvertor3() {

        Bowling bowling = new Bowling();

        Assertions.assertEquals("Fizz", bowling.convert(3));
    }
    
    @Test
    public void fizzBuzzConvertorMultiplesOfThree() {

        Bowling bowling = new Bowling();

        Assertions.assertEquals("Fizz", bowling.convert(6));
    }

    @Test
    void fizzBuzzConvertorMultiplesOfSeven() {

        Bowling bowling = new Bowling();

        Assertions.assertEquals("Buzz", fizzBuzz.convert(7));
    }

    @Test
    void fizzBuzzConvertorMultiplesOfThreeAndSeven() {
        Bowling fizzBuzz = new Bowling();
        Assertions.assertNotEquals("FizzBuzz", fizzBuzz.convert(14));
        Assertions.assertEquals("FizzBuzz", fizzBuzz.convert(21));
        Assertions.assertEquals("FizzBuzz", fizzBuzz.convert(42));
        Assertions.assertEquals("FizzBuzz", fizzBuzz.convert(63));
    }
    */
}