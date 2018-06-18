import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

class Patient extends Person
{
	private LocalDateTime admissionDateTime;
	private LocalDateTime dischargeDateTime;
	private int roomNumber;
	private int doctorId;
	private String illness;
	private int healthInsuranceId;

	public Patient(int id, String lastname, String firstname, String nameExtension, String middlename, LocalDate birthday, String sex, LocalDateTime admissionDateTime, int roomNumber) {
		setId(id);
		setLastname(lastname);
		setFirstname(firstname);
		setNameExtension(nameExtension);
		setMiddlename(middlename);
		setBirthday(birthday);
		setGender(sex);
		this.admissionDateTime = admissionDateTime;
		dischargeDateTime = null;
		this.roomNumber = roomNumber;
		doctorId = 0;
		illness = null;
		healthInsuranceId = 0;
	}

	public Patient(int id, String lastname, String firstname, String middlename, LocalDate birthday, String sex, LocalDateTime admissionDateTime, int roomNumber) {
		setId(id);
		setLastname(lastname);
		setFirstname(firstname);
		setNameExtension(null);
		setMiddlename(middlename);
		setBirthday(birthday);
		setGender(sex);
		this.admissionDateTime = admissionDateTime;
		dischargeDateTime = null;
		this.roomNumber = roomNumber;
		doctorId = 0;
		illness = null;
		healthInsuranceId = 0;
	}

	public LocalDateTime getAdmissionDateTime() {
		return(admissionDateTime);
	}

	public void setAdmissionDateTime(LocalDateTime datetime) {
		admissionDateTime = datetime;
	}

	public LocalDateTime getDischargeDateTime() {
		return(dischargeDateTime);
	}

	public void setDischargeDateTime(LocalDateTime datetime) {
		dischargeDateTime = datetime;
	}

	public int getRoomId() {
		return(roomNumber);
	}

	public void setRoomId(int room) {
		this.roomNumber = room;
	}

	public int getDoctorId() {
		return(doctorId);
	}

	public void setDoctorId(int id) {
		doctorId = id;
	}

	public String getIllness() {
		return(illness);
	}

	public void setIllness(String illness) {
		this.illness = illness.toUpperCase();
	}

	public int getHealthInsuranceId() {
		return(healthInsuranceId);
	}

	public void setHealthInsuranceId(int id) {
		healthInsuranceId = id;
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
