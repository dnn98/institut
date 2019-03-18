package sub_teacher;

import java.util.ArrayList;

import object.Classe;
import object.Company;
import object.Teacher;

public class ExternalTeacher extends Teacher{
	private int variableSalary;
	private Company compania;
	
	public ExternalTeacher() {
	}

	public ExternalTeacher(String dni, String name, String surname, int student_total, ArrayList<String> subject_list, ArrayList<Classe> classe_list, Company compania) {
		super(dni, name, surname, student_total, subject_list, classe_list);
		this.compania = compania;
		this.variableSalary = (student_total * compania.getCost_per_student());
	}
	public ExternalTeacher(ExternalTeacher t) {
		this.dni = t.getDni();
		this.name = t.getName();
		this.surname = t.getSurname();
		this.student_total = t.getStudent_total();
		this.subject_list = t.getSubject_list();
		this.variableSalary = t.getVariableSalary();
	}

	public int getVariableSalary() {
		return variableSalary;
	}

	public void setVariableSalary(int variableSalary) {
		this.variableSalary = variableSalary;
	}
	
	//metodos propi
	@Override
	public int getSalari() {
		return getVariableSalary();
	}
	public void showTeacher() {
		System.out.println("DNI: "+getDni());
		System.out.println("Name: "+getName());
		System.out.println("Surname: "+getSurname());
		System.out.println("Student total: "+getStudent_total());
		System.out.println("Subject list: "+getSubject_list());
		System.out.println("Salary: "+getVariableSalary());
		getCompania().showCompany();
		//we could do a print class method and show it here
	}

	public Company getCompania() {
		return compania;
	}

	public void setCompania(Company compania) {
		this.compania = compania;
	}
}