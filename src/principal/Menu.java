package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import object.Classe;
import object.Company;
import object.Teacher;
import sub_teacher.ExternalTeacher;
import sub_teacher.InternalTeacher;

public class Menu{
	ArrayList<Classe> list_classe = new ArrayList<Classe>();
	HashMap<String, Teacher> map_teacher = new HashMap<String, Teacher>();
	HashMap<String, Company> map_company = new HashMap<String, Company>();
	public void inici() {
		int i=0;
		System.out.println("En Pere ha fet canvis");
		while(i!=8) {
			printMenu1();
			i = Main.seleccionarInt();
			switch(i) {
			case 1:
				Classe c = newClasse();
				list_classe.add(c);
				break;
			case 2:
				printMenuTeacher();
				int j = Main.seleccionarInt();
				switch(j) {
				case 1:
					InternalTeacher internal = newInternalTeacher();
					map_teacher.put(internal.getDni(), internal);
					break;
				case 2:
					ExternalTeacher external = newExternalTeacher();
					map_teacher.put(external.getDni(), external);
					break;
				default:
					System.out.println("Error");
				}
				break;
			case 3:
				Company co = newCompany();
				map_company.put(co.getNif(), co);
				break;
			case 4:
				System.out.println("This teacher's salary is:");
				getSalari(searchTeacher());
				break;
			case 5:
				getTotalSalari();
				break;
			case 6:
				Teacher t = searchTeacher();
				if(t instanceof InternalTeacher) {
					System.out.println("Teacher Type: Internal");
				}
				if(t instanceof ExternalTeacher) {
					System.out.println("Teacher type: External");
				}
				t.showTeacher();
				break;
			case 7:
				searchCompany().showCompany(); //if there were more than 1 subclass, we would have to do it like in getSalari(searchTeacher())
				break;
			case 8:
				System.out.println("Exiting...");
				break;		
			default:
				
			}
		}
	}
	public void printMenu1() {
		System.out.println("1. New class\n2. New teacher\n3. New company\n4. Get salary of 1 teacher\n5. Get salary of all teachers\n6. Show teacher by DNI\n7. Show company by NIF\n8. Exit\nBefore creating teachers, you must create before a company and a class.");
	}
	public void printMenuTeacher() {
		System.out.println("1. Internal teacher\n2. External teacher");
	}
	public Classe newClasse(){
		String name;
		int capacity;
		ArrayList<String> material = new ArrayList<String>();
		String stop = "0";
		System.out.println("Enter a name for the new class: ");
		name = Main.seleccionarString();
		System.out.println("Enter its capacity: ");
		capacity = Main.seleccionarInt();
		while(!stop.equals("")) {
			System.out.println("Add a material: ");
			material.add(Main.seleccionarString());
			System.out.println("If you want to add more stuff, press 1, if not press enter.");
			stop = Main.seleccionarString();
		}
		Classe c = new Classe(name, capacity, material);
		return c;
	}
	public InternalTeacher newInternalTeacher() {
		String name;
		String surname;
		String dni;
		int student_total;
		ArrayList<String> subject_list = new ArrayList<String>();
		int baseSalary;
		ArrayList<Classe> classe_list = new ArrayList<Classe>();
		String stop = "0";
		String stop2 = "0";
		System.out.println("Enter a name for the teacher: ");
		name = Main.seleccionarString();
		System.out.println("Enter the surname: ");
		surname = Main.seleccionarString();
		System.out.println("Enter the DNI");
		dni = Main.seleccionarString();
		System.out.println("Enter the number of students: ");
		student_total = Main.seleccionarInt();
		while(!stop.equals("")) {
			System.out.println("Add a subject: ");
			subject_list.add(Main.seleccionarString());
			System.out.println("If you want to add more subjects, press 1, if not press enter.");
			stop = Main.seleccionarString();
		}
		System.out.println("Enter the base salary: ");
		baseSalary = Main.seleccionarInt();
		while(!stop2.equals("")) {
			System.out.println("Add a class: ");
			classe_list.add(searchClasse());
			System.out.println("If you want to add more classes, press 1, if not press enter.");
			stop2 = Main.seleccionarString();
		}
		System.out.println("Enter the company: ");
		InternalTeacher e = new InternalTeacher(dni, name, surname, student_total, subject_list, classe_list, baseSalary);
		for(Classe a : classe_list) {
			a.getTeacher_list().add(e);
		}
		return e;
	}
	public ExternalTeacher newExternalTeacher() {
		String name;
		String surname;
		String dni;
		int student_total;
		Company compania;
		ArrayList<String> subject_list = new ArrayList<String>();
		ArrayList<Classe> classe_list = new ArrayList<Classe>();
		String stop = "0";
		System.out.println("Enter a name for the teacher: ");
		name = Main.seleccionarString();
		System.out.println("Enter the surname: ");
		surname = Main.seleccionarString();
		System.out.println("Enter the DNI");
		dni = Main.seleccionarString();
		System.out.println("Enter the number of students: ");
		student_total = Main.seleccionarInt();
		while(!stop.equals("")) {
			System.out.println("Add a subject: ");
			subject_list.add(Main.seleccionarString());
			System.out.println("If you want to add more subjects, press 1, if not press enter.");
			stop = Main.seleccionarString();
		}
		while(!stop.equals("")) {
			System.out.println("Add a class: ");
			classe_list.add(searchClasse());
			System.out.println("If you want to add more classes, press 1, if not press enter.");
			stop = Main.seleccionarString();
		}
		System.out.println("Enter the company: ");
		compania = searchCompany();
		ExternalTeacher e = new ExternalTeacher(dni, name, surname, student_total, subject_list, classe_list, compania);
		e.getCompania().getTeacher_list().add(e);
		for(Classe a : classe_list) {
			a.getTeacher_list().add(e);
		}
		return e;
	}
	public Company newCompany() {
		String name;
		String nif;
		String email;
		int cost_per_student;
		System.out.println("Enter the company name: ");
		name = Main.seleccionarString();
		System.out.println("Enter the NIF: ");
		nif = Main.seleccionarString();
		System.out.println("Enter the email: ");
		email = Main.seleccionarString();
		System.out.println("Enter the cost per student: ");
		cost_per_student = Main.seleccionarInt();
		Company c = new Company(name, nif, email, cost_per_student);
		return c;
	}
	public void getSalari(Teacher t) { //it is done this way because there is more than 1 subclass
		t.getSalari();
	}
	public Teacher searchTeacher() {
		String search_dni;
		System.out.println("Enter DNI: ");
		search_dni = Main.seleccionarString();
		Teacher t = map_teacher.get(search_dni);
		return t;
	}
	public Company searchCompany() {
		String search_nif;
		System.out.println("Enter NIF: ");
		search_nif = Main.seleccionarString();
		Company c = map_company.get(search_nif);
		return c;
	}
	public Classe searchClasse() {
		String name = Main.seleccionarString();
		for(Classe e : list_classe) {
			if(e.getName().equals(name)) {
				return e;
			}
		}
		return null;
	}
	public void getTotalSalari() {
		int salary_internal = 0;
		int salary_external = 0;
		Iterator<Entry<String, Teacher>> it = map_teacher.entrySet().iterator();
		while (it.hasNext()) {
		    Entry<String, Teacher> pair = it.next();
		    if (pair.getValue() instanceof InternalTeacher) {
		    	salary_internal += pair.getValue().getSalari();
		    }
		    if (pair.getValue() instanceof ExternalTeacher) {
		    	salary_external += pair.getValue().getSalari();
		    }
		}
		System.out.println("Total salary of internal teachers: "+salary_internal+"\nTotal salary of external teachers: "+salary_external);
	}
}