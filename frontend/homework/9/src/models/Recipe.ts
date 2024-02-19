export interface Recipe {
  id: number;
  name: string;
  rating: number;
  cuisine: string;
  ingredients: string[];
  difficulty: string;
  preparationTime: number;
  cookingTime: number;
  caloriesCount: number;
}
