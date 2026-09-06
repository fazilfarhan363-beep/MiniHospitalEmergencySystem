public class Visit {

    String visitId;
    String visitDate;
    String doctorName;
    String diagnosis;
    String treatment;

    public Visit(String visitId, String visitDate,
                 String doctorName, String diagnosis,
                 String treatment) {

        this.visitId = visitId;
        this.visitDate = visitDate;
        this.doctorName = doctorName;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
    }

    public void displayVisit() {

        System.out.println("Visit ID: " + visitId);
        System.out.println("Visit Date: " + visitDate);
        System.out.println("Doctor Name: " + doctorName);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Treatment: " + treatment);
    }
}