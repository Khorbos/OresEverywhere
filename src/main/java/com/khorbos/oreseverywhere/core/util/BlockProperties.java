package com.khorbos.oreseverywhere.core.util;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockProperties {
    public static final Block.Properties STONE_PROPERTIES = Block.Properties
            .create(Material.ROCK)
            .sound(SoundType.STONE);

    public static final Block.Properties ORE_DIRT_PROPERTIES = Block.Properties
            .create(Material.ROCK)
            .tickRandomly()
            .hardnessAndResistance(0.6F)
            .sound(SoundType.SAND);
}
