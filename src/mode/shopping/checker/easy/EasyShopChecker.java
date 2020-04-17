package mode.shopping.checker.easy;

import mode.shopping.checker.ShopChecker;
import mode.shopping.ShopItem;

import java.util.List;

public class EasyShopChecker implements ShopChecker {


  @Override
  public boolean check(ShopItem expected, ShopItem actual) {
    return expected.getText().equalsIgnoreCase(actual.getText());
  }

  @Override
  public Boolean[] check(List<ShopItem> expected, List<ShopItem> actual) {
    if (expected.size() != actual.size())
        throw new IndexOutOfBoundsException("Both List need to be the same size");
    Boolean[] answers =  new Boolean[expected.size()];
    for (int i = 0; i < expected.size(); i++)
        answers[i] = check(expected.get(i), actual.get(i));
    return answers;
  }

  @Override
  public String getDifficulty() {
    return "easy";
  }
}
