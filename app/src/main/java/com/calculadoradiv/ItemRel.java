package com.calculadoradiv;

import java.math.BigDecimal;

public class ItemRel {

    private BigDecimal valorTotal;
    private BigDecimal valorDiv;
    private BigDecimal qtdCotas;

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public BigDecimal getValorDiv() {
        return valorDiv;
    }

    public void setValorDiv(BigDecimal valorDiv) {
        this.valorDiv = valorDiv;
    }

    public BigDecimal getQtdCotas() {
        return qtdCotas;
    }

    public void setQtdCotas(BigDecimal qtdCotas) {
        this.qtdCotas = qtdCotas;
    }
}
