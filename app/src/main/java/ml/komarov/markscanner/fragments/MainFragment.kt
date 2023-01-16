package ml.komarov.markscanner.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.camera.core.ExperimentalGetImage
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ml.komarov.markscanner.BarcodeActivity
import ml.komarov.markscanner.R
import ml.komarov.markscanner.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!

    companion object {
        const val REQUEST_CODE = 101

        fun newInstance(): MainFragment {
            val args = Bundle()

            val fragment = MainFragment()
            fragment.arguments = args
            return fragment
        }
    }

    @ExperimentalGetImage
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        setup()

        return binding.root
    }

    private fun setTitle() {
        requireActivity().title = getString(R.string.app_name)
    }

    private fun setup() {
        setTitle()

        binding.buttonScan.setOnClickListener {
            startActivityForResult(
                Intent(activity, BarcodeActivity::class.java),
                REQUEST_CODE
            )
        }

        binding.buttonCheck.setOnClickListener {
            openCodeData(binding.inputCode.text.toString())
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            val code = data!!.getStringExtra("DATA")!!
            openCodeData(code)
        }
    }

    private fun openCodeData(code: String) {
        val args = Bundle()
        args.putString("code", code)

        val newResultFragment = ResultFragment.newInstance()
        newResultFragment.arguments = args

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, newResultFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(ResultFragment::class.qualifiedName)
            .commit()
    }
}