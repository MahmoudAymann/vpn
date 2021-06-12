package com.qm.cleanmodule.ui.fragment.songs

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.qm.cleanmodule.base.view.BaseFragment
import com.qm.cleanmodule.databinding.FragmentSongBinding
import com.qm.cleanmodule.util.*

class SongFragment : BaseFragment<FragmentSongBinding, SongViewModel>() {
    override fun pageTitle(): String = ""
    override val mViewModel: SongViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.apply {
            observe(mutableLiveData) {
                when (it) {
                    is  SongsResponse.SongsResponseItem-> navigateSafe(SongFragmentDirections.actionSongFragmentToSongDetailsFragment(it))
                }
            }
            observe(resultLiveData) {
                when (it?.status) {
                    Status.SUCCESS -> {
                        showProgress(false)
                    }
                    Status.MESSAGE -> {
                        showProgress(false)
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                    Status.LOADING -> showProgress()
                }
            }
        }

        binding.tilSearch.editText?.onImeClick {
            mViewModel.getData()
            requireActivity().showKeyboard(false)
        }
    }
}