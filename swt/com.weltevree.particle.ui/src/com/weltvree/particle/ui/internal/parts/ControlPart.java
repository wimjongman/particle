 
package com.weltvree.particle.ui.internal.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ControlPart {
	@Inject
	public ControlPart() {
		
	}
	
	@PostConstruct
	public void postConstruct(Composite parent) {
		
		new Label(parent, 0).setText("sdfsdfsdsdf");
		
	}
	
	
	
	
}