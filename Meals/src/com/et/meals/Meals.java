package com.et.meals;


// creating an enum class with meals as the constants
public enum Meals {
	
	LASAGNA(600, false, 6.50), 
	PAD_THAI(500, true, 7.00), 
	BURGER(800, false, 6.00);
	
	private int calories;
	private boolean vegitarian;
	private double price;
	
	private Meals(int calories, boolean vegitarian, double price) {
		this.calories = calories;
		this.vegitarian = vegitarian;
		this.price = price;
	}
	
	
	// only getters as constants
	public int getCalories() {
		return calories;
	}
	public boolean isVegitarian() {
		return vegitarian;
	}
	public double getPrice() {
		return price;
	}
	
	
	// method to determine if meal is high calorie or not
	public boolean highCal() {
		if (this.calories > 600) {
			System.out.println("High calorie");
			return true;
		}	
		else
			System.out.println("Low calorie");
			return false;
		
	}

}
