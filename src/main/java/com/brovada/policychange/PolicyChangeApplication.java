package com.brovada.policychange;

import com.brovada.policychange.model.AutoPolicy;
import com.brovada.policychange.model.Insured;
import com.brovada.policychange.repository.AutoPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

        AutoPolicy policy1 = new AutoPolicy();
        policy1.setPolicyNumber("a1");
        Insured insured1 = new Insured("first1", "last1");
        policy1.getInsureds().add(insured1);
        autoPolicyRepository.save(policy1);

        AutoPolicy policy2 = new AutoPolicy();
        policy2.setPolicyNumber("a2");
        Insured insured2 = new Insured("first2", "last2");
        policy2.getInsureds().add(insured2);
        autoPolicyRepository.save(policy2);

        AutoPolicy policy3 = new AutoPolicy();
        policy3.setPolicyNumber("a3");
        Insured insured3 = new Insured("first3", "last2");
        policy3.getInsureds().add(insured3);
        autoPolicyRepository.save(policy3);

    }
}
