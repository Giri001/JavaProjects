package quizproblem;

import java.util.Random;

public class Question {
	private int id;
	private int a;
	private int b;
	private int c;
	private long answer;
	private long userAns;
	private String result;
	
	Question(int id, int a, int b, int c){
		this.id = id;
		this.a = a;
		this.b = b;
		this.c = c;
		this.answer = (long) (a-b)*c;
	}
	
	public static Question[] generateQuestions(int n, int difficulty) {
//		Creating an array of size n to storing questions
		Question[] questions = new Question[n];
//		Creating n Questions
		for(int i=0;i<n;i++) {
//			creating object of class Question with random values of a,b,c
			questions[i] = new Question(i+1, random(difficulty),random(difficulty),random(difficulty));
		}
//		returning the questions array back
		return questions;
	}
	
//	Creating a random number based on the difficulty 
	static int random(int difficulty) {
		Random rand = new Random();
		return rand.nextInt((int) Math.pow(10, difficulty));
	}
	
	@Override
	public String toString() {
		return "[id = "+this.id+ ",a = "+this.a+", b = "+this.b+", c = "+this.c+", answer = "+this.answer+"]";
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public long getAnswer() {
		return answer;
	}

	public void setAnswer(long answer) {
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long getUserAns() {
		return userAns;
	}

	public void setUserAns(long userAns) {
		this.userAns = userAns;
	}

	
	
	

}
