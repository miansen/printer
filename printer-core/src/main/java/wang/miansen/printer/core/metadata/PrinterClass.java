package wang.miansen.printer.core.metadata;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public class PrinterClass {

	private String name;
	
	private Class<?> type;
	
	public PrinterClass(Class<?> type) {
		this.type = type;
		this.name = type.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PrinterClass [name=" + name + "]";
	}

}
