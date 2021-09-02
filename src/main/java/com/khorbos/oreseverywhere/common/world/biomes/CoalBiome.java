package com.khorbos.oreseverywhere.common.world.biomes;

import com.khorbos.oreseverywhere.common.world.gen.OreBiomeSurfaceBuilder;
import com.khorbos.oreseverywhere.common.world.gen.OreGenerator;
import com.khorbos.oreseverywhere.core.registries.Registries;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.DesertHillsBiome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class CoalBiome extends Biome {
    public CoalBiome() {
        this(new Builder()
                .precipitation(RainType.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(2.4F)
                .downfall(0.4F)
                .waterColor(1644825)
                .waterFogColor(329011)
                .category(Category.DESERT)
                .parent(null)
                .surfaceBuilder(
                        new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
                                register("coal_surface",
                                        new OreBiomeSurfaceBuilder(SurfaceBuilderConfig::deserialize, Registries.COAL_DUST.get(), Blocks.COAL_ORE, Blocks.COAL_BLOCK)),
                                new SurfaceBuilderConfig(Registries.COAL_DUST.get().getDefaultState(),
                                        Blocks.COAL_ORE.getDefaultState(),
                                        Blocks.COAL_BLOCK.getDefaultState())))
                .category(Category.EXTREME_HILLS).downfall(0.5f).depth(0.12f).parent(null)
        );
    }

    public CoalBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.5445254F)));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.2505254F)));
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addFossils(this);
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
    }

    @SuppressWarnings("deprecation")
    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
    }
}
