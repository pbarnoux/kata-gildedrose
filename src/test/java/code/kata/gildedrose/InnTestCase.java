package code.kata.gildedrose;

import static org.fest.assertions.api.Assertions.*;

import java.util.List;

import org.junit.Test;

public class InnTestCase {

	@Test
	public void testUpdateAgainstLegacy() throws Exception {
		Inn inn = new Inn();
		LegacyInn legacyInn = new LegacyInn();

		for (int i = 0; i < 100; i++) {
			List<Item> items = inn.getItems();
			List<Item> legacyItems = legacyInn.getItems();

			for (int j = 0; j < items.size(); ++j) {
				Item item = items.get(j);
				Item legacy = legacyItems.get(j);
				assertThat(item.getSellIn()).isEqualTo(legacy.getSellIn());
				assertThat(item.getQuality()).isEqualTo(legacy.getQuality());
			}
			inn.updateQuality();
			legacyInn.updateQuality();
		}
	}

}
