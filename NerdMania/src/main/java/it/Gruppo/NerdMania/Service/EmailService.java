package it.Gruppo.NerdMania.Service;


import it.Gruppo.NerdMania.Modelli.Prodotto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void inviaEmailOrdine(String to, String username, Integer ordineId, List<Prodotto> prodotti) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject("Ordine confermato!");

        // 🔥 COSTRUZIONE HTML
        StringBuilder html = new StringBuilder();

        html.append("<h2>🚀 Ordine confermato!</h2>");
        html.append("<p>Ciao <strong>").append(username).append("</strong>,</p>");
        html.append("<p>Il tuo ordine <strong>#").append(ordineId).append("</strong> è stato creato con successo.</p>");
        html.append("<h3>📦 Prodotti acquistati:</h3>");

        Map<Integer, Integer> quantitaMap = new HashMap<>();
        Map<Integer, Prodotto> prodottoMap = new HashMap<>();

        for (Prodotto p : prodotti) {
            quantitaMap.put(p.getId(), quantitaMap.getOrDefault(p.getId(), 0) + 1);
            prodottoMap.putIfAbsent(p.getId(), p);
        }

        html.append("<ul>");

        for (Integer id : quantitaMap.keySet()) {
            Prodotto p = prodottoMap.get(id);
            int qty = quantitaMap.get(id);

            html.append("<li>")
                    .append("<strong>").append(p.getNome()).append("</strong><br>")
                    .append("Prezzo: €").append(p.getPrezzo()).append("<br>")
                    .append("<span style='color:#ff4d4f;font-weight:bold'>Quantità: ")
                    .append(qty)
                    .append("</span>")
                    .append("</li><br>");
        }

        html.append("</ul>");

        html.append("<br>");
        html.append("<p>Grazie per aver acquistato su <strong>NerdMania</strong> 💛</p>");

        helper.setText(html.toString(), true); // true = HTML

        mailSender.send(message);
    }
}
