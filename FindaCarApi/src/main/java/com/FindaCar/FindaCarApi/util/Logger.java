package com.FindaCar.FindaCarApi.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class Logger.
 */
@Component
public class Logger {

	/** The Constant LOG_FILE. */
	private static final String LOG_FILE = "log.txt";

	/**
	 * Log.
	 *
	 * @param message the message
	 */
	public static void log(String message) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(LOG_FILE, true))) {
			String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			writer.println(timestamp + " - " + message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
