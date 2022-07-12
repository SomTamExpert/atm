package ch.bbw.km.controller;


import ch.bbw.km.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.Random;

/**
 * ClientController registers a new client and creates a new card and an account for the client.
 *
 * @author marco karpf
 * @version 06.07.2022
 */

@Controller
public class ClientController {

    @Autowired
    Client newClient;

    @Autowired
    ApplicationCounter applicationCounter = new ApplicationCounter();

    @Autowired
    SessionCounter sessionCounter = new SessionCounter();

    /**
     * gets the registration form
     *
     * @param model  model is used to pass data to the view.
     * @param client client is used to reigster a new client.
     * @return registration form
     */
    @GetMapping("/register")
    public String register(Model model, @ModelAttribute Client client) {
        System.out.println(sessionCounter);
        model.addAttribute("surveys", applicationCounter);
        model.addAttribute("client", newClient);

        return "register";
    }

    /**
     * handles the registration of a new client.
     *
     * @param model         model is used to pass data to the view.
     * @param client        client is used to reigster a new client.
     * @param bindingResult bindingResult is used to check if the registration is valid.
     * @return registration form or login page.
     */
    @PostMapping("/register")
    public String registerNewCustomer(Model model, @Valid @ModelAttribute("client") Client client, BindingResult bindingResult) {

        // check if the registration is valid
        if (bindingResult.hasErrors()) {
            System.out.println(sessionCounter);
            model.addAttribute("surveys", applicationCounter);
            return "register";
        }
        // create a new account for the client
        double balance = Math.floor(1000 + Math.random() * 9000);
        Random randomNum = new Random();
        int accNum = randomNum.nextInt(999999999);
        String.format("%06d", accNum);
        Account account = new Account();
        account.setNumber(accNum);
        account.setBalance(balance);

        // creates a new  card for the client
        String pin = String.format("%04d", randomNum.nextInt(10000));
        String num = String.format("%08d", randomNum.nextInt(50000));
        String cvc = String.format("%03d", randomNum.nextInt(50000));
        Integer.parseInt(cvc);
        Card newCard = new Card();
        newCard.setPin(pin);
        newCard.setNumber(num);
        newCard.setTyp("Master");
        newCard.setValidUntil(new Date());
        newCard.setCvc(Integer.parseInt(cvc));

        //sets the card and account to the client
        newClient.setCard(newCard);
        newClient.setEmail(client.getEmail());
        newClient.setAccount(account);
        newClient.setCountry(client.getCountry());
        newClient.setLastname(client.getLastname());
        newClient.setFirstname(client.getFirstname());
        newClient.setStreetNr(client.getStreetNr());
        newClient.setZipCode(client.getZipCode());
        newClient.setPhoneNumber(client.getPhoneNumber());
        System.out.println(sessionCounter);

        //add client, applicationCounter as  model attribute
        model.addAttribute("surveys", applicationCounter);
        model.addAttribute("client", newClient);
        Card card = new Card();
        model.addAttribute("card", card);
        System.out.println("registerNewCustomer" + " " + newClient.toString());
        return "login";
    }
}
