package com.hyt.reflect;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Schoolbag {
    private String color;

    private PencilCase pencilCase;
}
