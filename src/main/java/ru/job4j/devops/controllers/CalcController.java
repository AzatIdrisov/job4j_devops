package ru.job4j.devops.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.devops.models.Result;
import ru.job4j.devops.models.TwoArgs;

/**
 * Контроллер для Calc операций
 */
@RestController
@RequestMapping("calc")
public class CalcController {

    /**
     * Endpoint, возвращающий результат сложения двух чисел
     * @param twoArgs - два числа
     * @return результат сложения
     */
    @PostMapping("summarise")
    public ResponseEntity<Result> summarise(@RequestBody TwoArgs twoArgs) {
        var result = twoArgs.getFirst() + twoArgs.getSecond();
        return ResponseEntity.ok(new Result(result));
    }
}
