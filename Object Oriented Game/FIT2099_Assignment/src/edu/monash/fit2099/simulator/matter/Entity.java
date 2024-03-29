package edu.monash.fit2099.simulator.matter;

import java.util.HashSet;
import java.util.Set;

import edu.monash.fit2099.simulator.space.Location;
import edu.monash.fit2099.simulator.userInterface.MessageRenderer;
/**
 * Base class for simulated items and actors. <code>Entity</code> implements the <code>EntityInterface</code>.
 * <p>
 * Generated by UML Lab.
 * 
 * @author 	ram
 * @date 	17 February 2013
 * @see 	edu.monash.fit2099.simulator.matter.EntityInterface
 */
/*
 * Changelog
 * 2013-02-17: initial version
 * 2013-02-19: added tick() (ram)
 * 2013-03-01: made generic to avoid downcasts in client code (ram)
 * 2013-03-04: extracted an interface and removed genericity because there are type parameters everywhere and I am confused (ram)
 * 2013-03-05: added a MessageRenderer and a say(String) method (ram)
 * 2013-03-07: made MessageRenderer a compulsory part of the constructor (ram)
 * 2013-03-07: removed EntityInterface to see if it's really necessary (ram)
 * 2013-03-09: made constructor instantiate affordances (ram)
 */

public abstract class Entity implements EntityInterface {
	
	/**
	 * <p>Set of <code>Affordances</code> representing actions that can be performed on this <code>Entity</code>.</p>
	 * 
	 * <p>Not all actions need to be placed in this list, only actions that are specifically
	 * enabled by the presence of this Entity (e.g. the act of pressing a button is enabled
	 * by the presence of the button).</p>
	 */
	private Set<Affordance> affordances;
	
	/**
	 * <code>MessageRenderer</code> that allows this <code>Entity</code> to display messages
	 */
	protected MessageRenderer messageRenderer;
	
	/**
	 * A string that describes this <code>Entity</code> in short, suitable for display.
	 */
	protected String shortDescription;
	
	/**
	 * A longer string that describes this <code>Entity</code>, suitable for display.
	 * <p>
	 * <code>longDescriptions</code> usually provide more information than the <code>shortDescriptions</code>.
	 */
	protected String longDescription;


	// Automatically generated getters and setters for description fields
	/* (non-Javadoc)
	 * @see edu.monash.fit2024.simulator.EntityInterface#getShortDescription()
	 */
	@Override
	public String getShortDescription() {
		return shortDescription;
	}

	/* (non-Javadoc)
	 * @see edu.monash.fit2024.simulator.EntityInterface#getLongDescription()
	 */
	@Override
	public String getLongDescription() {
		return longDescription;
	}

	/* (non-Javadoc)
	 * @see edu.monash.fit2024.simulator.EntityInterface#setShortDescription(java.lang.String)
	 */
	@Override
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
		/* If the long description has not been set, make it the same as the sort description.
		 * This allows a short-cut when creating entities and helps to prevent null string issues. 
		 */
		if (this.longDescription == null) {
			setLongDescription(shortDescription); 
		}
	}

	/* (non-Javadoc)
	 * @see edu.monash.fit2024.simulator.EntityInterface#setLongDescription(java.lang.String)
	 */
	@Override
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	/* (non-Javadoc)
	 * @see edu.monash.fit2024.simulator.EntityInterface#tick(L)
	 */
	@Override
	public <L extends Location> void tick(L loc) {
		return;	
	}

	/**
	 *  The default constructor is private to enforce the setting of a <code>MessageRenderer</code> in 
	 *  descendant classes.  Subclasses should explicitly call the parameterized version of
	 *  the constructor that takes a <code>MessageRenderer</code>.
	 */
	@SuppressWarnings("unused")
	private Entity() {};
	
	/**
	 * Parameterized constructor that sets a <code>MessageRenderer</code>. This method will initialize the list of <code></code> 
	 * of this <code>Entity</code> to an empty list.
	 * 
	 * @param m the <code>MessageRenderer</code> that allows this <code>Entity</code> to display messages
	 */
	protected Entity(MessageRenderer m) {
		affordances = new HashSet<Affordance>();
		messageRenderer = m;
	}


	/* (non-Javadoc)
	 * @see edu.monash.fit2024.simulator.EntityInterface#say(java.lang.String)
	 */
	@Override
	public void say(String message) {
		messageRenderer.render(message);
	}


	/* (non-Javadoc)
	 * @see edu.monash.fit2024.simulator.EntityInterface#addAffordance(edu.monash.fit2024.simulator.Affordance)
	 */
	@Override
	public void addAffordance(Affordance a) {
		affordances.add(a);
	}


	/* (non-Javadoc)
	 * @see edu.monash.fit2024.simulator.EntityInterface#removeAffordance(edu.monash.fit2024.simulator.Affordance)
	 */
	@Override
	public void removeAffordance(Affordance a) {
		affordances.remove(a);
	}

	/* (non-Javadoc)
	 * @see edu.monash.fit2024.simulator.EntityInterface#getAffordances()
	 */
	@Override
	public Affordance[] getAffordances() {
		Affordance[] theAffordances;
		theAffordances = affordances.toArray(new Affordance[0]);
		return theAffordances;
	}


}
