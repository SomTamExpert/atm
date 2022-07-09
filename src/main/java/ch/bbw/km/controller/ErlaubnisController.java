package ch.bbw.km.controller;

import ch.bbw.km.model.Karte;
import ch.bbw.km.model.Kunde;
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
    Karte kundenkarte;

    String newPin = "";

    @GetMapping(value={"/", "/login"})
    public String login(Model model, @ModelAttribute Karte karte) {
        model.addAttribute("karte", karte);
        return "login";
    }

/*
    @PostMapping("/login")
    public String login(@ModelAttribute Karte karte, @ModelAttribute Kunde kunde, Model model) {
        try {
            kundenkarte = karteRepository.findKarteByNummer(karte.getNummer());
            System.out.println("post start kundenkarte nummer: " + kundenkarte.getNummer());
            if (karte.getNummer().equals(kundenkarte.getNummer())) {
                model.addAttribute("karte", kundenkarte);
                return "redirect:/enterpin";
            }
        } catch (Exception err) {
            model.addAttribute("karte", karte);
            System.out.println(err);
        }
        return "redirect:/falsecardnummber";
    }

    @GetMapping("/falsecardnummber")
    public String falsecardnummber(@ModelAttribute Karte karte, Model model) {
        model.addAttribute("karte", karte);
        return "falsecardnummber";
    }

    @PostMapping("/falsecardnummber")
    public String verifyCardNumber(@ModelAttribute Karte karte, Model model) {

        try {
            kundenkarte = karteRepository.findKarteByNummer(karte.getNummer());
            System.out.println("post falsecardnummber kundenkarte nummer: " + kundenkarte.getNummer());
            if (karte.getNummer().equals(kundenkarte.getNummer())) {
                kundenkarte.setNummer(karte.getNummer());
                model.addAttribute("karte", kundenkarte);
            }
            return "redirect:/enterpin";
        } catch (Exception err) {
            model.addAttribute("karte", karte);
            System.out.println(err);
            return "redirect:/falsecardnummber";
        }
    }

    @GetMapping("/enterpin")
    public String enterpin(@ModelAttribute Karte karte, Model model) {
        model.addAttribute("karte", karte);
        return "enterpin";
    }

    @PostMapping("/enterpin")
    public String verifyCustomer(@ModelAttribute Karte karte, Model model) {
        System.out.println("post enterpin kundenkarte nummer: " + kundenkarte.getNummer());
        try {
            if (karte.getPin().equals(kundenkarte.getPin())) {
                model.addAttribute("karte", kundenkarte);
                System.out.println("enter pin controller - kundenkarten nummer: " + kundenkarte.getNummer());
                return "redirect:/homemenu";
            }

        } catch (Exception err) {
            model.addAttribute("karte", karte);
            System.out.println(err);
        }
        return "redirect:/falsepin";
    }

    @GetMapping("/falsepin")
    public String falsepin(@ModelAttribute Karte karte, Model model) {
        model.addAttribute("karte", karte);
        return "falsepin";
    }

    @PostMapping("/falsepin")
    public String verifyCustomerAgain(@ModelAttribute Karte karte, Model model) {
        try {
            if (karte.getPin().equals(kundenkarte.getPin())) {
                model.addAttribute("karte", kundenkarte);
                System.out.println("enter pin controller - kundenkarten nummer: " + kundenkarte.getNummer());
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
        model.addAttribute("karte", kundenkarte);
        System.out.println("homemenu controller - kundenkarten nummer: " + kundenkarte.getNummer());
        return "homemenu";
    }

    @GetMapping("/changepin")
    public String newPin(@ModelAttribute Karte karte, Model model) {
        model.addAttribute("karte", karte);
        System.out.println(" get change pin  - kundenkarten nummer " + kundenkarte.getNummer());
        return "changepin";
    }

    @PostMapping("/changepin")
    public String updatePin(@ModelAttribute Karte karte, Model model) {
        System.out.println(" post changepin controller - kundenkarte nummer" + kundenkarte.getNummer());
        newPin = karte.getPin();
        model.addAttribute("karte", kundenkarte);
        return "redirect:/confirmpin";
    }

    @GetMapping("/confirmpin")
    public String confirmNewPin(@ModelAttribute Karte karte, Model model) {
        System.out.println("get confirm pin - kundenkarte nummer" + kundenkarte.getNummer());
        model.addAttribute("karte", karte);
        return "confirmpin";
    }

    @PostMapping("/confirmpin")
    public String confirmPin(@ModelAttribute Karte karte, Model model) {
        System.out.println("put confirminpin, new pin should be " + newPin);
        if (karte.getPin().equals(newPin)) {
            System.out.println("pin confirmed");
            Karte updatedKarte = karteRepository.findKarteByNummer(kundenkarte.getNummer());
            updatedKarte.setPin(karte.getPin());
            karteRepository.save(updatedKarte);
            kundenkarte = updatedKarte;
            model.addAttribute("karte", kundenkarte);
            return "redirect:/pinchanged";
        } else {
            System.out.println("pin not confirmed");
            model.addAttribute("karte", karte);
            return "redirect:/falsenewpin";
        }
    }
    @GetMapping("/falsenewpin")
    public String falsenewpin(@ModelAttribute Karte karte, Model model) {
        System.out.println("get falsenewpin - kundenkarte nummer" + kundenkarte.getNummer());
        model.addAttribute("karte", karte);
        return "falsenewpin";
    }
    @GetMapping("/pinchanged")
    public String pinchanged(@ModelAttribute Karte karte, Model model) {
        System.out.println("get pinchanged - kundenkarte nummer" + kundenkarte.getNummer());
        model.addAttribute("karte", kundenkarte);
        return "pinchanged";
    }

*/

}


