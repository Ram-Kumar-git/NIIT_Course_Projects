package com.jap.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryOperations {

	// Declare the categories attribute
	private List<Category> categories;

	public CategoryOperations() {
		// Initialize the categories list
		categories = new ArrayList<Category>();
	}

	public boolean addCategory(String categoryName) {
		// Check if the category with the same name already exists
		for (Category category : categories) {
			if (category.getCategoryName().equals(categoryName)) {
				// If the category is present, return false
				return false;
			}
		}
		// If the category is not present, add the category and return true
		categories.add(new Category(categoryName));
		return true;
	}

	public Category findCategory(String categoryName) {
		// Check if categories list is empty
		if (categories.isEmpty()) {
			return null;
		}
		// If not empty, iterate through the list to find if the given categoryName is present
		for (Category category : categories) {
			if (category.getCategoryName().equals(categoryName)) {
				// If present, return the category
				return category;
			}
		}
		// Otherwise, return null
		return null;
	}

	public List<Category> listAllCategories() {
		// Display the categories and return the same
		return new ArrayList<Category>(categories);
	}

	public static Category getCategoryByName(Map<Category, List<Task>> categoryTaskMap, String categoryName) {
		// Get the keySet from the categoryTaskMap
		for (Category category : categoryTaskMap.keySet()) {
			// Check if the given categoryName is present in the map
			if (category.getCategoryName().equals(categoryName)) {
				// If the name is present, return the category
				return category;
			}
		}
		// Otherwise,return null
		return null;
	}
}
