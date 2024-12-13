package com.hikmetsuicmez.notebookapp.controller.base;

import com.hikmetsuicmez.notebookapp.common.ApiResponse;

public class RestBaseController {

        public static <T> ApiResponse<T> success(T data) {
                return ApiResponse.success(data);
        }

        public static <T> ApiResponse<T> error(String errorMessage) {
                return ApiResponse.error(errorMessage);
        }

}
