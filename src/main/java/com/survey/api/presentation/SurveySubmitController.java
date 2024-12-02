package com.survey.api.presentation;

import com.survey.api.application.SurveySubmitUseCase;
import com.survey.api.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SurveySubmitController {

    private final SurveySubmitUseCase surveySubmitUseCase;

    @PostMapping("/v1/surveys/{surveyFormId}/answers")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Long> submit(
            @PathVariable long surveyFormId,
            @RequestBody List<SurveyAnswerSubmitRequest> answers
    ) {
        surveySubmitUseCase.submit(
                surveyFormId,
                answers.stream()
                        .map(SurveyAnswerSubmitRequest::toCommand)
                        .toList()
        );
        return ApiResponse.success(surveyFormId);
    }
}
