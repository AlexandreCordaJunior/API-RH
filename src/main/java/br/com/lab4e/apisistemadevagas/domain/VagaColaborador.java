package br.com.lab4e.apisistemadevagas.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "vaga_colaborador")
public class VagaColaborador {
    @EmbeddedId
    private VCID id;

    @ManyToOne
    @JoinColumn
    @MapsId("vagaId")
    private Vaga vaga;

    @ManyToOne
    @JoinColumn
    @MapsId("colabId")
    private Colaborador colaborador;

    @Column(name = "data_de_cadastro")
    private Date dataDeCadastro;

    public VCID getId() {
        return id;
    }

    public void setId(VCID id) {
        this.id = id;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    @Override
    public String toString() {
        return "VagaColaborador{" +
                "id=" + id +
                ", vaga=" + vaga +
                ", colaborador=" + colaborador +
                '}';
    }
}
