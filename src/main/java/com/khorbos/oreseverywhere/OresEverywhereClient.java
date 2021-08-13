package com.khorbos.oreseverywhere;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = OresEverywhere.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class OresEverywhereClient {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent e){

    }
}


