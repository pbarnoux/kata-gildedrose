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

		if (item.getName().equals("Aged Brie")) {
			item.setSellIn(item.getSellIn() - 1);
			if (item.getQuality() < 50) {
				item.setQuality(item.getQuality() + 1);
			}
			if (item.getSellIn() < 0) {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);
				}
			}
		} else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
			item.setSellIn(item.getSellIn() - 1);
			if (item.getQuality() < 50) {
				item.setQuality(item.getQuality() + 1);
			}

			if (item.getSellIn() +1 < 11) {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);
				}
			}

			if (item.getSellIn() +1 < 6) {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);
				}
			}
			if (item.getSellIn() < 0) {
				item.setQuality(item.getQuality() - item.getQuality());
			}
		} else {
			item.setSellIn(item.getSellIn() - 1);
			if (item.getQuality() > 0) {
				item.setQuality(item.getQuality() - 1);
			}
			if (item.getSellIn() < 0) {
				if (item.getQuality() > 0) {
					item.setQuality(item.getQuality() - 1);
				}
			}
		}
	}
}