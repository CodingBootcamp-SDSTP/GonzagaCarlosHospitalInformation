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
}
