package com.personagemrpg.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gustavo
 */
@Entity
@Table
public class Outfit implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_outfit", sequenceName = "seq_outfit_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_outfit", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    @NotBlank(message = "A armadura deve ser informada.")
    private String armadura;
    @Column
    @NotBlank(message = "A calça deve ser informada.")
    private String calca;
    @Column
    @NotBlank(message = "As botas devem ser informadas.")
    private String botas;

    @OneToMany(mappedBy = "outfit", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Personagem> personagens = new ArrayList<>();
    

    public Outfit() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArmadura() {
        return armadura;
    }

    public void setArmadura(String armadura) {
        this.armadura = armadura;
    }

    public String getCalca() {
        return calca;
    }

    public void setCalca(String calca) {
        this.calca = calca;
    }

    public String getBotas() {
        return botas;
    }

    public void setBotas(String botas) {
        this.botas = botas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Outfit other = (Outfit) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Personagem> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<Personagem> personagens) {
        this.personagens = personagens;
    }

  

}
