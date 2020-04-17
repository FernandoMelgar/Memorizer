package mode.shopping.gateway;
import mode.shopping.ShopGateway;
import mode.shopping.ShopItem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class InMemoryShopGateway implements ShopGateway {
  private final String[] itemsText = new String[]{"Lechuga","Calabaza","Lechera", "Tortillas", "Manzana", "Pera", "Zanahoria"};
  private List<ShopItem> items;
  private Random rnd;
  private String scorePath = "C:\\Apt\\Memorizer\\scores.txt";
  public InMemoryShopGateway() {
    this.items = new ArrayList<>();
    rnd = new Random();
    createInMemoryItems();
  }

  @Override
  public int getMaxShoppingListSize(){
    return  itemsText.length;
  }
  private void createInMemoryItems() {
    for (String text : itemsText)
      items.add( new ShopItem(text, rnd.nextInt(5),  rnd.nextInt(10) % 2 == 0 ? "kg" : "pz"));
  }

  @Override
  public List<ShopItem> getRandomItems(int n) {
    if (n > items.size())
      throw new IndexOutOfBoundsException("The number of elements you request for exceeds the available amount");
    return randomItemsSelect(n);
  }

  @Override
  public void addItem(ShopItem item) {
    items.add(item);
  }

  @Override
  public List<String> getHistory() {
   List<String> history = new ArrayList<>();
    try {
      history = Files.readAllLines(Paths.get(scorePath));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return history;
  }

  @Override
  public void saveScore(int good, int total, float totalTimeInSeconds, String difficulty) {
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String score = String.format("\n%s %s/%s %ss %s", formatter.format(new Date()), good, total, totalTimeInSeconds, difficulty);
    try {
      Files.writeString(Paths.get(scorePath),score, StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private List<ShopItem> randomItemsSelect(int n) {
    List<ShopItem> randomItemList = new ArrayList<>();
    while (randomItemList.size() < n) {
      int randomIndex = rnd.nextInt(items.size());
      ShopItem toAdd = items.get(randomIndex);
      if(!randomItemList.contains(toAdd))
        randomItemList.add(toAdd);
    }
    return randomItemList;
  }
}

