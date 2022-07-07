package ch.bbw.km.controller;

import ch.bbw.km.model.Karte;
import ch.bbw.km.model.Konto;
import ch.bbw.km.model.Kunde;
import ch.bbw.km.repository.KarteRepository;
import ch.bbw.km.repository.KontoRepository;
import ch.bbw.km.repository.KundeRepository;
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
    KarteRepository karteRepository;
    @Autowired
    KundeRepository kundeRepository;
    @Autowired
    KontoRepository kontoRepository;
    @Autowired
    Karte karte = new Karte();

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("karte", karte);
        return "start";
    }
    @PostMapping("/start")
    public String start(@ModelAttribute Karte karte, Model model) {
        karte = karteRepository.findKarteByNummer(karte.getNummer());
        model.addAttribute("karte", karte);
        return "enterpin";
    }
    @PostMapping("/enterpin")
    public String verifyCustomer(@ModelAttribute Karte karte, @ModelAttribute Kunde kunde,  Model model) {
        System.out.println("karten nummer" + karte.getNummer());
        Karte card = karteRepository.findKarteByNummer(karte.getNummer());
        System.out.println("card number" + card.getNummer());
//        if (karte.getPin() == card.getPin()) {
//            model.addAttribute("karte", karte);
//            Konto konto = kontoRepository.findKontoByKarte(karte);
//            model.addAttribute("kunde", konto.getKunde());
//            return "homemenu";
//        } else {
//            model.addAttribute("karte", karte);
//            return "falsepin";
//        }
        return "homemenu";
    }




}


