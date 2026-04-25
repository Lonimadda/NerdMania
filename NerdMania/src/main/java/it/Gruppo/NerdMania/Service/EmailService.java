package it.Gruppo.NerdMania.Service;


import it.Gruppo.NerdMania.Modelli.Prodotto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

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
        html.append("<ul>");

        for (Prodotto p : prodotti) {
            html.append("<li>")
                    .append("<strong>").append(p.getNome()).append("</strong>")
                    .append(" - €").append(p.getPrezzo())
                    .append("</li>");
        }

        html.append("</ul>");

        html.append("<br>");
        html.append("<p>Grazie per aver acquistato su <strong>NerdMania</strong> 💛</p>");

        helper.setText(html.toString(), true); // true = HTML

        mailSender.send(message);
    }
}
