package app.utils;

/**
 * Constants used in tests
 * 
 * @author David García Prados
 *
 */
public class TestConstants {
	private TestConstants() {
	}

	/* Constants for ScreenRecorder */
	public static final String VIDEO_DEFAULT_FOLDER = "SeleniumVideos";
	public static final String VIDEO_ERROR_RECORD_TEST = "ERROR: test cannot be recorded on video";
	public static final int VIDEO_DEFAULT_FPS = 30;
	public static final int VIDEO_DEFAULT_DEPTH_BITS_PER_PIXEL = 24;

	// Localhost path hardcoded for the test
	public static final String LOCAHOST_BASE_URL = "http://localhost:8080/app/";

	// Selenium time constant
	public static final int SELENIUM_DEFAULT_WAIT_SECONDS = 5;

}
