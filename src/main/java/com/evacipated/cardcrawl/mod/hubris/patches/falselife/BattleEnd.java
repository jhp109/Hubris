package com.evacipated.cardcrawl.mod.hubris.patches.falselife;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import java.lang.reflect.Field;

@SpirePatch(
        cls="com.megacrit.cardcrawl.rooms.AbstractRoom",
        method="endBattle"
)
public class BattleEnd
{
    public static void Prefix(AbstractRoom __instance)
    {
        try {
            Field f = AbstractCreature.class.getDeclaredField("temporaryHealth");
            f.set(AbstractDungeon.player, 0);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
