package com.intraway.fizzbuzz.services.dao;

import java.util.Collection;

import com.intraway.fizzbuzz.domain.entities.Invocations;
import com.intraway.fizzbuzz.domain.entities.OkInvocations;
import com.intraway.fizzbuzz.domain.entities.Results;

/**
 * Interfaz de servicios que tienen la logica del acceso a datos
 * @author Pablo Mendez
 *
 */
public interface FizzbuzzDAO {

	public abstract void createInvocations(Invocations invocation);

	public abstract void createOkInvocations(OkInvocations okInvocation);

	public abstract void createResults(Results result);

	public Collection<Invocations> getAllInvocations();

	public Collection<Invocations> getAllInvocationsByState(boolean state);
}
