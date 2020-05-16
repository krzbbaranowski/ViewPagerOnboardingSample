package krzbb.com.viewpageronboardingsample.domain

import krzbb.com.viewpageronboardingsample.OnboardingPageItem
import krzbb.com.viewpageronboardingsample.R

class OnboardingRepository {
    private val pages = ArrayList<OnboardingPageItem>()

    init {
        pages.add(
            OnboardingPageItem(
                R.string.onboarding_bar_title,
                R.string.onboarding_bar_description,
                R.drawable.ic_bar,
                R.color.firstColor
            )
        )
        pages.add(
            OnboardingPageItem(
                R.string.onboarding_island_title,
                R.string.onboarding_island_description,
                R.drawable.ic_island,
                R.color.secondColor
            )
        )
        pages.add(
            OnboardingPageItem(
                R.string.onboarding_compass_title,
                R.string.onboarding_compass_description,
                R.drawable.ic_compass,
                R.color.thirdColor
            )
        )
        pages.add(
            OnboardingPageItem(
                R.string.onboarding_tickets_title,
                R.string.onboarding_tickets_description,
                R.drawable.ic_boarding_pass,
                R.color.fourthColor
            )
        )
    }

    fun getOnboardingPages(): ArrayList<OnboardingPageItem> {
        return pages
    }
}