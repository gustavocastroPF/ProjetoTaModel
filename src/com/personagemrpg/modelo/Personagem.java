package com.personagemrpg.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author gustavo
 */
@Entity
@Table
public class Personagem implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_personagem", sequenceName = "seq_personagem_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_personagem", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "nome")
    @NotBlank(message = "O nome deve ser informado.")
    private String nome;

    @NotNull(message = "A criação não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "criacao")
    private Calendar criacao;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "itens",
            joinColumns
            = @JoinColumn(name = "personagem", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "item", referencedColumnName = "id", nullable = false),
            uniqueConstraints = {
                @UniqueConstraint(
                        name = "UK_itens",
                        columnNames = {"personagem", "item"})})
    private List<Item> itens = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "classe", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_personagem_classe"))
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "outfit", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_personagem_outfit"))
    private Outfit outfit;

    public Personagem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getCriacao() {
        return criacao;
    }

    public void setCriacao(Calendar criacao) {
        this.criacao = criacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Personagem other = (Personagem) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Outfit getOutfit() {
        return outfit;
    }

    public void setOutfit(Outfit outfit) {
        this.outfit = outfit;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

}
