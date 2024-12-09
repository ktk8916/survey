package com.survey.api.presentation;

import com.survey.api.application.SurveyAnswerQueryService;
import com.survey.api.application.SurveyCreateService;
import com.survey.api.application.SurveyModifyService;
import com.survey.api.application.SurveySubmitService;
import com.survey.api.domain.survey.form.SurveyVersionKey;
import com.survey.api.global.ApiResponse;
import com.survey.api.presentation.request.SurveyAnswerSubmitRequest;
import com.survey.api.presentation.request.SurveyCreateRequest;
import com.survey.api.presentation.request.SurveyModifyRequest;
import com.survey.api.presentation.response.SurveyQueryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SurveyController {

    private final SurveyCreateService surveyCreateService;
    private final SurveyModifyService surveyModifyService;
    private final SurveySubmitService surveySubmitService;
    private final SurveyAnswerQueryService surveyAnswerQueryService;

    @PostMapping("/v1/surveys")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Long> create(@RequestBody SurveyCreateRequest request) {
        long surveyId = surveyCreateService.create(request.toCommand());
        return ApiResponse.success(surveyId);
    }

    @PutMapping("/v1/surveys/versions/{surveyVersionKey}")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Long> modify(@PathVariable String surveyVersionKey, @RequestBody SurveyModifyRequest request) {
        long surveyFormId = surveyModifyService.modify(SurveyVersionKey.from(surveyVersionKey), request.toCommand());
        return ApiResponse.success(surveyFormId);
    }

    @PostMapping("/v1/surveys/{surveyFormId}/submit")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<Long> submit(@PathVariable long surveyFormId, @RequestBody List<SurveyAnswerSubmitRequest> answers) {
        surveySubmitService.submit(
                surveyFormId,
                answers.stream()
                        .map(SurveyAnswerSubmitRequest::toDomain)
                        .toList()
        );
        return ApiResponse.success(surveyFormId);
    }

    @GetMapping("/v1/surveys/{surveyFormId}/answers")
    public ApiResponse<List<SurveyQueryResponse>> findById(@PathVariable long surveyFormId) {
        List<SurveyQueryResponse> responses = surveyAnswerQueryService.findById(surveyFormId);
        return ApiResponse.success(responses);
    }
}
