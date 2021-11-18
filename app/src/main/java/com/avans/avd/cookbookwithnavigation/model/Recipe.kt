package com.avans.avd.cookbookwithnavigation.model

// recipe has only read only values:
data class Recipe(
    val title: String,
    val description: String,
    val recipeType: RecipeType,
    val nutritionalValue: NutritionalValue
)

// nutritional value per 100 grams
data class NutritionalValue(
    val energy: Int,
    val carbohydrates: Int,
    val fat: Int,
    val protein: Int
)

enum class RecipeType {
    MEAT, FISH, VEGAN
}
