package com.example.datagen.providers;

import java.util.concurrent.CompletableFuture;

import com.example.ExampleMod;
import com.example.blocks.ModBlocks;
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

                createShapeless(RecipeCategory.FOOD, ModItems.PEANUT)
                        .input(ModBlocks.PEANUT_PLANT)
                        .criterion(hasItem(ModBlocks.PEANUT_PLANT), conditionsFromItem(ModBlocks.PEANUT_PLANT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.PEANUT_BUTTER)
                        .input(Items.HONEY_BOTTLE).input(ModItems.PEANUT)
                        .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.FOOD, ModItems.PEANUT_BUTTER_CRUNCHY)
                        .input(Items.HONEY_BOTTLE).input(ModItems.PEANUT).input(ModItems.PEANUT)
                        .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return ExampleMod.MOD_ID + "RecipeProvider";
    }
}
