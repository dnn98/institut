package object;

import java.util.ArrayList;

import principal.Main;

public class Classe{
	private String name;
	private int capacity;
	private ArrayList<String> material;
	private ArrayList<Teacher> teacher_list;
	
	public Classe(String name, int capacity, ArrayList<String> material, ArrayList<Teacher> teacher_list) {
		this.name = name;
		this.capacity = capacity;
		this.material = material;
		this.teacher_list = teacher_list;
	}
	
	public Classe(String name, int capacity, ArrayList<String> material) {
		this.name = name;
		this.capacity = capacity;
		this.material = material;
		teacher_list = new ArrayList<Teacher>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public ArrayList<String> getMaterial() {
		return material;
	}

	public void setMaterial(ArrayList<String> material) {
		this.material = material;
	}

	public ArrayList<Teacher> getTeacher_list() {
		return teacher_list;
	}

	public void setTeacher_list(ArrayList<Teacher> teacher_list) {
		this.teacher_list = teacher_list;
	}
}