package br.com.lab4e.apisistemadevagas.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    @Column(name = "cargo_atual", length = 127)
    private String cargoAtual;

    @Column(name = "nome", length = 127)
    private String nome;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getCargoAtual() {
        return cargoAtual;
    }

    public void setCargoAtual(String cargoAtual) {
        this.cargoAtual = cargoAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Colaborador{" +
                "codigo=" + codigo +
                ", cargoAtual='" + cargoAtual + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
