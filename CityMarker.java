package module6;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import processing.core.PConstants;
import processing.core.PGraphics;

/** Implements a visual marker for cities on an earthquake map
 * 
 * @author UC San Diego Intermediate Software Development MOOC team
 * 
 */
public class CityMarker extends CommonMarker {
	
	public static int TRI_SIZE = 10;  // The size of the triangle marker
	protected String cityinfo;
	public CityMarker(Location location) {
		super(location);
	}
	
	
	public CityMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
		// Cities have properties: "name" (city name), "country" (country name)
		// and "population" (population, in millions)
	}
	
	
	// pg is the graphics object on which you call the graphics
	// methods.  e.g. pg.fill(255, 0, 0) will set the color to red
	// x and y are the center of the object to draw. 
	// They will be used to calculate the coordinates to pass
	// into any shape drawing methods.  
	// e.g. pg.rect(x, y, 10, 10) will draw a 10x10 square
	// whose upper left corner is at position x, y
	/**
	 * Implementation of method to draw marker on the map.
	 */
	public void drawMarker(PGraphics pg, float x, float y) {
		//System.out.println("Drawing a city");
		// Save previous drawing style
		pg.pushStyle();
		
		// IMPLEMENT: drawing triangle for each city
		pg.triangle(x, y-TRI_SIZE, x-TRI_SIZE, y+TRI_SIZE, x+TRI_SIZE, y+TRI_SIZE);
		pg.fill(255,0,200);
		
		
		
	}
	public void drawMarkerPopulation(PGraphics pg, float x, float y) {
		float f = getPopulation();
		pg.pushStyle();
		
		if(f>=20.0f) {
			pg.stroke(255,0,0);
			pg.triangle(x, y-8, x-8, y+8, x+8, y+8);
			pg.fill(255,0,0);
			
		}
		else if(f>=10.0f && f<20.0f) {
			pg.stroke(0,255,255);
			pg.triangle(x, y-8, x-8, y+8, x+8, y+8);
			pg.fill(0, 255, 255);
			
		}
		else if(f<10.0f) {
			
			pg.triangle(x, y-8, x-8, y+8, x+8, y+8);
			pg.fill(0, 255, 0);
			pg.stroke(0,255,0);
		}
		
//		System.out.println("Color Pg = "+pg.fillColor);
		// Restore previous drawing style
//		pg.popStyle();
	}
	
	/** Show the title of the city if this marker is selected */
	public void showTitle(PGraphics pg, float x, float y)
	{
		drawMarkerPopulation(pg,x,y);
		
		String name = getCity() + " " + getCountry() + " ";
		String pop = "Pop: " + getPopulation() + " Million";
		
		pg.pushStyle();
		
		pg.fill(255, 255, 255);
		pg.textSize(12);
		pg.rectMode(PConstants.CORNER);
		pg.rect(x, y-TRI_SIZE-39, Math.max(pg.textWidth(name), pg.textWidth(pop)) + 6, 39);
		pg.fill(0, 0, 0);
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.text(name, x+3, y-TRI_SIZE-33);
		pg.text(pop, x+3, y - TRI_SIZE -18);
				
		
	}
	public void showmenu(PGraphics pg, float x, float y){
    	pg.pushStyle();
    	pg.fill(200, 255, 200);
    	pg.rect(x-20, y-20, 200, 20);
    	pg.fill(0, 0, 0);
    	pg.text(cityinfo, x-20, y-20);
    	
	}
	private String getCity()
	{
		return getStringProperty("name");
	}
	
	private String getCountry()
	{
		return getStringProperty("country");
	}
	
	private float getPopulation()
	{
		return Float.parseFloat(getStringProperty("population"));
	}
}
