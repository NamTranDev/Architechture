package nam.tran.architechture.view.splash

import android.os.Bundle
import android.os.Handler
import androidx.navigation.Navigation
import nam.tran.architechture.R
import nam.tran.data.Logger
import nam.tran.data.local.IPreference


import tran.nam.core.view.BaseFragmentInjection
import javax.inject.Inject

class SplashFragment : BaseFragmentInjection() {

    @Inject
    lateinit var iPref : IPreference

    private var isGoToMain = false
    private var handler: Handler? = null
    private var runnable: Runnable? = Runnable {
        Logger.debug("gotoMain")
        isGoToMain = true
        gotoMain()
    }

    private fun gotoMain() {
        if (iPref.user.isEmpty())
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_splashFragment_to_loginFragment)
        else
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
                    .navigate(R.id.action_splashFragment_to_homeFragment)
    }

    public override fun layoutId(): Int {
        return R.layout.fragment_splash
    }

    override fun onResume() {
        super.onResume()
        if (isGoToMain){
            gotoMain()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        handler = Handler()
        handler?.postDelayed(runnable, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler?.removeCallbacks(runnable)
        handler = null
        runnable = null
    }

}
