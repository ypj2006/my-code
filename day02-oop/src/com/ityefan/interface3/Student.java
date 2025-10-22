package com.ityefan.interface3;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //lomok技术
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private String sex;
    private double score;
}
