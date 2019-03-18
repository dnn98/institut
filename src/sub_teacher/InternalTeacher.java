package sub_teacher;

import java.util.ArrayList;

import object.Classe;
import object.Company;
import object.Teacher;

public class InternalTeacher extends Teacher{
	private int baseSalary;
	
	public InternalTeacher(String dni, String name, String surname, int student_total, ArrayList<String> subject_list, ArrayList<Classe> classe_list, int baseSalary) {
		super(dni, name, surname, student_total, subject_list, classe_list);
		this.baseSalary = baseSalary;
	}
	public InternalTeacher(InternalTeacher t) {
		this.dni = t.getDni();
		this.name = t.getName();
		this.surname = t.getSurname();
		this.student_total = t.getStudent_total();
		this.subject_list = t.getSubject_list();
		this.baseSalary = t.getBaseSalary();
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	//metodos propios
	public int getSalari() {
		return getBaseSalary();
	}
	public void showTeacher() {
		System.out.println("DNI: "+getDni());
		System.out.println("Name: "+getName());
		System.out.println("Surname: "+getSurname());
		System.out.println("Student total: "+getStudent_total());
		System.out.println("Subject list: "+getSubject_list());
		System.out.println("Salary: "+getBaseSalary());
		//we could do a print class method and show it here
	}
}