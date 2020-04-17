package mode.shopping.checker;

import mode.shopping.checker.easy.EasyShopChecker;
import mode.shopping.checker.veryeasy.VeryEasyShopChecker;

public class ShoppingCheckerFactory {
  public static ShopChecker buildByDifficulty(String difficulty){
    if (difficulty.equals("veryEasy"))
      return new VeryEasyShopChecker();
    if(difficulty.equals("easy"))
      return new EasyShopChecker();
    else throw new UnsupportedOperationException("Problem with your selection, got:" + difficulty + " expected: " + ShoppingCheckerFactory.showAvailableOptions());
  }
  public static String showAvailableOptions(){
    return "veryEasy, easy";
  }

}
