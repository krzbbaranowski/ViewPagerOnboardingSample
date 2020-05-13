package krzbb.com.viewpageronboardingsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onboardingFragment = OnboardingFragment.newInstance()

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, onboardingFragment, "onboardingFragment")
                .addToBackStack(null)
                .commit()
    }
}


