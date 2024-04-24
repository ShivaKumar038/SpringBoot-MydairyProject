package com.msd.springboot.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
//	@Override
//	public void addResourceHandlers (ResourceHandlerRegistry registry) {
//	Path docDir = Paths.get("./docs");
//	String docPath = docDir.toFile().getAbsolutePath();
//	registry.addResourceHandler("/docs/**").addResourceLocations("file:/" + docPath + "/");
//	exposeDirectory("../category-images", registry);
//	exposeDirectory("../product-images", registry);
//	exposeDirectory("../site-logo", registry);
//	}
//	
//	private void exposeDirectory (String dirName, ResourceHandlerRegistry registry) {
//	Path uploadDir = Paths.get(dirName);
//	String uploadPath = uploadDir.toFile().getAbsolutePath();
//	if (dirName.startsWith("../")) dirName = dirName.replace("../", "");
//	registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/"+ uploadPath + "/");
//	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    exposeDirectory("D:/vehicleReports/assets/", registry);
	}

	private void exposeDirectory(String dirName, ResourceHandlerRegistry registry) {
	    Path uploadDir = Paths.get(dirName);
	    String uploadPath = uploadDir.toFile().getAbsolutePath();
	    if (dirName.startsWith("../")) {
	        dirName = dirName.replace("../", "");
	    }
	    registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file:/" + uploadPath + "/");
	}
	

}
