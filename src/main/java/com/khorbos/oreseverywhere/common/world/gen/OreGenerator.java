package com.khorbos.oreseverywhere.common.world.gen;

import com.khorbos.oreseverywhere.core.registries.Registries;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator {
    public static void generateCopperOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Registries.COPPER_ORE.get().getDefaultState(), 10)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(20, 0, 0, 100))));
        }
    }

    public static void generateExtraCopperOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if(biome == Registries.COPPER_BIOME.get()){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Registries.COPPER_ORE.get().getDefaultState(), 25)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 125))));
            }
        }
    }

    public static void generateExtraIronOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if(biome == Registries.IRON_BIOME.get()){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.IRON_ORE.getDefaultState(), 25)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 125))));
            }
        }
    }

    public static void generateExtraCoalOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if(biome == Registries.COAL_BIOME.get()){
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.COAL_ORE.getDefaultState(), 25)).withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(50, 0, 0, 125))));
            }
        }
    }
}

