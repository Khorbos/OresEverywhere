package com.khorbos.oreseverywhere.common.world.gen;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.function.Function;

public class OreBiomeSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    private Block soilBlock;
    private Block oreBlock;
    private Block extraBlock;

    public OreBiomeSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> function, Block soilBlock, Block oreBlock, Block extraBlock) {
        super(function);
        this.soilBlock = soilBlock;
        this.oreBlock = oreBlock;
        this.extraBlock = extraBlock;
    }

    @Override
    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
                             BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        Random rd = new Random();
        int i = rd.nextInt(3);
        if (i == 0){
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed,
                    new SurfaceBuilderConfig(
                            this.soilBlock.getDefaultState(),
                            this.oreBlock.getDefaultState(), this.extraBlock.getDefaultState()));
        } else {
            SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed,
                    new SurfaceBuilderConfig(
                            i == 1? this.soilBlock.getDefaultState(): this.soilBlock.getDefaultState(),
                            this.oreBlock.getDefaultState(), this.extraBlock.getDefaultState()));
        }
    }
}
