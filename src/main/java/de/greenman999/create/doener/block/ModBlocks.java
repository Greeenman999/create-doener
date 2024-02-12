package de.greenman999.create.doener.block;

import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import de.greenman999.create.doener.CreateDoener;
import de.greenman999.create.doener.block.kebabgrill.KebabGrillBlock;
import de.greenman999.create.doener.item.ModCreativeModeTabs;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class ModBlocks {

    static {
        CreateDoener.REGISTRATE.setCreativeTab(ModCreativeModeTabs.DOENER_TAB);
    }

    public static final BlockEntry<KebabGrillBlock> KEBAB_GRILL = CreateDoener.REGISTRATE.block("kebab_grill", KebabGrillBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.PODZOL))
            .transform(pickaxeOnly())
            .blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.standardModel(c, p)))
            .transform(BlockStressDefaults.setImpact(4.0))
            .simpleItem()
            .register();

    public static void register() {}
}
