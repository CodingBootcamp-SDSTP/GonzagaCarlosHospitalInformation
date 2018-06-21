import java.util.ArrayList;

class ConfinementCollection
{
	public static ConfinementCollection _instance;

	public static ConfinementCollection instance() {
		if(_instance == null) {
			_instance = new ConfinementCollection();
		}
		return(_instance);
	}

	private ArrayList<Confinement> confinements;

	private ConfinementCollection() {
		confinements = new ArrayList<Confinement>();
	}

	public ArrayList<Confinement> getAllConfinements() {
		return(confinements);
	}

	public ArrayList<Confinement> getCurrentConfinements() {
		ArrayList<Confinement> list = new ArrayList<Confinement>();
		for(Confinement c : confinements) {
			if(c.getDischargeDateTime() == null) {
				list.add(c);
			}
		}
		return(list);
	}

	public ArrayList<Confinement> getPastConfinements() {
		ArrayList<Confinement> list = new ArrayList<Confinement>();
		for(Confinement c : confinements) {
			if(c.getDischargeDateTime() != null) {
				list.add(c);
			}
		}
		return(list);
	}

	public void addConfinement(Confinement c) {
		confinements.add(c);
	}

	public Confinement getConfinementById(int id) {
		for(Confinement c : confinements) {
			if(c.ID == id) {
				return(c);
			}
		}
		return(null);
	}

	public void removeConfinement(Confinement c) {
		confinements.remove(c);
	}

	public ArrayList<Person> getCurrentPatients() {
		ArrayList<Person> plist = new ArrayList<Person>();
		ArrayList<Confinement> clist = getCurrentConfinements();
		for(Confinement c : clist) {
			plist.add(c.getPatient());
		}
		return(plist);
	}

	public ArrayList<Person> getPastPatients() {
		ArrayList<Person> plist = new ArrayList<Person>();
		ArrayList<Confinement> clist = getPastConfinements();
		for(Confinement c : clist) {
			plist.add(c.getPatient());
		}
		return(plist);
	}

	public ArrayList<Person> getAllPatients() {
		ArrayList<Person> plist = new ArrayList<Person>();
		for(Confinement c : confinements) {
			plist.add(c.getPatient());
		}
		return(plist);
	}
}
