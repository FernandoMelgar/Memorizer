package mode.shopping.checker.veryeasy;

import mode.shopping.ShopItem;
import mode.shopping.checker.ShopChecker;

import java.util.Arrays;
import java.util.List;

public class VeryEasyShopChecker implements ShopChecker {
  @Override
  public boolean check(ShopItem expected, ShopItem actual) {
    return false;
  }

  @Override
  public Boolean[] check(List<ShopItem> expected, List<ShopItem> actual) {
    if (expected.size() != actual.size())
      throw new IndexOutOfBoundsException("Both List need to be the same size");
    Boolean[] answers = new Boolean[expected.size()];
    Arrays.fill(answers,false);
    for (int i = 0; i < expected.size(); i++) {
      ShopItem item = expected.get(i);
      for (ShopItem shopItem : actual) {
        if (item.getText().equalsIgnoreCase(shopItem.getText())) {
          answers[i] = true;
          break;
        }
      }
    }
    return answers;
  }

  @Override
  public String getDifficulty() {
    return "veryEasy";
  }
}
