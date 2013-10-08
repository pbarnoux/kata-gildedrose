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
			if (item.getQuality() < 50) {
				item.setQuality(item.getQuality() + 1);
			}
		} else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
			if (item.getQuality() < 50) {
				item.setQuality(item.getQuality() + 1);
	
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
		} else {
			if (item.getQuality() > 0) {
				item.setQuality(item.getQuality() - 1);
			}
		}
	
		item.setSellIn(item.getSellIn() - 1);
	
		if (item.getSellIn() < 0) {
			if (item.getName().equals("Aged Brie")) {
				if (item.getQuality() < 50) {
					item.setQuality(item.getQuality() + 1);
				}
			} else if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
				item.setQuality(item.getQuality() - item.getQuality());
			} else {
				if (item.getQuality() > 0) {
					item.setQuality(item.getQuality() - 1);
				}
			}
		}
	}
}