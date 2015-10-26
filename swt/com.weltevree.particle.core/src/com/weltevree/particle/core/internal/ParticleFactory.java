package com.weltevree.particle.core.internal;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

import com.weltevree.particle.model.IParticle;
import com.weltevree.particle.model.IParticleFactory;

public class ParticleFactory implements IParticleFactory {

	/**
	 * The main particle factory
	 */
	private static IParticleFactory main;

	/**
	 * The ID of this factory.
	 */
	UUID id = UUID.randomUUID();

	/**
	 * A store for all the contributed factories
	 */
	private HashMap<UUID, IParticleFactory> factories = new HashMap<UUID, IParticleFactory>();

	public synchronized static IParticleFactory getInstance() {
		if (main == null)
			main = new ParticleFactory();
		return main;

	}

	public synchronized static IParticleFactory getInstance(
			IParticleFactory factory) {
		if (main == null)
			main = new ParticleFactory();
		main.addFactory(factory);
		return main;

	}

	private ParticleFactory(IParticleFactory factory) {
		factories.put(factory.getID(), factory);
	}

	public ParticleFactory(UUID id) {
		this.id = id;
	}

	public ParticleFactory() {
		this(UUID.randomUUID());
	}

	@Override
	public IParticle createParticle(final int[] min, final int[] max) {

		return new IParticle() {

			@Override
			public int[] getPosition() {

				Random rnd = new Random();

				int x = min[0] + rnd.nextInt(max[0] - min[0]);
				int y = min[1] + rnd.nextInt(max[1] - min[1]);
				int z = min[2] + rnd.nextInt(max[2] - min[2]);
				int v = min[3] + rnd.nextInt(max[3] - min[3]);
				int l = min[4] + rnd.nextInt(max[4] - min[4]);

				return new int[] { x, y, z, v, l };
			}
		};

	}

	@Override
	public UUID getID() {
		return id;
	}

	@Override
	public void addFactory(IParticleFactory factory) {
		factories.put(factory.getID(), factory);

	}

}
