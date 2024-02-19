import { RecipeService } from "../services/RecipeService";
import { Recipe } from "../models/Recipe";

export class RecipeController {
  private recipeService: RecipeService;

  constructor() {
    this.recipeService = new RecipeService();
  }

  async getAllRecipesAndRender(): Promise<void> {
    try {
      const recipes: Recipe[] = await this.recipeService.getAllRecipes();
      this.renderRecipesToConsole(recipes);
    } catch (error) {
      console.log("Error retrieving Recipes", error);
    }
  }

  async searchRecipesAndRender(query: string): Promise<void> {
    try {
      const recipes: Recipe[] = await this.recipeService.searchRecipes(query);
      this.renderRecipesToConsole(recipes);
    } catch (error) {
      console.log("Error searching Recipe", error);
    }
  }

  private renderRecipesToConsole(recipes: Recipe[]): void {
    recipes.forEach((recipe) => {
      console.log(`Recipe Name: ${recipe.name}`);
      console.log(`Cuisine: ${recipe.cuisine}`);
      console.log(`Rating: ${recipe.rating}`);
      console.log("-----------------------------");
    });
  }
}
