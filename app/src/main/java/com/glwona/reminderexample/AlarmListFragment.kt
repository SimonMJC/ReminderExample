package com.glwona.reminderexample

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.glwona.reminderexample.databinding.FragmentAlarmListBinding

class AlarmListFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentAlarmListBinding
    private lateinit var viewModel: AlarmListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_alarm_list,container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.view = this
        binding.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(AlarmListViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    fun moveReminder(v: View?){
        findNavController().navigate(R.id.action_alarmListFragment_to_alarmSettingFragment)
    }

    override fun onClick(v: View?) {

    }

    companion object {
        fun newInstance() = AlarmListFragment()
    }
}