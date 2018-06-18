class Room
{
	private final int ROOM_NUMBER;
	private final String TYPE;
	private final int BED_CAPACITY;
	private int numberOfOccupiedBeds;

	public Room(int roomNumber, String type, int bedCapacity, int numberOfOccupiedBeds) {
		ROOM_NUMBER = roomNumber;
		TYPE = type;
		BED_CAPACITY = bedCapacity;
		this.numberOfOccupiedBeds = numberOfOccupiedBeds;
	}

	public int getRoomNumber() {
		return(ROOM_NUMBER);
	}

	public String getType() {
		return(TYPE);
	}

	public int getBedCapacity() {
		return(BED_CAPACITY);
	}

	public int getNumberOccupiedBeds() {
		return(numberOfOccupiedBeds);
	}

	public int getNumberOfAvailableBeds() {
		return(BED_CAPACITY - numberOfOccupiedBeds);
	}

	public boolean addNumberOfOccupiedBed() {
		if(BED_CAPACITY > numberOfOccupiedBeds) {
			numberOfOccupiedBeds++;
			return(true);
		}
		return(false);
	}
}
