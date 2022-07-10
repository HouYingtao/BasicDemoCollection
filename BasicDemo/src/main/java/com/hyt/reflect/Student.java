package com.hyt.reflect;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Student {
    private String name;

    private Schoolbag bag;
}
