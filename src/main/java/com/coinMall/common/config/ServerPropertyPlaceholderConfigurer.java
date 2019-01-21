package com.coinMall.common.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;

/**   
* @author xiao.huiyu  
* @date 2018年10月12日  新建  
*/
public class ServerPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{
	private Logger logger = Logger.getLogger(ServerPropertyPlaceholderConfigurer.class);
	public static String version = "DEV";
	private Resource[] locations;
	private PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();
	@Override
	protected void loadProperties(Properties props) throws IOException {
		logger.info("当前运行环境为："+version);
		for (Resource location : locations) {
			InputStream is = null;
			try {
				String filename = location.getFile().getParent();
				if(filename.endsWith(version)) {
					logger.info("开始加载 "+version+"/"+location.getFilename());
					is = location.getInputStream();
					propertiesPersister.load(props,is);
				}
			} catch (Exception e) {
				logger.error("",e);
			}
		}
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public void setLocations(Resource[] locations) {
		this.locations = locations;
	}
}
