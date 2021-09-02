package com.khorbos.oreseverywhere.core.util;

import com.khorbos.oreseverywhere.OresEverywhere;
import com.khorbos.oreseverywhere.core.registries.Registries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = OresEverywhere.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e){
        RenderTypeLookup.setRenderLayer(Registries.COPPER_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(Registries.IRON_SAPLING.get(), RenderType.getCutout());
    }
}
