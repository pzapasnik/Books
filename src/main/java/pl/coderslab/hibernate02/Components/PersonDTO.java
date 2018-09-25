package pl.coderslab.hibernate02.Components;

import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class PersonDTO {

    public Collection<String> showCountrys() {
        String[] countrys = Locale.getISOCountries();
        return Arrays.asList(countrys);
    }

    public Collection<String> showProgrammingSkills() {
        List<String> programmingSkills = new ArrayList<>();
        programmingSkills.add("Java");
        programmingSkills.add("MySQL");
        programmingSkills.add("Servlets");
        programmingSkills.add("JavaScript");
        programmingSkills.add("Sprign");
        programmingSkills.add("Hibernate");
        return programmingSkills;
    }

    public Collection<String> showHobbies() {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Sport");
        hobbies.add("Podroze");
        hobbies.add("Film");
        hobbies.add("Muzyka");
        hobbies.add("Gry Komputerowe");
        return hobbies;
    }
}
