package my.jdbc.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;

/**
 * Created by iuliana.cosmina on 4/16/17.
 */
@Configuration
@PropertySource("classpath:db/jdbc.properties")
@ComponentScan(basePackages = "my.jdbc")
public class AppConfig {

	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	@Value("${driverClassName}")
	private String driverClassName;
	@Value("${url}")
	private String url;
	@Value("${db_username}")
	private String dbusername;
	@Value("${db_password}")
	private String dbpassword;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		try {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(dbusername);
			dataSource.setPassword(dbpassword);
			return dataSource;
		} catch (Exception e) {
			logger.error("DBCP DataSource bean cannot be created!", e);
			return null;
		}
	}
}
