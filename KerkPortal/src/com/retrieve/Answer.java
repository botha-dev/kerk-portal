package com.retrieve;

public class Answer {
	private String text;
	private String type;
	
	@Override
	public String toString() {
		return "Answer [text=" + text + ", type=" + type + ", answer=" + answer + "]";
	}
	private String answer;
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText()
	{
		return this.text;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getAnswer() {
		return this.answer;
	}
	
	
	public boolean ansIsEmpty() {
		boolean isEmpty;
		
		isEmpty = answer == "";
		if (isEmpty) {
			return isEmpty;
		}
		
		isEmpty = answer == null;
		if (isEmpty) {
			return isEmpty;
		}
		
		isEmpty = answer == "null";
		return isEmpty;
	}
	
}
