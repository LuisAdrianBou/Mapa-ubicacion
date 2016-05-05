package Ubicacion;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.examples.marker.SimpleMarkerManagerApp;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.utils.ScreenPosition;
import de.fhpotsdam.unfolding.providers.Google;

public class Ubicacion extends PApplet {

	UnfoldingMap map;

	public void setup() {
		size(1200, 900, OPENGL);

		map = new UnfoldingMap(this, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
	}

	public void draw() {
		map.draw();

		fill(215, 0, 0, 100);
		Location location = map.getLocation(mouseX, mouseY);
		text("geo:" + location.toString(), mouseX, mouseY);

		Location loc = new Location(-16.42489402918141, -71.51242107152939);
		ScreenPosition pos = map.getScreenPosition(loc);
		ellipse(pos.x, pos.y, 20, 20);

		String berlinDescription = "Mi casita :v (" + (int) pos.x + "," + (int) pos.y + ")";
		text(berlinDescription, pos.x, pos.y);
	}

	public static void main(String[] args) {
		PApplet.main(new String[] { "de.fhpotsdam.unfolding.examples.SimplePositionConversionMapApp" });
	}
}
