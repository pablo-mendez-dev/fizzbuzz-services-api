package com.intraway.fizzbuzz.services;

import java.util.Collection;

import com.intraway.fizzbuzz.domain.dto.ERRORFizzbuzzDTO;
import com.intraway.fizzbuzz.domain.dto.OKFizzbuzzDTO;
import com.intraway.fizzbuzz.domain.entities.Invocations;
import com.intraway.fizzbuzz.domain.entities.OkInvocations;
import com.intraway.fizzbuzz.domain.entities.Results;

public interface FizzbuzzServices {

	public abstract void createInvocations(Invocations invocation);
	public abstract void createOkInvocations(OkInvocations okInvocation);
	public abstract void createResults(Results result);
	
	public Collection<Invocations> getAllInvocations();
	public boolean validateMinMax(String min, String max);
	public OKFizzbuzzDTO getOkResult(String min, String max);
	public ERRORFizzbuzzDTO getErrorResult(String path);

	
	
}
