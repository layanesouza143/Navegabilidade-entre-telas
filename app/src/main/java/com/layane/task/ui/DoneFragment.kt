package com.layane.task.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.layane.task.R
import com.layane.task.data.model.Status
import com.layane.task.data.model.Task
import com.layane.task.databinding.FragmentDoingBinding
import com.layane.task.databinding.FragmentDoneBinding
import com.layane.task.databinding.FragmentHomeBinding
import com.layane.task.databinding.FragmentTodoBinding
import com.layane.task.ui.adapter.TaskAdapter

class DoneFragment : Fragment() {
    private var _binding: FragmentDoneBinding? = null
    private val biding get() = _binding!!
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDoneBinding.inflate(inflater, container, false)
        return biding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerViewTask(
            taskList = TODO()
        )
        getTask()
    }

    private fun initRecyclerViewTask(taskList: List<Task>){
        taskAdapter = TaskAdapter(requireContext()) {task, option -> optionSelected(task, option)}
        with(biding.recyclerViewTask){
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = taskAdapter
        }


    }

    private fun optionSelected(task: Task, option: Int){
        when (option){
            TaskAdapter.SELECT_REMOVER->{
                Toast.makeText(requireContext(), "Removendo $(task.description)", Toast.LENGTH_SHORT).show()
            }

            TaskAdapter.SELECT_EDIT->{
                Toast.makeText(requireContext(), "Editando $(task.description)", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_DETAILS->{
                Toast.makeText(requireContext(), "Detalhes $(task.description)", Toast.LENGTH_SHORT).show()
            }
            TaskAdapter.SELECT_NEXT->{
                Toast.makeText(requireContext(), "Próximo", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun getTask() {
        val taskList = listOf(
            Task("0", "Criar nova tela do app", Status.DONE),
            Task("0", "Validar informações na tela de login", Status.DONE),
            Task("0", "Adicionar nova funcionalidade no app", Status.DONE),
            Task("0", "Salvar token localmente", Status.DONE),
            Task("0", "Criar funcionalidade de layout no app", Status.DONE),
            )
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}