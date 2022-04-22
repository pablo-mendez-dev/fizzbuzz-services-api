package com.intraway.fizzbuzz.domain.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="invocations")
public class Invocations implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_invocation", unique=true, nullable=false, precision=10)
    private int idInvocation;
    @Column(name="created_time", nullable=false)
    private LocalDateTime createdTime;
    @Column(name="path", nullable=false, length=45)
    private String path;
    @Column(name="state", nullable=false, length=1)
    private boolean state;
    @OneToMany(mappedBy="invocations")
    private Set<OkInvocations> okInvocations;

    /**
     * GET idInvocation.
     *
     * @return valor actual de idInvocation
     */
    public int getIdInvocation() {
        return idInvocation;
    }

    /**
     * SET idInvocation.
     *
     * @param valor de idInvocation
     */
    public void setIdInvocation(int aIdInvocation) {
        idInvocation = aIdInvocation;
    }

    /**
     * GET createdTime.
     *
     * @return valor actual de createdTime
     */
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * SET createdTime.
     *
     * @param valor de createdTime
     */
    public void setCreatedTime(LocalDateTime aCreatedTime) {
        createdTime = aCreatedTime;
    }

    /**
     * GET url.
     *
     * @return valor actual de url
     */
    public String getPath() {
        return path;
    }

    /**
     * SET url.
     *
     * @param valor de url
     */
    public void setPath(String aPath) {
        path = aPath;
    }

    /**
     * IS true state.
     *
     * @return valor actual de state
     */
    public boolean isState() {
        return state;
    }

    /**
     * SET state.
     *
     * @param valor de state
     */
    public void setState(boolean aState) {
        state = aState;
    }

    /**
     * GET okInvocations.
     *
     * @return valor actual de okInvocations
     */
    public Set<OkInvocations> getOkInvocations() {
        return okInvocations;
    }

    /**
     * SET okInvocations.
     *
     * @param valor de okInvocations
     */
    public void setOkInvocations(Set<OkInvocations> aOkInvocations) {
        okInvocations = aOkInvocations;
    }

   
}
