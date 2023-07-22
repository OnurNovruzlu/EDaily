package az.coftea.edaily.controller;

import az.coftea.edaily.service.DailyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("daily")
@RequiredArgsConstructor
public class DailyController {
    private final DailyService dailyService;
}
