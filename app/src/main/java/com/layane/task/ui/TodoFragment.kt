package com.layane.task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.layane.task.R
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
            findNavController().navigate(R.id.action_homeFragment_to_fragment_form_task)
        }
    }

    private fun initRecyclerViewTask(taskList: List<Task>){

        taskAdapter = TaskAdapter(taskList)
        biding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        biding.recyclerViewTask.setHasFixedSize(true)

        biding.recyclerViewTask.adapter = taskAdapter

    }

    private fun getTask() = listOf(
        Task("0", "Criar nova tela do app"),
        Task("1", "Validar informações na tela de login"),
        Task("2", "Adicionar nova funcionalidade no app"),
        Task("3", "Salvar token localmente"),
        Task("2", "Criar funcionalidade de layout no app"),

    )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}