package krzbb.com.viewpageronboardingsample

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingPageItem(@StringRes
                              val title: Int,
                              @StringRes
                              val description: Int,
                              @DrawableRes
                              val image: Int)

