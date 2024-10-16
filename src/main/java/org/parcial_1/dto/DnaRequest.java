package org.parcial_1.dto;

import lombok.Getter;
import lombok.Setter;
import org.parcial_1.validators.ValidDna;

@Getter
@Setter
public class DnaRequest {
    @ValidDna
    private String[] dna;
}
