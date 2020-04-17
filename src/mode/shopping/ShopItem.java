package mode.shopping;

import java.util.Objects;

public class ShopItem {
  private final String text;
  private final int amount;
  private final String unit;


  public ShopItem(String text, int amount, String unit) {
    this.text = text;
    this.amount = amount;
    this.unit = unit;
  }

  public ShopItem(String text) {
    this.text = text;
    this.amount = 1;
    this.unit = "none";
  }

  public String getText() {
    return text;
  }

  public int getAmount() {
    return amount;
  }

  public String getUnit() {
    return unit;
  }

  @Override
  public String toString() {
    return "ShoppingItem{" +
        "name='" + text + '\'' +
        ", amount=" + amount +
        ", unit='" + unit + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ShopItem that = (ShopItem) o;
    return amount == that.amount &&
        Objects.equals(text, that.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(text);
  }
}
