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

@Controller
public class KundenController {

    @Autowired
    Kunde neuKunde;

    @Autowired
    ApplicationCounter myApplicationCounter = new ApplicationCounter();

    @Autowired
    SessionCounter mySessionCounter = new SessionCounter();

    @GetMapping("/register")
    public String register(Model model, @ModelAttribute Kunde kunde) {
        System.out.println(mySessionCounter);
        model.addAttribute("surveys", myApplicationCounter);
        model.addAttribute("kunde", neuKunde);

        return "register";
    }

    @PostMapping("/register")
    public String registerNewCustomer(Model model, @Valid @ModelAttribute("kunde") Kunde kunde, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println(mySessionCounter);
            model.addAttribute("surveys", myApplicationCounter);
            System.out.println("Fehler");
            return "register";
        }
        Karte neueKarte = new Karte();
        double saldoNum = Math.floor(1000 + Math.random() * 9000);
        Random rnd = new Random();
        int accNum = rnd.nextInt(999999999);
        String.format("%06d", accNum);
        Konto konto = new Konto();
        konto.setNummer(accNum);
        konto.setSaldo(saldoNum);
        String pin = String.format("%04d", rnd.nextInt(10000));
        String num = String.format("%08d", rnd.nextInt(50000));
        String cvc = String.format("%03d", rnd.nextInt(50000));
        Integer.parseInt(cvc);
        Karte karte = new Karte();
        karte.setPin(pin);
        karte.setNummer(num);
        karte.setTyp("Master");
        karte.setGueligkeitsdatum(new Date());
        karte.setCvc(Integer.parseInt(cvc));
        neuKunde.setKarte(karte);
        neuKunde.setEmail(kunde.getEmail());
        neuKunde.setKonto(konto);
        neuKunde.setLand(kunde.getLand());
        neuKunde.setNachname(kunde.getNachname());
        neuKunde.setVorname(kunde.getVorname());
        neuKunde.setStrasseNummer(kunde.getStrasseNummer());
        neuKunde.setPlz(kunde.getPlz());
        neuKunde.setTelefonnummer(kunde.getTelefonnummer());
        System.out.println(mySessionCounter);
        model.addAttribute("surveys", myApplicationCounter);
        model.addAttribute("kunde", neuKunde);
        model.addAttribute("karte", neueKarte);
        System.out.println("registerNewCustomer" + " " + neuKunde.toString());
        return "login";
    }
}
