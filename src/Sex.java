public enum Sex
{
	F("Female"), M("Male"), U("Unknown");

	private String value;

	private Sex(String value) {
		this.value = value;
	}

	public String getValue() {
		return(value);
	}
}
