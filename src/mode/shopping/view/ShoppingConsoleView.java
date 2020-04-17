package mode.shopping.view;

import mode.shopping.ShopItem;
import mode.shopping.ShopView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingConsoleView  implements ShopView {
  private Scanner scanner = new Scanner(System.in);

  @Override
  public void showShoppingItems(List<ShopItem> shoppingList) {
    System.out.println("Instructions: Remember the list in order");
    printShoppingList(shoppingList);
    System.out.println("Press Enter to continue");
    if (scanner.nextLine() != null)
      clearView();
  }
      private void printShoppingList(List<ShopItem> shoppingList) {
        for (int i = 0; i < shoppingList.size(); i++)
          System.out.println((i + 1) +")"+ shoppingList.get(i).getText());
      }

  @Override
  public String ask() {
    return scanner.nextLine();
  }

  @Override
  public List<ShopItem> askForNofShopItems(int n) {
    System.out.println("Please insert the shopping list in order");
    List<ShopItem> userAnswers = new ArrayList<>();
    for (int i = 0; i < n ; i++){
      System.out.print((i + 1) + ") ");
      userAnswers.add(new ShopItem(scanner.nextLine().trim()));
    }
    return userAnswers;
  }

  @Override
  public int askForNofItems(int MAX_ITEMS) {
    System.out.println("Please insert the number for your shopping cart MAX SIZE = " + MAX_ITEMS);
    return getValidNumberOfItems(MAX_ITEMS);
  }
      private int getValidNumberOfItems(int maxSize) {
        boolean isValid = false;
        int n = 0;
        while  (!isValid){
          try {
            n = Integer.parseInt(scanner.nextLine());
            if (n > maxSize)
              throw new NumberFormatException();
            isValid = true;
          }catch (NumberFormatException nfe){
            System.out.println("Please use a valid shopping list number MAX SIZE = " + maxSize);
          }
        }
        return n;
      }

  @Override
  public void clearView() {
    System.out.println("\n\n\n\n\n\n\n\n\n");
  }

  @Override
  public void displayResults(Boolean[] answersScore, List<ShopItem> shoppingList, List<ShopItem> userAnswers) {
    int totalCorrect = 0;
    for (int i = 0; i < answersScore.length; i++) {
      if (!answersScore[i])
        System.out.println("Error in item (" + (i + 1) + ") Expected: " + shoppingList.get(i).getText() + " Was: " + userAnswers.get(i).getText());
      else
        totalCorrect += 1;
    }
    if (totalCorrect == shoppingList.size())
      System.out.println("Excellent you got 0 errors, good work :) ");
    else
      System.out.println("you got " + totalCorrect + " of " + shoppingList.size() + " Correct");
  }

  @Override
  public void display(String s) {
    System.out.println(s);
  }
  @Override
  public void display(List<String> historyItem) {
    for (String item :
        historyItem) {
      display(item);
    }
  }


}
