public enum NameExtension
{
	JR("JR."), SR("SR."), II("II"), III("III"), IV("IV"), V("V");

	private String value;

	private NameExtension(String value) {
		this.value = value;
	}

	public String getValue() {
		return(value);
	}
}
