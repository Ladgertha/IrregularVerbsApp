package ru.ladgertha.feature_study_impl

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ladgertha.feature_study_impl.databinding.FragmentIrregularVerbsBinding

class IrregularVerbsFragment : Fragment() {
    private var _binding: FragmentIrregularVerbsBinding? = null
    private val binding get() = _binding!!
    private val irregularVerbsViewModel: IrregularVerbsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIrregularVerbsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextButton.setOnClickListener {
            // irregularVerbsViewModel.nextWord()
        }

        binding.checkButton.setOnClickListener {
            // irregularVerbsViewModel.checkWord()
        }
        binding.rareVerbsCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            irregularVerbsViewModel.updateShowRareVerbs(isChecked)
        }
        observeViewModel()
      //  irregularVerbsViewModel.nextWord()
    }

    // TODO Implement splash screen
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val content: View = requireActivity().findViewById(android.R.id.content)

        var isHideSplashScreen = false

        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                isHideSplashScreen = true
            }
        }.start()

        content.viewTreeObserver.addOnPreDrawListener(
            object : ViewTreeObserver.OnPreDrawListener {
                override fun onPreDraw(): Boolean {
                    return if (isHideSplashScreen) {
                        content.viewTreeObserver.removeOnPreDrawListener(this)
                        true
                    } else {
                        false
                    }
                }
            }
        )
    }

    private fun observeViewModel() {
        observeNextWord()
        observeRareVerbSettings()
    }

    private fun observeNextWord() {
        irregularVerbsViewModel
            .getNextVerbObservable()
            .filterNotNull()
            .onEach {
                binding.irregularVerbBaseForm.text = it.baseForm
            }
            .launchWhenStarted(lifecycleScope)
    }

    private fun observeRareVerbSettings() {
        irregularVerbsViewModel
            .getRareVerbsSettingsObservable()
            .filterNotNull()
            .onEach {
                // TODo Заменить на нормальную логику
                binding.rareVerbsCheckBox.isChecked = it
                irregularVerbsViewModel.nextWord(it)
            }
            .launchWhenStarted(lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = IrregularVerbsFragment()
    }
}