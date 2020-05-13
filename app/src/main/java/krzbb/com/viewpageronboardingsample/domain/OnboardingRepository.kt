package krzbb.com.viewpageronboardingsample.domain

import krzbb.com.viewpageronboardingsample.OnboardingPageItem
import krzbb.com.viewpageronboardingsample.R

class OnboardingRepository
{
    private val pages = ArrayList<OnboardingPageItem>()

    init
    {
        pages.add(
                OnboardingPageItem(
                        R.string.onboarding_bar_title,
                        R.string.onboarding_bar_description,
                        R.drawable.ic_bar
                )
        )
        pages.add(
                OnboardingPageItem(
                        R.string.onboarding_island_title,
                        R.string.onboarding_island_description,
                        R.drawable.ic_island
                )
        )
        pages.add(
                OnboardingPageItem(
                        R.string.onboarding_compass_title,
                        R.string.onboarding_compass_description,
                        R.drawable.ic_compass
                )
        )
        pages.add(
                OnboardingPageItem(
                        R.string.onboarding_tickets_title,
                        R.string.onboarding_tickets_description,
                        R.drawable.ic_boarding_pass
                )
        )
    }

    fun getOnboardingPages(): ArrayList<OnboardingPageItem>
    {
        return pages
    }
}