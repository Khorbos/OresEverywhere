package com.khorbos.oreseverywhere.common.blocks;

import com.khorbos.oreseverywhere.core.registries.Registries;
import com.khorbos.oreseverywhere.core.util.BlockProperties;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class CopperGrassBlock extends AbstractOreGrassBlock {
    public CopperGrassBlock() {
        super(BlockProperties.ORE_DIRT_PROPERTIES);
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = Registries.COPPER_GRASS.get().getDefaultState();
        initCanGrow(worldIn, rand, pos, state, blockpos, blockstate);
    }
}
