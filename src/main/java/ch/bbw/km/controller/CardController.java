package ch.bbw.km.controller;

import ch.bbw.km.model.ApplicationCounter;
import ch.bbw.km.model.Card;
import ch.bbw.km.model.Client;
import ch.bbw.km.model.SessionCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * CardController handles the card data of the client.
 *
 * @author marco karpf
 * @version 12.07.2022
 */
@Controller
public class CardController {

    String newPin = "";

    @Autowired
    Client newClient;

    @Autowired
    ApplicationCounter applicationCounter = new ApplicationCounter();

    @Autowired
    SessionCounter sessionCounter = new SessionCounter();

    /**
     * gets the change pin page
     *
     * @param card  card is used to read the new pin in form
     * @param model model is used to pass data to the view.
     * @returns change pin html
     */
    @GetMapping("/changepin")
    public String newPin(@ModelAttribute Card card, Model model) {
        model.addAttribute("card", card);
        System.out.println(sessionCounter);
        model.addAttribute("surveys", applicationCounter);
        System.out.println(" get change pin  - kundencardn nummer " + newClient.getCard().getNumber());
        return "changepin";
    }

    /**
     * handles the change of the pin of a client.
     *
     * @param card card is used to read the new pin in form
     * @returns the confim pin page
     */
    @PostMapping("/changepin")
    public String updatePin(@ModelAttribute Card card) {
        System.out.println(" post changepin controller - kundencard nummer" + newClient.getCard().getNumber());
        newPin = card.getPin();
        return "redirect:/confirmpin";
    }

    /**
     * gets the confirm pin page
     *
     * @param card  card is used to read the new pin in form
     * @param model model is used to pass data to the view.
     * @returns confirm pin html
     */
    @GetMapping("/confirmpin")
    public String confirmNewPin(@ModelAttribute Card card, Model model) {
        System.out.println("get confirm pin - kundencard nummer" + newClient.getCard().getNumber());
        model.addAttribute("card", card);
        System.out.println(sessionCounter);
        model.addAttribute("surveys", applicationCounter);
        return "confirmpin";
    }

    /**
     * handles the confirm of the pin of a client.
     *
     * @param card  card is used to read the new confirming pin in form
     * @param model model is used to pass data to the view.
     * @return either the change pin page or the false new pin page
     */
    @PostMapping("/confirmpin")
    public String confirmPin(@ModelAttribute Card card, Model model) {
        System.out.println("put confirminpin, new pin should be " + newPin);
        if (card.getPin().equals(newPin)) {
            System.out.println("pin confirmed");
            newClient.getCard().setPin(newPin);
            return "redirect:/pinchanged";
        } else {
            System.out.println("pin not confirmed");
            return "redirect:/falsenewpin";
        }
    }

    /**
     * gets the false new pin page
     *
     * @param card  card is used to read the new pin in form
     * @param model model is used to pass data to the view.
     * @returns false new pin html
     */
    @GetMapping("/falsenewpin")
    public String falsenewpin(@ModelAttribute Card card, Model model) {
        System.out.println("get falsenewpin - kundencard nummer" + newClient.getCard().getNumber());
        model.addAttribute("card", card);
        System.out.println(sessionCounter);
        model.addAttribute("surveys", applicationCounter);
        return "falsenewpin";
    }

    /**
     * gets the pin changed page
     *
     * @param card is used to print out the new pin
     * @return pin changed html
     */
    @GetMapping("/pinchanged")
    public String pinchanged(@ModelAttribute Card card, Model model) {
        System.out.println("get pinchanged - kundencard nummer" + newClient.getCard().getNumber());
        System.out.println(sessionCounter);
        model.addAttribute("surveys", applicationCounter);
        return "pinchanged";
    }


}
