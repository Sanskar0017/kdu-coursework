import { Recipe } from "../models/Recipe";

export class RecipeAPI {
  private readonly API_BASE_URL: string;

  constructor() {
    this.API_BASE_URL = "https://dummyjson.com/recipes";
  }

  async fetchRecipes(): Promise<Recipe[]> {
    try {
      const response = await fetch(this.API_BASE_URL);
      if (!response.ok) {
        throw new Error("fetch call from Url failed!");
      }

      const data = await response.json();
      return data.recipes;
    } catch (error) {
      console.log("Error fetching Recipes", error);
      return [];
    }
  }
  
  async searchRecipes(query: string): Promise<Recipe[]> {
    try {
      const response = await fetch(
        `${this.API_BASE_URL}/search?q=${encodeURIComponent(query)}`
      );
      if (!response.ok) {
        throw new Error("Failed to collect response for search from API!");
      }
      const data = await response.json();
      return data.recipes;
    } catch (error) {
      console.log("Error fetching search API's:", error);
      return [];
    }
  }
}
