package de.greenman999.create.doener.item;

import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import de.greenman999.create.doener.CreateDoener;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {

    static {
        CreateDoener.REGISTRATE.setCreativeTab(ModCreativeModeTabs.DOENER_TAB);
    }

    public static final ItemEntry<Item> KEBAB_SKEWER = CreateDoener.REGISTRATE.item("kebab_skewer", Item::new).register();
    public static final ItemEntry<Item> FLATBREAD_DOUGH = CreateDoener.REGISTRATE.item("flatbread_dough", Item::new).register();
    public static final ItemEntry<Item> FLATBREAD_DOUGH_WITH_SESAME = CreateDoener.REGISTRATE.item("flatbread_dough_with_sesame", Item::new).register();
    public static final ItemEntry<Item> FLATBREAD = CreateDoener.REGISTRATE.item("flatbread", Item::new)
            .properties(p -> p.food(new FoodProperties.Builder().nutrition(6)
                    .saturationMod(0.5F)
                    .build()))
            .register();
    public static final ItemEntry<Item> SESAME_SEEDS = CreateDoener.REGISTRATE.item("sesame_seeds", Item::new).register();

    public static final ItemEntry<Item> BEEF_LAYER = CreateDoener.REGISTRATE.item("beef_layer", Item::new).register();
    public static final ItemEntry<Item> EMPTY_SKEWER = CreateDoener.REGISTRATE.item("empty_skewer", Item::new).register();
    public static final ItemEntry<SequencedAssemblyItem> INCOMPLETE_KEBAB_SKEWER = CreateDoener.REGISTRATE.item("incomplete_kebab_skewer", SequencedAssemblyItem::new).register();
    public static void register(IEventBus eventBus) {

    }

}
