package mode.shopping;

import java.util.List;

public interface ShopGateway {
  int getMaxShoppingListSize();
  List<ShopItem> getRandomItems(int n) throws NumberFormatException;
  void addItem(ShopItem item);
  List<String> getHistory();
  void saveScore(int countGood, int size, float totalTimeInSeconds, String difficulty);
}
