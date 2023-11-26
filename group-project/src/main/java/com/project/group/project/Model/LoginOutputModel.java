package com.project.group.project.Model;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginOutputModel {

    private String userName;
    private String token;
}
