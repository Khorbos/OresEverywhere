package com.khorbos.oreseverywhere.core.util.helpers;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

public class NBTHelper {
    public static CompoundNBT toNBT(Object object){
        if (object instanceof ItemStack){
            return writeItemStack((ItemStack) object);
        }
//        if (object instanceof QuarryTileEntity){
//            return writeQuarry((QuarryTileEntity) object);
//        }
        return null;
    }

//    private static CompoundNBT writeQuarry(QuarryTileEntity quarry){
//        CompoundNBT compound = new CompoundNBT();
//        compound.putInt("x", quarry.posX);
//        compound.putInt("y", quarry.posY);
//        compound.putInt("z", quarry.posZ);
//        return compound;
//    }

    private static CompoundNBT writeItemStack(ItemStack itemStack){
        CompoundNBT nbt = new CompoundNBT();
        nbt.putInt("count", itemStack.getCount());
        nbt.putString("item", itemStack.getItem().getRegistryName().toString());
        nbt.putByte("type", (byte)0);
        return nbt;
    }

    public static Object fromNBT(CompoundNBT compound) {
        switch (compound.getByte("type")) {
            case 0:
                return readItemStack(compound);
            default:
                return null;
        }
    }

    private static ItemStack readItemStack(CompoundNBT compound) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(compound.getString("item")));
        int count = compound.getInt("count");
        return new ItemStack(item, count);
    }
}
