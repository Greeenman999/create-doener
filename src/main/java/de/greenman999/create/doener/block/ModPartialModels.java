package de.greenman999.create.doener.block;

import com.jozufozu.flywheel.core.PartialModel;
import de.greenman999.create.doener.CreateDoener;
import net.minecraft.resources.ResourceLocation;

public class ModPartialModels {

    public static final PartialModel KEBAB_SKEWER = block("kebab_skewer_10");

    private static PartialModel block(String path) {
        return new PartialModel(new ResourceLocation(CreateDoener.MOD_ID, "block/" + path));
    }

    public static void register() {
    }

}
