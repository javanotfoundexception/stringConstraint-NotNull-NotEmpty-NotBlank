package com.stringConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@NoArgsConstructor
public class WordNotBlank {

    @NotBlank
    private String notBlankString;
}
