package com.jotform.api.samples;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.jotform.api.*;
import com.retrieve.Form;
import java.util.ArrayList;

public class PrintFormList {

	public static void main(String[] args) {
	
		JotForm client = new JotForm("ad35e63e59012992d56952e1913e6e20");
		
		
		JSONObject formsResponse = client.getForms();
		
		try {
			JSONArray forms = formsResponse.getJSONArray("content");
			ArrayList<Form> formList = new ArrayList<>();
			for (int i=0; i<forms.length(); i++){
				JSONObject form = forms.getJSONObject(i);
				
                                formList.add(new Form(String.valueOf(form.get("id")),String.valueOf(form.get("title"))));
                                                                    
				//System.out.println(form.get("id") + " " + form.get("title") + " (Total:" +form.get("count") + " New:" + form.get("new") + ")");
			}
                        for (Object object : formList) {
                            System.out.println(object.toString());
                    }
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
}
