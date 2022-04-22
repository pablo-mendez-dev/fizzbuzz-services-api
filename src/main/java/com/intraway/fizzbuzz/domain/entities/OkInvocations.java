package com.intraway.fizzbuzz.domain.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name="ok_invocations")
public class OkInvocations implements Serializable {

	private static final long serialVersionUID = 2L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_ok", unique=true, nullable=false, precision=10)
    private int idOk;
    @Column(name="code", nullable=false, length=45)
    private String code;
    @Column(name="description", nullable=false, length=100)
    private String description;
    @OneToOne(optional=false)
    @JoinColumn(name="fk_id_invocation", nullable=false)
    private Invocations invocations;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE}, mappedBy="okInvocations")
    private List<Results> results;


    /**
     * GET idOk.
     *
     * @return valor actual de idOk
     */
    public int getIdOk() {
        return idOk;
    }

    /**
     * SET idOk.
     *
     * @param valor de idOk
     */
    public void setIdOk(int aIdOk) {
        idOk = aIdOk;
    }

    /**
     * GET code.
     *
     * @return valor actual de code
     */
    public String getCode() {
        return code;
    }

    /**
     * SET code.
     *
     * @param valor de code
     */
    public void setCode(String aCode) {
        code = aCode;
    }

    /**
     * GET description.
     *
     * @return valor actual de description
     */
    public String getDescription() {
        return description;
    }

    /**
     * SET description.
     *
     * @param valor de description
     */
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    /**
     * GET invocations.
     *
     * @return valor actual de invocations
     */
    public Invocations getInvocations() {
        return invocations;
    }

    /**
     * SET invocations.
     *
     * @param valor de invocations
     */
    public void setInvocations(Invocations aInvocations) {
        invocations = aInvocations;
    }

    /**
     * GET results.
     *
     * @return valor actual de results
     */
    public List<Results> getResults() {
        return results;
    }

    /**
     * SET results.
     *
     * @param valor de results
     */
    public void setResults(List<Results> aResults) {
        results = aResults;
    }

}
