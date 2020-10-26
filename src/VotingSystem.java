import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;


public class VotingSystem {
	
	//a list of all created votings
	private ArrayList<Voting> votingList;
	
	/**
	 * creating a voting system
	 */
	public VotingSystem(){
		votingList = new ArrayList<>();
	}
	
	/**
	 * create a new voting
	 * @param question voting question
	 * @param type voting type - 0 means one choice only, 1 means multiple choices
	 */
	public void createVoting(String question, int type){
		Voting newVoting = new Voting(type, question);
		votingList.add(newVoting);
		System.out.println("voting created succesully");
	}
	
	public void addChoiceToVoting(int votingIndex, String choice){
		if(votingIndex < votingList.size() && votingIndex >= 0){
			votingList.get(votingIndex).createChoice(choice);
		}
		else{
			System.out.println("there is no voting with this index");
		}
	}
	
	/**
	 * prints questions of created votings
	 */
	public void printListOfVotings(){
		int counter = 0;
		for(Voting voting : votingList){
			voting.showVoting();
			counter++;
		}
		
		if(counter == 0){
			System.out.println("there is not voting yet");
		}
	}
	
	/**
	 * printing questions and polls of a voting by taking its index
	 * @param index index of voting
	 */
	public void printVoting(int index){
		if(index < votingList.size() && index >= 0){
			votingList.get(index).showVoting();
		}
		else{
			System.out.println("there is no voting with this index");
		}
	}
	
	/**
	 * adding a vote to some voting
	 * @param votingIndex index of voting
	 * @param voter Person who votes
	 * @param choices choices of Person for this voting
	 */
	public void vote(int votingIndex, Person voter, JalaliCalendar date, ArrayList<String> choices){
		if(votingIndex < votingList.size() && votingIndex >= 0){
			votingList.get(votingIndex).vote(voter, date, choices);
		}
		else{
			System.out.println("there is no voting with this index");
		}	
	}
	
	/**
	 * prints result of a voting
	 * @param votingIndex index of voting
	 */
	public void printResult(int votingIndex){
		if(votingIndex < votingList.size() && votingIndex >= 0){
			votingList.get(votingIndex).printResult();
		}
		else{
			System.out.println("there is no voting with this index");
		}	
	}
}
