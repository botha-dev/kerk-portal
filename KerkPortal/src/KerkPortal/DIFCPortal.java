/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KerkPortal;

import com.jotform.api.JotForm;
import com.retrieve.Answer;
import com.retrieve.FormType;
import com.retrieve.Submission;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author jaco
 */
public class DIFCPortal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public DIFCPortal() {

        initComponents();
    }
    public static final String API_KEY = "ad35e63e59012992d56952e1913e6e20";
    public static final String CELL_REPORT_FORM_ID = "90522205031541";
    public static final String WEEKLY_ATT_FORM_ID = "90550998535570";

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        dtPick = new org.jdesktop.swingx.JXDatePicker();
        jLabel1 = new javax.swing.JLabel();
        cbxReportType = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtResults = new javax.swing.JEditorPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnSavePDF = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select Date ");

        cbxReportType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select Report Type", "Weekly Attendance", "Cell Report" }));
        cbxReportType.setName("cbxReportType"); // NOI18N

        jScrollPane1.setName("edtResults"); // NOI18N

        edtResults.setText("Reports:");
        edtResults.setToolTipText("");
        edtResults.setName("jEdtResults"); // NOI18N
        jScrollPane1.setViewportView(edtResults);

        jButton1.setText("Close");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Process");
        jButton2.setMaximumSize(new java.awt.Dimension(91, 23));
        jButton2.setMinimumSize(new java.awt.Dimension(91, 23));
        jButton2.setPreferredSize(new java.awt.Dimension(91, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnSavePDF.setText("Save as PDF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxReportType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtPick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 162, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSavePDF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dtPick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxReportType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSavePDF))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (cbxReportType.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Error: Please Select Report Type", "Report Type Error", 0);
                return;
            }

            Date pickDate = dtPick.getDate();
            Instant pickDateInstant = pickDate.toInstant();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(pickDateInstant, ZoneId.systemDefault());
            LocalDate localDate = localDateTime.toLocalDate();
            LocalDate endDate = localDate.plusDays(3);
            LocalDate startDate = localDate.minusDays(3);
            if (endDate.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                endDate = localDate.plusDays(4);
            }
            if (startDate.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                startDate = localDate.minusDays(2);
            }

            String result = getSubmission(startDate, endDate);
            edtResults.setText(result);
        } catch (JSONException ex) {
            Logger.getLogger(DIFCPortal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private String getFormId() {

        switch (cbxReportType.getSelectedIndex()) {
            case 0:
                break;
            case 1:
                return WEEKLY_ATT_FORM_ID;
            case 2:
                return CELL_REPORT_FORM_ID;
            default:
                break;

        }
        return "";
    }

    private String getSubmission(LocalDate startDate, LocalDate endDate) throws JSONException {
        String result = "";
        DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime startDateTime = LocalDateTime.of(startDate, LocalTime.MIDNIGHT);
        LocalDateTime endDateTime = LocalDateTime.of(endDate, LocalTime.MIDNIGHT);
        String startLocalDateTimeString = FORMATTER.format(startDateTime);

        String endLocalDateTimeString = FORMATTER.format(endDateTime);
        System.out.println(startLocalDateTimeString);
        HashMap<String, String> submissionFilter = new HashMap<>();

        String form_id = getFormId();

        submissionFilter.put("id:gt", form_id);
        System.out.println(form_id);

        submissionFilter.put("created_at:gt", startLocalDateTimeString);
        //submissionFilter.put("created_at:lt", endLocalDateTimeString);

        JotForm clientt = new JotForm(API_KEY);
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
            if (!subm.isEmpty()) {
                submissionList.add(subm);
            }

            //System.out.println(subm.toString());
        }

        for (Submission submission : submissionList) {
            //System.out.println(submission.getAnswers().toString());
            ArrayList<Answer> answerlist = submission.buildAnswer();
            answerlist.forEach((answer) -> {
                //System.out.println(answer.toString());
                submission.parseSubmission(answer);
            });
            //submission.parseSubmission(answer);
            //if (!submission.isEmpty()) {
                result += "\n";
                result += submission.toString();
            //}
            //System.out.println("\n");
            //System.out.println(submission.toString());
        }
        return result;
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DIFCPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DIFCPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DIFCPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DIFCPortal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new DIFCPortal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSavePDF;
    private javax.swing.JComboBox<String> cbxReportType;
    private org.jdesktop.swingx.JXDatePicker dtPick;
    private javax.swing.JEditorPane edtResults;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
