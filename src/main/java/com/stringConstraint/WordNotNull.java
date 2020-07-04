package com.stringConstraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
@NoArgsConstructor
public class WordNotNull {

    @NotNull
    private String notNullString;
}
