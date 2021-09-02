package com.khorbos.oreseverywhere.core.util;

import com.khorbos.oreseverywhere.OresEverywhere;
import com.khorbos.oreseverywhere.core.registries.Registries;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = OresEverywhere.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModForgeEventBusSubcriber {
    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event){
        final IForgeRegistry<Item> registry = event.getRegistry();
        Registries.BLOCKS.getEntries().stream()
                .map(RegistryObject::get).forEach(block -> {
            final Item.Properties properties = new Item.Properties().group(OresEverywhere.itemGroup);
            final BlockItem blockItem = new BlockItem(block, properties);
            blockItem.setRegistryName(block.getRegistryName());
            registry.register(blockItem);
        });

        OresEverywhere.LOGGER.debug("OresEverywhereMod debug : Registered BlockItems");
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event){
        OresEverywhere.LOGGER.debug("OresEverywhereMod debug : Registered biomes");
        Registries.registerBiomes();
    }
}
