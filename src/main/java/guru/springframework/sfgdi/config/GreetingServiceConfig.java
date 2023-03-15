package guru.springframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetSeviceFactory;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springframework.sfgdi.services.*;
import org.springframework.context.annotation.*;

@ImportResource("classpath:sfgi-config.xml")
@Configuration
public class GreetingServiceConfig {

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
