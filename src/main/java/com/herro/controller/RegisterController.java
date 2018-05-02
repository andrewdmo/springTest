//package com.herro.controller;
//
//import com.herro.entity.User;
//import com.herro.service.EmailService;
//import com.herro.service.SecurityService;
//import com.herro.service.UserService;
//import com.herro.validator.UserValidator;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//@Controller
//public class RegisterController {
//
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    private UserService userService;
//    private EmailService emailService;
//
//    //turn AW back on(?):
//    @Autowired
//    public RegisterController(BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService, EmailService emailService, UserValidator userValidator, SecurityService securityService) {
//
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//        this.userService = userService;
//        this.emailService = emailService;
//        this.userValidator = userValidator;
//        this.securityService = securityService;
//    }
//
//    // Return registration form template:
////    @RequestMapping(value = "/register", method = RequestMethod.GET)
////    public String register(Model model, User user) {
////        model.addAttribute("user", user);
////        return "register";
////    }
//    //   ^^^^^^^^^
//    // Return registration form template (original for reference):
////    @RequestMapping(value = "/register", method = RequestMethod.GET)
////    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
////        modelAndView.addObject("user", user);
////        modelAndView.setViewName("register");
////        return modelAndView;
////    }
//
//    private final UserValidator userValidator;
//
//    private final SecurityService securityService;
//
//
//
//
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String register(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "register";
//    }
//
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String register(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//        userValidator.validate(userForm, bindingResult);
//
//        if (bindingResult.hasErrors()) {
//            return "register";
//        }
//
//        userService.saveUser(userForm);
//
//        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
//
//        return "redirect:/login";
//    }
//
////    needed?
//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String registration(Model model) {
//        model.addAttribute("userForm", new User());
//
//        return "register";
//
//    }
//
//
//
//
//
////    @RequestMapping(value = "/register", method = RequestMethod.POST)
////    public String register(Model model, @Valid User user) {
////
////        User userExists = userService.findByUsername(user.getUsername());
////
////        System.out.println(userExists);
////
////        if (userExists != null) {
////            model.addAttribute("alreadyRegisteredMessage", "You or someone with the same email already registered!");
////            return "register";
////        } else {
////            userService.saveUser(user);
////            //need auto-fill parameters:
////            return "redirect:/login";
////
////        }
////    }
//
//
//    // Process form input data (original):
////    @RequestMapping(value = "/register", method = RequestMethod.POST)
////    public String registerForm(Model model, @Valid User user, BindingResult bindingResult, HttpServletRequest request) {
////
////        // Lookup user in database by e-mail
////        User userExists = userService.findByUsername(user.getUsername());
////
////        System.out.println(userExists);
////
////        if (userExists != null) {
////            model.addAttribute("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
//////            model.setViewName("register");
////            bindingResult.reject("email");
////        }
////
////        if (bindingResult.hasErrors()) {
//////            model.setViewName("register");
////        } else { // new user so we create user and send confirmation e-mail
////
////            // Disable user until they click on confirmation link in email
//////            user.setEnabled(false);
////
////            // Generate random 36-character string token for confirmation link
////            user.setConfirmationToken(UUID.randomUUID().toString());
////
////            userService.saveUser(user);
////
////            String appUrl = request.getScheme() + "://" + request.getServerName();
////
////            SimpleMailMessage registrationEmail = new SimpleMailMessage();
////            registrationEmail.setTo(user.getUsername());
////            registrationEmail.setSubject("Registration Confirmation");
////            registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
////                + appUrl + "/confirm?token=" + user.getConfirmationToken());
////            registrationEmail.setFrom("noreply@domain.com");
////
////            emailService.sendEmail(registrationEmail);
////
////            model.addAttribute("confirmationMessage", "A confirmation e-mail has been sent to " + user.getUsername());
////            model.addAttribute("register");
////        }
////
////        return "login";
////    }
//
//    public BCryptPasswordEncoder getbCryptPasswordEncoder() {
//        return bCryptPasswordEncoder;
//    }
//
//    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//// Process confirmation link, activate later:
//
////    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
////    public ModelAndView showConfirmationPage(ModelAndView modelAndView, @RequestParam("token") String token) {
////
////        User user = userService.findByConfirmationToken(token);
////
////        if (user == null) { // No token found in DB
////            modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
////        } else { // Token found
////            modelAndView.addObject("confirmationToken", user.getConfirmationToken());
////        }
////
////        modelAndView.setViewName("confirm");
////        return modelAndView;
////    }
//
//// Process confirmation link, activate later:
//
////    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
////    public ModelAndView processConfirmationForm(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map requestParams, RedirectAttributes redir) {
////
////        modelAndView.setViewName("confirm");
////
////        Zxcvbn passwordCheck = new Zxcvbn();
////
////        Strength strength = passwordCheck.measure(requestParams.get("password"));
////
////        if (strength.getScore() < 3) {
////            bindingResult.reject("password");
////
////            redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");
////
////            modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
////            System.out.println(requestParams.get("token"));
////            return modelAndView;
////        }
////
////        // Find the user associated with the reset token
////        User user = userService.findByConfirmationToken(requestParams.get("token"));
////
////        // Set new password
////        user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));
////
////        // Set user to enabled
////        user.setEnabled(true);
////
////        // Save user
////        userService.saveUser(user);
////
////        modelAndView.addObject("successMessage", "Your password has been set!");
////        return modelAndView;
//
//}