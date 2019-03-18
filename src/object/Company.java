package object;

import java.util.ArrayList;

public class Company{
	private String name;
	private String nif;
	private String email;
	private int cost_per_student;
	ArrayList<Teacher> teacher_list;
	public Company() {
	}
	
	public Company(String name, String nif, String email, int cost_per_student) {
		this.name = name;
		this.nif = nif;
		this.email = email;
		this.cost_per_student = cost_per_student;
		teacher_list = new ArrayList<Teacher>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCost_per_student() {
		return cost_per_student;
	}

	public void setCost_per_student(int cost_per_student) {
		this.cost_per_student = cost_per_student;
	}
	//metodos propios
	public void showCompany() {
		System.out.println("Company name: "+getName());
		System.out.println("NIF: "+getNif());
		System.out.println("Email: "+getEmail());
		System.out.println("Cost per student: "+getCost_per_student());
	}

	public ArrayList<Teacher> getTeacher_list() {
		return teacher_list;
	}

	public void setTeacher_list(ArrayList<Teacher> teacher_list) {
		this.teacher_list = teacher_list;
	}
}