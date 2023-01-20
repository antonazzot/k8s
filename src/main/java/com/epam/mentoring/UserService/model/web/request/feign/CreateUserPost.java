package com.epam.mentoring.UserService.model.web.request.feign;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.boot.jackson.JsonComponent;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonComponent
public class CreateUserPost {
    private Long authorId;
}
