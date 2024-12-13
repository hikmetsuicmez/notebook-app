package com.hikmetsuicmez.notebookapp.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

        private boolean result;
        private String errorMessage;
        private T data;

        public static <T> ApiResponse<T> success(T data) {
                ApiResponse<T> result = new ApiResponse<T>();
                result.setResult(true);
                result.setData(data);
                result.setErrorMessage(null);
                return result;
        }

        public static <T> ApiResponse<T> success(T data, String errorMessage) {
                ApiResponse<T> result = new ApiResponse<T>();
                result.setResult(true);
                result.setData(data);
                result.setErrorMessage(errorMessage);
                return result;
        }

        public static <T> ApiResponse<T> success(String errorMessage) {
                ApiResponse<T> result = new ApiResponse<T>();
                result.setResult(true);
                result.setErrorMessage(errorMessage);
                return result;
        }

        public static <T> ApiResponse<T> error(String errorMessage) {
                ApiResponse<T> result = new ApiResponse<T>();
                result.setResult(false);
                result.setErrorMessage(errorMessage);
                return result;
        }

        public static <T> ApiResponse<T> error(String errorMessage, T data) {
                ApiResponse<T> result = new ApiResponse<T>();
                result.setResult(false);
                result.setErrorMessage(errorMessage);
                result.setData(data);
                return result;
        }
}

