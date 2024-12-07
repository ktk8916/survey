package com.survey.api.presentation;

import com.survey.api.application.SurveyModifyService;
import com.survey.api.domain.survey.form.SurveyVersionKey;
import com.survey.api.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SurveyModifyController {

    private final SurveyModifyService surveyModifyService;

    @PostMapping("/v1/surveys/{surveyVersionKey}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Long> create(
            @PathVariable String surveyVersionKey,
            @RequestBody SurveyModifyRequest request
    ) {
        long surveyFormId = surveyModifyService.modify(
                SurveyVersionKey.from(surveyVersionKey),
                request.toCommand()
        );
        return ApiResponse.success(surveyFormId);
    }
}
