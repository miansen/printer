package wang.miansen.printer.core.converters;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import wang.miansen.printer.core.util.StringUtils;

/**
 * 数字转换器
 * 
 * @author miansen.wang
 * @date 2020-04-14
 * @since 1.0
 */
public abstract class NumberConverter extends AbstractConverter {
	
	private static final Integer ZERO = new Integer(0);
	 
	private static final Integer ONE  = new Integer(1);
	 
	public NumberConverter() {
		super();
	}

	public NumberConverter(Object defaultValue) {
		super(defaultValue);
	}

	@Override
	protected <T> T convertProcess(Object value, Class<T> targetType) throws ConversionException {
		Class<?> sourceType = value.getClass();
		if (sourceType == targetType) {
			return targetType.cast(value);
		}
		if (Byte.class == targetType) {
			return toByte(sourceType, targetType, value);
		}
		if (Short.class == targetType) {
			return toShort(sourceType, targetType, value);
		}
		if (Integer.class == targetType) {
			return toInteger(sourceType, targetType, value);
		}
		if (Long.class == targetType) {
			return toLong(sourceType, targetType, value);
		}
		if (Float.class == targetType) {
			return toFloat(sourceType, targetType, value);
		}
		if (Double.class == targetType) {
			return toDouble(sourceType, targetType, value);
		}
		if (AtomicInteger.class == targetType) {
			return toAtomicInteger(sourceType, targetType, value);
		}
		if (AtomicLong.class == targetType) {
			return toAtomicLong(sourceType, targetType, value);
		}
		if (BigInteger.class == targetType) {
			return toBigInteger(sourceType, targetType, value);
		}
		if (BigDecimal.class == targetType) {
			return toBigDecimal(sourceType, targetType, value);
		}
		if (Number.class == targetType) {
			return toNumber(sourceType, targetType, value);
		}
		if (Long.class == targetType && value instanceof Date) {
			return targetType.cast(new Long(((Date) value).getTime()));
		}
		if (Long.class == targetType && value instanceof Calendar) {
			return targetType.cast(new Long(((Calendar) value).getTime().getTime()));
		}
		throw new ConversionException("Unsupport conversion [" + sourceType.getName() + "] to [" + targetType.getName() + "]");
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
	
	private <T> T toFloat(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			double doubleValue = ((Number) value).doubleValue();
			if (doubleValue > Float.MAX_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too large for " + targetType.getName());
			}
			if (doubleValue < Float.MIN_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too small for " + targetType.getName());
			}
			return targetType.cast(new Float(((Number) value).floatValue()));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(new Float(booleanValue.floatValue()));
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(Float.valueOf(stringValue));
		}
	}
	
	private <T> T toDouble(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			return targetType.cast(new Double(((Number) value).doubleValue()));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(new Double(booleanValue.doubleValue()));
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(Double.valueOf(stringValue));
		}
	}
	
	private <T> T toAtomicInteger(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			long longValue = ((Number) value).longValue();
			if (longValue > Integer.MAX_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too large for " + targetType.getName());
			}
			if (longValue < Integer.MIN_VALUE) {
				throw new ConversionException(sourceType.getName() + " value '" + value + "' is too small for " + targetType.getName());
			}
			return targetType.cast(new AtomicInteger(((Number) value).intValue()));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(new AtomicInteger(booleanValue.intValue()));
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(new AtomicInteger(Integer.valueOf(stringValue)));
		}
	}

	private <T> T toAtomicLong(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			return targetType.cast(new AtomicLong(((Number) value).longValue()));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(new AtomicLong(booleanValue.longValue()));
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(new AtomicLong(Long.valueOf(stringValue)));
		}
	}
	
	private <T> T toBigInteger(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			return targetType.cast(BigInteger.valueOf(((Number) value).longValue()));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(BigInteger.valueOf(booleanValue.longValue()));
		}else if (value instanceof BigDecimal) {
			return targetType.cast(((BigDecimal)value).toBigInteger());
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(new BigInteger(stringValue));
		}
	}
	
	private <T> T toBigDecimal(Class<?> sourceType, Class<T> targetType, Object value) {
		// 浮点型先转成 String，避免精度问题
		if (value instanceof Float || value instanceof Double) {
			return targetType.cast(new BigDecimal(value.toString()));
		} else if (value instanceof BigInteger) {
			return targetType.cast(new BigDecimal((BigInteger) value));
		} else if (value instanceof Boolean) {
			Integer booleanValue = ((Boolean) value).booleanValue() ? ONE : ZERO;
			return targetType.cast(BigDecimal.valueOf(booleanValue.longValue()));
		}else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			return targetType.cast(new BigDecimal(stringValue));
		}
	}
	
	@SuppressWarnings("unchecked")
	private <T> T toNumber(Class<?> sourceType, Class<T> targetType, Object value) {
		if (value instanceof Number) {
			return targetType.cast(value);
		} else {
			String stringValue = convertToString(value);
			if (StringUtils.isEmpty(stringValue)) {
				return null;
			}
			try {
				return (T) NumberFormat.getInstance().parse(stringValue);
			} catch (ParseException e) {
				throw new ConversionException(e);
			}
		}
	}
	
	@Override
	protected Class<?> getTargetType() {
		return Number.class;
	}

}
