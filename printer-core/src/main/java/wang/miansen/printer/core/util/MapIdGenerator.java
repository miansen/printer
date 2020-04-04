package wang.miansen.printer.core.util;

import java.util.Arrays;

/**
 * @author miansen.wang
 * @date 2020-04-04
 */
public final class MapIdGenerator {

	 public static String generator(Class<?> source, Class<?> target) {
		 return String.valueOf(new Key(new Class<?>[] {source, target}).hashCode());
	 }
	 
	 private static final class Key {

		 private final int hash;
		 
		 Key(Class<?>[] classes) {
			 hash = Arrays.hashCode(classes);
		 }

		@Override
		public int hashCode() {
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) return true;
			if (obj == null) return false;
			if (getClass() != obj.getClass()) return false;
			Key other = (Key) obj;
			if (hash != other.hash) return false;
			return true;
		}
	 }
	 
	 public static void main(String[] args) {
		 String generator = generator(CollectionUtils.class, MappingUtils.class);
		 System.out.println(generator);
		 String generator2 = generator(CollectionUtils.class, MappingUtils.class);
		 System.out.println(generator2);
	}
}
