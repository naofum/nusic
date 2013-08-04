package info.schnatterer.newsic.service;

import info.schnatterer.newsic.db.model.Release;
import info.schnatterer.newsic.service.event.PreferenceChangedListener;

import java.util.Date;

/**
 * Provides access to the key-value-preferences of the app.
 * 
 * @author schnatterer
 * 
 */
public interface PreferencesService {
	/**
	 * Distinguishes different kinds of app starts: <li>
	 * <ul>
	 * First start ever ({@link #FIRST_TIME})
	 * </ul>
	 * <ul>
	 * First start in this version ({@link #FIRST_TIME_VERSION})
	 * </ul>
	 * <ul>
	 * Normal app start ({@link #NORMAL})
	 * </ul>
	 * 
	 * @author schnatterer
	 * 
	 */
	public enum AppStart {
		FIRST_TIME, FIRST_TIME_VERSION, NORMAL;
	}

	/**
	 * Finds out started for the first time (ever or in the current version).
	 * 
	 * @return the type of app start
	 */
	AppStart checkAppStart();

	/**
	 * Resets all your preferences. Carefuly with that!
	 */
	void clearPreferences();

	/**
	 * Gets the last time the {@link Release}s have <b>successfully</b> been
	 * loaded from the internet.
	 * 
	 * This is useful to determine the start date for the next refresh.
	 */
	Date getLastSuccessfullReleaseRefresh();

	/**
	 * Set last time the {@link Release}s have <b>successfully</b> been loaded
	 * from the internet.
	 * 
	 * This is useful to determine the start date for the next refresh.
	 * 
	 * @return <code>true</code> if successfully written, otherwise
	 *         <code>false</code>
	 */
	boolean setLastSuccessfullReleaseRefresh(Date date);

	/**
	 * @return <code>true</code> if the user has checked to only download images
	 *         on Wi-Fi. Otherwise <code>false</code>
	 */
	boolean isUseOnlyWifi();

	/**
	 * >Also download and display releases that are not available yet.
	 * 
	 * @return
	 */
	boolean isIncludeFutureReleases();

	/**
	 * Returns time period in months (from today back in time) for which
	 * releases are downloaded and displayed.
	 * 
	 * @return
	 */
	int getDownloadReleasesTimePeriod();

	/**
	 * Always update the complete time period.
	 * 
	 * @return
	 */
	boolean isFullUpdate();

	void registerOnSharedPreferenceChangeListener(
			PreferenceChangedListener preferenceChangedListener);

	void unregisterOnSharedPreferenceChangeListener(
			PreferenceChangedListener preferenceChangedListener);

}