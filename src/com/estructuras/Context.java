package com.estructuras;
import mode.shopping.gateway.InMemoryShopGateway;
import mode.shopping.checker.ShoppingCheckerFactory;
import mode.shopping.ShoppingGameContext;
import mode.shopping.view.ShoppingConsoleView;

import java.util.Scanner;

public class Context {
  private Scanner scanner = new Scanner(System.in);
  private static final String shoppingMode = "1";
  private static final String showHistoryMode = "2";

  private void play(){
   String mode = showInstructions();
    startMode(mode);
  }

    private String showInstructions() {
      System.out.println("Welcome to memorizer, please select a mode: \n 1) Shopping List \n2)Show History");
      return scanner.nextLine();
    }

    private void startMode(String mode) {
      if (mode.equalsIgnoreCase(shoppingMode))
        playShoppingMode();
      if(mode.equals(showHistoryMode))
        showHistory();
      else
        System.out.println("You select a wrong game mode, please try again");
    }

  private void showHistory() {

  }

  private void playShoppingMode() {
        System.out.println("Please select a difuculty: \n1) veryEasy \n2) Easy");
        String diffId = scanner.nextLine();
        String difficulty = diffId.equals("1") ? "veryEasy" : "easy";
        ShoppingGameContext shoppingGameContext = new ShoppingGameContext(new ShoppingConsoleView(), new InMemoryShopGateway(),
            ShoppingCheckerFactory.buildByDifficulty(difficulty));
        shoppingGameContext.play();
  }

  public static void main(String[] args) {
    Context context = new Context();
    context.play();
  }
}

