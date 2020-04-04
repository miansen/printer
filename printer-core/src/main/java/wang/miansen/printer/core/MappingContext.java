package wang.miansen.printer.core;

import wang.miansen.printer.core.map.ClassMap;

/**
 * 映射上下文接口
 * <p>在处理 Bean 到 Bean 的映射时，这个接口的实现被传递给映射器 {@link #Mapper}，
 * 映射器将根据此上下文来工作。
 * 
 * @author miansen.wang
 * @date 2020-04-04
 */
public interface MappingContext {
	
	/**
	 * 添加全局的映射配置
	 * 
	 * @param globalConfiguration 全局的映射配置
	 */
	void addGlobalConfiguration(Configuration globalConfiguration);

	/**
	 * 获取全局的映射配置
	 * 
	 * @return 全局的映射配置
	 */
	Configuration getGlobalConfiguration();
	
	/**
	 * 将给定类映射添加到此上下文
	 * 
	 * @param classMap 类映射
	 */
	void addClassMap(ClassMap classMap);
	
	/**
	 * 将给定类映射数组添加到此上下文。使用此方法，可以一次添加多个类映射。
	 * 
	 * @param classMaps 类映射数组
	 */
	void addClassMaps(ClassMap[] classMaps);
	
	/**
	 * 返回指定 ID 的类映射，如果找不到类映射，则返回 <b>null</b>。
	 * 
	 * @param mapId 类映射的 ID
	 * @return 类映射
	 */
	ClassMap getClassMap(String mapId);
	
	/**
	 * 根据来源类型和目标类型返回类映射，如果找不到类映射，则返回 <b>null</b>。
	 * 
	 * @param source 来源类型
	 * @param target 目标类型
	 * @return 类映射
	 */
	ClassMap getClassMap(Class<?> source, Class<?> target);
	
	/**
	 * 删除指定 ID 的类映射
	 * 
	 * @param mapId 类映射的 ID
	 */
	void removeClassMap(String mapId);
	
	/**
	 * 根据来源类型和目标类型删除类映射
	 * 
	 * @param source 来源类型
	 * @param target 目标类型
	 */
	void removeClassMap(Class<?> source, Class<?> target);
	
	/**
	 * 检测此上下文中是否已经包含指定 ID 的类映射。可以使用此方法来防止已存在的类映射被覆盖。
	 * 
	 * @param mapId 类映射的 ID
	 * @return 如果已经添加过了此 ID 的类映射，则返回 {@code true}，否则返回 {@code false}。
	 */
	boolean hasClassMap(String mapId);
	
	/**
	 * 检测此上下文中是否已经包含指定来源类型和目标类型的类映射。可以使用此方法来防止已存在的类映射被覆盖。
	 * 
	 * @param source 来源类型
	 * @param target 目标类型
	 * @return 如果已经添加过了相同类型的类映射，则返回 {@code true}，否则返回 {@code false}。
	 */
	boolean hasClassMap(Class<?> source, Class<?> target);
	
}
