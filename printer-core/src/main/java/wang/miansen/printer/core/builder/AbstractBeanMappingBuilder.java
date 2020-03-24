package wang.miansen.printer.core.builder;

import wang.miansen.printer.core.propertydescriptor.PropertyDescriptorFactory;

/**
 * @author miansen.wang
 * @date 2020-03-24
 */
public abstract class AbstractBeanMappingBuilder implements BeanMappingBuilder {

	private final PropertyDescriptorFactory propertyDescriptorFactory;

	public AbstractBeanMappingBuilder(PropertyDescriptorFactory propertyDescriptorFactory) {
		this.propertyDescriptorFactory = propertyDescriptorFactory;
	}
	
}
