package com.example1.help;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.example1.help.ctrl.Database;

@SpringBootApplication
@Configuration
@PropertySource("classpath:database.properties")
public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext ctx=SpringApplication.run(MyApp.class, args);
		Database db=(Database)ctx.getBean(Database.class);
		System.out.println("Name:"+db.getName());
		System.out.println("Password"+db.getPassword());
	}
	
	@Value("${channel.name}")
	public String name;
	@Value("${channel.password}")
	public String password;
	
	@Bean
	public Database getDetails() {
		Database db=new Database();
		db.setName(name);
		db.setPassword(password);
		return db;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer property() 
	{
		return new PropertySourcesPlaceholderConfigurer();
		
	}

}
