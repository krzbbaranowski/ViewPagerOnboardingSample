package krzbb.com.viewpageronboardingsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import kotlinx.android.synthetic.main.fragment_onboarding.*
import krzbb.com.viewpageronboardingsample.domain.OnboardingViewModel
import krzbb.com.viewpageronboardingsample.page.Transformer

class OnboardingFragment : Fragment()
{
    private var viewModel: OnboardingViewModel? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(
            view: View,
            savedInstanceState: Bundle?
    )
    {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(OnboardingViewModel::class.java)

        viewModel?.onboardingPages?.observe(viewLifecycleOwner, Observer { pages ->

            viewPager.adapter = object : FragmentStateAdapter(this)
            {
                override fun createFragment(position: Int): Fragment
                {
                    val currentPage = pages.get(position)
                    return OnboardingPageFragment.getInstance(
                            currentPage.image,
                            currentPage.title,
                            currentPage.description
                    )
                }

                override fun getItemCount(): Int
                {
                    return pages.count()
                }
            }

            viewPager_indicator.setViewPager(viewPager)
            viewPager.setPageTransformer(Transformer())
        })
    }

    companion object
    {
        fun newInstance(): OnboardingFragment
        {
            return OnboardingFragment()
        }
    }
}