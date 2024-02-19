import { Recipe } from "../models/Recipe";
import { RecipeAPI } from "../api/RecipeAPI";

export class RecipeService {
  private recipeAPI: RecipeAPI;

  constructor() {
    this.recipeAPI = new RecipeAPI();
  }

  async getAllRecipes(): Promise<Recipe[]> {
    return await this.recipeAPI.fetchRecipes();
  }

  async searchRecipes(query: string): Promise<Recipe[]> {
    return await this.recipeAPI.searchRecipes(query);
  }
}

new RecipeService().getAllRecipes();
