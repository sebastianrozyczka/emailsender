package p.sebroz.thymeleaftask.application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactController {
    private SimpleEmailSender simpleEmailSender;

    public ContactController(SimpleEmailSender simpleEmailSender) {
        this.simpleEmailSender = simpleEmailSender;
    }

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@ModelAttribute("contact") Contact contact) {
        simpleEmailSender.sendEmail(contact.getName(), contact.getEmail(), contact.getContent());
        return "home";
    }
}
