import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class Person
{
	private int id;
	private String lastname;
	private String firstname;
	private String nameExtension;
	private String middlename;
	private LocalDate birthday;
	private String gender;

	public int getId() {
		return(id);
	}

	public void setId(int n) {
		id = n;
	}

	public String getLastname() {
		return(lastname);
	}

	public void setLastname(String ln) {
		lastname = ln.toUpperCase();
	}

	public String getFirstname() {
		return(firstname);
	}

	public void setFirstname(String fn) {
		firstname = fn.toUpperCase();
	}

	public String getNameExtension() {
		return(nameExtension);
	}

	public void setNameExtension(String ne) {
		if(ne != null) {
			nameExtension = ne.toUpperCase().replace(".", "");
		}
		else {
			nameExtension = ne;
		}
	}

	public String getMiddlename() {
		return(middlename);
	}

	public void setMiddlename(String mn) {
		middlename = mn.toUpperCase();
	}

	public LocalDate getBirthday() {
		return(birthday);
	}

	public void setBirthday(LocalDate date) {
		birthday = date;
	}

	public String getGender() {
		return(gender);
	}

	public void setGender(String sex) {
		gender = sex.toUpperCase();
	}

	public String birthdayToString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		return(birthday.format(f));
	}

	public int getAge() {
		return(Period.between(birthday, LocalDate.now()).getYears());
	}

	public String toString() {
		return(lastname + ", " + firstname + " " + (nameExtension != null ? nameExtension + ". " : "") + middlename);
	}
}
