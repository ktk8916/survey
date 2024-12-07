package com.survey.api.presentation;

import com.survey.api.application.SurveySubmitService;
import com.survey.api.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SurveySubmitController {

    private final SurveySubmitService surveySubmitService;

    @PostMapping("/v1/surveys/{surveyFormId}/answers")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Long> submit(
            @PathVariable long surveyFormId,
            @RequestBody List<SurveyAnswerSubmitRequest> answers
    ) {
        surveySubmitService.submit(
                surveyFormId,
                answers.stream()
                        .map(SurveyAnswerSubmitRequest::toCommand)
                        .toList()
        );
        return ApiResponse.success(surveyFormId);
    }
}
