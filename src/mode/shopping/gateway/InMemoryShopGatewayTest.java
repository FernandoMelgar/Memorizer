package mode.shopping.gateway;

import mode.shopping.ShopGateway;
import mode.shopping.ShopItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryShopGatewayTest {

  ShopGateway repository;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    repository = new InMemoryShopGateway();
    repository.addItem(new ShopItem("Lechuga",1,"kg"));
    repository.addItem(new ShopItem("Papa",1, "kg"));
    repository.addItem(new ShopItem("Zanahoria",1, "kg"));

  }

  @Test
  public void test_get2ListElements(){
    List<ShopItem> randomItems = repository.getRandomItems(2);
    System.out.println("randomItems = " + randomItems);
    assertEquals(2, randomItems.size());
  }
}