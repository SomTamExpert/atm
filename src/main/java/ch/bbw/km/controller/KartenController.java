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

@Controller
public class KartenController {
    @Autowired
    KarteRepository karteRepository;
    @Autowired
    Karte karte = new Karte();

    @GetMapping("/changepin")
    public String newPin(@ModelAttribute Karte karte, Model model) {
        karte = karteRepository.findKarteByNummer(karte.getNummer());
        model.addAttribute("karte", karte);
        return "changepin";
    }
    @PostMapping("/changepin")
    public String changePin(@ModelAttribute Karte karte, Model model) {
        karte = karteRepository.findKarteByNummer(karte.getNummer());
        model.addAttribute("karte", karte);
        return "confirmpin";
    }
    @PostMapping("/confirmpin")
    public String confirmPin(@ModelAttribute Karte karte, Model model) {
        karte = karteRepository.findKarteByNummer(karte.getNummer());
        model.addAttribute("karte", karte);
        return "pinchanged";
    }
}
