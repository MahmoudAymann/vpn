package com.qm.cleanmodule.ui.fragment.songdetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.qm.cleanmodule.base.view.BaseFragment
import com.qm.cleanmodule.databinding.FragmentSongDetailsBinding
import com.qm.cleanmodule.util.Status
import com.qm.cleanmodule.util.observe

class SongDetailsFragment : BaseFragment<FragmentSongDetailsBinding, SongDetailsViewModel>() {
    override fun pageTitle(): String = ""
    override val mViewModel: SongDetailsViewModel by viewModels()
    private val args: SongDetailsFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel.apply {
            gotData(args)
        }
    }
}