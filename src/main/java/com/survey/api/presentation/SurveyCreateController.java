package com.survey.api.presentation;

import com.survey.api.application.SurveyCreateService;
import com.survey.api.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SurveyCreateController {

    private final SurveyCreateService surveyCreateService;

    @PostMapping("/v1/surveys")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Long> create(@RequestBody SurveyCreateRequest request) {
        long surveyId = surveyCreateService.create(request.toCommand());
        return ApiResponse.success(surveyId);
    }
}
