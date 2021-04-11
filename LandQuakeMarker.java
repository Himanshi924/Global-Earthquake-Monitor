package module6;

import de.fhpotsdam.unfolding.data.PointFeature;
import processing.core.PGraphics;

/** Implements a visual marker for land earthquakes on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 *
 */
public  class LandQuakeMarker extends EarthquakeMarker {
	
	
	public LandQuakeMarker(PointFeature quake) {
		
		// calling EarthquakeMarker constructor
		super(quake);
		
		// setting field in earthquake marker
		isOnLand = true;
	}


	@Override
	public void drawEarthquake(PGraphics pg, float x, float y) {
		// IMPLEMENT: drawing circle for LandQuake
		// DO NOT set the fill color.  That will be set in the EarthquakeMarker
		// class to indicate the depth of the earthquake.
		// Simply draw a centered square.
		// HINT: Notice the radius variable in the EarthquakeMarker class
		// and how it is set in the EarthquakeMarker constructor
		pg.pushStyle();
		pg.ellipse(x, y, 2*radius, 2*radius);
		
		float mag= getMagnitude();
		
		if(mag>=5.0) {
			pg.strokeWeight(3);
			pg.stroke(255,0,0);
			pg.ellipse(x, y, 2*radius, 2*radius);
			
	    }
	    else if(mag>=4.0 && mag<5.0) {
	    	pg.strokeWeight(3);
	    	pg.stroke(34,139,34);
	    	pg.ellipse(x, y, 2*radius, 2*radius);
	    
	    }
	    else {
	    	pg.ellipse(x, y,  2*radius, 2*radius);
	    	pg.strokeWeight(3);
	    	pg.stroke(139,0,139);
	    		
	    	pg.ellipse(x, y, 2*radius, 2*radius);
	    }
		
	}
	

	// Get the country the earthquake is in
	public String getCountry() {
		return (String) getProperty("country");
	}


	@Override
	public int compareTo(EarthquakeMarker o) {
		// TODO Auto-generated method stub
		return 0;
	}

		
}