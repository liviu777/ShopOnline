package com.sda.shop.controllers;

import com.sda.shop.entities.AuthorityEntity;
import com.sda.shop.entities.UserEntity;
import com.sda.shop.repository.AuthorityRepository;
import com.sda.shop.repository.UserEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class SecurityController {
    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);

    public SecurityController() {
        logger.info(getClass().getSimpleName() + " created");
    }

    @Autowired
    private UserEntityRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public ModelAndView getLogin() {
        ModelAndView modelAndView = new ModelAndView("login-form");
        return modelAndView;

    }

    @GetMapping("/register")
    public ModelAndView registerUser() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", new UserEntity());

        return modelAndView;
    }

    @PostMapping("/register")
    public ModelAndView registerUserRequest(@Valid @ModelAttribute("user") UserEntity userEntity, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        if(bindingResult.hasErrors()){
            modelAndView.setViewName("register");
            modelAndView.addObject("user", userEntity);
            return modelAndView;
        }
        Optional<UserEntity> optionalUserEntity = userRepository.findById(userEntity.getUsername());
        if (optionalUserEntity.isPresent()) {
            UserEntity editedUserEntity = optionalUserEntity.get();
//            editedUserEntity.setPassword(userEntity.getPassword());
            editedUserEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
            userEntity = editedUserEntity;
        } else {
            userEntity.setEnabled(true);
            userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        }
        userEntity = userRepository.save(userEntity);
        if (null == userEntity.getAuthorities()) {
            AuthorityEntity authorityEntity = new AuthorityEntity();
            authorityEntity.setUsername(userEntity.getUsername());
            authorityEntity.setAuthority("USER");
            authorityRepository.save(authorityEntity);
        }
        return modelAndView;
    }
    @GetMapping("/editUser/{user}")
    public ModelAndView editUser(@PathVariable(name ="user") String username) {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("user", userRepository.findById(username).get());
        modelAndView.addObject("editMode",true);
        return modelAndView;

    }

    @GetMapping("/login-error")
    public ModelAndView loginError(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView modelAndView = new ModelAndView("login-form");
        String errorMessage = null;
        if (session != null) {
            Object object = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
            if (object instanceof BadCredentialsException) {
                errorMessage = "Wrong username or password";
            }
        }
        modelAndView.addObject("errorMessage", errorMessage);
        return modelAndView;
    }

}

