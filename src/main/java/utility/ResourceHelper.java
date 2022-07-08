package utility;


import org.assertj.core.api.Assertions;

import java.io.File;
import java.io.InputStream;
import java.util.Objects;


/**
 * @author krana
 *
 */
public class ResourceHelper {

	private static ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	public static InputStream getResourcePathInputStream(String resource) {
		return getClassLoader().getResourceAsStream(resource);
	}

	public static File getResourceFile(String resource) {
		try {
			return new File(Objects.requireNonNull(getClassLoader().getResource(resource)).toURI());
		} catch (Exception e) {
			Assertions.fail("Can't get file " + resource);
			return null;
		}
	}

}
