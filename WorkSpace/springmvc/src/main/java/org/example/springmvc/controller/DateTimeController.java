package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.*;

@Controller
public class DateTimeController {
    @GetMapping("datetime")
    public String datetime(Model model) {
        LocalDate date = LocalDate.now();
        model.addAttribute("CurrentDate", date);

        LocalDateTime dateTime = LocalDateTime.now();
        model.addAttribute("CurrentDateTime", dateTime);

        LocalTime time = LocalTime.now();
        model.addAttribute("CurrentTime", time);

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        model.addAttribute("CurrentZonedDateTime", zonedDateTime);
        return "datetime";
    }
}
