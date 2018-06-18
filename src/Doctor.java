import java.time.LocalDate;
import java.util.ArrayList;

class Doctor extends Person
{
	private int licenseNumber;
	private String type;
	private ArrayList<Patient> patients;

	public Doctor(int id, String lastname, String firstname, String nameExtension, String middlename, LocalDate birthday, String sex, int licenseNumber, String type) {
		setId(id);
		setLastname(lastname);
		setFirstname(firstname);
		setNameExtension(nameExtension);
		setMiddlename(middlename);
		setBirthday(birthday);
		setGender(sex);
		this.licenseNumber = licenseNumber;
		this.type = type;
		patients = new ArrayList<Patient>();
	}

	public Doctor(int id, String lastname, String firstname, String middlename, LocalDate birthday, String sex, int licenseNo, String type) {
		setId(id);
		setLastname(lastname);
		setFirstname(firstname);
		setNameExtension(null);
		setMiddlename(middlename);
		setBirthday(birthday);
		setGender(sex);
		licenseNumber = licenseNo;
		this.type = type;
		patients = new ArrayList<Patient>();
	}

	public int getLicenseNumber() {
		return(licenseNumber);
	}

	public void setLicenseNumber(int lno) {
		licenseNumber = lno;
	}

	public String getType() {
		return(type);
	}

	public void setType(String t) {
		type = t;
	}

	public ArrayList<Patient> getPatients() {
		return(patients);
	}

	public void addPatient(Patient p) {
		patients.add(p);
	}

	public void removePatient(Patient p) {
		patient.remove(p);
	}

	public void removePatientById(int id) {
		for(Patient p : patients) {
			if(p.getId() == id) {
				patients.remove(p);
			}
		}
	}
}
