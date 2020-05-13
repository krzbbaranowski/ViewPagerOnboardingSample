package krzbb.com.viewpageronboardingsample.domain

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import krzbb.com.viewpageronboardingsample.OnboardingPageItem

class OnboardingViewModel : ViewModel()
{
    private val onboardingRepository =
            OnboardingRepository()

    val onboardingPages =
        MutableLiveData<List<OnboardingPageItem>>()

    init
    {
        var pages = onboardingRepository.getOnboardingPages()
        onboardingPages.postValue(pages)
    }
}
