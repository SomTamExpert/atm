package ch.bbw.km.controller;

import ch.bbw.km.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * PermissionController liest die Kartedaten des Kunden aus
 *
 * @author marco karpf
 * @version 06.07.2022
 */

@Controller
public class PermissionController {

    @Autowired
    Client newClient;

    @Autowired
    ApplicationCounter applicationCounter = new ApplicationCounter();

    @Autowired
    SessionCounter sessionCounter = new SessionCounter();

    @Autowired
    Login login;

    /**
     * gets the index html page
     * @param model model is used to pass data to the view.
     * @param card card is used to read the card number in form
     * @returns index html
     */
    @GetMapping(value = {"/", "/index", "/login"})
    public String login(Model model, @ModelAttribute Card card) {
        System.out.println(sessionCounter);
        model.addAttribute("surveys", applicationCounter);
        model.addAttribute("card", card);
        return "index";
    }

    /**
     * handles the login of a new client.
     * @param card card is used to read the card number in form
     * @param model model is used to pass data to the view.
     * @returs enter pin  or false carnd number page
     */
    @PostMapping("/login")
    public String login(@ModelAttribute Card card, Model model) {
        try {
            System.out.println("post start clientncard nummer: " + newClient.getCard().getNumber());
            if (card.getNumber().equals(newClient.getCard().getNumber())) {
                return "redirect:/enterpin";
            }
        } catch (Exception err) {
            System.out.println(err);
        }
        return "redirect:/falsecardnummber";
    }

    /**
     * gets the false card number page
     * @param card card is used to read the card number in form
     * @param model model is used to pass data to the view.
     * @returns false card number page
     */
    @GetMapping("/falsecardnummber")
    public String falsecardnummber(@ModelAttribute Card card, Model model) {
        System.out.println(sessionCounter);
        model.addAttribute("surveys", applicationCounter);
        model.addAttribute("card", card);
        model.addAttribute("attempts", login.getAttempts());
        System.out.println("attempts: " + login.getAttempts());
        return "falsecardnummber";
    }

    /**
     * gets the enter pin page
     * @param card card is used to read the pin number in form
     * @param model model is used to pass data to the view.
     * @returns enter pin page
     */
    @GetMapping("/enterpin")
    public String enterpin(@ModelAttribute Card card, Model model) {
        model.addAttribute("card", card);
        return "enterpin";
    }

    /**
     * cheks the pin number of the client is correct and redirects to the home menu page.
     * @param card card is used to read the pin number in form
     * @param model model is used to pass data to the view.
     * @returns either home menu page or false pin page
     */
    @PostMapping("/enterpin")
    public String verifyCustomer(@ModelAttribute Card card, Model model) {
        System.out.println("post enterpin clientncard nummer: " + newClient.getCard().getNumber());
        try {
            if (card.getPin().equals(newClient.getCard().getPin())) {
                model.addAttribute("card", newClient.getCard());
                System.out.println("enter pin controller - clientncardn nummer: " + newClient.getCard().getNumber());
                return "redirect:/homemenu";
            }

        } catch (Exception err) {
            model.addAttribute("card", card);
            System.out.println(err);
        }
        return "redirect:/falsepin";
    }

    /**
     * gets the home menu page
     * @param model model is used to pass data to the view.
     * @return home menu page
     */
    @GetMapping("/homemenu")
    public String homemenu(Model model) {
        System.out.println(sessionCounter);
        model.addAttribute("surveys", applicationCounter);
        model.addAttribute("client", newClient);
        return "homemenu";
    }

    /**
     * cheks the pin number of the client is correct and redirects to the home menu page.
     * @param card card is used to read the pin number in form
     * @param model model is used to pass data to the view.
     * @returns either home menu page or false pin page
     */
    @PostMapping("/falsecardnummber")
    public String verifyCardNumber(@ModelAttribute Card card, Model model) {
        try {
            System.out.println("post falsecardnummber clientncard nummer: " + newClient.getCard().getNumber());
            if (card.getNumber().equals(newClient.getCard().getNumber())) {
                return "redirect:/enterpin";
            }

        } catch (Exception err) {
            model.addAttribute("card", card);
            System.out.println(sessionCounter);
            model.addAttribute("surveys", applicationCounter);
            System.out.println(err);
        }
        return "redirect:/falsecardnummber";
    }

    /**
     * gets the false pin page
     * @param card card is used to read the pin number in form
     * @param model model is used to pass data to the view.
     * @returns false pin page and blocked if client enters wrong pin at least 3 times
     */
    @GetMapping("/falsepin")
    public String falsepin(@ModelAttribute Card card, Model model) {
        login.increaseAttempts();
        if (login.getAttempts() >= 3) {
            return "blocked";
        }
        model.addAttribute("card", card);
        model.addAttribute("login", login);
        System.out.println(" remaining attempts: " + login.getAttempts());
        return "falsepin";
    }

    /**
     * cheks the pin number of the client is correct and redirects to the home menu page.
     * @param card card is used to read the pin number in form
     * @returns either home menu page or false pin page
     */
    @PostMapping("/falsepin")
    public String verifyCustomerAgain(@ModelAttribute Card card) {
        try {
            if (card.getPin().equals(newClient.getCard().getPin())) {
                System.out.println("enter pin controller - clientncardn nummer: " + newClient.getCard().getNumber());
                return "redirect:/homemenu";
            }
        } catch (Exception err) {
            System.out.println(err);
        }
        return "redirect:/falsepin";
    }

}


