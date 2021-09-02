package com.khorbos.oreseverywhere.core.util;

import com.khorbos.oreseverywhere.OresEverywhere;
import com.khorbos.oreseverywhere.core.registries.Registries;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OresEverywhere.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEventBusSubcriber {
    @SubscribeEvent
    public static void registerDimensions(final RegisterDimensionsEvent event){
        if(DimensionType.byName(OresEverywhere.MINING_DIM_TYPE) == null){
            DimensionManager.registerDimension(OresEverywhere.MINING_DIM_TYPE, Registries.MINING_DIM.get(), null, true);
        }
        OresEverywhere.LOGGER.debug("OresEverywhereMod debug : Registered dimension");
    }
}
