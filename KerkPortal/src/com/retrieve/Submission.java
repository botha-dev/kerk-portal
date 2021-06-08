package com.retrieve;

import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.jotform.api.*;

public class Submission {
	private String id;
	private String created_at_date;
	private String form_id;
	private String msgToSeniorPastor;
	private String sheperdName;
	private LocalDate dateOfCell;
	private int contactTotal;
	private int memTotal;
	private JSONObject answers;
	
	@Override
	public String toString() {
		String returnString = sheperdName + " " + dateOfCell + " " + String.valueOf(contactTotal) + " " + String.valueOf(memTotal) + " " + msgToSeniorPastor;  
		return returnString;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreated_at_date() {
		return created_at_date;
	}
	public void setCreated_at_date(String created_at_date) {
		this.created_at_date = created_at_date;
	}
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}
	public String getMsgToSeniorPastor() {
		return msgToSeniorPastor;
	}
	public void setMsgToSeniorPastor(String msgToSeniorPastor) {
		this.msgToSeniorPastor = msgToSeniorPastor;
	}
	public String getSheperdName() {
		return sheperdName;
	}
	public void setSheperdName(String sheperdName) {
		this.sheperdName = sheperdName;
	}
	public LocalDate getDateOfCell() {
		return dateOfCell;
	}
	public void setDateOfCell(LocalDate dateOfCell) {
		this.dateOfCell = dateOfCell;
	}
	public int getContactTotal() {
		return contactTotal;
	}
	public void setContactTotal(int contactTotal) {
		this.contactTotal = contactTotal;
	}
	public int getMemTotal() {
		return memTotal;
	}
	public void setMemTotal(int memTotal) {
		this.memTotal = memTotal;
	}
	public JSONObject getAnswers() {
		return answers;
	}
	public void setAnswers(JSONObject answers) {
		this.answers = answers;
	}
	
	public ArrayList<Answer> buildAnswer() throws JSONException
	{
		ArrayList<Answer> ans = new ArrayList<>();
		for (int i = 1; i < answers.length() + 1; i++) {
			try {
				JSONObject tempAnswer = answers.getJSONObject(String.valueOf(i));
				//System.out.println(tempAnswer.toString());
				Answer tmpAns = new Answer();
				tmpAns.setText(tempAnswer.getString("text"));
				tmpAns.setType(tempAnswer.getString("type"));
				try {
					tmpAns.setAnswer(tempAnswer.getString("answer"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				if (!tmpAns.ansIsEmpty()) {
					ans.add(tmpAns);
				}
				//System.out.println(tmpAns.toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
		}
		return ans;
	}
	
	public void parseSubmission(Answer answer) {
		String key = answer.getText();
		switch (key) {
		case "Members - TOTAL":
			setMemTotal(Integer.parseInt(answer.getAnswer()));
			
			break;
		case "Message to Senior Pastor:":
			setMsgToSeniorPastor(answer.getAnswer());
			break;
		case "Contacts - TOTAL":
			setContactTotal(Integer.parseInt(answer.getAnswer()));
			break;
		case "What was the date for the cell?":
			try {
				JSONObject json = new JSONObject(answer.getAnswer());
				//json.append("date", answer.getAnswer());
				int month = json.getInt("month");
				int day = json.getInt("day");
				int year = json.getInt("year");
				setDateOfCell(LocalDate.of(year, month, day));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "Cell Shepherd or person filling in the report":
			try {
				JSONObject json2 = new JSONObject(answer.getAnswer());
				//json2.append("fname", answer.getAnswer());
				setSheperdName(json2.getString("first") + " " + json2.getString("last"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
			
		default:
			break;
		}
	}
        
        public boolean isEmpty()
        {
           return  !(memTotal == 0 );           
        }
}
