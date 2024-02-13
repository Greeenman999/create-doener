package de.greenman999.create.doener.block;

import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.ModelGen;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import de.greenman999.create.doener.CreateDoener;
import de.greenman999.create.doener.block.kebabgrill.KebabGrillBlock;
import de.greenman999.create.doener.item.ModCreativeModeTabs;


public class ModBlocks {

    static {
        CreateDoener.REGISTRATE.setCreativeTab(ModCreativeModeTabs.DOENER_TAB);
    }

    public static final BlockEntry<KebabGrillBlock> KEBAB_GRILL = CreateDoener.REGISTRATE.block("kebab_grill", KebabGrillBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .transform(BlockStressDefaults.setImpact(4.0))
            .blockstate((dataGenContext, provider) -> provider.simpleBlock(dataGenContext.get(),
                    provider.models().getExistingFile(provider.modLoc("block/kebab_grill"))))
            .item()
            .transform(ModelGen.customItemModel())
            .register();

    public static void register() {}
}
