import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class Person
{
	final int ID;
	private String lastname;
	private String firstname;
	private NameExtension nameExtension;
	private String middlename;
	private LocalDate birthday;
	private Sex gender;

	public Person(int id, String lastname, String firstname, NameExtension nameExtension, String middlename, LocalDate birthday, Sex sex) {
		this.ID = id;
		this.lastname = lastname.toUpperCase();
		this.firstname = firstname.toUpperCase();
		this.nameExtension = nameExtension;
		this.middlename = middlename.toUpperCase();
		this.birthday = birthday;
		this.gender = sex;
	}

	public Person(int id, String lastname, String firstname, String middlename, LocalDate birthday, Sex sex) {
		this.ID = id;
		this.lastname = lastname.toUpperCase();
		this.firstname = firstname.toUpperCase();
		this.nameExtension = null;
		this.middlename = middlename.toUpperCase();
		this.birthday = birthday;
		this.gender = sex;
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
		return(nameExtension.getValue());
	}

	public void setNameExtension(NameExtension ne) {
		if(ne != null) {
			nameExtension = ne;
		}
		else {
			nameExtension = null;
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

	public Sex getGender() {
		return(gender);
	}

	public String getGenderValue() {
		return(gender.getValue());
	}

	public void setGender(Sex sex) {
		gender = sex;
	}

	public String birthdayToString() {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		return(birthday.format(f));
	}

	public int getAge() {
		return(Period.between(birthday, LocalDate.now()).getYears());
	}

	public String toString() {
		String ext = nameExtension != null ? nameExtension.getValue() + " ": "";
		return(lastname + ", " + firstname + " " + ext + middlename);
	}

	public boolean matches(String str) {
		if(lastname.contains(str) || firstname.contains(str) || middlename.contains(str)) {
			return(true);
		}
		return(false);
	}
}
