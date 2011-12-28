package com.weltevree.particle.model;

import java.util.UUID;

public interface IParticleFactory {

	public IParticle createParticle(int[] min, int[] max);
	
	/**
	 *
	 * @return a unique id
	 */
	public UUID getID();

	/**
	 * Adds a factory to the factory. This is used to combine multiple particle emi
	 * @param factory
	 */
	public void addFactory(IParticleFactory factory);

}
