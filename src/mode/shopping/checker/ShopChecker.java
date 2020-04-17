package mode.shopping.checker;

import mode.shopping.ShopItem;

import java.util.List;

public interface ShopChecker {
  public boolean check(ShopItem expected, ShopItem actual);
  public Boolean[] check(List<ShopItem> expected, List<ShopItem> actual);
  public String getDifficulty();
}
