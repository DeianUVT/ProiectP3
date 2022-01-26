package GameHubTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameHubTests {
	
	
	//Tests for Roulette
	
	@Test
	void test1() {
		int []cashOn = new int[49];
		Assertions.assertEquals(0,GameHub.Roulette.getNumberOfBetsForTest(cashOn));
	}
	
	@Test
	void test2() {
		int []cashOn = new int[49];
		cashOn[0] = 1;
		cashOn[1] = 1;
		cashOn[2] = 1;
		Assertions.assertEquals(3,GameHub.Roulette.getNumberOfBetsForTest(cashOn));
	}
	
	@Test
	void test3() {
		int []cashOn = new int[49];
		cashOn[0] = 0;
		cashOn[1] = 1;
		cashOn[2] = 0;
		Assertions.assertEquals(1,GameHub.Roulette.getNumberOfBetsForTest(cashOn));
	}
	
	@Test
	void test4() {
		int []cashOn = new int[49];
		for(int i=0; i<30; i++)
			cashOn[i] = 1;
		Assertions.assertEquals(30,GameHub.Roulette.getNumberOfBetsForTest(cashOn));
	}
	
	@Test
	void test5() {
		int []cashOn = new int[49];
		for(int i=0; i<49; i++)
			cashOn[i] = 1;
		cashOn[48] = 0;
		Assertions.assertEquals(48,GameHub.Roulette.getNumberOfBetsForTest(cashOn));
	}
	
	//Tests for X and 0
	
	@Test
	void test6() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		Assertions.assertEquals("Game continues",GameHub.Xand0Computer.verificationForTest(playerOneChoice,playerTwoChoice));
	}
	
	@Test
	void test7() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		playerOneChoice[1] = 1;
		playerOneChoice[2] = 1;
		playerOneChoice[3] = 1;
		Assertions.assertEquals("You won!",GameHub.Xand0Computer.verificationForTest(playerOneChoice,playerTwoChoice));
	}
	
	@Test
	void test8() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		playerTwoChoice[7] = 1;
		playerTwoChoice[5] = 1;
		playerTwoChoice[3] = 1;
		Assertions.assertEquals("You lost!",GameHub.Xand0Computer.verificationForTest(playerOneChoice,playerTwoChoice));
	}
	
	@Test
	void test9() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		playerTwoChoice[1] = 1;
		playerTwoChoice[3] = 1;
		playerTwoChoice[4] = 1;
		playerTwoChoice[8] = 1;
		
		playerOneChoice[2] = 1;
		playerOneChoice[5] = 1;
		playerOneChoice[7] = 1;
		playerOneChoice[6] = 1;
		Assertions.assertEquals("Game continues",GameHub.Xand0Computer.verificationForTest(playerOneChoice,playerTwoChoice));
	}
	
	@Test
	void test10() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		playerTwoChoice[1] = 1;
		playerTwoChoice[3] = 1;
		playerTwoChoice[4] = 1;
		playerTwoChoice[8] = 1;
		
		playerOneChoice[2] = 1;
		playerOneChoice[5] = 1;
		playerOneChoice[7] = 1;
		playerOneChoice[6] = 1;
		playerOneChoice[9] = 1;
		Assertions.assertEquals("Draw",GameHub.Xand0Computer.verificationForTest(playerOneChoice,playerTwoChoice));
	}
	
	@Test
	void test11() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		playerOneChoice[3] = 1;
		playerOneChoice[5] = 1;
		playerOneChoice[7] = 1;
		
		playerTwoChoice[1] = 1;
		playerTwoChoice[2] = 1;
		playerTwoChoice[4] = 1;
		playerTwoChoice[6] = 1;
		playerTwoChoice[8] = 1;
		playerTwoChoice[9] = 1;
		Assertions.assertEquals("You won!",GameHub.Xand0Computer.verificationForTest(playerOneChoice,playerTwoChoice));
	}
	
	@Test
	void test12() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		playerOneChoice[1] = 1;
		playerOneChoice[2] = 1;
		Assertions.assertEquals(3,GameHub.Xand0Computer.intelligentChoiceForTests(playerOneChoice,playerTwoChoice));
	}
	
	@Test
	void test13() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		playerOneChoice[1] = 1;
		playerOneChoice[5] = 1;
		Assertions.assertEquals(9,GameHub.Xand0Computer.intelligentChoiceForTests(playerOneChoice,playerTwoChoice));
	}
	
	@Test
	void test14() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		playerOneChoice[1] = 1;
		playerOneChoice[2] = 1;
		playerOneChoice[4] = 1;
		playerOneChoice[5] = 1;
		
		playerTwoChoice[3] = 1;
		Assertions.assertEquals(6,GameHub.Xand0Computer.intelligentChoiceForTests(playerOneChoice,playerTwoChoice));
	}
	
	@Test
	void test15() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		playerOneChoice[1] = 1;
		playerOneChoice[2] = 1;

		playerTwoChoice[4] = 1;
		playerTwoChoice[5] = 1;
		Assertions.assertEquals(6,GameHub.Xand0Computer.intelligentChoiceForTests(playerOneChoice,playerTwoChoice));
	}
	
	// For RNG
	@Test
	void test16() {
		int playerOneChoice[] = new int[10];
		int playerTwoChoice[] = new int[10];
		int high = 9;
		int low = 0;
		for(int i=0; i<1000; i++)
			assertEquals((high + low) / 2.0, GameHub.Xand0Computer.intelligentChoiceForTests(playerOneChoice,playerTwoChoice), (high - low) / 2.0);
	}
	
	@Test
	void test17() {
		Random random = new Random();
		for(int i=0; i<1000; i++) {
			int spinnedNumber = random.nextInt(37);
			
			int high = 36;
			int low = 0;
			assertEquals((high + low) / 2.0, spinnedNumber, (high - low) / 2.0);
		}
	}
}
