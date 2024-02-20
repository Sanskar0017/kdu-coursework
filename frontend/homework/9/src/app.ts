import { RecipeController } from "./controllers/RecipeController";
const recipeController = new RecipeController();
console.log("Rendering all recipes");
recipeController.getAllRecipesAndRender();
console.log("Searching Recipes By Name");
recipeController.searchRecipesAndRender("chicken");
