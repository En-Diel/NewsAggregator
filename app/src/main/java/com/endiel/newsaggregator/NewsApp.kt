package com.endiel.newsaggregator

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// In case we need to use Dagger Hilt in Application context
@HiltAndroidApp
class NewsApp(): Application()