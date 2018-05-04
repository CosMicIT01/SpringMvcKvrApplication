package de.cosmicit.kvr.controller;


import de.cosmicit.kvr.model.Person;
import de.cosmicit.kvr.model.Registration;
import de.cosmicit.kvr.service.PersonService;
import de.cosmicit.kvr.service.RegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/person")
public class PersonController {

    public static final String REGISTRATION_URL = "/person/registration";

    final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    PersonService personService;

    @Autowired
    RegistrationService registrationService;



    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String retrieveAllPersons(ModelMap model) {
        List<Person> persons = new ArrayList<>();
        persons = personService.retrieveAllPersons();
        model.addAttribute("persons", persons);
        return "personsList";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getPersonRegistrationForm(ModelMap model) {
        Person person = new Person();
        model.addAttribute("registerPerson", person);
        model.addAttribute("edit", false);
        return "addPerson";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String savePersonDetails(Person personDetail, BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            model.addAttribute("registerPerson", personDetail);
            return "addPerson";
        }

        boolean personExists = personService.personAlreadyExists(personDetail);
        if (personExists) {
            model.addAttribute("registerPerson", personDetail);
            model.addAttribute("errorMessage", "Person already exists");
            return "addPerson";
        }
        personDetail = personService.savePersonDetails(personDetail);

        model.addAttribute("success", "person  registered successfully");
        model.addAttribute("personDetail", personDetail);
        return "personRegistrationsuccess";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Person get(@PathVariable("id") Long id) {
        return personService.findById(id);
    }


    @RequestMapping(path = "/edit/{id}", method = RequestMethod.POST)
    public String getEditForm(Person personDetail, BindingResult result, ModelMap model) {
        personService.updatePersonDetails(personDetail);
        model.addAttribute("editPersonDetail", personDetail);
        model.addAttribute("success", "person  details updated successfully");
        return "personEditSuccess";
    }

    @RequestMapping(path = "/edit/{id}", method = RequestMethod.GET)
    public String getEditForm(@PathVariable("id") Long id, ModelMap model) {
        Person personDetail = personService.findById(id);
        model.addAttribute("editPersonDetail", personDetail);
        return "editPerson";
    }


    @RequestMapping(path = "/findregistrations", method = RequestMethod.GET)
    public String getRegistrationsForPerson( Person person, BindingResult result,
                                            ModelMap model) {
        List<Person> searchPersonsResult = personService.searchByFirstNameLastName(person.getFirstName(), person.getLastName());
        if (searchPersonsResult.isEmpty()){
            model.addAttribute("person", person);
            model.addAttribute("errorMessage", "No registrations found");
            return "personRegistrations";
        }
        List<Registration> registrationList = registrationService.searchByPerson(searchPersonsResult.get(0));
        model.addAttribute("localDateTimeFormat", new SimpleDateFormat("MM.dd.yyyy hh:mm"));
        model.addAttribute("personRegistrations", registrationList);
        model.addAttribute("personFullName", searchPersonsResult.get(0).getFirstName()+ " "+searchPersonsResult.get(0).getLastName());
        return "personRegistrations";
    }


    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String getPersonSearchForm(Person person, BindingResult result, ModelMap model) {
        person = new Person();
        model.addAttribute("person", person);
        return "personSearchForm";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String searchPerson(Person person, BindingResult result, ModelMap model) {
        List<Person> personList = personService.searchByFirstNameLastName(person.getFirstName(),person.getLastName());

        if (personList.isEmpty()) {
            model.addAttribute("errorMessage", "No matching records found");
            return "personsList";
        }

        model.addAttribute("persons", personList);
        return "personsList";
    }

    @RequestMapping(value = "/searchbyfirstname", method = RequestMethod.GET)
    public @ResponseBody
    List<Person> getPersonListByFirstName(@RequestParam("firstName") String queryStringFirstName) {
        List<Person> personList = personService.searchByFirstName(queryStringFirstName);
        return personList;
    }

    @RequestMapping(value = "/searchbylastname", method = RequestMethod.GET)
    public @ResponseBody
    List<Person> getPersonListByLastName(@RequestParam("lastName") String queryStringLastName) {
        List<Person> personList = personService.searchByLastName(queryStringLastName);
        return personList;
    }

}
