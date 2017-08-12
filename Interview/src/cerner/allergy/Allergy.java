package cerner.allergy;

import java.util.Date;
import java.util.List;

public class Allergy {

   private String allergyName;
   private List<String> symptoms;
   private Severity severity;
   private ReportedBy reportedBy;
   private Date detectedDate;


    public Allergy(String allergyName, List<String> symptoms, Severity severity, ReportedBy reportedBy, Date detectedDate) {
        this.allergyName = allergyName;
        this.symptoms = symptoms;
        this.severity = severity;
        this.reportedBy = reportedBy;
        this.detectedDate = detectedDate;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public ReportedBy getReportedBy() {
        return reportedBy;
    }

    public void setReportedBy(ReportedBy reportedBy) {
        this.reportedBy = reportedBy;
    }

    public Date getDetectedDate() {
        return detectedDate;
    }

    public void setDetectedDate(Date detectedDate) {
        this.detectedDate = detectedDate;
    }
}
