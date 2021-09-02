package com.khorbos.oreseverywhere.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CopperBlock extends Block {
    public CopperBlock() {
        super(Properties
                .create(Material.IRON)
                .hardnessAndResistance(4.5F, 3.0F)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.METAL));
    }
}
