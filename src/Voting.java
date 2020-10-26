import ir.huri.jcal.JalaliCalendar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class Voting {
	//type of Voting - 0 means one choice only, 1 means multiple choices
	private int type;
	private String question;
	//it is better to have an arraylist of votes than voters; because vote has voter in itself
	private ArrayList<Vote> votes;
	//HashMap of choice to its Votes
	private HashMap<String, HashSet<Vote>> choices;
	
	/**
	 * creating a new Voting
	 * @param type type of voting - 0 means one choice only, 1 means multiple choices
	 * @param question question of voting
	 */
	public Voting(int type, String question){
		this.type = type;
		this.question = question;
		votes = new ArrayList<>();
		choices = new HashMap<>();
	}
	
	/**
	 * print question of voting
	 */
	public void showVoting(){
		System.out.println(question);
	}
	
	/**
	 * getting question of this Voting
	 * @return question of this Voting
	 */
	public String getQuestion(){
		return question;
	}
	
	/**
	 * adding a choice to this Voting
	 */
	public void createChoice(String choice){
		HashSet<Vote> choiceVotes = new HashSet<>();
		choices.put(choice, choiceVotes);
		System.out.println("choice added succesfully to this voting");
	}
	
	/**
	 * add a Vote to this Voting
	 * @param voter voter Person
	 * @param choices choices of this voter
	 */
	public void vote(Person voter, JalaliCalendar date,  ArrayList<String> choices){
		for(Vote vote : votes){
			if(vote.getPerson().getFirstName().equals(voter.getFirstName()) && vote.getPerson().getLastName().equals(voter.getLastName())){
				System.out.println("this person has voted before. It is not possible to vote again");
				return;
			}
		}
		
		//creating a new Vote
		Vote vote = new Vote(voter, date);
		
		//adding vote choices to choices
		HashSet<Vote> oldVotes;
		if(type == 0){
			if(choices.size() > 1){
				System.out.println("you can not have multiple choices for this voting");
				return;
			}
			else if(choices.size() == 1){
				if(this.choices.containsKey(choices.get(0))){
					oldVotes = this.choices.get(choices.get(0));
					oldVotes.add(vote);
					this.choices.put(choices.get(0), oldVotes);
				}
				else{
					System.out.println("this voting does not have entered choice or choices");
					return;
				}
			}
		}
		else if(type == 1){
			if(choices.size() > this.choices.size()){
				System.out.println("you have entered more choices than available choices");
				return;
			}
			else {
				for(String choice : choices){
					if(this.choices.containsKey(choice)){
						oldVotes = this.choices.get(choice);
						oldVotes.add(vote);
						this.choices.put(choice, oldVotes);
					}
					else{
						System.out.println("this voting does not have entered choice or choices");
						return;
					}
				}
			}
		}
		
		//adding vote to votes
		votes.add(vote);
		
		
		
		System.out.println("voted succesfully");
		
		
	}
	
	public void printVoters(){
		int counter = 0;
		
		for(Vote vote : votes){
			vote.getPerson().showPerson();
			counter++;
		}
		
		if(counter == 0){
			System.out.println("there is no voter for this voting yet");
		}
	}
	
	
	public void printResult(){
		Iterator it = choices.entrySet().iterator();
		String winner = "no choice";
		ArrayList<String> winners = new ArrayList<>();
		int votesCounter = 0;
		
		while(it.hasNext()){
			Map.Entry item = (Map.Entry) it.next();
			HashSet<Vote> values = (HashSet<Vote>) item.getValue();
			if(values.size() > votesCounter){
				votesCounter = values.size();
				winner = (String) item.getKey();
			}
		}
		/*
		System.out.println("*");
		System.out.println(votesCounter);
		System.out.println(winner);
		*/
		Iterator it2 = choices.entrySet().iterator();
		while(it2.hasNext()){
			Map.Entry item = (Map.Entry) it2.next();
			HashSet<Vote> values = (HashSet<Vote>) item.getValue();
			if(values.size() == votesCounter){
				winner = (String) item.getKey();
				winners.add(winner);
			}
		}
		
		System.out.println("winners of this voting are:");
		
		for(String item : winners){
			System.out.println(item);
		}
	}
	
	
	
	
}
