import java.util.ArrayList;

class PersonCollection
{
	private static PersonCollection _instance;

	public static PersonCollection instance() {
		if(_instance == null) {
			_instance = new PersonCollection();
		}
		return(_instance);
	}

	ArrayList<Person> persons;

	private PersonCollection() {
		persons = new ArrayList<Person>();
	}

	public ArrayList<Person> getAllPersons() {
		return(persons);
	}

	public void addPerson(Person p) {
		persons.add(p);
	}

	public Person getPersonById(int id) {
		for(Person p : persons) {
			if(p.ID == id) {
				return(p);
			}
		}
		return(null);
	}

	public ArrayList<Person> search(String str) {
		ArrayList<Person> list = new ArrayList<Person>();
		for(Person p : persons) {
			if(p.matches(str)) {
				list.add(p);
			}
		}
		return(list);
	}
}
