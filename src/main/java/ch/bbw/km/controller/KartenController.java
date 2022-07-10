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

@Controller
public class KartenController {

    String newPin = "";

    @Autowired
    Kunde neuKunde;

    @Autowired
    ApplicationCounter myApplicationCounter = new ApplicationCounter();

    @Autowired
    SessionCounter mySessionCounter = new SessionCounter();

    @GetMapping("/changepin")
    public String newPin(@ModelAttribute Karte karte, Model model) {
        model.addAttribute("karte", karte);
        System.out.println(" get change pin  - kundenkarten nummer " + neuKunde.getKarte().getNummer());
        return "changepin";
    }

    @PostMapping("/changepin")
    public String updatePin(@ModelAttribute Karte karte) {
        System.out.println(" post changepin controller - kundenkarte nummer" + neuKunde.getKarte().getNummer());
        newPin = karte.getPin();
        return "redirect:/confirmpin";
    }

    @GetMapping("/confirmpin")
    public String confirmNewPin(@ModelAttribute Karte karte, Model model) {
        System.out.println("get confirm pin - kundenkarte nummer" + neuKunde.getKarte().getNummer());
        model.addAttribute("karte", karte);
        return "confirmpin";
    }

    @PostMapping("/confirmpin")
    public String confirmPin(@ModelAttribute Karte karte, Model model) {
        System.out.println("put confirminpin, new pin should be " + newPin);
        if (karte.getPin().equals(newPin)) {
            System.out.println("pin confirmed");
            neuKunde.getKarte().setPin(newPin);
            return "redirect:/pinchanged";
        } else {
            System.out.println("pin not confirmed");
            return "redirect:/falsenewpin";
        }
    }

    @GetMapping("/falsenewpin")
    public String falsenewpin(@ModelAttribute Karte karte, Model model) {
        System.out.println("get falsenewpin - kundenkarte nummer" + neuKunde.getKarte().getNummer());
        model.addAttribute("karte", karte);
        return "falsenewpin";
    }

    @GetMapping("/pinchanged")
    public String pinchanged(@ModelAttribute Karte karte, Model model) {
        System.out.println("get pinchanged - kundenkarte nummer" + neuKunde.getKarte().getNummer());
        return "pinchanged";
    }


}
