package com.avans.avd.cookbookwithnavigation.model

interface RecipeDAO {
    fun getAll(): List<Recipe>
    fun find(title: String): Recipe?
}