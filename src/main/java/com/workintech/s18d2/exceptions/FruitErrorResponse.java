package com.workintech.s18d2.exceptions;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data @AllArgsConstructor
public class FruitErrorResponse { private Integer status; private String message; private Long timestamp; }
