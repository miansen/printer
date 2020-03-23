package wang.miansen.printer.core.map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import wang.miansen.printer.core.MappingException;
import wang.miansen.printer.core.metadata.PrinterField;
import wang.miansen.printer.core.util.MappingUtils;

/**
 * 字段映射类
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public class FieldMap {

	/**
	 * 来源字段
	 */
	private PrinterField sourceField;

	/**
	 * 目标字段
	 */
	private PrinterField targetField;
	
	/**
	 * 类映射
	 */
	private ClassMap classMap;


	public PrinterField getSourceField() {
		return sourceField;
	}

	public void setSourceField(PrinterField sourceField) {
		this.sourceField = sourceField;
	}

	public PrinterField getTargetField() {
		return targetField;
	}

	public void setTargetField(PrinterField targetField) {
		this.targetField = targetField;
	}
	
	public ClassMap getClassMap() {
		return classMap;
	}

	public void setClassMap(ClassMap classMap) {
		this.classMap = classMap;
	}

	/**
	 * 将指定的值赋给目标对象的 {@link #targetField} 字段
	 * 
	 * @param targetObj 目标对象
	 * @param targetValue 值
	 * @throws MappingException
	 */
	public void writeTargetValue(Object targetObj, Object targetValue) throws MappingException {
		Method writeMethod = this.targetField.getWriteMethod();
		try {
			Object existsValue = readTargetValue(targetObj);
			if (Objects.equals(existsValue, targetValue)) {
				return;
			}
			writeMethod.invoke(targetObj, targetValue);
		} catch (IllegalAccessException e) {
			MappingUtils.throwMappingException(e);
		} catch (IllegalArgumentException e) {
			MappingUtils.throwMappingException(e);
		} catch (InvocationTargetException e) {
			MappingUtils.throwMappingException(e);
		}
	}

	/**
	 * 获取目标对象 {@link #targetField} 字段的值
	 * 
	 * @param targetObj 目标对象
	 * @return Object
	 * @throws MappingException
	 */
	public Object readTargetValue(Object targetObj) throws MappingException {
		Object result = null;
		Method readMethod = this.targetField.getReadMethod();
		try {
			result = readMethod.invoke(targetObj);
		} catch (IllegalAccessException e) {
			MappingUtils.throwMappingException(e);
		} catch (IllegalArgumentException e) {
			MappingUtils.throwMappingException(e);
		} catch (InvocationTargetException e) {
			MappingUtils.throwMappingException(e);
		}
		return result;
	}
	
	/**
	 * 获取来源对象 {@link #sourceField} 字段的值
	 * @param sourceObj
	 * @return
	 * @throws MappingException
	 */
	public Object readSourceValue(Object sourceObj) throws MappingException {
		Object result = null;
		Method readMethod = this.sourceField.getReadMethod();
		try {
			result = readMethod.invoke(sourceObj);
		} catch (IllegalAccessException e) {
			MappingUtils.throwMappingException(e);
		} catch (IllegalArgumentException e) {
			MappingUtils.throwMappingException(e);
		} catch (InvocationTargetException e) {
			MappingUtils.throwMappingException(e);
		}
		return result;
	}

}
