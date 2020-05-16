package krzbb.com.viewpageronboardingsample

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class OnboardingPageItem(
    @StringRes
    val title: Int,
    @StringRes
    val description: Int,
    @DrawableRes
    val image: Int,
    @ColorRes
    val backgroundColor: Int
)

