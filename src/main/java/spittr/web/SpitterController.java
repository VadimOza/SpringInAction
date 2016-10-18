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
    @RequestMapping(value="/register", method=POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors,
                                      @RequestPart("profilePicture") MultipartFile profilePicture) throws IOException {
        if (errors.hasErrors()) {
            return "registerForm";
        }


        File imge = new File("/home/vadim/Java/"+profilePicture.getOriginalFilename());
        profilePicture.transferTo(imge);

        spitterRepository.save(spitter);
        return "redirect:/spitter/" +
                spitter.getUserName();

    }
    @RequestMapping(value="/{username}", method=GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        if (spitter == null){
            throw new SpittrNotFoundException();
        }
        model.addAttribute(spitter);
        return "profile";
    }

    @ExceptionHandler(SpittrNotFoundException.class)
    public String handleDuplicateSpittle() {
        return "error/SpittrNotFound";
    }
}
