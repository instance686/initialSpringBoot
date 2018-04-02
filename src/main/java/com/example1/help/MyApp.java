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
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.example1.help.ctrl.Contact;
import com.example1.help.ctrl.Database;

@SpringBootApplication
@Configuration
//@PropertySource({"classpath:database.properties","classpath:email.properties"})
/*@PropertySources({
		@PropertySource("classpath:database.properties"),
		@PropertySource("classpath:email.properties")
})*/

public class MyApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext ctx=SpringApplication.run(MyApp.class, args);
		Database db=(Database)ctx.getBean(Database.class);
		Contact con=(Contact)ctx.getBean(Contact.class);
		System.out.println("Name:"+db.getName());
		System.out.println("Password"+db.getPassword());
		System.out.println("Email:"+con.getEmail());
		System.out.print("Number:"+con.getNumber());
	}
	
	@Value("${channel.name}")
	public String name;
	@Value("${channel.password}")
	public String password;
	
	@Value("${contact.email}")
	public String email;
	@Value("${contact.number}")
	public String number;
	
	@Bean
	public Contact getDet() {
		Contact con=new Contact();
		con.setEmail(email);
		con.setNumber(number);
		return con;
		}
	
	@Bean
	public Database getDetails() {
		Database db=new Database();
		db.setName(name);
		db.setPassword(password);
		return db;
	}
	
	/*@Bean
	public static PropertySourcesPlaceholderConfigurer property() 
	{
		return new PropertySourcesPlaceholderConfigurer();
		
	}*/

}
