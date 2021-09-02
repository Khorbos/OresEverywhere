package com.khorbos.oreseverywhere.common.blocks;

import com.khorbos.oreseverywhere.core.registries.Registries;
import com.khorbos.oreseverywhere.core.util.BlockProperties;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class IronGrassBlock extends AbstractOreGrassBlock {
    public IronGrassBlock() {
        super(BlockProperties.ORE_DIRT_PROPERTIES);
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = Registries.IRON_GRASS.get().getDefaultState();
        initCanGrow(worldIn, rand, pos, state, blockpos, blockstate);
    }
}
