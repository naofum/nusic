nusic Changelog
=========

**v.0.6 New Tabs & UTC Fix**

* New Tabs for available and announced releases
* Bugfixes (Wrong release dates when changing timezones, error on daily refresh of releases)

**v.0.5.1 Encryption and fixes**

* Fixed an exception when hiding releases
* Fixed issue #1
* Enabled encryption (HTTPS) for communication with MusicBrainz

**v.0.5 Several minor enhancements**

* Added back button to action bar in preferences menu
* Implemented swiping between tabs
* Removed error notification when update failed for some artists

**v.0.4 Hide albums**

* Possibility to hide a single album or all ablums by a specific artist by long tapping an album.
* Hidden albums can be reset in the preferences.

**v.0.3.1 Android 2.x**

* Fix: App did not start on Android 2.x devices.

**v.0.3 Android 4.4**

* Fix: artists could not be read in Android 4.4

**v.0.2.2 Changed default values**

* Prepared launch on Google Play.
* Mobile internet is now used by default in order to avoid unexpected behavior by default.

**v.0.2.1: Bugfix: Duplicated releases**

* Fixed an issue where one release could appear several times.

**v.0.2: Improvements for background task**

* Minor improvements, especially regarding background service that keeps releases up-to-date

**v.0.1: First "official" version**

* Checks for new album releases for all artists on phone using MusicBrainz
* Releases are displayed in two tabs: "Recently added" (within the last two weeks) and "All"
* Refreshs of the releases are performed daily
* When no internet connection available, refresh is postponed
* Availability of new releases are shown as notifications
* Available preferences: Time period (releases), download future releases, incremental/full update, use only wifi
