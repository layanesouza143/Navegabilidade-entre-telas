package com.layane.task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.layane.task.R
import com.layane.task.data.model.Status
import com.layane.task.data.model.Task
import com.layane.task.databinding.FragmentDoingBinding
import com.layane.task.databinding.FragmentTodoBinding
import com.layane.task.ui.adapter.TaskAdapter

class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null
    private val biding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return biding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()

        initRecyclerViewTask(getTask())
    }

    private fun initListeners(){
        biding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_formTaskFragment)
        }
    }

    private fun initRecyclerViewTask(taskList: List<Task>){

        taskAdapter = TaskAdapter(requireContext(), taskList)
        biding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        biding.recyclerViewTask.setHasFixedSize(true)

        biding.recyclerViewTask.adapter = taskAdapter

    }

    private fun getTask() = listOf(
        Task("0", "Criar nova tela do app", Status.TODO),
        Task("0", "Validar informações na tela de login", Status.TODO),
        Task("0", "Adicionar nova funcionalidade no app", Status.TODO),
        Task("0", "Salvar token localmente", Status.TODO),
        Task("0", "Criar funcionalidade de layout no app", Status.TODO),

    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}