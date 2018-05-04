package de.cosmicit.kvr.controller;

import de.cosmicit.kvr.model.Person;
import de.cosmicit.kvr.model.Registration;
import de.cosmicit.kvr.service.PersonService;
import de.cosmicit.kvr.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {

    final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    RegistrationService registrationService;

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRegistrations(ModelMap model) {
        logger.debug("In getRegistrations method");
        Registration registration = new Registration();
        model.addAttribute("addressRegistration", registration);
        model.addAttribute("edit", false);
        return "addressRegistration";
    }

    /**
     * This method will be called on form submission, handling POST request for
     * saving user in database. It also validates the user input
     */
    @RequestMapping(method = RequestMethod.POST)
    public String saveRegistrationDetails(Registration registration, BindingResult result,
                                          ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("addressRegistration", registration);
            return "addressRegistration";
        }

        registration.setCreatedBy("ADMIN");
        registration.setActive("Y");

        registrationService.saveRegistrationDetails(registration);

        model.addAttribute("success", "address  registered successfully");
        return "addressRegistrationsuccess";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/search/person")
    public String getRegistrationsForPerson(ModelMap model) {
        Person person = new Person();
        model.addAttribute("personSearchRegistration", person);
        return "personRegistrationSearch";
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Long id, ModelMap model) {
        Registration registration = registrationService.findById(id);
        model.addAttribute("registrationDetail", registration);
        return "registrationDetails";
    }

    @RequestMapping(value = "/deregister", method = RequestMethod.GET)
    public String deregister(@RequestParam("id") long registrationId, ModelMap model) {
        Registration registrationDetail = registrationService.findById(registrationId);
        if (registrationDetail == null) {
            model.addAttribute("failureMessage", "registration details not found");
            return "deregistrationfailure";
        }
        registrationService.deRegister(registrationDetail);
        model.addAttribute("success", "address  deregistered successfully");
        return "deregistrationsuccess";
    }

//    @RequestMapping(value = "/deregister", method = RequestMethod.GET)
//    public String deregister(@RequestParam("id") long registrationId, ModelMap model) {
//        registrationRepository.delete(registrationId);
//        model.addAttribute("success", "address  deregistered successfully");
//        return "deregistrationsuccess";
//    }
}
