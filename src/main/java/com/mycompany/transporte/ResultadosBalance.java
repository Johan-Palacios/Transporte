package com.mycompany.transporte;

public class ResultadosBalance {
  public int[][] costos;
  public int[] oferta;
  public int[] demanda;
  public String result;

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public ResultadosBalance(int[][] costos, int[] oferta, int[] demanda, String result) {
    this.costos = costos;
    this.oferta = oferta;
    this.demanda = demanda;
    this.result = result;
  }
}
