package com.facinpro.aulaspringboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;


public record FacinPro_ProdutoRecordDto(@NotBlank String name, @NotBlank String description, @NotBlank String categoryPath, @NotNull BigDecimal price, @NotBlank String available){


}