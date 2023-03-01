package net.kokochi.tutorialmod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EightBallitem extends Item {
    public EightBallitem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            // 메인 핸드(오른손) 에 아이템을 들고있을때만 발동하게 됨

            // 랜덤 숫자를 출력한다.
            outputRandomNumber(player);

            // 쿨타임을 적용한다.
            player.getCooldowns().addCooldown(this, 20);

        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            // 쉬프트 다운을 하고 있을 때
            components.add(Component.literal("Right click to get a random number!")
                    .withStyle(ChatFormatting.BOLD));
        } else {
            // 아닐 때
            components.add(Component.literal("Preses SHIFT for more info")
                    .withStyle(ChatFormatting.AQUA));   // 텍스트 스타일링을 할 수 있음
        }

        super.appendHoverText(itemStack, level, components, tooltipFlag);
    }

    private void outputRandomNumber(Player player) {
        player.sendSystemMessage(Component.literal("Your Number is " + getRandomNumber()));
    }

    private int getRandomNumber() {
        return RandomSource.createNewThreadLocalInstance().nextInt(10);
    }
}
