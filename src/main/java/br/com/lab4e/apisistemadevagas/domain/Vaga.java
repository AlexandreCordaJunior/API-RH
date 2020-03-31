package br.com.lab4e.apisistemadevagas.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "vaga")
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codigo;

    @Column(name = "cargo", length = 127)
    private String cargo;

    @Column(name = "data_de_vencimento")
    private Date dataDeVencimento;

    @Column
    private String descricao;

    @Column(name = "locacao", length = 31)
    private String locacao;

    @Column(name = "situacao", length = 31)
    private String situacao;

    @Column(name = "tipo", length = 31)
    private String tipo;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(Date dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocacao() {
        return locacao;
    }

    public void setLocacao(String locacao) {
        this.locacao = locacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Vaga{" +
                "codigo=" + codigo +
                ", cargo='" + cargo + '\'' +
                ", dataDeVencimento=" + dataDeVencimento +
                ", descricao='" + descricao + '\'' +
                ", locacao='" + locacao + '\'' +
                ", situacao='" + situacao + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
