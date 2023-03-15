package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetSeviceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgi-config.xml")
@Configuration
public class GreetingServiceConfig {

    /**
     * Bean construction from external properties
     * @param username
     * @param password
     * @param jdbcURL
     * @return fakedatasourece
     */
    @Bean
    FakeDataSource fakeDataSource (@Value("${guru.username}") String username,
                                   @Value("${guru.password}")String password,
                                   @Value("${guru.jdbcURL}") String jdbcURL){
        FakeDataSource fakeDataSource= new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcURL(jdbcURL);

        return fakeDataSource;
    }

    @Bean
    PetSeviceFactory petServiceFactory (){
        return new PetSeviceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService (PetSeviceFactory petSeviceFactory){
        return petSeviceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService (PetSeviceFactory petSeviceFactory){
        return petSeviceFactory.getPetService("cat");
    }



    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18NSpanishService i18NSpanishService (){
        return new I18NSpanishService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService (){
        return new PrimaryGreetingService();
    }

    //@Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
