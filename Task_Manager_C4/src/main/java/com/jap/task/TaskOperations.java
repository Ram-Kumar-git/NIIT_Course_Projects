package com.jap.task;

import java.util.*;

public class TaskOperations {
	// Declare the attributes taskNames, userTaskMap, categoryTaskMap
	private Set<String> taskNames;
	private Map<User, List<Task>> userTaskMap;
	private Map<Category, List<Task>> categoryTaskMap;

	public TaskOperations() {
		//initialize the attributes
		taskNames= new HashSet<>();
		userTaskMap = new HashMap<User,List<Task>>();
		categoryTaskMap = new HashMap<Category,List<Task>>();
	}

	public boolean addTask(Category selectedCategory,Task task, User authenticatedUser) {
		boolean flag=false;
		//check if task is already present in taskNames
		if(taskNames.contains(task.getTaskName())){
			//if present display appropriate message and return false;
			System.out.println("Task already exists");
			return false;
		}
		//if not present  get the userTask from the authenticatedUser.
		List<Task> userTasks = userTaskMap.get(authenticatedUser);
		//check if UserTask not equal to null
		if(userTasks==null){
			//initialize the list  and the task to the list.
			//if present just add the task to the list.
			userTasks= new ArrayList<Task>();
			userTaskMap.put(authenticatedUser,userTasks);
		}
		userTasks.add(task);

		List<Task> categoryTasks = categoryTaskMap.get(selectedCategory);
		//check if categoryTasks not equal to null
		if(categoryTasks==null){
			//initialize the list  and the task to the list.
			//if present just add the task to the list.
			categoryTasks = new ArrayList<Task>();
			categoryTaskMap.put(selectedCategory,categoryTasks);
		}
		//add the task to the taskNames
		categoryTasks.add(task);
		taskNames.add(task.getTaskName());
		//return true
		return true;
	}
	public List<String> listAllTasks(String categoryName) {
		//fetch categories by categoryName  using getCategoryByName method of the category class
		Category selectedCategory = CategoryOperations.getCategoryByName(categoryTaskMap, categoryName);
		//create a list of sortedTasks
		List<String> sortedTasks = new ArrayList<String>();
		// If the selectedCategory is null, display appropriate message
		if (selectedCategory == null) {
			System.out.println("Category not found.");
			return sortedTasks;
		}
		// If selectedCategory is not null
		List<Task> tasks = categoryTaskMap.get(selectedCategory);
		if (tasks != null) {
			for (Task task : tasks) {
				// Generate a string for each task
				String taskDetails = "Category: " + categoryName + " - " +
						"Name: " + task.getTaskName() + " Priority: " + task.getPriority() +
						" Description: " + task.getDescription() + " Status: " + (task.isCompleted() ? "Completed" : "Pending");
				// Add the string to the list
				sortedTasks.add(taskDetails);
			}
		}
		// Return the list
		return sortedTasks;
	}
	public boolean markTaskAsCompleted(String taskToComplete,String statusInput ) {
		//iterate the list of task from categoryTaskMap
		for(List<Task>tasks : categoryTaskMap.values()){
			for(Task task : tasks){
				//check if the task with the given name is present
				//if the given statusInput is completed setCompleted to true and return true
				if(task.getTaskName().equals(taskToComplete)){
					if ("completed".equalsIgnoreCase(statusInput)){
						task.setCompleted(true);
						return true;
					}
					//if the given statusInput is pending setCompleted to false and return true
					if("pending".equalsIgnoreCase(statusInput)){
						task.setCompleted(false);
						return false;
					}
				}

			}
		}


		//if the given statusInput is neither completed nor pending return false
		return false;
	}
	public boolean removeTask(String taskToRemove) throws TaskNotFoundException {
		boolean found=false;
		//iterate the list of task from categoryTaskMap
		for(List<Task> tasks : categoryTaskMap.values()){
			Iterator<Task> iterator = tasks.iterator();
			while(iterator.hasNext()){
				Task task = iterator.next();
				//check if the task with the given name is present
				// remove the task
				if (task.getTaskName().equals(taskToRemove)){
					iterator.remove();
					found=true;
				}
			}
		}
		//remove the task from taskNames
		//return true if the task is removed
		// Check if the task with the given name is present and was removed
		if (found) {
			taskNames.remove(taskToRemove); // remove the task from taskNames
			return true; // return true if the task is removed
		}
		else {
			//if task is not removed throw TaskNotFoundException
			throw new TaskNotFoundException("Task not found.");
		}
	}
	public Task searchTasksByName(String taskName) {
		//iterate the list of task from categoryTaskMap
		for(List<Task> tasks : categoryTaskMap.values()){
			for (Task task : tasks){
				//check if the task with the given name is present
				//add it to the matchingTaskList
				if(task.getTaskName().equals(taskName)){
					return task;
				}
			}
		}

		return null;
	}
}

