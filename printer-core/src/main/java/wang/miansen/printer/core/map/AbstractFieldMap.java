package wang.miansen.printer.core.map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import wang.miansen.printer.core.MappingException;
import wang.miansen.printer.core.metadata.PrinterField;
import wang.miansen.printer.core.util.MappingUtils;

/**
 * 用于描述字段映射关系的抽象类
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public abstract class AbstractFieldMap implements FieldMap {

	/**
	 * 来源字段
	 */
	private final PrinterField sourceField;

	/**
	 * 目标字段
	 */
	private final PrinterField targetField;
	
	/**
	 * 类映射
	 */
	private final ClassMap classMap;

	public AbstractFieldMap(PrinterField sourceField, PrinterField targetField, ClassMap classMap) {
		this.sourceField = sourceField;
		this.targetField = targetField;
		this.classMap = classMap;
	}

	public PrinterField getSourceField() {
		return sourceField;
	}

	public PrinterField getTargetField() {
		return targetField;
	}

	public ClassMap getClassMap() {
		return classMap;
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
