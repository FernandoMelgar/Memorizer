package mode.shopping;

import mode.shopping.checker.ShopChecker;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class ShoppingGameContext {
  private Scanner scanner = new Scanner(System.in);
  private ShopGateway gateway;
  private ShopView view;
  private ShopChecker checker;
  private int MAX_ITEMS;
  private Instant start;
  private float totalTimeInSeconds;

  public ShoppingGameContext(ShopView view, ShopGateway gateway, ShopChecker checker) {
    this.view = view;
    this.gateway = gateway;
    this.checker = checker;
    MAX_ITEMS = this.gateway.getMaxShoppingListSize();
  }

  public void play(){
    boolean playing = true;
    while (playing){
      List<ShopItem> shoppingList = loadShoppingList();
      List<ShopItem> userAnswers = playGame(shoppingList);
      checkAnswers(shoppingList, userAnswers);
      view.display("Do you want to play again? y/n");
      playing = view.ask().equalsIgnoreCase("y");
    }
  }

      private List<ShopItem> loadShoppingList() {
            int nOfItems = view.askForNofItems(MAX_ITEMS);
            return gateway.getRandomItems(nOfItems);
          }

      private List<ShopItem> playGame(List<ShopItem> shoppingList) {
        startTimeCounting();
        view.showShoppingItems(shoppingList);
        List<ShopItem> userAnswers = view.askForNofShopItems(shoppingList.size());
        endTimeCounting();
        return userAnswers;
      }

          private void startTimeCounting() {
            start = Instant.now();
          }
          private void endTimeCounting() {
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            totalTimeInSeconds = (timeElapsed/1000F);
          }

      private void checkAnswers(List<ShopItem> shoppingList, List<ShopItem> userAnswers) {
        Boolean[] answersScore = checker.check(shoppingList, userAnswers);
        view.displayResults(answersScore, shoppingList, userAnswers);
        view.display(String.format("Your total time was: %.1f seconds", totalTimeInSeconds));
        gateway.saveScore(countGood(answersScore), shoppingList.size(),totalTimeInSeconds,checker.getDifficulty());
      }

          private int countGood(Boolean[] answersScore) {
            int good = 0;
            for (boolean b : answersScore) if (b) good += 1;
            return good;
          }
}
