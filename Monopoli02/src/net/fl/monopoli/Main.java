package net.fl.monopoli;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    System.out.println("Welcome to the Monopoli simulation!");
    System.out.println("Please tell me how many player do you want (from 1 to 8");
    runSimulation();
  }

  private static void runSimulation() {
    try {
      new MonopoliSimulation(readNrOfPlayers());
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  private static int readNrOfPlayers() {
    Scanner scanner = new Scanner(System.in);
    int nrOfPlayers = Integer.parseInt(scanner.nextLine().trim());
    scanner.close();
    return nrOfPlayers;
  }
}
