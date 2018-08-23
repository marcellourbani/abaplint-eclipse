package org.abaplint.eclipse.builder;

import java.io.File;

import org.junit.jupiter.api.Test;

class AbaplintBuilderTest {

	@Test
	void testGetBundleLocation() {
		String separator = File.separator;
		AbaplintBuilder cut = new AbaplintBuilder();
		String bundleLocation = cut.getBundleLocation();
		String regex = separator.equals("/")?"/":"\\\\";
		String[] parts = bundleLocation.split(regex);
		
		assert parts[parts.length-1].equals("bundle.js");
		if(separator.equals("/")){
			assert parts[0].equals("");
		}else {
			assert parts[0].matches("[a-zA-Z]:");// no UNC paths, for now
		}
		
	}

}
