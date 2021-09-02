package com.khorbos.oreseverywhere.common.world.features;

import com.khorbos.oreseverywhere.core.registries.Registries;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import java.util.Random;

public class CopperTree extends Tree {
    public static final TreeFeatureConfig COPPER_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(Registries.COPPER_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(Registries.COPPER_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(2).foliageHeight(3).ignoreVines()
            .setSapling((IPlantable) Registries.COPPER_SAPLING.get()).build();

    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(COPPER_TREE_CONFIG);

    }

}
