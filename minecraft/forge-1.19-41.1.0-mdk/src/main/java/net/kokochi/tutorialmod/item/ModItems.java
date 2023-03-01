package net.kokochi.tutorialmod.item;

import net.kokochi.tutorialmod.TutorialMod;
import net.kokochi.tutorialmod.item.custom.EightBallitem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> ZIRCON = ITEMS.register
            ("zircon", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)));

    public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register
            ("raw_zircon", () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.TUTORIAL_TAB)));    // 크리에이티브 모드의 어느 탭에 들어갈 것인지를 지정함
    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register
            ("eight_ball", () -> new EightBallitem(new Item.Properties().tab(ModCreativeModeTab.TUTORIAL_TAB)
                    .stacksTo(1)));     // 한개까지만 스택이 가능하다.
    // 새롭게 생성한 이벤트를 가진 이벤트 아이템을 생성한다.

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
