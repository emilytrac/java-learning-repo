package com.et.meals;

public class MealsMain {

	public static void main(String[] args) {
		
		 // Printing high calorie meal
		 Meals firstMeal = Meals.BURGER;
		 firstMeal.highCal();
		 
		 // Printing low calorie meal
		 Meals secondMeal = Meals.PAD_THAI;
		 secondMeal.highCal();

	}

}
