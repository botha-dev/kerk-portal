package com.jotform.api.samples;

import KerkPortal.DIFCPortal;
import static KerkPortal.DIFCPortal.API_KEY;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.jotform.api.*;
import com.retrieve.Answer;
import com.retrieve.Submission;
import java.time.Month;

public class SubmissionFormFilters {

    public static void main(String[] args) throws JSONException {
        DIFCPortal dfcPortal = new DIFCPortal();

        //JotForm client = new JotForm("ad35e63e59012992d56952e1913e6e20");
        JotForm client = new JotForm(dfcPortal.API_KEY);
        String form_id = "90522205031541";
        form_id = dfcPortal.CELL_REPORT_FORM_ID;
        DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
        //LocalDateTime ldt = LocalDateTime.now();
        //LocalTime.parse("00:00"));
        LocalDateTime ldt = LocalDateTime.of(LocalDate.of(2019, 6, 5), LocalTime.MIDNIGHT);
        String localDateTimeString = FORMATTER.format(ldt);
        System.out.println(localDateTimeString);
        HashMap<String, String> submissionFilter = new HashMap<String, String>();
        submissionFilter.put("id:gt", form_id);

        submissionFilter.put("created_at:gt", localDateTimeString);

        JSONObject submissions = client.getSubmissions("", "", submissionFilter, "");

        JSONArray content = null;
        try {
            content = submissions.getJSONArray("content");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<Submission> submissionList = new ArrayList<>();
        for (int i = 0; i < content.length(); i++) {
            JSONObject subContent = content.getJSONObject(i);
            Submission subm = new Submission();

            subm.setCreated_at_date(subContent.getString("created_at"));
            subm.setForm_id(subContent.getString("form_id"));
            subm.setId(subContent.getString("id"));
            subm.setAnswers(subContent.getJSONObject("answers"));
            submissionList.add(subm);
            //	System.out.println(subm.toString());
        }

        for (Submission submission : submissionList) {
            //System.out.println(submission.getAnswers().toString());
            ArrayList<Answer> answerlist = submission.buildAnswer();
            answerlist.forEach((answer) -> {
                //System.out.println(answer.toString());
                submission.parseSubmission(answer);
            });
            //submission.parseSubmission(answer);
            System.out.println("\n");
            System.out.println(submission.toString());
        }
        System.out.println(getSubmission());
        //System.out.println(submissions);
    }

    private static String getSubmission() throws JSONException {
        JotForm clientt = new JotForm(API_KEY);
        String result = "";
        DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
        
        LocalDateTime startDateTime = LocalDateTime.of(LocalDate.of(2019, 6, 5), LocalTime.MIDNIGHT);
        //LocalDateTime endDateTime = LocalDateTime.of(endDate, LocalTime.MIDNIGHT);
        String startLocalDateTimeString = FORMATTER.format(startDateTime);

        //String endLocalDateTimeString = FORMATTER.format(endDateTime);
        System.out.println(startLocalDateTimeString);
        HashMap<String, String> submissionFilter = new HashMap<>();

        String form_id = "90522205031541";

        submissionFilter.put("id", form_id);
        System.out.println(form_id);

        submissionFilter.put("created_at:gt", startLocalDateTimeString);
        //submissionFilter.put("created_at:lt", endLocalDateTimeString);

        
        JSONObject submissions = clientt.getSubmissions("", "", submissionFilter, "");

        JSONArray content = null;
        try {
            content = submissions.getJSONArray("content");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ArrayList<Submission> submissionList = new ArrayList<>();
        for (int i = 0; i < content.length(); i++) {
            JSONObject subContent = content.getJSONObject(i);
            Submission subm = new Submission();

            subm.setCreated_at_date(subContent.getString("created_at"));
            subm.setForm_id(subContent.getString("form_id"));
            subm.setId(subContent.getString("id"));
            subm.setAnswers(subContent.getJSONObject("answers"));
            submissionList.add(subm);
            System.out.println(subm.toString());
        }

        for (Submission submission : submissionList) {
            //System.out.println(submission.getAnswers().toString());
            ArrayList<Answer> answerlist = submission.buildAnswer();
            answerlist.forEach((answer) -> {
                //System.out.println(answer.toString());
                submission.parseSubmission(answer);
            });
            //submission.parseSubmission(answer);
            result += "\n";
            result += submission.toString();
            System.out.println("\n");
            System.out.println(submission.toString());
        }
        return result;
    }

}
