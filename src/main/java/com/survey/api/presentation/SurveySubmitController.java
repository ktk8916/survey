package com.survey.api.presentation;

import com.survey.api.application.SurveySubmitUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SurveySubmitController {

    private final SurveySubmitUseCase surveySubmitUseCase;

    @PostMapping("/v1/surveys/{surveyId}/answers")
    public void submit(
            @PathVariable long surveyId,
            @RequestBody List<SurveyAnswerSubmitRequest> submitAnswer
    ) {

    }
}
