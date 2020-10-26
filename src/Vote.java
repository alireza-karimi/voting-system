import ir.huri.jcal.JalaliCalendar;


public class Vote {
	private Person person;
	JalaliCalendar date;
	
	public Vote(Person person, JalaliCalendar date){
		this.person = person;
		this.date = date;
	}
	
	public Person getPerson(){
		return person;
	}
	
	public JalaliCalendar getDate(){
		return date;
	}
	
}
