package utils;

import bean.Circle;
import bean.Point;
import bean.Pos;

public class PosUtils {
	public static Pos getPos(Point point, Circle circle) {
		double distance = Math.sqrt(Math.pow((point.getX()-circle.getxCenter()), 2) + Math.pow((point.getY()-circle.getyCenter()), 2));
		if(distance == circle.getRadius()) {
			return Pos.ONSIDE;
		}
		if(distance > circle.getRadius()) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}

}
