package wang.miansen.printer.core.converters;

import wang.miansen.printer.core.util.ConvertUtils;

/**
 * 抽象转换器，提供了通用的转换逻辑
 * 
 * @author miansen.wang
 * @date 2020-04-10
 * @since 1.0
 */
public abstract class AbstractConverter implements Converter {
	
	/**
	 * 指定转换的默认值
	 */
	private Object defaultValue = null;
	
	/**
	 * 默认的构造器
	 * <p>使用这个构造器的话，转换发生错误时将抛出 {@link #ConversionException} 异常。
	 */
	public AbstractConverter() {
		
	}
	
	/**
	 * 带有默认值的构造器
	 * <p>使用这个构造器的话，可以设置默认值。转换的值丢失或者转发的过程中发生错误时，将返回这个默认值。
	 * 
	 * @param defaultValue 默认值
	 */
	public AbstractConverter(Object defaultValue) {
		setDefaultValue(defaultValue);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T convert(Object value, Class<T> type) throws ConversionException {
		if (defaultValue == null && type == null) {
			throw new ConversionException(String.format("[type] and [defaultValue] are both null for Converter [{}], we can not know what type to convert !", this.getClass().getName()));
		}
		Class<?> sourceType = value == null ? null : value.getClass();
		Class<T> targetType = ConvertUtils.primitiveToWrapper(type);
		if (targetType == null) {
			targetType = (Class<T>) defaultValue.getClass();
		}
		if (value == null && !targetType.isInstance(defaultValue)) {
			throw new ConversionException(String.format("Default value [{}] is not the instance of [{}]", defaultValue, targetType));
		}
		if (value == null) {
			return targetType.cast(defaultValue);
		}
		if (value != null && sourceType == targetType) {
			return targetType.cast(value);
		}
		try {
			return convertProcess(value, type);
		} catch (Exception e) {
			if (defaultValue != null) {
				return (T) defaultValue;
			} else {
				throw e;
			}
		}
	}
	
	/**
	 * 将输入的对象转换为字符串。
	 * <p>该方法只是简单的返回 {@code toString()}，如果需要更复杂的转换机制，子类应该重写此方法。
	 * 
	 * @param value 要转换的输入值。
	 * @return 如果输入对象为空，那么将返回 {@code null}。否则，返回输入对象的 {@code toString()} 方法。
	 */
	protected String convertToString(final Object value) {
		if (value == null) {
			return null;
		}
        return value.toString();
    }

	/**
	 * 具体的转换逻辑，由子类实现。
	 * 
	 * @param value 原始值
	 * @param type 转换的类型
	 * @return 转换值
	 * @throws ConversionException 如果转换发生错误并且默认值为 {@code null}，则抛出此异常。
	 */
	protected abstract <T> T convertProcess(Object value, Class<T> type) throws ConversionException;
	
	/**
	 * 获取目标类型，由子类实现。
	 * 
	 * @return 目标类型
	 */
	protected abstract Class<?> getTargetType();
	
	/**
	 * 获取默认值
	 * 
	 * @return 默认值
	 */
	protected Object getDefaultValue() {
		return defaultValue;
	}

	/**
	 * 设置默认值
	 * 
	 * @param defaultValue 默认值
	 */
	protected void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}

}
