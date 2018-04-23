package zhaowe.guncannon.util;

import java.util.Calendar;

public class Logger {

	public static final String FINISHED_MESSAGE = "finished!";
	public static final String STARTED_MESSAGE = "started!";
	private static final String LOG_FORMAT = "[%1$tF %1$tT] [%2$s] %3$s\n";

	public static void info(String methodName, String message) {
		System.out.format(LOG_FORMAT, Calendar.getInstance(), methodName, message);
	}
	
	public static void infoStarted(String methodName) {
		info(methodName, STARTED_MESSAGE);
	}
	
	public static void infoFinished(String methodName) {
		info(methodName, FINISHED_MESSAGE);
	}
}
