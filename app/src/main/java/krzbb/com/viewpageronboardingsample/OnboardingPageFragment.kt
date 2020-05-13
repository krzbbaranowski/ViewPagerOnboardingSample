package krzbb.com.viewpageronboardingsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_onboarding_page.*

class OnboardingPageFragment : Fragment()
{
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_onboarding_page, container, false)
    }

    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            onboarding_page_title.text = getString(it.getInt(TITLE))
            onboarding_page_description.text = getString(it.getInt(DESCRIPTION))
            onboarding_page_image.setImageResource(it.getInt(IMAGE))
        }
    }

    companion object
    {
        val IMAGE = "imageId"
        val TITLE = "titleId"
        val DESCRIPTION = "descriptionId"

        fun getInstance(@DrawableRes
                        imageId: Int,
                        @StringRes
                        titleId: Int,
                        @StringRes
                        descriptionId: Int): OnboardingPageFragment
        {
            var fragment =
                    OnboardingPageFragment()
            val args = Bundle()

            args.putInt(IMAGE, imageId)
            args.putInt(TITLE, titleId)
            args.putInt(DESCRIPTION, descriptionId)

            fragment.arguments = args
            return fragment
        }
    }
}