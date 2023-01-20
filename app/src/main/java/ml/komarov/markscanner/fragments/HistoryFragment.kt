package ml.komarov.markscanner.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import ml.komarov.markscanner.App
import ml.komarov.markscanner.R
import ml.komarov.markscanner.databinding.FragmentHistoryBinding
import ml.komarov.markscanner.db.AppDatabase
import ml.komarov.markscanner.db.History


class HistoryFragment : Fragment() {
    private var _binding: FragmentHistoryBinding? = null
    private val binding: FragmentHistoryBinding get() = _binding!!

    companion object {
        fun newInstance(): HistoryFragment {
            val args = Bundle()

            val fragment = HistoryFragment()
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
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)

        setup()

        return binding.root
    }

    private fun setTitle() {
        requireActivity().title = getString(R.string.scan_history)
    }

    private fun setup() {
        setTitle()

        val db: AppDatabase = App.instance!!.getDatabase()!!
        val historyDao = db.historyDao()!!

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = HistoryRecyclerAdapter(
            historyDao.all.reversed(),
            onClickListener = { history -> openHistoryData(history) })
    }

    private fun openHistoryData(history: History) {
        val args = Bundle()
        args.putString("code", history.code)
        args.putLong("id", history.id)

        val newResultFragment = ResultFragment.newInstance()
        newResultFragment.arguments = args

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, newResultFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .addToBackStack(ResultFragment::class.qualifiedName)
            .commit()
    }
}