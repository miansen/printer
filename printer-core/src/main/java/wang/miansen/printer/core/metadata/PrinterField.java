package wang.miansen.printer.core.metadata;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public class PrinterField {

	private String type;

	private String name;

	private String dateFormat;

	private String theGetMethod;

	private String theSetMethod;

	private String key;

	private String mapSetMethod;

	private String mapGetMethod;

	private Boolean accessible;

	private String createMethod;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getTheGetMethod() {
		return theGetMethod;
	}

	public void setTheGetMethod(String theGetMethod) {
		this.theGetMethod = theGetMethod;
	}

	public String getTheSetMethod() {
		return theSetMethod;
	}

	public void setTheSetMethod(String theSetMethod) {
		this.theSetMethod = theSetMethod;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMapSetMethod() {
		return mapSetMethod;
	}

	public void setMapSetMethod(String mapSetMethod) {
		this.mapSetMethod = mapSetMethod;
	}

	public String getMapGetMethod() {
		return mapGetMethod;
	}

	public void setMapGetMethod(String mapGetMethod) {
		this.mapGetMethod = mapGetMethod;
	}

	public Boolean getAccessible() {
		return accessible;
	}

	public void setAccessible(Boolean accessible) {
		this.accessible = accessible;
	}

	public String getCreateMethod() {
		return createMethod;
	}

	public void setCreateMethod(String createMethod) {
		this.createMethod = createMethod;
	}

	@Override
	public String toString() {
		return "PrinterField [type=" + type + ", name=" + name + ", dateFormat=" + dateFormat + ", theGetMethod="
				+ theGetMethod + ", theSetMethod=" + theSetMethod + ", key=" + key + ", mapSetMethod=" + mapSetMethod
				+ ", mapGetMethod=" + mapGetMethod + ", accessible=" + accessible + ", createMethod=" + createMethod
				+ "]";
	}

}
