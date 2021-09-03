package com.khorbos.oreseverywhere.core.registries;

import com.electronwill.nightconfig.core.ConfigSpec;
import com.khorbos.oreseverywhere.OresEverywhere;
import com.khorbos.oreseverywhere.common.blocks.*;
import com.khorbos.oreseverywhere.common.world.biomes.CoalBiome;
import com.khorbos.oreseverywhere.common.world.biomes.CopperBiome;
import com.khorbos.oreseverywhere.common.world.biomes.IronBiome;
import com.khorbos.oreseverywhere.common.world.dimensions.MiningWorldModDimension;
import com.khorbos.oreseverywhere.common.world.features.CopperTree;
import com.khorbos.oreseverywhere.common.world.features.IronTree;
import com.khorbos.oreseverywhere.core.util.BlockProperties;
import com.khorbos.oreseverywhere.core.util.ItemProperties;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registries {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OresEverywhere.ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OresEverywhere.ID);
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, OresEverywhere.ID);
    public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, OresEverywhere.ID);

    // Items
    public static final RegistryObject<Item> COPPER_GEODE = ITEMS.register("copper_geode", () -> new Item(ItemProperties.BASIC_PROPERTIES));
    public static final RegistryObject<Item> IRON_GEODE = ITEMS.register("iron_geode", () -> new Item(ItemProperties.BASIC_PROPERTIES));
    public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new Item(ItemProperties.BASIC_PROPERTIES));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget", () -> new Item(ItemProperties.BASIC_PROPERTIES));
    public static final RegistryObject<Item> GOLD_GEODE = ITEMS.register("gold_geode", () -> new Item(ItemProperties.BASIC_PROPERTIES));

    // Blocks
    public static final RegistryObject<CopperOreBlock> COPPER_ORE = BLOCKS.register("copper_ore", () -> new CopperOreBlock());
    public static final RegistryObject<Block> CUPRUM_STONE = BLOCKS.register("cuprum_stone", () -> new Block(BlockProperties.STONE_PROPERTIES));
    public static final RegistryObject<CopperOreBlock> CUPRUM_ORE = BLOCKS.register("cuprum_ore", () -> new CopperOreBlock());
    public static final RegistryObject<CopperBlock> COPPER_BLOCK = BLOCKS.register("copper_block", () -> new CopperBlock());
    public static final RegistryObject<CopperGrassBlock> COPPER_GRASS = BLOCKS.register("copper_grass", () -> new CopperGrassBlock());
    public static final RegistryObject<Block> COPPER_ROCK = BLOCKS.register("copper_rock", () -> new OreRockBlock());
    public static final RegistryObject<Block> COPPER_STAIRS = BLOCKS.register("copper_stairs", () -> new StairsBlock(() -> COPPER_BLOCK.get().getDefaultState(), Block.Properties.create(Material.IRON)));
    public static final RegistryObject<SlabBlock> COPPER_SLAB = BLOCKS.register("copper_slab", () -> new SlabBlock(Block.Properties.from(COPPER_BLOCK.get())));
    public static final RegistryObject<Block> COPPER_FENCE = BLOCKS.register("copper_fence", () -> new FenceBlock(Block.Properties.from(COPPER_BLOCK.get())));
    public static final RegistryObject<WallBlock> COPPER_WALL = BLOCKS.register("copper_wall", () -> new WallBlock(Block.Properties.from(COPPER_BLOCK.get())));
    public static final RegistryObject<Block> COPPER_BUTTON = BLOCKS.register("copper_button", () -> new CopperButtonBlock(Block.Properties.from(COPPER_BLOCK.get())));
    public static final RegistryObject<Block> COPPER_PRESSURE_PLATE = BLOCKS.register("copper_pressure_plate", () -> new CopperPressurePlate(Block.Properties.from(COPPER_BLOCK.get())));
    public static final RegistryObject<Block> COPPER_LOG = BLOCKS.register("copper_log", () -> new CopperLog(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> COPPER_LEAVES = BLOCKS.register("copper_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> COPPER_SAPLING = BLOCKS.register("copper_sapling", () -> new BasicSapling(() -> new CopperTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<IronGrassBlock> IRON_GRASS = BLOCKS.register("iron_grass", () -> new IronGrassBlock());
    public static final RegistryObject<Block> IRON_ROCK = BLOCKS.register("iron_rock", () -> new OreRockBlock());
    public static final RegistryObject<Block> IRON_STAIRS = BLOCKS.register("iron_stairs", () -> new StairsBlock(() -> Blocks.IRON_BLOCK.getDefaultState(), Block.Properties.from(Blocks.IRON_BLOCK)));
    public static final RegistryObject<SlabBlock> IRON_SLAB = BLOCKS.register("iron_slab", () -> new SlabBlock(Block.Properties.from(Blocks.IRON_BLOCK.getBlock())));
    public static final RegistryObject<WallBlock> IRON_WALL = BLOCKS.register("iron_wall", () -> new WallBlock(Block.Properties.from(Blocks.IRON_BLOCK.getBlock())));
    public static final RegistryObject<Block> IRON_BUTTON = BLOCKS.register("iron_button", () -> new CopperButtonBlock(Block.Properties.from(Blocks.IRON_BLOCK.getBlock())));
    public static final RegistryObject<Block> IRON_LOG = BLOCKS.register("iron_log", () -> new IronLog(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> IRON_LEAVES = BLOCKS.register("iron_leaves", () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> IRON_SAPLING = BLOCKS.register("iron_sapling", () -> new BasicSapling(() -> new IronTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> COAL_DUST = BLOCKS.register("coal_dust", () -> new Block(BlockProperties.STONE_PROPERTIES));

    //  Biomes
    public static final RegistryObject<Biome> IRON_BIOME = BIOMES.register("iron_biome", IronBiome::new);
    public static final RegistryObject<Biome> COPPER_BIOME = BIOMES.register("copper_biome", CopperBiome::new);
    public static final RegistryObject<Biome> COAL_BIOME = BIOMES.register("coal_biome", CoalBiome::new);

    //  Dimensions
    public static final RegistryObject<ModDimension> MINING_DIM = MOD_DIMENSIONS.register("mining_dim", MiningWorldModDimension::new);

    public static void registerBiomes(){
        registerBiome(IRON_BIOME.get(), BiomeDictionary.Type.PLAINS);
        registerBiome(COPPER_BIOME.get(), BiomeDictionary.Type.PLAINS);
        registerBiome(COAL_BIOME.get(), BiomeDictionary.Type.PLAINS);
    }

    private static void registerBiome(Biome biome, BiomeDictionary.Type... types){
//        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, 100));    // Make it spawn in the overworld
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }

    public static void initRegistries(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        BLOCKS.register(modEventBus);
        BIOMES.register(modEventBus);
        MOD_DIMENSIONS.register(modEventBus);
    }
}
