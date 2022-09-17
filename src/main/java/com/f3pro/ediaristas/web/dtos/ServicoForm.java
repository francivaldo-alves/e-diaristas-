package com.f3pro.ediaristas.web.dtos;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import com.f3pro.ediaristas.core.enums.Icone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoForm {

    @NotNull
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style =Style.CURRENCY, pattern ="#,##0.00" )
    private BigDecimal valorMinimo;

    @NotNull
    @PositiveOrZero
    private Integer qtdHoras;

    @NotNull
    @PositiveOrZero
    @Max(100)
    @NumberFormat(style =Style.CURRENCY, pattern ="#,##0.00" )
    private BigDecimal procentagemComissao;

    @NotNull
    @PositiveOrZero
    private Integer horasQuarto;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style =Style.CURRENCY, pattern ="#,##0.00" )
    private BigDecimal valorQuarto;

    @NotNull
    @PositiveOrZero
    Integer horasSala;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style =Style.CURRENCY, pattern ="#,##0.00" )
    BigDecimal valorSala;

    @NotNull
    @PositiveOrZero
    Integer horasBanheiro;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style =Style.CURRENCY, pattern ="#,##0.00" )
    BigDecimal valorBanheiro;

    @NotNull
    @PositiveOrZero
    Integer horasCozinha;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style =Style.CURRENCY, pattern ="#,##0.00" )
    BigDecimal valorCozinha;

    @NotNull
    @PositiveOrZero
    Integer horasQuintal;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style =Style.CURRENCY, pattern ="#,##0.00" )
    BigDecimal valorQuintal;

    @NotNull
    @PositiveOrZero
    Integer horasOutros;

    @NotNull
    @PositiveOrZero
    @NumberFormat(style =Style.CURRENCY, pattern ="#,##0.00" )
    BigDecimal valorOutros;
    @NotNull
    private Icone icone;

    @NotNull
    @Positive
    private Integer posicao;

}
