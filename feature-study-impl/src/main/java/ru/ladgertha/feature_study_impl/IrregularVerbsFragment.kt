package ru.ladgertha.feature_study_impl

import android.app.AlertDialog
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomsheet.BottomSheetDialog
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
            irregularVerbsViewModel.nextWord(binding.rareVerbsCheckBox.isChecked)
        }

        binding.checkButton.setOnClickListener {
            irregularVerbsViewModel.checkWord(
                pastSimple = binding.pastSimpleEditText.text.toString(),
                pastParticiple = binding.pastParticipleEditText.text.toString()
            )
        }
        binding.rareVerbsCheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
            irregularVerbsViewModel.updateShowRareVerbs(isChecked)
        }
        binding.showAnswerButton.setOnClickListener {
            irregularVerbsViewModel.showAnswer()
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
        observeRareVerbSettings()
        observeScreenState()
        observeDatabaseState()
        observeEditTextErrorsState()
        observeDialogs()
    }

    private fun observeRareVerbSettings() {
        irregularVerbsViewModel
            .getRareVerbsSettingsObservable()
            .filterNotNull()
            .onEach {
                binding.rareVerbsCheckBox.isChecked = it
            }
            .launchWhenStarted(lifecycleScope)
    }

    private fun observeDatabaseState() {
        irregularVerbsViewModel
            .getDatabaseIsUpdatedObservable()
            .filterNotNull()
            .onEach {
                irregularVerbsViewModel.nextWord(binding.rareVerbsCheckBox.isChecked)
            }
            .launchWhenStarted(lifecycleScope)
    }

    private fun observeScreenState() {
        irregularVerbsViewModel
            .getScreenStateObservable()
            .onEach {
                when (it) {
                    IrregularVerbsViewModel.ScreenState.Loading -> {
                        binding.progressBar.visibility = View.VISIBLE
                        binding.contentGroup.visibility = View.GONE
                    }
                    is IrregularVerbsViewModel.ScreenState.Content -> {
                        binding.contentGroup.visibility = View.VISIBLE
                        binding.progressBar.visibility = View.GONE
                        binding.irregularVerbBaseForm.text = it.baseForm
                    }
                }
            }
            .launchWhenStarted(lifecycleScope)
    }

    private fun observeEditTextErrorsState() {
        irregularVerbsViewModel
            .getEditTextErrorsStateObservable()
            .onEach {
                when (it) {
                    IrregularVerbsViewModel.EditTextErrorsState.PastParticipleError -> {
                        binding.pastParticipleInputLayout.error =
                            getString(R.string.irregular_verbs_f_past_participle_edit_text_error)
                    }
                    IrregularVerbsViewModel.EditTextErrorsState.PastSimpleError -> {
                        binding.pastSimpleInputLayout.error =
                            getString(R.string.irregular_verbs_f_past_simple_edit_text_error)
                    }
                }
            }
            .launchWhenStarted(lifecycleScope)
    }

    private fun observeDialogs() {
        irregularVerbsViewModel
            .getDialogsObservable()
            .onEach {
                when (it) {
                    is IrregularVerbsViewModel.Dialogs.ShowAnswer -> {
                        AlertDialog.Builder(context)
                            .setTitle(getString(R.string.irregular_verbs_f_show_answer_dialog_title))
                            .setMessage(
                                getString(
                                    R.string.irregular_verbs_f_show_answer_dialog_text,
                                    it.verb.pastSimple,
                                    it.verb.pastParticiple
                                )
                            )
                            .setPositiveButton(
                                android.R.string.yes
                            ) { dialog, which ->
                            }
                            .show()
                    }
                }
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