package ch.bbw.km.controller;

import ch.bbw.km.model.Karte;
import ch.bbw.km.repository.KarteRepository;
import ch.bbw.km.repository.KontoRepository;
import ch.bbw.km.repository.KundeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Optional;

@Controller
public class KartenController {

    @Autowired
    KarteRepository karteRepository;
    @Autowired
    Karte kundenkarte;

    int newPin = 0;

//    @GetMapping("/changepin")
//    public String newPin(@ModelAttribute Karte karte, Model model) {
//        System.out.println("updating card" + kundenkarte.toString());
//        model.addAttribute("karte", karte);
//        System.out.println(" get change pin  - kundenkarten nummer " + kundenkarte.getNummer());
//        return "changepin";
//    }
//
//    @PostMapping("/changepin")
//    public String updatePin(@ModelAttribute Karte karte, Model model) {
//        System.out.println(" post changepin controller - kundenkarte" + kundenkarte.toString());
//        newPin = karte.getPin();
//        model.addAttribute("karte", kundenkarte);
//        return "redirect:/confirmpin";
//    }
//
//    @GetMapping("/confirmpin")
//    public String confirmNewPin(@ModelAttribute Karte karte, Model model) {
//        System.out.println("get confirm pin - kundenkarte" + kundenkarte.toString());
//        model.addAttribute("karte", karte);
//        return "confirmpin";
//    }
//
//    @PutMapping("/confirmpin")
//    public String confirmPin(@ModelAttribute Karte karte, Model model) {
//        System.out.println("put confirminpin, new pin should be " + newPin);
//        if (karte.getPin() == newPin) {
//            System.out.println("pin confirmed");
//            Karte updatedKarte = karteRepository.findKarteByNummer(kundenkarte.getNummer());
//            updatedKarte.setPin(karte.getPin());
//            karteRepository.save(updatedKarte);
//            kundenkarte = updatedKarte;
//            model.addAttribute("karte", kundenkarte);
//            return "redirect:/pinchanged";
//        } else {
//            System.out.println("pin not confirmed");
//            model.addAttribute("karte", karte);
//            return "redirect:/falsenewpin";
//        }
//    }
//    @GetMapping("/falsenewpin")
//    public String falsenewpin(@ModelAttribute Karte karte, Model model) {
//        System.out.println("get falsenewpin - kundenkarte" + kundenkarte.toString());
//        model.addAttribute("karte", karte);
//        return "falsenewpin";
//    }
//    @GetMapping("/pinchanged")
//    public String pinchanged(@ModelAttribute Karte karte, Model model) {
//        System.out.println("get pinchanged - kundenkarte" + kundenkarte.toString());
//        model.addAttribute("karte", kundenkarte);
//        return "pinchanged";
//    }
}
