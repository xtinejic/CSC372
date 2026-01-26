package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class Students {
	private static final String address = null;
	private static final ArrayList<Students> byRoll = null;
	int rollno;
	String name;

	public Students(int rollno, String name, String address) {
		// TODO Auto-generated constructor stub
	}

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		ArrayList<Students> studentList = new ArrayList<Students>();
		System.out.println("=== Enter 10 Students ===");
		
		for (int i = 1; i <= 10; i++) {
			System.out.println("\nStudent " + i + ":");
			
			System.out.print("Roll Number: ");
			int roll = input.nextInt();
			input.nextLine(); 
			
			System.out.print("Name: ");
			String name = input.nextLine();
			
			System.out.print("Address: ");
			String address = input.nextLine();
			
			studentList.add(new Students(roll, name, address));		
		}
		
		System.out.println("\n=== All Students ===");
		showStudents(studentList);
		
		System.out.println("\n=== Sorted by Roll Number ===");
		ArrayList<Students> rollSorted = sortByRoll(studentList);
		showStudents(rollSorted);
		
		System.out.println("\n=== Sorted by Name ===");
		ArrayList<Students> nameSorted = sortByName(studentList, null, input);
		showStudents(nameSorted);
		
		input.close();
	}
	
	public static void showStudents(ArrayList<Students> list) {
		for (int i = 0; i <list.size(); i++) {
			Students s = list.get(i);
			System.out.println(s.rollno + " " + s.name + " " + s.address);
		}
	}
	public static ArrayList<Students> sortByRoll(ArrayList<Students> list) {
		ArrayList<Students> byRoll = new ArrayList<>();
		 for (Students s : list) {
			 byRoll.add(new Students(s.rollno, s.name, Students.address));
		 }
		 for (int i = 0; i < byRoll.size() - 1; i++) {
			 for (int j = i + 1; j < byRoll.size() - 1 - i; j++) {
				 if (byRoll.get(j).rollno > byRoll.get(j+1).rollno) {
					  Students temp = byRoll.get(i);
					  byRoll.set(i,  byRoll.get(j));
					  byRoll.set(j+1, temp);
				 }
			 }
		 }
		 ArrayList<Students> sorted;
		 return byRoll;
	}
	public static ArrayList<Students> sortByName(ArrayList<Students> list, Students[] byName, Scanner sc) {
		ArrayList<Students> sorted = new ArrayList<Students>();
		for(Students s : list) {
			sorted.add(s); 
		}
		for (int i = 0; i < sorted.size() - 1; i++) {
			for (int j = i + 1; j < sorted.size(); j++) {
			String name1 = sorted.get(j).name;
			String name2 = sorted.get(j).name;
			
	  		if (name1.compareTo(name2) < 0) {
				Students temp = sorted.get(j);
				sorted.set(j, sorted.get(j));
				sorted.set(j, temp);
			}
		}
	}
		System.out.println("\n--- SORTED BY NAME ---");
		for (Students s : byName) {
			s.print();
		}
		
		sc.close();
		return sorted;

 	}

	private void print() {
		
	}
 }
 