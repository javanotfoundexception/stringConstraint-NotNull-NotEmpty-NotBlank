package com.stringConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
@NoArgsConstructor
public class WordNotEmpty {

    @NotEmpty
    private String notEmptyString;
}
