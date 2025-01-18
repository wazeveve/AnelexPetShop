package bcc.anelex.Anelex.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    public void agendaEmailTexto(String destinatario, String assunto, String mensagem, LocalDateTime horarioEnvio){
        long delay = calcularDelay(horarioEnvio);

        scheduledExecutorService.schedule(() -> {
            try{
                SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
                simpleMailMessage.setFrom(remetente);
                simpleMailMessage.setTo(destinatario);
                simpleMailMessage.setSubject(assunto);
                simpleMailMessage.setText(mensagem);

                javaMailSender.send(simpleMailMessage);
                return "Email enviado!";
            } catch (Exception e){
                return "Erro ao enviar email" + e.getMessage();
            }
        }, delay, TimeUnit.SECONDS);
    }

    private long calcularDelay(LocalDateTime horarioEnvio) {
        LocalDateTime agora = LocalDateTime.now();
        return java.time.Duration.between(agora, horarioEnvio).getSeconds();
    }
}
