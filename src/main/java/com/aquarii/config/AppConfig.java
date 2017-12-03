package com.aquarii.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.aquarii.repository.CustomerRepository;
import com.aquarii.repository.HibernateCustomerRepositoryImpl;
import com.aquarii.service.CustomerService;
import com.aquarii.service.CustomerServiceImpl;

@Configuration
@ComponentScan({"com.aquarii"})//for Annotation:Service,Repository,Component
@PropertySource("app.properties")
public class AppConfig {
	
	@Bean(name="customerService1")
	//@Scope("singleton")//One Bean One Container One Instance
	@Scope("prototype")//One Bean One Container Multiple Instance
	public CustomerService getCustomerServiceBean() {
		
		
/*		//--JavaConfigSetter Injection:: Disable @Annotation on Setter Method while Using This
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl();
		customerServiceImpl.setCustomerRepository(getCustomerRepositoryBean());
		//--End of Setter Injection
*/		
		//OR
		
		//--JavaConfigConstructorInjection :: Disable @Annotation on Constructor method while Using This
		CustomerServiceImpl customerServiceImpl = new CustomerServiceImpl(getCustomerRepositoryBean());
		//--End //--ConstructorInjection
		
		//OR
		
//		//--JavaConfigNoInjection
//		CustomerServiceImpl customerServiceImpl= new CustomerServiceImpl();
//		//--END
		
		
		return customerServiceImpl;
	}
	
	
	/*
	 * Enable this bean If you are injecting field of CustomerServiceImpl using JavaConfigConstructor-arg or JavaConfigSetter
	 */
	@Bean(name="customerRepository")
	//@Scope("prototype")
	public CustomerRepository getCustomerRepositoryBean() {
		return new HibernateCustomerRepositoryImpl();
	}
	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	

}
