import java.util.Arrays;

public class Activity_Selection {

	public static void main(String[] args) {
		int[] starts = { 3, 0, 1, 8, 5, 5 };
		int[] ends = { 4, 6, 2, 9, 9, 7 };
		activityselection(starts, ends);
	}

	private static void activityselection(int[] starts, int[] ends) {
		Activity[] activities = new Activity[ends.length];
		for (int i = 0; i < activities.length; i++) {
			activities[i] = new Activity(starts[i], ends[i]);
		}
		Arrays.sort(activities);
		int count = 1;
		int last = 0;
		for (int i = 1; i < activities.length; i++) {
			if (activities[i].start > activities[last].end) {
				last = i;
				count++;
			}
		}
		System.out.println(count);
	}

	private static class Activity implements Comparable<Activity> {
		int start;
		int end;

		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Activity o) {
			return this.end - o.end;
		}

	}

}
