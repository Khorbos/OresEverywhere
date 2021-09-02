package com.khorbos.oreseverywhere;

import com.khorbos.oreseverywhere.common.world.gen.OreGenerator;
import com.khorbos.oreseverywhere.core.registries.*;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(OresEverywhere.ID)
@Mod.EventBusSubscriber(modid = OresEverywhere.ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class OresEverywhere
{
    public static final String ID = "oreseverywhere";
    public static final ItemGroup itemGroup = new ItemGroup(ItemGroup.GROUPS.length, "oreseverywheremod") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Registries.COPPER_INGOT.get());
        }
    };
    public static OresEverywhere instance;
    public static final Logger LOGGER = LogManager.getLogger();
    public static final ResourceLocation MINING_DIM_TYPE = new ResourceLocation(ID, "mining");

    public OresEverywhere() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::doClientStuff);

        Registries.initRegistries(modEventBus);

        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {

    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event){
        OreGenerator.generateCopperOre();
        OreGenerator.generateExtraIronOre();
        OreGenerator.generateExtraCopperOre();
        OreGenerator.generateExtraCoalOre();
    }
}
