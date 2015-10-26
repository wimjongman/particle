/*******************************************************************************
 * Copyright (c) 2010 - 2013 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Lars Vogel <lars.Vogel@gmail.com> - Bug 419770
 *******************************************************************************/
package com.weltvree.particle.ui.internal.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import com.weltevree.particle.model.ICanvas;

public class CanvasPart {

	@Inject
	ICanvas fCanvas;

	@PostConstruct
	public void createComposite(Composite parent, Display display) {
		parent.setLayout(new GridLayout(1, false));
		parent.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
		Canvas canvas = new Canvas(parent, SWT.NONE);
		canvas.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		canvas.setLayout(new GridLayout(1, false));
		canvas.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
		canvas.addControlListener(getCanvasControlAdapter());
	}

	private ControlAdapter getCanvasControlAdapter() {
		return new ControlAdapter() {
			@Override
			public void controlResized(ControlEvent e) {
				fCanvas.setWidth(((Canvas) e.widget).getClientArea().width);
				fCanvas.setHeight(((Canvas) e.widget).getClientArea().height);
			}
		};
	}
}