package com.example.items;

import com.example.ExampleMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    // why is it saturationModifier, and then nutrition?
    public static final FoodComponent PEANUT_BUTTER_COMPONENT = new FoodComponent.Builder()
            .saturationModifier(20f).nutrition(4).build();

    public static final FoodComponent PEANUT_BUTTER_CRUNCHY_COMPONENT = new FoodComponent.Builder()
            .saturationModifier(14.5f).nutrition(8).build();

    public static final Item PEANUT = register("peanut", Item::new, new Item.Settings());

    public static final Item PEANUT_BUTTER = register("peanut_butter", Item::new, new Item.Settings().food(PEANUT_BUTTER_COMPONENT));
    public static final Item PEANUT_BUTTER_CRUNCHY = register("peanut_butter_crunchy", Item::new, new Item.Settings().food(PEANUT_BUTTER_CRUNCHY_COMPONENT));

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.PEANUT));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.PEANUT_BUTTER));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.PEANUT_BUTTER_CRUNCHY));
    }

    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(ExampleMod.MOD_ID, name));

        Item item = itemFactory.apply(settings.registryKey(itemKey));

        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

}