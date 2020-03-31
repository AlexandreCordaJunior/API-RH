package br.com.lab4e.apisistemadevagas.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class VCID implements Serializable {
    private Long colabId;
    private Long vagaId;

    public Long getColabId() {
        return colabId;
    }

    public void setColabId(Long colabId) {
        this.colabId = colabId;
    }

    public Long getVagaId() {
        return vagaId;
    }

    public void setVagaId(Long vagaId) {
        this.vagaId = vagaId;
    }
}
