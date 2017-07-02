package mma.legacy.interval;

import java.util.ArrayList;
import java.util.List;

public class IntervalsTestCreator {
	
	
	
	public void IntervalsTestComposite(){
		
		
	}
	
	public static List<Interval> create(IntervalType intervalType){
		List<Interval> intervals=new ArrayList<Interval>();
		intervals.add(IntervalFactory.getInterval(10, 15, intervalType));		
		intervals.add(IntervalFactory.getInterval(15, 20, intervalType));
		intervals.add(IntervalFactory.getInterval(20, 25, intervalType));
		intervals.add(IntervalFactory.getInterval(25, 30, intervalType));
		intervals.add(IntervalFactory.getInterval(30, 35, intervalType));
		intervals.add(IntervalFactory.getInterval(35, 40, intervalType));
		intervals.add(IntervalFactory.getInterval(40, 45, intervalType));
		
		return intervals;

	}
	
	

}
