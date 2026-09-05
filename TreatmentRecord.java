public class TreatmentRecord {

	String treatmentId;
	int patientId;
	String treatmentDate;
	String treatmentDescription;

	public TreatmentRecord(String treatmentId, int patientId,
						   String treatmentDate,
						   String treatmentDescription) {

		this.treatmentId = treatmentId;
		this.patientId = patientId;
		this.treatmentDate = treatmentDate;
		this.treatmentDescription = treatmentDescription;
	}

	public void displayTreatment() {

		System.out.println("Treatment ID: " + treatmentId);
		System.out.println("Patient ID: " + patientId);
		System.out.println("Treatment Date: " + treatmentDate);
		System.out.println("Treatment Description: " + treatmentDescription);
	}
}
