package com.example.datagen.providers;

import java.util.concurrent.CompletableFuture;

import com.example.ExampleMod;
import com.example.items.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class modidRecipeProvider extends FabricRecipeProvider {
    public modidRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShapeless(RecipeCategory.FOOD, ModItems.PUPPY_FOOD)
                        .input(Items.JUNGLE_PLANKS).input(Items.APPLE)
                        .criterion(hasItem(Items.JUNGLE_PLANKS), conditionsFromItem(Items.JUNGLE_PLANKS))
                        .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return ExampleMod.MOD_ID + "RecipeProvider";
    }
}
