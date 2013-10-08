package code.kata.gildedrose;

import static org.fest.assertions.api.Assertions.*;

import java.util.List;

import org.junit.Test;

public class InnTestCase {

	@Test
	public void testDefaultValues() throws Exception {
		Inn inn = new Inn();
		List<Item> items = inn.getItems();
		assertThat(extractProperty("name").from(items)).containsExactly(
				"+5 Dexterity Vest", "Aged Brie", "Elixir of the Mongoose",
				"Sulfuras, Hand of Ragnaros",
				"Backstage passes to a TAFKAL80ETC concert",
				"Conjured Mana Cake");
		assertThat(extractProperty("sellIn").from(items)).containsExactly(10, 2, 5, 0, 15, 3);
		assertThat(extractProperty("quality").from(items)).containsExactly(20, 0, 7, 80, 20, 6);
	}

}
