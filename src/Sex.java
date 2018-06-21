public enum Sex
{
	F("FEMALE"), M("MALE"), U("UNKNOWN");

	private String value;

	private Sex(String value) {
		this.value = value;
	}

	public String getValue() {
		return(value);
	}
}
