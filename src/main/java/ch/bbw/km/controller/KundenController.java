package ch.bbw.km.controller;


import ch.bbw.km.model.Karte;
import ch.bbw.km.model.Konto;
import ch.bbw.km.model.Kunde;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Controller
public class KundenController {

    @Autowired
    Kunde neuKunde;

    @GetMapping("/register")
    public String register(Model model, @ModelAttribute Kunde kunde) {
        model.addAttribute("kunde", neuKunde);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewCustomer(Model model, @ModelAttribute Kunde kunde) {
       double saldoNum = Math.floor(1000 + Math.random() * 9000);
        Random rnd = new Random();
        int accNum = rnd.nextInt(999999999);
        String.format("%06d", accNum);
        Konto konto = new Konto("Sparkonto",accNum, saldoNum, new ArrayList<>() );
        String pin = String.format("%04d", rnd.nextInt(10000));
        String num = String.format("%08d", rnd.nextInt(50000));
        String cvc = String.format("%03d", rnd.nextInt(50000));
        Integer.parseInt(cvc);
        Karte karte = new Karte(pin,num,"Master",new Date(), Integer.parseInt(cvc));
        neuKunde.setAlter(kunde.getAlter());
        neuKunde.setKarte(karte);
        neuKunde.setEmail(kunde.getEmail());
        neuKunde.setKonto(konto);
        neuKunde.setLand(kunde.getLand());
        neuKunde.setNachname(kunde.getNachname());
        neuKunde.setVorname(kunde.getVorname());
        neuKunde.setStrasseNummer(kunde.getStrasseNummer());
        neuKunde.setPlz(kunde.getPlz());
        neuKunde.setTelefonnummer(kunde.getTelefonnummer());
        model.addAttribute("kunde", neuKunde);
        System.out.println("registerNewCustomer" +" "+ neuKunde.toString());
        return "login";
    }
}
