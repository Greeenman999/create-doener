package de.greenman999.create.doener.item;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import de.greenman999.create.doener.CreateDoener;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateDoener.MOD_ID);

    public static final RegistryObject<CreativeModeTab> DOENER_TAB = CREATIVE_MODE_TABS.register("doener_tab", () -> CreativeModeTab.builder()
            .icon(() -> ModItems.KEBAB_SKEWER.get().getDefaultInstance())
            .title(Component.translatable("creativetab.doener_tab"))
            .displayItems(new RegistrateDisplayItemsGenerator())
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

    public static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {

        private List<Item> collectBlocks(RegistryObject<CreativeModeTab> tab, Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();
            for (RegistryEntry<Block> entry : CreateDoener.REGISTRATE.getAll(Registries.BLOCK)) {
                if (!CreateDoener.REGISTRATE.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get()
                        .asItem();
                if (item == Items.AIR)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));
            return items;
        }

        private List<Item> collectItems(RegistryObject<CreativeModeTab> tab, Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();

            for (RegistryEntry<Item> entry : CreateDoener.REGISTRATE.getAll(Registries.ITEM)) {
                if (!CreateDoener.REGISTRATE.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get();
                if (item instanceof BlockItem)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            return items;
        }

        private static void outputAll(CreativeModeTab.Output output, List<Item> items) {
            for (Item item : items) {
                output.accept(item);
            }
        }

        List<Item> exclude = List.of();

        @Override
        public void accept(CreativeModeTab.@NotNull ItemDisplayParameters params, CreativeModeTab.@NotNull Output output) {
            List<Item> items = new LinkedList<>();
            items.addAll(collectBlocks(DOENER_TAB, (item) -> {
                return false;
            }));
            items.addAll(collectItems(DOENER_TAB, (item) -> exclude.contains(item)));

            outputAll(output, items);
        }
    }
}
