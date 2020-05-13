package krzbb.com.viewpageronboardingsample.page

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import krzbb.com.viewpageronboardingsample.R

class Transformer : ViewPager2.PageTransformer
{
    private val MIN_SIZE = 0.4f

    override fun transformPage(page: View, position: Float)
    {
        if (position >= -1 && position <= 0)
        {
            page.findViewById<View>(R.id.onboarding_page_image).scaleX = getScale(-position)
            page.findViewById<View>(R.id.onboarding_page_image).scaleY = getScale(-position)
        } else if (position > 0)
        {
            page.findViewById<View>(R.id.onboarding_page_image).scaleX = getScale(position)
            page.findViewById<View>(R.id.onboarding_page_image).scaleY = getScale(position)
        }else if (position >= -1 && position <= 1)
        {
            page.findViewById<View>(R.id.onboarding_page_title).translationX = position * page.width / 2
            page.findViewById<View>(R.id.onboarding_page_description).translationX = position * page.width / 5

            page.findViewById<View>(R.id.onboarding_page_title).alpha = 1f - position
            page.findViewById<View>(R.id.onboarding_page_description).alpha = 1f - position
        } else
        {
            page.alpha = position * 1.2f
        }
    }

    private fun getScale(position: Float): Float
    {
        var result = (1f - position) * 1.1f

        if (result > 1f)
            result = 1f
        else if (result < MIN_SIZE)
            result = MIN_SIZE

        return result
    }
}