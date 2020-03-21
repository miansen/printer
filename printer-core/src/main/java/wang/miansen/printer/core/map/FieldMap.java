package wang.miansen.printer.core.map;

import wang.miansen.printer.core.Converter;
import wang.miansen.printer.core.metadata.PrinterClass;
import wang.miansen.printer.core.metadata.PrinterField;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public class FieldMap {

	private PrinterClass printerClass;
	
	private PrinterField srcField;
	
	private PrinterField destField;
	
	private Converter<?, ?> converter;

	public PrinterClass getPrinterClass() {
		return printerClass;
	}

	public void setPrinterClass(PrinterClass printerClass) {
		this.printerClass = printerClass;
	}

	public PrinterField getSrcField() {
		return srcField;
	}

	public void setSrcField(PrinterField srcField) {
		this.srcField = srcField;
	}

	public PrinterField getDestField() {
		return destField;
	}

	public void setDestField(PrinterField destField) {
		this.destField = destField;
	}

	public Converter<?, ?> getConverter() {
		return converter;
	}

	public void setConverter(Converter<?, ?> converter) {
		this.converter = converter;
	}

	@Override
	public String toString() {
		return "FieldMap [printerClass=" + printerClass + ", srcField=" + srcField + ", destField=" + destField
				+ ", converter=" + converter + "]";
	}
	
}
