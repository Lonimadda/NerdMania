package it.Gruppo.NerdMania.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void inviaEmailOrdine(String to, String username, Integer ordineId) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Ordine confermato!");
        message.setText("Ciao " + username + ",\n\n" +
                "Il tuo ordine con ID " + ordineId + " è stato creato con successo!\n\n" +
                "Grazie per aver acquistato su NerdMania 🚀");

        mailSender.send(message);
    }
}
