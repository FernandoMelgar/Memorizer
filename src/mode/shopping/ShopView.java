package mode.shopping;

import java.util.List;

public interface ShopView {
  void showShoppingItems(List<ShopItem> shoppingList);
  List<ShopItem> askForNofShopItems(int size);
  void displayResults(Boolean[] answersScore, List<ShopItem> shoppingList, List<ShopItem> userAnswers);
  int askForNofItems(int MAX_ITEMS);
  void clearView();
  void display(String s);
  void display(List<String> historyItem);
  String ask();
}
