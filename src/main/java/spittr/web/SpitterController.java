package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;

import javax.servlet.http.Part;
import javax.validation.Valid;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    @Autowired
    private SpitterRepository spitterRepository;

    public SpitterController() {
    }

    @Autowired
    public SpitterController(
    SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }
    @RequestMapping(value="/register", method=GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }
//    @RequestMapping(value="/register", method=POST)
//    public String processRegistration(@Valid Spitter spitter, Errors errors,
//                                      @RequestPart("profilePicture") MultipartFile profilePicture, RedirectAttributes model) throws IOException {
    @RequestMapping(value="/register", method=POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors, RedirectAttributes model) throws IOException {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);
        model.addAttribute("username",spitter.getUserName());
        model.addFlashAttribute(spitter);
        return "redirect:/spitter/{username}";

    }
    @RequestMapping(value="/{username}", method=GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
//        if (!model.containsAttribute("spitter")) {
            model.addAttribute(
                    spitterRepository.findByUsername(username));
//        }
        return "profile";
    }
}
