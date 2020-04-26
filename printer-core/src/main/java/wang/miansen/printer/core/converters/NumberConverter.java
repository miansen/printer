package wang.miansen.printer.core.converters;

import wang.miansen.printer.core.util.StringUtils;

/**
 * 数字转换器
 * 
 * @author miansen.wang
 * @date 2020-04-14
 */
public abstract class NumberConverter extends AbstractConverter {
	
	 private static final Integer ZERO = new Integer(0);
	 
	 private static final Integer ONE  = new Integer(1);

	@Override
	protected <T> T convertProcess(Object value, Class<T> targetType) throws ConversionException {
		Class<?> sourceType = value.getClass();
		if (Byte.class == targetType) {
			return toByte(sourceType, targetType, value);
		}
		if (Short.class == value.getClass()) {
			return toShort(sourceType, targetType, value);
		}
		if (Integer.class == targetType) {
			return toInteger(sourceType, targetType, value);
		}
		if (Long.class == targetType) {
			return toLong(sourceType, targetType, value);
		}
		return null;
	}

	private <T> T toByte(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			long longValue = ((Number) value).longValue();
			if (longValue > Byte.MAX_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too large for " + targetType.getName());
			}
			if (longValue < Byte.MIN_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too small for " + targetType.getName());
			}
			return targetType.cast(new Byte(((Number) value).byteValue()));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(new Byte(booleanValue.byteValue()));
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(Byte.valueOf(stringValue));
		}
	}
	
	private <T> T toShort(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			long longValue = ((Number) value).longValue();
			if (longValue > Short.MAX_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too large for " + targetType.getName());
			}
			if (longValue < Short.MIN_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too small for " + targetType.getName());
			}
			return targetType.cast(new Short(((Number) value).shortValue()));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(new Short(booleanValue.byteValue()));
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(Short.valueOf(stringValue));
		}
	}
	
	private <T> T toInteger(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			long longValue = ((Number) value).longValue();
			if (longValue > Integer.MAX_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too large for " + targetType.getName());
			}
			if (longValue < Integer.MIN_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too small for " + targetType.getName());
			}
			return targetType.cast(new Integer(((Number) value).intValue()));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(new Integer(booleanValue.intValue()));
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(Integer.valueOf(stringValue));
		}
	}
	
	private <T> T toLong(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			return targetType.cast(new Long(((Number) value).longValue()));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(new Long(booleanValue.longValue()));
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(Long.valueOf(stringValue));
		}
	}

	@Override
	protected Class<?> getTargetType() {
		return Number.class;
	}

}
