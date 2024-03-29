package com.rbmi.student.portal.rbmi.apiResponse;

import java.util.List;

import com.rbmi.student.portal.rbmi.payloads.ResultDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    
    private String message;
    private boolean status;
    private List<ResultDto> result;
}
