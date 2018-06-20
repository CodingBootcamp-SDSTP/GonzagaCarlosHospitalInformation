import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

class Confinement
{
	final int ID;
	private Person patient;
	private LocalDateTime admissionDateTime;
	private LocalDateTime dischargeDateTime;
	private Room room;

	public Confinement(int id, Person patient, LocalDateTime admissionDateTime, Room room) {
		this.ID = id;
		this.patient = patient;
		this.admissionDateTime = admissionDateTime;
		this.dischargeDateTime = null;
		this.room = room;
	}

	public Person getPatient() {
		return(patient);
	}

	public void setPatient(Person patient) {
		this.patient = patient;
	}

	public LocalDateTime getAdmissionDateTime() {
		return(admissionDateTime);
	}

	public void setAdmissionDateTime(LocalDateTime admissionDateTime) {
		this.admissionDateTime = admissionDateTime;
	}

	public LocalDateTime getDischargeDateTime() {
		return(dischargeDateTime);
	}

	public void setDischargeDateTime(LocalDateTime dischargeDateTime) {
		this.dischargeDateTime = dischargeDateTime;
	}

	public Room getRoom() {
		return(room);
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String confinementPeriodToString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a");
		String admission = admissionDateTime.format(f);
		String discharge = dischargeDateTime != null ? dischargeDateTime.format(f) : "Present";
		return(admission + " to " + discharge);
	}

	public String confinementDurationToString() {
		LocalDateTime datetime = dischargeDateTime != null ? dischargeDateTime : LocalDateTime.now();
		long hours = Duration.between(admissionDateTime, datetime).toHours();
		int days = (int)hours/24;
		int hrs = (int)hours%24;
		return(days + (days < 2 ? " day and " : " days and ") + hrs + (hours < 2 ? " hour " : " hours "));
	}
}
