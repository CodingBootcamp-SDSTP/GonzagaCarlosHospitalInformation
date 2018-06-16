import java.time.LocalDate;
import java.time.Period;

class Person
{
	private final int ID;
	private String lastname;
	private String firstname;
	private String nameExtension;
	private String middlename;
	private LocalDate birthday;
	private String sex;

	public Person(int i, String ln, String fn, String ne, String mn, LocalDate date, String s) {
		ID = i;
		lastname = ln.toUpperCase();
		firstname = fn.toUpperCase();
		nameExtension = ne.toUpperCase();
		middlename = mn.toUpperCase();
		birthday = date;
		sex = s;
	}

	public Person(int i, String ln, String fn, String mn, LocalDate date, String s) {
		ID = i;
		lastname = ln.toUpperCase();
		firstname = fn.toUpperCase();
		nameExtension = null;
		middlename = mn.toUpperCase();
		birthday = date;
		sex = s.toUpperCase();
	}

	public int getID() {
		return(ID);
	}

	public String getLastname() {
		return(lastname);
	}

	public void setLastname(String ln) {
		lastname = ln;
	}

	public String getFirstname() {
		return(firstname);
	}

	public void setFirstname(String fn) {
		firstname = fn;
	}

	public String getNameExtension() {
		return(nameExtension);
	}

	public void setNameExtenstion(String ne) {
		nameExtension = ne;
	}

	public String getMiddlename() {
		return(middlename);
	}

	public void setMiddlename(String mn) {
		middlename = mn;
	}

	public LocalDate getBirthday() {
		return(birthday);
	}

	public void setBirthday(LocalDate date) {
		birthday = date;
	}

	public int getAge() {
		return(Period.between(birthday, LocalDate.now()).getYears());
	}

	public String toString() {
		return(lastname + " " + firstname + " " + (nameExtension != null ? nameExtension + " " : "") + middlename);
	}
}
