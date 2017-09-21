package com.brovada;

import com.brovada.document.Broker;
import com.brovada.document.Draft;
import com.brovada.document.Quote;
import com.brovada.document.User;
import com.brovada.document.config.ComponentConfig;
import com.brovada.document.config.FormConfig;
import com.brovada.document.config.LabelConfig;
import com.brovada.document.config.PanelConfig;
import com.brovada.document.config.TextFieldConfig;
import com.brovada.repository.BrokerRepository;
import com.brovada.repository.DraftRepository;
import com.brovada.repository.FormConfigRepository;
import com.brovada.repository.QuoteRepository;
import com.brovada.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

import javax.inject.Inject;
import java.util.List;


@SpringBootApplication
@EnableCaching
@EnableWebSocketMessageBroker
@ComponentScan("com.brovada")
public class Application implements CommandLineRunner {

	@Inject private QuoteRepository quoteRepository;
	@Inject private BrokerRepository brokerRepository;
    @Inject private FormConfigRepository formConfigRepository;
    @Inject private UserRepository userRepository;
    @Inject private DraftRepository draftRepository;

    public static void main(String[] args) {
        // check application.properties for port.   currently 9090.
		SpringApplication.run(Application.class, args);
	}

    @Override
	public void run(String... args) throws Exception {

        initDb();

        System.out.println("Brokers found with findAll():");
        System.out.println("-------------------------------");
        for (Broker broker : brokerRepository.findAll()) {
            System.out.println(broker);
        }
        System.out.println();
        System.out.println("Forms found with findAll():");
        System.out.println("-------------------------------");
        for (FormConfig form : formConfigRepository.findAll()) {
            System.out.println(form);
        }
        System.out.println();
	}

    private void initDb() {
        quoteRepository.deleteAll();

        quoteRepository.save(new Quote("Alice", "Smith"));
        quoteRepository.save(new Quote("Bob", "Smith"));
        quoteRepository.save(new Quote("Bill", "Jones"));
        quoteRepository.save(new Quote("John", "Doe"));
        quoteRepository.save(new Quote("Sally", "Smith"));
        quoteRepository.save(new Quote("Alice", "Hearth"));

        brokerRepository.deleteAll();
        brokerRepository.save(new Broker("Prince", "Fielder"));
        brokerRepository.save(new Broker("Elvis", "Presley"));
        brokerRepository.save(new Broker("Samuel", "Johnson"));
        brokerRepository.save(new Broker("Betty", "Crocker"));
        brokerRepository.save(new Broker("Patti", "Peppermint"));
        brokerRepository.save(new Broker("Lucy", "Ball"));

        formConfigRepository.deleteAll();

        List<ComponentConfig> children = Lists.newArrayList(
                new LabelConfig("name"),
                new TextFieldConfig("name.first"),
                new PanelConfig().withChildren(
                        Lists.newArrayList(new LabelConfig("subpanel"))
                )
        );

        FormConfig f = new FormConfig()
                .withVersion(1, 0)
                .withChildren(children)
                .withLabel("test form");

        formConfigRepository.save(f);

        userRepository.deleteAll();
        userRepository.save(new User()
                .withEmail("foo@bar.com")
                .withName("John Doe"));

        draftRepository.deleteAll();
        draftRepository.save(new Draft("tom", "smith"));

    }

}
