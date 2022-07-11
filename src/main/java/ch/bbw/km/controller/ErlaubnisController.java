package ch.bbw.km.controller;

import ch.bbw.km.model.ApplicationCounter;
import ch.bbw.km.model.Karte;
import ch.bbw.km.model.Kunde;
import ch.bbw.km.model.SessionCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * ErlaubnisController liest die Kartedaten des Kunden aus
 *
 * @author marco karpf
 * @version 06.07.2022
 */

@Controller
public class ErlaubnisController {

    @Autowired
    Kunde neuKunde;

    @Autowired
    ApplicationCounter myApplicationCounter = new ApplicationCounter();

    @Autowired
    SessionCounter mySessionCounter = new SessionCounter();

    @GetMapping(value = {"/", "/index", "/login"})
    public String login(Model model, @ModelAttribute Karte karte) {
        System.out.println(mySessionCounter);
        model.addAttribute("surveys", myApplicationCounter);
        model.addAttribute("karte", karte);
        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Karte karte, Model model) {
        try {
            System.out.println("post start kundenkarte nummer: " + neuKunde.getKarte().getNummer());
            if (karte.getNummer().equals(neuKunde.getKarte().getNummer())) {
                return "redirect:/enterpin";
            }
        } catch (Exception err) {
            System.out.println(err);
        }
        return "redirect:/falsecardnummber";
    }

    @GetMapping("/falsecardnummber")
    public String falsecardnummber(@ModelAttribute Karte karte, Model model) {
        System.out.println(mySessionCounter);
        model.addAttribute("surveys", myApplicationCounter);
        model.addAttribute("karte", karte);
        return "falsecardnummber";
    }

    @GetMapping("/enterpin")
    public String enterpin(@ModelAttribute Karte karte, Model model) {
        model.addAttribute("karte", karte);
        return "enterpin";
    }

    @PostMapping("/enterpin")
    public String verifyCustomer(@ModelAttribute Karte karte, Model model) {
        System.out.println("post enterpin kundenkarte nummer: " + neuKunde.getKarte().getNummer());
        try {
            if (karte.getPin().equals(neuKunde.getKarte().getPin())) {
                model.addAttribute("karte", neuKunde.getKarte());
                System.out.println("enter pin controller - kundenkarten nummer: " + neuKunde.getKarte().getNummer());
                return "redirect:/homemenu";
            }

        } catch (Exception err) {
            model.addAttribute("karte", karte);
            System.out.println(err);
        }
        return "redirect:/falsepin";
    }

    @GetMapping("/homemenu")
    public String homemenu(@ModelAttribute Karte karte, Model model) {
        System.out.println(mySessionCounter);
        model.addAttribute("surveys", myApplicationCounter);
        model.addAttribute("kunde", neuKunde);
        return "homemenu";
    }

    @PostMapping("/falsecardnummber")
    public String verifyCardNumber(@ModelAttribute Karte karte, Model model) {

        try {
            System.out.println("post falsecardnummber kundenkarte nummer: " + neuKunde.getKarte().getNummer());
            if (karte.getNummer().equals(neuKunde.getKarte().getNummer())) {
                return "redirect:/enterpin";
            }
        } catch (Exception err) {
            model.addAttribute("karte", karte);
            System.out.println(mySessionCounter);
            model.addAttribute("surveys", myApplicationCounter);
            System.out.println(err);
        }
        return "redirect:/falsecardnummber";
    }

    @GetMapping("/falsepin")
    public String falsepin(@ModelAttribute Karte karte, Model model) {
        model.addAttribute("karte", karte);
        return "falsepin";
    }

    @PostMapping("/falsepin")
    public String verifyCustomerAgain(@ModelAttribute Karte karte) {
        try {
            if (karte.getPin().equals(neuKunde.getKarte().getPin())) {
                System.out.println("enter pin controller - kundenkarten nummer: " + neuKunde.getKarte().getNummer());
                return "redirect:/homemenu";
            }
        } catch (Exception err) {
            System.out.println(err);
        }
        return "redirect:/falsepin";
    }

}


