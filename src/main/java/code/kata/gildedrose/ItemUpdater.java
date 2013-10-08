package code.kata.gildedrose;

public class ItemUpdater {
	public Item item;

	public ItemUpdater(Item item) {
		this.item = item;
	}

	public void update() {
		if (item.getName().equals("Sulfuras, Hand of Ragnaros")) {
			return;
		}
		item.setSellIn(item.getSellIn() - 1);

		if (item.getName().equals("Aged Brie")) {
			increaseQuality();

			if (item.getSellIn() < 0) {
				increaseQuality();
			}
		} else if (item.getName().equals(
				"Backstage passes to a TAFKAL80ETC concert")) {
			increaseQuality();

			if (item.getSellIn() < 10) {
				increaseQuality();
			}

			if (item.getSellIn() < 5) {
				increaseQuality();
			}
			if (item.getSellIn() < 0) {
				item.setQuality(0);
			}
		} else {
			decreaseQuality();

			if (item.getSellIn() < 0) {
				decreaseQuality();
			}
		}
	}

	public void decreaseQuality() {
		if (item.getQuality() > 0) {
			item.setQuality(item.getQuality() - 1);
		}
	}

	public void increaseQuality() {
		if (item.getQuality() < 50) {
			item.setQuality(item.getQuality() + 1);
		}
	}
}