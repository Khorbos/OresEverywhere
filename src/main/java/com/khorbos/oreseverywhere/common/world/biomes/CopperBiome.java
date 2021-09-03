package com.khorbos.oreseverywhere.common.world.biomes;

import com.khorbos.oreseverywhere.common.world.features.CopperTree;
import com.khorbos.oreseverywhere.common.world.gen.OreBiomeSurfaceBuilder;
import com.khorbos.oreseverywhere.core.registries.Registries;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class CopperBiome extends Biome {
    public CopperBiome() {
        this(new Builder()
                .precipitation(RainType.NONE)
                .depth(0.125F)
                .scale(0.05F)
                .temperature(0.8F)
                .downfall(0.4F)
                .waterColor(4159204)
                .waterFogColor(329011)
                .category(Category.PLAINS)
                .parent(null)
                .surfaceBuilder(
                        new ConfiguredSurfaceBuilder<SurfaceBuilderConfig>(
                                register("copper_surface",
                                        new OreBiomeSurfaceBuilder(SurfaceBuilderConfig::deserialize, Registries.COPPER_GRASS.get(), Registries.CUPRUM_ORE.get(), Registries.CUPRUM_STONE.get())),
                                new SurfaceBuilderConfig(Registries.COPPER_GRASS.get().getDefaultState(),
                                        Registries.CUPRUM_STONE.get().getDefaultState(),
                                        Registries.CUPRUM_STONE.get().getDefaultState())))
                .category(Category.PLAINS).downfall(0.5f).depth(0.12f).parent(null)
        );
    }

    public CopperBiome(Builder biomeBuilder) {
        super(biomeBuilder);
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.CANYON, new ProbabilityConfig(0.5445254F)));
        this.addCarver(GenerationStage.Carving.AIR, createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.2505254F)));
        this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.08D, MineshaftStructure.Type.NORMAL)));
        DefaultBiomeFeatures.addFossils(this);
        DefaultBiomeFeatures.addLakes(this);
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.NORMAL_TREE.withConfiguration(CopperTree.COPPER_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));
    }

    @SuppressWarnings("deprecation")
    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        return (F) (Registry.<SurfaceBuilder<?>>register(Registry.SURFACE_BUILDER, key, builderIn));
    }
}
