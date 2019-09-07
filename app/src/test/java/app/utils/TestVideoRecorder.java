package app.utils;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.MIME_QUICKTIME;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.COMPRESSOR_NAME_QUICKTIME_ANIMATION;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_QUICKTIME_ANIMATION;

import java.awt.AWTException;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.Registry;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

/**
 * Class that extends Monte ScreenRecorder used for record Selenium test videos
 * 
 * @author David García Prados
 *
 */
public class TestVideoRecorder extends ScreenRecorder {

	private String videoName = null;

	/**
	 * Default constructor: QuickTime, 30FPS, 24depth, mouse capture, NO audio
	 * capture, default video path
	 * 
	 * @throws HeadlessException
	 * @throws IOException
	 * @throws AWTException
	 */
	public TestVideoRecorder() throws HeadlessException, IOException, AWTException {

		super( // Graphics configuration of the capture screen
				GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration(),
				// The video File format (Quicktime)
				new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
				// The output format for screen capture (30 FPS and 24 bits per pixel)
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_QUICKTIME_ANIMATION, CompressorNameKey,
						COMPRESSOR_NAME_QUICKTIME_ANIMATION, DepthKey, TestConstants.VIDEO_DEFAULT_DEPTH_BITS_PER_PIXEL,
						FrameRateKey, new Rational(TestConstants.VIDEO_DEFAULT_FPS, 1)),
				// The video format for mouse capture
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_BLACK_CURSOR, FrameRateKey,
						new Rational(TestConstants.VIDEO_DEFAULT_FPS, 1)),
				// No audio capture configured (null)
				null);

		// Set movie folder to SeleniumVideos
		this.movieFolder = new File(
				movieFolder.getAbsolutePath().replace(movieFolder.getName(), TestConstants.VIDEO_DEFAULT_FOLDER));

	}

	/**
	 * Constructor using a video name (uses default constructor and then sets the
	 * video name)
	 * 
	 * @param videoPath
	 * @throws HeadlessException
	 * @throws IOException
	 * @throws AWTException
	 */
	public TestVideoRecorder(String videoName) throws HeadlessException, IOException, AWTException {
		this();
		this.videoName = videoName;
	}

	@Override
	/**
	 * Create movie file on Movie folder with default name (if videoName is null) or
	 * using the provided in constructor
	 */
	protected File createMovieFile(Format fileFormat) throws IOException {
		File result;

		if (videoName == null) {
			result = super.createMovieFile(fileFormat);
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH_mm_ss");
			result = new File(movieFolder, this.videoName + "_" + dateFormat.format(new Date()) + "."
					+ Registry.getInstance().getExtension(fileFormat));

			result.mkdirs();
			result.createNewFile();
		}

		return result;
	}

}
