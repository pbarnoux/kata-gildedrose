package code.kata.gildedrose;

import java.util.ArrayList;
import java.util.List;

public class Inn {

	private List<Item> items;

	public Inn() {
		items = new ArrayList<Item>();
		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
	}

	public List<Item> getItems() {
		return items;
	}

	public void updateQuality() {
		for (Item item : items) {
			if (item.getName().equals("Aged Brie")) {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);

					if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (item.getSellIn() < 11) {
							if (item.getQuality() < 50) {
								item.setQuality(item.getQuality() + 1);
							}
						}

						if (item.getSellIn() < 6) {
							if (item.getQuality() < 50) {
								item.setQuality(item.getQuality() + 1);
							}
						}
					}
				}
			} else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);

					if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
						if (item.getSellIn() < 11) {
							if (item.getQuality() < 50) {
								item.setQuality(item.getQuality() + 1);
							}
						}

						if (item.getSellIn() < 6) {
							if (item.getQuality() < 50) {
								item.setQuality(item.getQuality() + 1);
							}
						}
					}
				}
			} else if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
			} else {
				if (item.getQuality() > 0) {
					item.setQuality(item.getQuality() - 1);
				}
			}

			if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
			} else {
				item.setSellIn(item.getSellIn() - 1);
			}

			if (item.getSellIn() < 0) {
				if (item.getName().equals("Aged Brie")) {
					if (item.getQuality() < 50) {
						item.setQuality(item.getQuality() + 1);
					}
				} else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
					item.setQuality(item.getQuality() - item.getQuality());
				} else if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
				} else {
					if (item.getQuality() > 0) {
						item.setQuality(item.getQuality() - 1);
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("OMGHAI!");
		new Inn().updateQuality();
	}
}

