package com.brovada.policychange;

import com.brovada.policychange.model.AutoPolicy;
import com.brovada.policychange.repository.AutoPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

@SpringBootApplication
public class PolicyChangeApplication implements CommandLineRunner {

    @Autowired
    private AutoPolicyRepository autoPolicyRepository;

    public static void main(String[] args) {
        SpringApplication.run(PolicyChangeApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        autoPolicyRepository.deleteAll();

        JAXBContext context = JAXBContext.newInstance(AutoPolicy.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputStream fis;
        for (int i = 1; i < 4; i++) {
            fis = this.getClass().getResourceAsStream("/samples/sample_auto_policy_" + i + ".xml");
            AutoPolicy policy = (AutoPolicy) unmarshaller.unmarshal(fis);
            autoPolicyRepository.save(policy);
        }
    }
}
