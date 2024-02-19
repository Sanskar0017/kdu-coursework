"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var RecipeController_1 = require("./controllers/RecipeController");
var recipeController = new RecipeController_1.RecipeController();
console.log("Rendering all recipes");
recipeController.getAllRecipesAndRender();
console.log("Searching Recipes By Name");
recipeController.searchRecipesAndRender("chicken");
