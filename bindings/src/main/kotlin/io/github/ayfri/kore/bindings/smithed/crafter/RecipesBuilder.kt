package io.github.ayfri.kore.bindings.smithed.crafter

class RecipesBuilder(val namespace: String) {
    val recipes = mutableListOf<Recipe>()

    fun shapelessRecipe(block: ShapelessRecipe.() -> Unit) {
        val recipe = ShapelessRecipe()
        recipe.block()
        recipes.add(recipe)
    }

    fun shapedRecipe(block: ShapedRecipe.() -> Unit) {
        val recipe = ShapedRecipe()
        recipe.block()
        recipes.add(recipe)
    }
}