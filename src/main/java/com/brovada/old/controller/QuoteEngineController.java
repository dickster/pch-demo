package com.brovada.old.controller;

import com.brovada.old.document.Quote;
import com.brovada.old.document.QuoteResult;
import com.brovada.old.repository.QuoteRepository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;


@RestController
@RequestMapping(value = "/quote/calculate")
public class QuoteEngineController {

    private @Inject QuoteRepository quoteRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public QuoteResult add(@RequestBody QuoteData quote) {
        System.out.print("calculating quote for " + quote);
        double total = Math.abs((8765+quote.getCreditCard().hashCode()+quote.getCreditCardType().hashCode()+quote.getSecurityCode().hashCode())*123)%1000;
        QuoteResult result = QuoteResult.success(total);
        try {                    // just for debugging reasons...
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    private double calculate(Quote quote) {
        return Math.random() * 3000 + 150;
    }

    // TODO : add a method that will calculate quote given QuoteId as parameter.  a headless service. doesn't need a client to POST.
    //   can CURL quotes.

}





