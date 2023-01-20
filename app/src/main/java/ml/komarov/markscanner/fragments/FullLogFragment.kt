package ml.komarov.markscanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ml.komarov.markscanner.R
import ml.komarov.markscanner.databinding.FragmentFullLogBinding
import org.json.JSONObject


class FullLogFragment : Fragment() {
    private var _binding: FragmentFullLogBinding? = null
    private val binding: FragmentFullLogBinding get() = _binding!!

    companion object {
        fun newInstance(): FullLogFragment {
            val args = Bundle()

            val fragment = FullLogFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        _binding = FragmentFullLogBinding.inflate(inflater, container, false)

        setup()

        return binding.root
    }

    private fun setTitle () {
        requireActivity().title = getString(R.string.full_result)
    }

    private fun setup () {
        setTitle()

        val jsonString = requireArguments().getString("json", "{}")
        val jsonObject = JSONObject(jsonString)
        binding.rvJson.setJson(jsonObject)
    }
}