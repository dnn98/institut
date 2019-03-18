package object;

import java.util.ArrayList;

public abstract class Teacher{
	protected String dni;
	protected String name;
	protected String surname;
	protected int student_total;
	protected ArrayList<String> subject_list;
	protected ArrayList<Classe> classe_list;
	public Teacher(){
	}
	
	public Teacher(String dni, String name, String surname, int student_total, ArrayList<String> subject_list, ArrayList<Classe> classe_list) {
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.student_total = student_total;
		this.subject_list = subject_list;
		this.classe_list = classe_list;
	}
	public Teacher(Teacher t) {
		this.dni = t.getDni();
		this.name = t.getName();
		this.surname = t.getSurname();
		this.student_total = t.getStudent_total();
		this.subject_list = t.getSubject_list();
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public int getStudent_total() {
		return student_total;
	}
	public void setStudent_total(int student_total) {
		this.student_total = student_total;
	}
	public ArrayList<String> getSubject_list() {
		return subject_list;
	}
	public void setSubject_list(ArrayList<String> subject_list) {
		this.subject_list = subject_list;
	}
	//metodos propios
	public int getSalari() {
		return 0;
	}
	public void showTeacher() {
		System.out.println("DNI: "+getDni());
		System.out.println("Name: "+getName());
		System.out.println("Surname: "+getSurname());
		System.out.println("Student total: "+getStudent_total());
		System.out.println("Subject list: "+getSubject_list());
	}
}