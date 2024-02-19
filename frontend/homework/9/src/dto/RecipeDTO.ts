export interface RecipeDTO {
  id: number;
  name: string;
  rating: number;
  cuisine: string;
  ingredients: string[];
  difficulty: string;
  preparationTime: number;
  cookingTime: number;
  calorieCount: number;
}
