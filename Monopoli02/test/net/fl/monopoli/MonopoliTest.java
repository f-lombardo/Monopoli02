package net.fl.monopoli;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.*;


public class MonopoliTest {
  
  private Monopoli monopoli;

  @Before
  public void setUp() {
    monopoli = new Monopoli();
  }
  
  @Test
  public void threePlayersScenario() {
    Player player1 = newPlayerStartingOnSquareZero("Player1");
    Player player2 = newPlayerStartingOnSquareZero("Player 2");
    Player player3 = newPlayerStartingOnSquareZero("Player 3");
    
    monopoli.newRound();
    
    assertPlayerMovesAroundAccordingToDice(player1, 1, 3);
    assertPlayerMovesAroundAccordingToDice(player2, 5, 5);
    assertPlayerMovesAroundAccordingToDice(player3, 50, 6);
  }
  
  @Test
  public void nextPlayerReturnsNullOnNoMorePlayers() {
    Player player1 = newPlayerStartingOnSquareZero("Player1");
    Player player2 = newPlayerStartingOnSquareZero("Player 2");
    
    monopoli.newRound();
    assertThat(monopoli.nextPlayer(), is(player1));
    assertThat(monopoli.nextPlayer(), is(player2));
    assertNull(monopoli.nextPlayer());
    
    monopoli.newRound();
    assertThat(monopoli.nextPlayer(), is(player1));
    assertThat(monopoli.nextPlayer(), is(player2));
    assertNull(monopoli.nextPlayer());
  }
  
  @Test
  public void tooManyPlayersAreNotAdmitted() throws Exception {
    for (int i = 1; i <= Monopoli.MAX_PLAYERS; i++) {
      newPlayerStartingOnSquareZero("Player " + i);
    }
    try {
      newPlayerStartingOnSquareZero("LastPlayer");
      fail("Too many players accepted");
    } catch (TooManyPlayersException e) {
    }
  }
  
  private void assertPlayerMovesAroundAccordingToDice(Player player, int die1Result, int die2Result) {
    assertEquals(player, monopoli.nextPlayer());
    player.throwDice(new FixedResultDie(die1Result), new FixedResultDie(die2Result));
    assertThat(monopoli.position(player), is(monopoli.square((die1Result + die2Result) % monopoli.size())));
  }
  
  private Player newPlayerStartingOnSquareZero(String playerName) {
    Player player = new Player(playerName);
    monopoli.addPlayer(player);
    Square position = monopoli.position(player);
    assertNotNull("Position shouldn't be null", position);
    assertThat(position, is(monopoli.square(0)));
    return player;
  }
}
