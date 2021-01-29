package com.meeting.organization.controller;

import com.meeting.organization.dto.CredentialDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {
    @RequestMapping(value = "/login")
    public String userLogin(Model model){
        CredentialDto credentialDto = new CredentialDto();
        model.addAttribute("credentials", credentialDto);
        return "/templates/login";
    }

//    @RequestMapping(value = "/home", method= RequestMethod.POST)
//    public String userLoginRequest(Model model, @ModelAttribute("credentials") CredentialDto credentialDto){
//        model.addAttribute("credentials", credentialDto);
//        return "/templates/home";
//    }
//
    @RequestMapping(value = "/authenticateUser", method= RequestMethod.POST)
    public String authenticateUserRequest(Model model, @ModelAttribute("credentials") CredentialDto credentialDto){
        model.addAttribute("credentials", credentialDto);
        return "/templates/home";
    }
}
