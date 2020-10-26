import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * user interface for voting system
 * @author alireza karimi
 * @version 1.0.0
 */
public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static VotingSystem system = new VotingSystem();

	private static void createVoting(){
		String question;
		int type;
		
		System.out.println("enter the question:");
		question = scanner.nextLine();
		
		System.out.println("enter the type (0 for one choice only, 1 for multiple choices):");
		type = scanner.nextInt();
		scanner.nextLine();
		
		system.createVoting(question, type);
	}
	
	private static void addChoiceToVoting(){
		
		int votingIndex;
		System.out.println("enter voting index:");
		votingIndex = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter the available choices seperating them by white spcace (enter DONE when done):");
		int flag = 1;
		String choice;
		
		while(flag != 0){
			choice = scanner.nextLine();
			if(choice.equals("DONE")){
				flag = 0;
			}
			else{
				system.addChoiceToVoting(votingIndex, choice);
			}
		}
	}
	
	
	private static void printAllVotings(){
		system.printListOfVotings();
	}
	
	private static void printVoting(){
		int index;
		
		System.out.println("enter the voting index:");
		index = scanner.nextInt();
		scanner.nextLine();
		
		system.printVoting(index);
	}
	
	private static void createVote(){
		System.out.println("enter the voting index:");
		int index = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter the voter first name:");
		String firstName = scanner.nextLine();
		
		System.out.println("enter the voter last name:");
		String lastName = scanner.nextLine();
		
		Person voter = new Person(firstName, lastName);
		
		System.out.println("enter the voting year:");
		int year = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter the voting month:");
		int month = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("enter the voting day:");
		int day = scanner.nextInt();
		scanner.nextLine();
		
		JalaliCalendar date = new JalaliCalendar(year, month, day);
		
		//adding the choices
		System.out.println("enter the choices seperating them by white spcace (enter DONE when done):");
		int flag = 1;
		String choice;
		ArrayList<String> choices = new ArrayList<>();
		
		while(flag != 0){
			choice = scanner.nextLine();
			if(choice.equals("DONE")){
				flag = 0;
			}
			else{
				choices.add(choice);
			}
		}
		
		system.vote(index, voter, date, choices);
	}
	
	private static void printResult(){
		System.out.println("enter the voting index:");
		int index = scanner.nextInt();
		scanner.nextLine();
		
		system.printResult(index);
	}
	
	public static void main(String[] args) {
		int input = 1;
		
		while(input != 0){
			
			System.out.println("1. create voting");
			System.out.println("2. print list of all votings");
			System.out.println("3. print an specific voting");
			System.out.println("4. create a vote");
			System.out.println("5. print result of voting");
			System.out.println("6. add choices to a voting");
			System.out.println("0. exit");
			input = scanner.nextInt();
			scanner.nextLine();
			
			if(input == 1){
				createVoting();
			}
			else if(input == 2){
				printAllVotings();
			}
			else if(input == 3){
				printVoting();
			}
			else if(input == 4){
				createVote();
			}
			else if(input == 5){
				printResult();
			}
			else if(input == 6){
				addChoiceToVoting();
			}
			
		}

	}

}
