package art.jeanyvehector.service;

import art.jeanyvehector.controller.ProfileController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ModelAttribute
    public void addCommonAttributes(Model model) {
        // Add global attributes here
        model.addAttribute("sessionId", ProfileController.getSessionId());
    }
}
