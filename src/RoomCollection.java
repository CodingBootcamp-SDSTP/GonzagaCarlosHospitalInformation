import java.util.ArrayList;

class RoomCollection
{
	public static RoomCollection _instance;

	public static RoomCollection instance() {
		if(_instance == null) {
			_instance = new RoomCollection();
		}
		return(_instance);
	}

	private ArrayList<Room> rooms;

	private RoomCollection() {
		rooms = new ArrayList<Room>();
	}

	public ArrayList<Room> getAllRooms() {
		return(rooms);
	}

	public void addRoom(Room rm) {
		rooms.add(rm);
	}

	public void removeRoom(Room rm) {
		rooms.remove(rm);
	}

	public Room getRoomByNumber(int roomNumber) {
		for(Room rm : rooms) {
			if(rm.ROOM_NUMBER == roomNumber) {
				return(rm);
			}
		}
		return(null);
	}

	public ArrayList<Room> getRoomsWithAvailableBed() {
		ArrayList<Room> list = new ArrayList<Room>();
		for(Room rm : rooms) {
			if(rm.getNumberOfAvailableBeds() > 0) {
				list.add(rm);
			}
		}
		return(list);
	}
}
