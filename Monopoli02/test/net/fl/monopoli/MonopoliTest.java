package net.fl.monopoli;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import org.junit.Test;


public class MonopoliTest {

  @Test
  public void threePlayersScenario() {
    Monopoli monopoli = new Monopoli();
    
    Player player1 = new Player("Player 1");
    monopoli.addPlayer(player1);
    assertThat(player1.position(), is(monopoli.square(0)));
    
    Player player2 = new Player("Player 2");
    monopoli.addPlayer(player2);
    assertThat(player2.position(), is(monopoli.square(0)));
    
    Player player3 = new Player("Player 3");
    monopoli.addPlayer(player3);
    assertThat(player3.position(), is(monopoli.square(0)));
    
    assertEquals(player1, monopoli.nextPlayer());
    player1.throwDice(new FixedResultDie(1), new FixedResultDie(3));
    assertThat(player1.position(), is(monopoli.square(3)));
    
    assertEquals(player2, monopoli.nextPlayer());
    player2.throwDice(new FixedResultDie(1), new FixedResultDie(5));
    assertThat(player2.position(), is(monopoli.square(6)));
    
    assertEquals(player3, monopoli.nextPlayer());
    player3.throwDice(new FixedResultDie(1), new FixedResultDie(40));
    assertThat(player3.position(), is(monopoli.square(0)));   
  }
}
