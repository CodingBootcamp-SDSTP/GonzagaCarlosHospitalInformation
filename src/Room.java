class Room
{
	final int ROOM_NUMBER;
	final String TYPE;
	final int BED_CAPACITY;
	private int numberOfOccupiedBeds;

	public Room(int roomNumber, String type, int bedCapacity, int numberOfOccupiedBeds) {
		ROOM_NUMBER = roomNumber;
		TYPE = type;
		BED_CAPACITY = bedCapacity;
		this.numberOfOccupiedBeds = numberOfOccupiedBeds;
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
