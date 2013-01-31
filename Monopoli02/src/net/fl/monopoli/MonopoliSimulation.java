package net.fl.monopoli;

public class MonopoliSimulation {

  private static final int NR_OF_TURNS = 20;
  
  private Monopoli monopoli;

  public MonopoliSimulation(int nrOfPlayers) {
    createGame(nrOfPlayers);
    Die die1 = new RandomDie(6);
    Die die2 = new RandomDie(6);
    for (int i = 1; i < NR_OF_TURNS; i++) {
      monopoli.newRound();
      for (Player player = monopoli.nextPlayer(); player != null; player = monopoli.nextPlayer()) {
        System.out.println(player + " is on " + monopoli.position(player));
        player.throwDice(die1, die2);
        System.out.println(player + " rolls " + die1.result() + " / " + die2.result());
        System.out.println(player + " goes on square " + monopoli.position(player));
      } 
    }
  }

  protected void createGame(int nrOfPlayers) {
    monopoli = new Monopoli();
    for (int i = 1; i <= nrOfPlayers; i++) {
      monopoli.addPlayer(new Player("Player " + i));
    }
  }

}
