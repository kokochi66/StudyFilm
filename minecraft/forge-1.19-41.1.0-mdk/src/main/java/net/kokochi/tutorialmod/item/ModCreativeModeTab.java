package net.kokochi.tutorialmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab("tutorialtab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.ZIRCON.get());
        }
    };

//    public static final CreativeModeTab TUTORIAL_TAB_2 = new CreativeModeTab("tutorialtab_2") {
//        @Override
//        public ItemStack makeIcon() {
//
//            return new ItemStack(ModItems.RAW_ZIRCON.get());
//        }
//    };
}
