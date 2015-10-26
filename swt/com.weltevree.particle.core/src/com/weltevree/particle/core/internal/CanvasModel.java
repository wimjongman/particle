package com.weltevree.particle.core.internal;

import org.eclipse.e4.core.di.annotations.Creatable;

import com.weltevree.particle.model.ICanvas;

@Creatable
public class CanvasModel implements ICanvas {

	int fHeight = 0;
	int fWidth = 0;

	@Override
	public ICanvas setWidth(int pWidth) {
		fWidth = pWidth;
		return this;
	}

	@Override
	public ICanvas setHeight(int pHeight) {
		fHeight = pHeight;
		return this;
	}

	public static ICanvas create() {
		return new CanvasModel();
	}
}
