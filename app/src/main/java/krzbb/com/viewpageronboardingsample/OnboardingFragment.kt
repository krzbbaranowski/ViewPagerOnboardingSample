package krzbb.com.viewpageronboardingsample

import android.animation.ArgbEvaluator
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.transition.ChangeBounds
import androidx.transition.Slide
import androidx.transition.TransitionManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_onboarding.*
import krzbb.com.viewpageronboardingsample.domain.OnboardingViewModel
import krzbb.com.viewpageronboardingsample.page.Transformer

class OnboardingFragment : Fragment() {
    private var viewModel: OnboardingViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(OnboardingViewModel::class.java)

        viewModel?.onboardingPages?.observe(viewLifecycleOwner, Observer { pages ->

            viewPager.adapter = object : FragmentStateAdapter(this) {
                override fun createFragment(position: Int): Fragment {
                    val currentPage = pages.get(position)
                    return OnboardingPageFragment.getInstance(
                        currentPage.image,
                        currentPage.title,
                        currentPage.description
                    )
                }

                override fun getItemCount(): Int {
                    return pages.count()
                }
            }

            viewPager_indicator.setViewPager(viewPager)
            viewPager.clipToPadding = false
            viewPager.setPageTransformer(Transformer())

            viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

                override fun onPageSelected(position: Int) {
                    if (position < pages.count() - 1)
                        root_view.transitionToState(R.id.start)
                    else
                        root_view.transitionToState(R.id.end)
                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    if (position < pages.count() - 1) {
                        val pageItemData = pages[position]
                        val nextPageItemData = pages[position + 1]

                        val color = getPageColor(
                            positionOffset,
                            pageItemData.backgroundColor,
                            nextPageItemData.backgroundColor
                        )

                        root_view.setBackgroundColor(color)
                    }
                }
            })
        })
    }

    private fun getPageColor(
        positionOffset: Float,
        @ColorRes currentPageColor: Int,
        @ColorRes nexyPageColor: Int
    ): Int {
        return ArgbEvaluator().evaluate(
            positionOffset,
            ContextCompat.getColor(requireContext(), currentPageColor),
            ContextCompat.getColor(
                requireContext(),
                nexyPageColor
            )
        ) as Int
    }

    companion object {
        fun newInstance(): OnboardingFragment {
            return OnboardingFragment()
        }
    }
}